module Eval

import String;
import ToString;
import List;

data IXML = 
	element(str name, list[IXML] contents) 
	| content(str txt)
	| seq(list[IXML] elts);


data Statement =
	ifThen(Predicate pred, Statement body, value noelse)
	| ifElse(Predicate pred, Statement body, Statement elseBody)
	| each(str var, Expression exp, Statement body)
	| let(list[Assignment] bindings, list[Statement] stats)
	| block(list[Statement] stats)
	| comment(str string)
	| echo(Expression exp)
	| \echo-embedding(Embedding emb)
	| cdata(Expression exp)
	| yield()
	| markup(Markup markup)
	| \markup-stat(list[Markup] markups, Statement stat)
	| \markup-markup(list[Markup] markups, Markup markup)
	| \markup-exp(list[Markup] markups, Expression exp)
	| \markup-embedding(list[Markup] markups, Embedding embedding);

data Assignment = 
	\var-bind(str id, Expression exp)
	| \func-bind(str id, list[str] formals, Statement stat);

data Expression =
	text(str text)
	| var(str id)
	| sym(str sym)
	| num(str nat)
	| field(Expression exp, str name)
	| cat(Expression exp1, Expression exp2)
	| \list(list[Expression] exprs)
	| record(list[KeyValuePair] pairs);

data KeyValuePair = pair(str id, Expression exp);

data Embedding =
	pre(str pre, Embed embed, TextTail tail);

data TextTail = 
	post(str post) 
	| mid(str mid, Embed embed, TextTail tail);

data Embed =
	\exp-embedding(list[Markup], Expression exp)
	| \markup-embedding(list[Markup], Markup markup);

data Markup =
	call(Designator designator, Arguments args)
	| nillary(Designator); // Injection!

data Arguments = args(list[Argument] args);

data Argument = 
	attr(str id, Expression exp)
	| \value(Expression exp); // Injection!

data Designator = 
	\tag(str id, list[Attribute] attrs);

data Attribute =
	id(str val)
	| class(str val)
	| name(str val)
	| type(str val)
	| \width-height(str width, str height)
	| height(str height);

data ModuleId = \module-id(list[str] ids);

data Import = \import(ModuleId id);

data ModuleElement = // these are injections
	\func-def(FunctionDef def)
	| \import-decl(Import imp)
	| site(Site site);

data Module = \module(ModuleId id, list[ModuleElement] body);

data Site = site(list[Mapping] mappings);

data Mapping = mapping(Path path, Markup markup);

data Path = path(str directory, str fileName)
	| filename(str filename); // is injection


data Formals = formals(list[str] ids) | empty();

data FunctionDef = def(str id, Formals formals, list[Statement] stats); 

data Type = \list-type() | \record-type() | \string-type();

data Predicate =
	exp(Expression exp) // injection
	| \is-a(Expression exp, Type type)
	| not(Predicate pred) 
	| and(Predicate left, Predicate right)
	| or(Predicate left, Predicate right);


public Module example = 
  \module(\module-id(["menus"]),[
site(site([mapping(filename("menus.html"),call(\tag("main",[]),args([])))])),
\func-def(def("main",empty(),[\markup-stat([call(\tag("layout",[]),args([\value(text("\"Recursive Menus\""))]))],block([
markup(call(\tag("the-menu",[]),args([])))]))])),\func-def(def("css",formals(["url","media"]),[markup(
call(\tag("link",[]),args([attr("rel",text("\"stylesheet\"")),attr("href",var("url")),
attr("type",text("\"text/css\"")),attr("media",var("media"))])))])),
\func-def(def("layout",formals(["title"]),[\markup-stat([nillary(\tag("html",[]))],block([\markup-stat(
[nillary(\tag("head",[]))],block([markup(call(\tag("css",[]),args([\value(text("\"blueprint.css\"")),
\value(text("\"screen, projection\""))]))),\markup-exp([nillary(\tag("title",[]))],var("title"))])),
\markup-stat([nillary(\tag("body",[]))],yield())]))])),\func-def(def("the-menu",empty(),[markup(call(\tag("menu",[]),
args([\value(record([pair("title",text("\"Menu\"")),pair("kids",\list([record([pair("title",text("\"Home\"")),
pair("link",text("\"/\""))]),record([pair("title",text("\"Misc\"")),pair("kids",
\list([record([pair("title",text("\"Contact\"")),pair("link",text("\"contact.html\""))]),
record([pair("title",text("\"Links\"")),pair("link",text("\"links.html\""))])]))])]))]))])))])),
\func-def(def("menu",formals(["menu"]),[echo(field(var("menu"),"title")),\markup-stat([nillary(\tag("ul",[]))],
each("kid",field(var("menu"),"kids"),markup(call(\tag("item",[]),args([\value(var("kid"))])))))])),
\func-def(def("item",formals(["mi"]),[\markup-stat([nillary(\tag("li",[]))],ifElse(exp(field(var("mi"),"kids")),
markup(call(\tag("menu",[]),args([\value(var("mi"))]))),\markup-exp([call(\tag("a",[]),args([attr("href",
field(var("mi"),"link"))]))],field(var("mi"),"title"))))]))]);


alias Heap = map[str, FunctionDef];
alias Env = map[str, value];
alias Closure = tuple[Env, FunctionDef];

data Undef = undef();

public Heap collectFunctions(Module mod) {
   Heap result = ();
   visit (mod) {
     case FunctionDef f: {  
          result[f.id] = <(), f>;
     } 
   };
   return result;
}

public bool isClosure(value v) {
  return <Env _, FunctionDef _> := v;
}

public value evalExp(Expression exp, Env env) {
  switch (exp) {
    case var(str id): return env[id];
    case num(str nat): return toInt(nat);
    case sym(str sym): return substring(sym, 1);
    case \list(exprs) : return [ evalExp(e, env) | e <- exprs ];
    case record(pairs): return ( k: evalExp(e, env) | pair(str k, Expression e) <- pairs );
    default: return undef();
  }

}

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
     case \is-a(Expression e, Type type): {
        r = evalExp(e, env);
        return typeOf(r) == type;
     }
     case not(arg): return !evalPred(arg, env);
     case and(l, r): return evalPred(l, env) && evalPred(r, env);
     case or(l, r): return evalPred(l, env) || evalPred(r, env);
     default: return false;
   }
}

str unquote(str x) {
   // TODO: unescape \n etc.
   return substring(x, 1, size(x) - 2);
}


public str evalStat(Statement stat, Env env, Heap heap, str block) {
   switch (stat) {
     case echo(e): return toString(evalExp(e, env));
     case yield() : return block;
     // BUG: if < is in string, you get parser error much later.
     case comment(s): return "\<!--" + unquote(s) + "-->";
     case cdata(e): return "\<![CDATA[" + toString(evalExp(e, env)) + "-->";
     //BUG: \if, \if-else geeft null pointer in parser scheduler.
     case ifThen(pred, stat, _): {
	if (evalPred(pred, env)) {
	  return evalStat(stat, env, heap, block);
	}
        return "";
     }
     case ifElse(pred, stat, stat2): {
	if (evalPred(pred, env)) {
	  return evalStat(stat, env, heap, block);
	}
        return evalStat(stat, env, heap, block);
     }
     case each(id, exp, stats): {
        list[value] l;  
	switch (x) {
          case list[value] x: l = x;
          case value x: l = [x];
        }
	str result = "";
	for (x <- l) {
          env[id] = x;
          result += evalStats(stats, env, heap, block);
        }
        return result;
     }
     case let(bins, stats): {
	<env, heap> = evalBindings(bins, env, heap);
        return evalStats(bins, env, heap);
     }
     case markup(markup): {
	return evalMarkups([markup], env, heap, "");
     }
     case \markup-stat(ms, stat): {
	block = evalStat(stat, env, heap, block);
	return evalMarkups(ms, env, heap, block);
     }
     case \markup-exp(ms, exp): {
	block = content(toString(evalStat(exp, env)));
	return evalMarkups(ms, env, heap, block);
     }
     case \markup-markup(ms, markup): {
	return evalMarkups(ms + [markup], env, heap, "");
     }
     case \markup-embedding(ms, emb): {
	block = evalEmbedding(emb, env, heap, "");
	return evalMarkups(ms, env, heap, block);
     }   
   }
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
  return [ evalStat(stat, env, heap, block) | stat <- stats];
}

public str evalMarkups(list[Markup] ms, Env env, Heap heap, str block) {
  for (m <- reverse(ms)) 
    block = evalMarkup(markup, env, heap, block);
  return block;
}

public str evalMarkup(Markup m, Env env, Heap heap, str block) {
   switch (m) {
    case nillary(des): return evalMarkup(call(des, args([])), env, heap, block);
    case call(des, args(as)): {
	as += evalAttributes(des.attrs);
	args = evalArguments(as, env);
	name = des.id;
	if (heap?[name]) {
	   return evalFunction(heap[name], [ v | <_, value v> <- args ], heap);
        } 
	attrs = argsToAttrs(args);
	if (block == "") return "\<<name><attrs>/>";
	return "\<<name><attrs>><block>\<<name>/>";
     }           
   }
}

public str evalFunction(Closure clos, list[value] actuals, Heap heap) {
  if (<Env env, def(str id, formals(list[str] formals), 
	list[Statement] stats)> := clos) {
     i = 0;
     for (f <- formals) {
        v = undef();
        if (i <= size(actuals) - 1) v = actuals[i];
        env[f] = v;
     }
     return evalStatements(stats, env, heap);    
  }
  //error  
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

public str evalArguments(list[Argument] args, Env env) {
   list[tuple[str,value]] result = [];
   if (size(args) > 0) result = " ";
   for (arg <- args) {
     switch (arg) {
      case \value(exp): result += [<"value", evalExp(exp, env)>];
      case attr(id, exp): result += [<id, evalExp(exp, env)>];
     } 
   }
   return result; 
}

public str argsToAttrs(list[tuple[str,value]] args) {
  str result = "";
  for (<name, val> <- args)
    result += " <name>=<val>";	
  return result;
}

