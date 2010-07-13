module C2_visit

import C2_Java; 
import Tools;
import languages::waebric::syntax::Waebric; 
import ParseTree; 
import IO; 
import List; 
import Set; 
import String;
import ToString; 
import Relation; 
import Map; 
import Node; 


public list[str] modul = []; 
public list[str] impor = []; 
public list[tuple[str, list[Statement]]] metho0 = [];
public list[tuple[str, list[str], list[str]]] metho = [];
public list[tuple[str, str]] sites = [];

public str getEach(Statement stat, list[tuple[str, list[IdCon], Statement?]] assignments, list[str] formals, bool defaultStyle){
	if(`each ( <a> : <b> ) <c>` := stat){
		if(`<Expression e> . <IdCon idc>`:=b){
			return printForEach1() + "Object $temp = " + printForEachArray1("<e>", "<idc>") + printForEachArray2();
		}else{
			<left, mid, right> = getVarList(b, toString(a), ""+getStatementData(c, assignments, formals, defaultStyle));
			return "<left><mid><right>";
		}
	}
}

public tuple[str, str, str] getVarList(Expression b){	
	return getVarList(b, "", "");
}

public tuple[str, str, str] getVarList(Expression b, str expr1, str expr2){
	toReturn = ""; 
	ending = "";	
	str left = ""; 
	str mid = "";	
	firstTime = true;


	visit(b){
		case `{ <{KeyValuePair ","}* e> }` : {
			ending += ");
	return $v;
	}}.list()";
		}
	}
	if(`[ ]`:=b){
		left += printForEach1() + printForEach2b();
	}else{
		switch(b){
			case `{ <{KeyValuePair ","}* e> }` : { 
				toReturn += getExpression(b, false) + ";";
				mid = "" + toReturn + "" + ""; 
				left += printForEach1()+printForEach2();
			}
			case `[ <{Expression ","}* e> ]` : { 
				toReturn += ""+getExpression(b, false)+";";
				mid = "" + toReturn + "" + ""; 
				left += printForEach1() + printForEach2();
			}
			case `<Expression expr>` : {
				if(!firstTime){ 
					toReturn += "" + printForEach4(); 	
					mid = "" + toReturn + "" + printForEach5() + "" + ending + "";
					left += printForEach1() + printForEach2();			
				}else{
					left += printForEach1() + "Object $temp = <b>;";
				} 
				toReturn += "" + printForEach3(toString(expr));
			}
		}
	}
	return <left, mid, printForEach8(expr1, expr2)>;
}

public void doVisit(loc inp, loc outputLoc){
	modul = [];	impor = [];	metho = [];	metho0 = []; sites = []; 
	getData(parse(#Module, inp), true);
	writeFile(outputLoc, printJava(modul, impor, metho, sites));
}	

public str getArgs(list[Argument] args){ 
	toReturn = ""; 	
	for(Argument arg <- args){
		switch(arg){
			case (Argument) `<Expression expr>` : {
				toReturn += ", <getExpression(expr, false)>";
			}
		} 
	}	
	return toReturn;
}

public str getExpression2(IdCon idc, Expression e, bool firstTime, list[tuple[str, list[IdCon], Statement?]] assignments, bool defaultStyle){	
	switch(e){ 	
		case (Expression) `[ <{ Expression "," }* expressions> ]` :{
			<left, mid, right> = getVarList(e);
			return "{\nfinal Object <idc> = <mid>\n"; 
		}
	} 	
	return "{\nfinal Object <idc> = " + getExpression(e, firstTime)+";\n";
}

public str getAssignment(Assignment+ ass, list[tuple[str, list[IdCon], Statement?]] assignments, Statement* stats, list[str] formals, bool defaultStyle){
	toReturn = ""; 
	closingBrackets = ""; 
	booleanthatneedsaname = true;

	visit(ass){
		case (Assignment) `<IdCon idc> = <Expression ex> ;`:{
			closingBrackets = "\n}\n" + closingBrackets;
			toReturn += "<getExpression2(idc, ex, false, assignments, defaultStyle)>";
		}
		case (Assignment) `<func_name> ( <{IdCon "," }* idcs> ) = <Statement s>`:{

			closingBrackets = "\n}\n" + closingBrackets;
			constrParams = "";
			params = "";
			idConList = []; 
			for(IdCon idc <- idcs){
				idConList += idcs;
				constrParams += ", final Object " + toString(idc);
				params += ", " + toString(idc);
			};
			
			toReturn += 
			"{\nfinal Func<size(idConList)> <func_name> = new Func<size(idConList)>() {
				public void call(Writer $out, Markup $markup<constrParams>)
				throws IOException, SQLException {
";
			toReturn += "" +getStatementData(s, assignments, formals, defaultStyle) + "\n\t}\n\t\t};\n";
			assignments += [<"<func_name>", idConList, s>];
			booleanthatneedsaname = false;
		}
	}
	if(booleanthatneedsaname){		
		toReturn += ""+getMultipleStatementsData(stats, assignments, formals, defaultStyle);	
	}
	else{
		for(Statement stat <- stats){
			toReturn += ""+getStatementData(stat, assignments, formals, defaultStyle);
		}
	}

	toReturn += closingBrackets;
	return toReturn;
}

public void getData(Module source, bool defaultStyle){
	visit(source){
		case (Module) `module <ModuleId mid> <_*>`:
			modul += toString(mid);
		case (Import) `import <ModuleId mid>`:
			impor += toString(mid);
		case (Mapping) `<Path path> : <Markup mu>`:
			sites += [<toString(path), printMarkupParameters(getMarkupData(mu))>]; //TODO: Wat doet printMarkupParameters hier?
		case (FunctionDef) `def <IdCon name> <Formals formals> <Statement* stat> end` :{
			metho0 += <printMethodName("<name>"), [ s | `<Statement s>` <- stat]>;
			metho += <printMethodName("<name>"), [getParameters(formal) | formal <- formals], []>;
		}
	}
	list[tuple[str, list[str], list[str]]] newMetho = [];
	for(<str name, list[str] formals, list[str] statementList> <- metho){
		for(<str name2, list[Statement] stat> <- metho0){
			if(name==name2){ 
				if(statementList==[]){ 
					newMetho += <name, formals, [""+getStatementData(s, [], formals, defaultStyle)| Statement s <- stat]>; 
				}else{ 
					newMetho += statementList; 
				}
			}
		}
	}
	metho = newMetho;
}


public str markupCalculation(Markup m, list[tuple[str, list[IdCon], Statement?]] assignments, list[str] formals){
	<<object, attr>, parameters> = getMarkupData(m);
	newAttr = attr;
	toReturn = "";

	for(par <- parameters){
		if(/`<IdCon idc> = <Expression expr>`:=par){
			str string = "\"<unQuote(toString(expr))>\"";
			for(key <- ["class", "id", "name", "type"]){
				if(key=="<idc>"){
					newAttr += [<"<idc>", string>];
				}
			}
		}else{
			newAttr += [<"value", getQuotedString(unQuote(toString(par)))>];
		}
	}
	if(newAttr!=[]){
		toReturn += ""+printAttributes(newAttr);
		toReturn += ";\n$out.write(\" /\>\");\n";
		return toReturn;
	}else{
		for(/`<Expression par>` <- parameters){
			for(ass <- assignments){
				if(ass[0]==object){	
					k = visit(ass[2]){
						case (Expression) `<Expression var>` => par 
					}
					toReturn += ""+getStatementData(k, assignments, formals, false);
				}
			}
		}
		str pars = getArgs(parameters);
		if(toReturn==""){
			for(<name, list[str] p1, list[str] p2> <- metho, <name, list[Statement] statementList> <- metho0){ 
				if(name==object){ 
					if(p2==[]){ 
						p2 = [""+getStatementData(s, assignments, formals, false)| Statement s <- statementList]; 
					} 
					return "<name>($out, $nil<pars>);\n";
				}
			}
			return "$out.write(\"\<\" + \"<"<object>">\" + \" /\>\");\n";
		}
		return toReturn;
	}
}

public str unQuote(str string){
	if(substring(string, 0, 1)=="\"" && substring(string, size(string)-1, size(string))=="\""){
		string = substring(string, 1, size(string)-1);
	}
	return string;
}

public str getIfElse(Predicate p, Statement s, Statement s2, list[str] formals, list[tuple[str, list[IdCon], Statement?]] assignments, bool defaultStyle){

	switch(p){
		case `<Expression expr> . <Type tpe> ?` : 
			return printIfElseNEW(getPredicate(p, formals, false), "<s>", "<s2>");

		case `! <Predicate p1>` : 
			return printIfElseNEW(getPredicate(p, formals, false), "<s>", "<s2>"); 	

		case `<Predicate p1> && <Predicate p2>` : 
			return printIfElseNEW(getPredicate(p, formals, false), "<s>", "<s2>");

		case `<Predicate p1> || <Predicate p2>` : 
			return printIfElseNEW(getPredicate(p, formals, false), "<s>", "<s2>");

		default: {
			return printIfElse(getPredicate(p, formals, true),  
				""+getStatementData(s, assignments, formals, defaultStyle), 
				""+getStatementData(s2, assignments, formals, defaultStyle));
		}
	}
}

public str getPredicate(Predicate p, list[str] formals, bool defaultStyle){
	switch(p){
		case `<Expression expr>` :{
			if(defaultStyle)
				return "<getExpression(expr, true)> != null";
			else
				return "<getExpression(expr, true)>";
		}		
		case `<Expression expr> . <Type tpe> ?` : 
			return "<getExpression(expr, false)>.<tpe>?";		

		case `! <Predicate p>` : 
			return "!"+getPredicate(p, formals, false);

		case `<Predicate p1> && <Predicate p2>` : 
			return ""+getPredicate(p1, formals, false) + " && " + getPredicate(p2, formals, false);

		case `<Predicate p1> || <Predicate p2>` : 
			return ""+getPredicate(p1, formals, false) + " || " + getPredicate(p2, formals, false);

		default: {
			<begin, end> = getWTF("<p>");
				if(defaultStyle)
					if(begin!=""){
						return ""+printForEachArray1("<begin>", "<end>")+" != null";
					}
					else
						return "<getExpression(p, true)> != null";
				else
					return "<getExpression(p, true)>";
		}
	}
}

public str getMu1(Markup m){
	<<object, attr>, parameters> = getMarkupData(m);
	if(attr!=[]){
		return "$out.write(\"\<\" + \"<object>";
	}
	return "";
}

//check for functions over markup
public tuple[str, str] getMuda(Markup m, list[tuple[str, list[IdCon], Statement?]] assignments, list[str] formals, bool defaultStyle){
	toReturn = "";
	endings = "";
	if(<str name, list[str] params, list[str] values> <- metho){
		if(endsWith(name, " ")){
			name = subString(name, 0, size(name)-1);
		}
		<<name2,_>, argus> = getMarkupData(m);
		k = {<namcall, milf>| <nam, milf, _> <- assignments, namcall:="<nam>.call"};
		if(name2==name || "<name2>.call" in domain(k)){
			if(name2==name){
				if(argus!=[]){
					if(defaultStyle){
						toReturn += "<name2>($out, $nil<getArgs(argus)>";
						endings += ");\n";
					}else{
						toReturn += ""+printMarkupData2("<name2>");
						endings += "}}<getArgs(argus)>);";
					}
				}else{
					if(defaultStyle){
						toReturn += "" + "<name2>($out, $nil";
						endings += ");";
					}else{
						toReturn += "<name2>($out, new Markup() {
			public void render(Writer $out) 
				throws IOException, SQLException {
";
						endings += "\n}});\n";
					}
				}
			}
			else if("<name2>.call" in domain(k)){
				if(argus!=[]){
					toReturn += "<name2>.call($out, $nil";
					endings += "<getArgs(argus)>);";
				}
				else{
					if(defaultStyle){
						toReturn += "<name2>.call($out, $nil);\n";
					}else{
						toReturn += "<name2>.call($out, new Markup() {
			public void render(Writer $out) 
				throws IOException, SQLException {
";
						endings += "\n}});\n";	
					}
				}
			}
			else{
				toReturn += "";
			}
		}else{
			bool functionExists = false;
			theName = ""; theParms = []; theVals = [];
			for(<methname, parms, vals> <- metho){
				<<name2,parms2>, argus> = getMarkupData(m);
				methname2 = printMethodName(name2);
				if(methname==methname2){
					functionExists = true;
					theName = methname;
					theParms = parms2;
					theVals = argus;
				}
			}
			if(!functionExists){
				if(defaultStyle){
					toReturn += ""+getMu1(m);
					toReturn += ""+markupCalculation(m, assignments, formals);
				}else{
					toReturn += ""+printMarkupData(getMarkupData(m));
					endings += printMarkupEnding(getMarkupData(m));
				}
			}else{
				if(!defaultStyle){
					toReturn += "<theName>($out, new Markup() {
			public void render(Writer $out) 
				throws IOException, SQLException {
";
						endings += "\n}}";
						for(vals <- theVals){
							endings += ", \"<vals>\"";
						}
						endings += ");\n";
				}else{
					if(argus==[]){
						toReturn += "<theName>($out, $nil);\n";
					}else{
						args = getArgs(argus);
						parame = ""; 
						for(arg <- args){
							parame += arg;
						}			
						toReturn += "<printMethodName(name2)>($out, $nil<parame>);";
					}
				}
			}
		}
	}else{
		toReturn += "";
	}
	return <toReturn, endings>;
}

public str getStatementData(Statement stat, list[tuple[str, list[IdCon], Statement?]] assignments, list[str] formals, bool defaultStyle){
	switch(stat){
		case (Statement) `<Markup+ ms> <Statement s>`: {
			toReturn = "";
			muEnding = "";
			for(Markup m <- ms){
				style = false;
				if("{}"=="<s>"){
					style = true;
				}
				<r1, r2> = getMuda(m, assignments, formals, style);
				toReturn += r1;
				muEnding += r2;
			}
			toReturn += ""+getStatementData(s, assignments, formals, defaultStyle) + ""+muEnding;
            return toReturn;
		}
		case (Statement) `<Markup m> ;`:{
			<r1,r2> = getMuda(m, assignments, formals, true);
			toReturn = ""+r1 + r2;
			return ""+toReturn;
		}
		case (Statement) `<Markup+ ms> <Markup mu> ;`: { 
			toReturn = "";
			muEnding = "";
			for(Markup m <- ms){
				<r1, r2> = getMuda(m, assignments, formals, false); 
				toReturn += r1;
				muEnding += r2;
			}
			<r1, r2> = getMuda(mu, assignments, formals, true);
			toReturn += r1 + r2 + muEnding;  
            return toReturn;
		}
		case (Statement) `<Markup+ ms> <Expression e>;`: {
			toReturn = "";	
			str muEnding = "";
			for(/`<Markup m>` <- ms){
				<r1, r2> = getMuda(m, assignments, formals, false); 
				toReturn += r1;
				muEnding += r2;
			}
			toReturn += ""+printExpression(e, defaultStyle) + ""+muEnding;
			return toReturn;
		}
		case (Statement) `<Markup+ ms> <Embedding embedding>;`: {
			toReturn = "";
			str muEnding = "";
			for(/`<Markup m>` <- ms){
				<r1, r2> = getMuda(m, assignments, formals, false); 
				toReturn += r1;
				muEnding += r2;
			}
						
			toReturn += ""+getEmbedding(embedding, assignments, formals, defaultStyle) + ""+muEnding;
			return toReturn;
		}
		case (Statement)`if ( <Predicate p> ) <Statement s> <NoElseMayFollow>`:{
			// return getIf();
			return printIf(getPredicate(p, formals, true), ""+getStatementData(s, assignments, formals, defaultStyle));
		}
		case (Statement)`if ( <Predicate p> ) <Statement s> else <Statement s2>`:{
			return getIfElse(p, s, s2, formals, assignments, defaultStyle); 
		}
		case (Statement)`let <Assignment+ ass> in <Statement* stat> end`:
			return "\n" + getAssignment(ass, assignments, stat, formals, defaultStyle) + "\n";
		case (Statement)`{ <Statement* stat> }`:
			return ""+getMultipleStatementsData(stat, assignments, formals, defaultStyle);
		case (Statement)`comment <StrCon com> ;`:{
			strCom = "<com>";
			return "$out.write(\"\<!--<substring(strCom, 1, size(strCom)-1)>--\>\");";
		}
		case (Statement) `echo <Expression e> ;`:{
			return ""+printExpression(e, defaultStyle);
		}
		case (Statement) `echo <Embedding embedding> ;` :{
			return ""+getEmbedding(embedding, assignments, formals, defaultStyle);
		}
		case (Statement) `cdata <Expression e> ;`:
			return "CDATA"; //HIER ZIJN GEEN TESTS VOOR??
		case (Statement)`yield ;`:{
			return "$markup.render($out);\n";
		}
		default : return ""+getEach(stat, assignments, formals, defaultStyle);
	};
}

public str getEmbedding(Embedding embedding, list[tuple[str, list[IdCon], Statement?]] assignments, list[str] formals, bool defaultStyle){
	if((Embedding) `<preText:_> <Embed e> <TextTail tail>` <- embedding){
		return getEmbedding(toString(preText), e, tail, assignments, formals, defaultStyle);
	}
}

public str getEmbeddingRec(TextTail textTail, list[tuple[str, list[IdCon], Statement?]] assignments, list[str] formals, bool defaultStyle){
	if((TextTail) `<PostText text>` <- textTail){
		post = toString(text);
		return "$out.write(\"" + substring(post, 1, size(post)-1) + "\");\n";
	}
	else if((TextTail) `<preText:_> <Embed e> <TextTail tail>` <- textTail){
		return getEmbedding(toString(preText), e, tail, assignments, formals, defaultStyle);
	}
}

public str getEmbedding(str pre, Embed e, TextTail textTail, list[tuple[str, list[IdCon], Statement?]] assignments, list[str] formals, bool defaultStyle){
	toReturn = "$out.write(\"" + substring(pre, 1, size(pre)-1) + "\");\n";
	if((Embed) `<Markup* ms><Expression expr>` <- e){
		list[str] endings = [];
		for(Markup m <- ms){
			toReturn += printMarkupData(getMarkupData(m));
			endings += printMarkupEnding(getMarkupData(m));
		}
		toReturn += printExpression(expr, defaultStyle);
		for(str s <- reverse(endings)){ 
			toReturn += s;
		}
		toReturn += getEmbeddingRec(textTail, assignments, formals, defaultStyle);
	}else if((Embed) `<Markup* ms> <Markup mu>` <- e){
		list[str] endings = [];
		for(Markup m <- ms){
			toReturn += printMarkupData(getMarkupData(m));
			endings += printMarkupEnding(getMarkupData(m));
		}
		toReturn += getMu1(mu);
		toReturn += markupCalculation(mu, assignments, formals);
		for(str s <- reverse(endings)){ 
			toReturn += s;
		}
		toReturn += getEmbeddingRec(textTail, assignments, formals, defaultStyle);
	}
	return toReturn;
}

public str getMultipleStatementsData(Statement* stat, list[tuple[str, list[IdCon], Statement?]] assignments, list[str] formals, bool defaultStyle){
	toReturn = "";
	for(Statement s <- stat){	
		toReturn += ""+getStatementData(s, assignments, formals, defaultStyle)+"    ";	
	};
	return toReturn;
}

public tuple[tuple[str, list[tuple[str, str]]], list[Argument]] getMarkupData(Markup markup){
	switch(markup){
		case (Markup) `<Designator des> <Arguments args>` :{
			return <getDesignator(des), [arg| /`<Argument arg>` <- args]>;
		}
		case (Markup) `<Designator des>` :
			return <getDesignator(des), []>;
	}	
}

public tuple[str, list[tuple[str, str]]] getDesignator(Designator des){
	if(`<IdCon idc> <Attribute* attrs>`:= des){
		toReturn = [];
		for(Attribute attr <- attrs){
			switch(attr){
				case (Attribute) `# <IdCon attribute>` :
					toReturn += [<"id", "\"<attribute>\"">];
				case (Attribute) `. <IdCon attribute>` :
					toReturn += [<"class", "\"<attribute>\"">];
				case (Attribute) `$ <IdCon attribute>` :
					toReturn += [<"name", "\"<attribute>\"">];
				case (Attribute) `: <IdCon attribute>` :
					toReturn += [<"type", "\"<attribute>\"">];
				case (Attribute) `@ <NatCon w> % <NatCon h>` :
					toReturn += [<"width-height", "<w>, <h>">];
				case (Attribute) `@ <NatCon w>` :
					toReturn += [<"width", "<w>">];
				default:{ 
					toReturn += [<"<idc>", []>];
				}
			}
		}
		return <"<idc>", toReturn>;
	}
}

public list[str] getParameters(Formals pars){
	toReturn = [];
	visit(pars){
		case `<IdCon i>` : {
			toReturn += toString(i);
		}
	}
	return toReturn;
}
