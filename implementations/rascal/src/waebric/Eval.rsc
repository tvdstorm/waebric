module waebric::Eval

import String;
import ToString;
import List;
import Map;
import waebric::AST;


alias Heap = map[str, Closure];
alias Env = map[str, value];
alias Closure = tuple[Env, FunctionDef];

data Undef = undef();

public Module EXAMPLE = waebric::AST::example;

public Heap collectFunctions(Module mod) {
   Heap result = ();
   visit (mod) {
     case FunctionDef f: {  
          str name = f.id;
          result[name] = <(), f>;
     } 
   };
   return result;
}

public bool isClosure(value v) {
  return <Env _, FunctionDef _> := v;
}

public str evalModule(Module mod, Heap heap) {
     return evalFunction(heap["main"], [], heap, "");
}

public value evalExp(Expression exp, Env env) {
  switch (exp) {
    case var(str id): return env[id];
    case num(str nat): return toInt(nat);
    case sym(str sym): return substring(sym, 1);
    case text(str txt): return substring(txt, 1, size(txt) - 1);
    case field(Expression exp, str n): {
        x = evalExp(exp, env);
        if (map[str,value] m := x) {
          if (n in domain(m)) {
             return m[n];
          } 
        }
        return undef();
    }
    case cat(Expression exp1, Expression exp2):
       return toString(evalExp(exp1, env)) + toString(evalExp(exp2, env));
    case \list(exprs) : return [ evalExp(e, env) | e <- exprs ];
    case record(pairs): return ( k: evalExp(e, env) | pair(str k, Expression e) <- pairs );
    default: return undef();
  }

}


test evalExp(var("x"), ("x": 3)) == 3;
test evalExp(num("3"), ()) == 3;
test evalExp(sym("'abc"), ()) == "abc";

Type typeOf(value v) {
   switch (r) {
     case map[str, value] _: return \record-type(); 
     case list[value] _: return \list-type();
     default: return \string-type();
   }
}


public bool evalPred(Predicate pred, Env env) {
   switch (pred) {
     case exp(Expression e): return evalExp(e, env) != undef();
     case \is-a(Expression e, Type \type): {
        r = evalExp(e, env);
        return typeOf(r) == \type;
     }
     case not(Predicate arg): return !evalPred(arg, env);
     case and(Predicate l, Predicate r): return evalPred(l, env) && evalPred(r, env);
     case or(Predicate l, Predicate r): return evalPred(l, env) || evalPred(r, env);
     default: return false;
   }
}

str unquote(str x) {
   // TODO: unescape \n etc.
   return substring(x, 1, size(x) - 2);
}


public str evalStat(Statement stat, Env env, Heap heap, str ablock) {
   switch (stat) {
     case echo(Expression e): return toString(evalExp(e, env));
     case yield() : return ablock;
     // BUG: if < is in string, you get parser error much later.
     case comment(str s): 
	return "\<!--" + unquote(s) + "-->";
     case cdata(Expression e): 
	return "\<![CDATA[" + toString(evalExp(e, env)) + "-->";
     //BUG: \if, \if-else geeft null pointer in parser scheduler.
     case block(list[Statement] mystats):
	return evalStats(mystats, env, heap, ablock);
     case ifThen(Predicate pred, Statement stat, _): {
	if (evalPred(pred, env)) {
	  return evalStat(stat, env, heap, ablock);
	}
        return "";
     }
     case ifElse(Predicate pred, Statement stat, Statement stat2): {
	if (evalPred(pred, env)) {
	  return evalStat(stat, env, heap, ablock);
	}
        return evalStat(stat2, env, heap, ablock);
     }
     case each(str id, Expression exp, Statement stat): {
        list[value] l;
        x = evalExp(exp, env);  
	switch (x) {
          case list[value] x: l = x;
          case value x: l = [x];
        }
	str result = "";
	for (y <- l) {
          env[id] = y;
          result += evalStat(stat, env, heap, ablock);
        }
        return result;
     }
     case let(list[Assignment] bins, list[Statement] stats): {
	<env, heap> = evalBindings(bins, env, heap);
        return evalStats(bins, env, heap);
     }
     case markup(Markup mark): {
	return evalMarkups([mark], env, heap, "");
     }
     case \markup-stat(list[Markup] ms, Statement stat): {
	ablock = evalStat(stat, env, heap, ablock);
	return evalMarkups(ms, env, heap, ablock);
     }
     case \markup-exp(list[Markup] ms, Expression exp): {
	ablock = toString(evalExp(exp, env));
	return evalMarkups(ms, env, heap, ablock);
     }
     case \markup-markup(list[Markup] ms, Markup markup): {
	return evalMarkups(ms + [markup], env, heap, "");
     }
     case \markup-embedding(list[Markup] ms, Embedding emb): {
	ablock = evalEmbedding(emb, env, heap, "");
	return evalMarkups(ms, env, heap, ablock);
     }   
   }
   return "ERROR in evalStat; missing case for: <stat>";
}


public tuple[Env, Heap] evalBindings(list[Assignment] bins, Env env, Heap heap) {
	for (bin <- bins) {
           switch (bin) {
	     case \var-bind(id, exp): {
		env[id] = evalExp(exp, env);
	     }
	     case \func-bind(id, formals, stat): {
		heap[id] = <env, def(id, formals, [stat])>;
             } 
	  }
        }
	return <env, heap>;
 }

public str evalStats(list[Statement] stats, Env env, Heap heap, str block) {
  str result = "";
  for (stat <- stats) {
     result += evalStat(stat, env, heap, block);
  }
  return result;
}


public str evalMarkups(list[Markup] ms, Env env, Heap heap, str block) {
  for (m <- reverse(ms)) 
    block = evalMarkup(m, env, heap, block);
  return block;
}

public str evalMarkup(Markup m, Env env, Heap heap, str block) {
   switch (m) {
    case nillary(des): return evalMarkup(call(des, args([])), env, heap, block);
    case call(des, args(as)): {
	as += evalAttributes(des.attrs);
	argus = evalArguments(as, env);
	aName = des.id;
	// heap?[aName] does not work?
	if (aName in domain(heap)) {
	   return evalFunction(heap[aName], [ v | <_, value v> <- argus ], heap, block);
        } 
	attrs = argsToAttrs(argus);
	if (block == "") return "\<<aName><attrs>/>";
	return "\<<aName><attrs>><block>\</<aName>>";
     }           
   }
}

public str evalFunction(Closure clos, list[value] actuals, Heap heap, str block) {
  if (<Env env, def(str id, Formals frms, list[Statement] stats)> := clos) {
     i = 0;
     fs = [];
     if (formals(list[str] params) := frms) {
        fs = params;
     }
     for (f <- fs) {
        v = undef();
        if (i <= size(actuals) - 1) v = actuals[i];
        env[f] = v;
     }
     return evalStats(stats, env, heap, block);    
  }
  return "Error in evalFunction";  
}

public list[Argument] evalAttributes(list[Attribute] attrs) {
   list[Argument] args = [];
   visit(attrs) {
     case id(val): args += [attr("id", text("\"<val>\""))];
     case class(val): args += [attr("class", text("\"<val>\""))];
     case name(val): args += [attr("name", text("\"<val>\""))];
     case type(val): args += [attr("type", text("\"<val>\""))];
     // BUG: forgetting \ does not give parse error here.
     case \width-height(w,h): 
        args += [attr("width", num(w)), attr("height", num(h))];
     case height(h): 
        args += [attr("height", num(h))];
   }
   return args;
}

public list[tuple[str,value]] evalArguments(list[Argument] args, Env env) {
   list[tuple[str,value]] result = [];
   for (arg <- args) {
     switch (arg) {
      case \value(Expression exp): result += [<"value", evalExp(exp, env)>];
      case attr(str id, Expression exp): result += [<id, evalExp(exp, env)>];
     } 
   }
   return result; 
}

public str argsToAttrs(list[tuple[str,value]] args) {
  str result = "";
  for (<str name, value val> <- args)
    result += " <name>=<val>";	
  return result;
}

