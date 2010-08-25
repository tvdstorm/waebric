module compiler_rascal_v2::C2_visit
import compiler_rascal_v2::C2_Java; 
import compiler_rascal_v2::Tools;
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
import compiler_rascal_v2::Datatypes; 
data Allocatie = allocatie(str id, list[node] args, node val);
public list[str] modul = []; 
public list[str] impor = []; 
public list[tuple[str, list[Statement]]] metho0 = [];
public list[Method] metho = [];
public list[tuple[str, str]] sites = [];
/* FUNCTION (3->1): getEach -> printForEachArray1, getVarList, toString, getStatementData */
public str getEach(Statement stat, list[Allocatie] assignments, bool defaultStyle){
	if(`each ( <a> : <b> ) <c>` := stat){
		if(`<Expression e> . <IdCon idc>`:=b){
			return printForEach1 + "Object $temp = " + printForEachArray1("<e>", "<idc>") + printForEachArray2;
		}else{
			<left, mid, right> = getVarList(b, toString(a), getStatementData(c, assignments, defaultStyle));
			return "<left><mid><right>";
		}
	}
}
/* FUNCTION (1->3): getVarList -> getVarList */
public tuple[str, str, str] getVarList(Expression b){	
	return getVarList(b, "", "");
}
/* FUNCTION (3->3): getVarList -> getExpression_NOT_FIRST_TIME, printForEach3, printForEach8 */
public tuple[str, str, str] getVarList(Expression b, str expr1, str expr2){
	toReturn = ""; 
	ending = "";	
	str left = ""; 
	str mid = "";	
	firstTime = true;
	visit(b){
		case `{ <{KeyValuePair ","}* e> }` : {
			ending += printForEach9;
		}
	}
	if(`[ ]`:=b){
		left += printForEach1 + printForEach2b;
	}else{
		switch(b){
			case `{ <{KeyValuePair ","}* e> }` : { 
				toReturn += getExpression_NOT_FIRST_TIME(b) + ";";
				mid = toReturn; 
				left += printForEach1 + printForEach2;
			}
			case `[ <{Expression ","}* e> ]` : { 
				toReturn += getExpression_NOT_FIRST_TIME(b) + ";";
				mid = toReturn; 
				left += printForEach1 + printForEach2;
			}
			case `<Expression expr>` : {
				if(!firstTime){ 
					toReturn += printForEach4; 	
					mid = toReturn + printForEach5 + ending;
					left += printForEach1 + printForEach2;			
				}else{
					left += printForEach1 + "Object $temp = <b>;";
				} 
				toReturn += printForEach3(toString(expr));
			}
		}
	}
	return <left, mid, printForEach8(expr1, expr2)>;
}
/* FUNCTION (2->0): doVisit -> getData, parse, writeFile, printJava */
public void doVisit(loc inp, loc outputLoc){
	modul = [];	impor = [];	metho = [];	metho0 = []; sites = []; 
	getData(parse(#Module, inp), true);
	writeFile(outputLoc, printJava(modul, metho, sites));
}	
/* FUNCTION (1->1): getArgs -> getExpression_NOT_FIRST_TIME */
public str getArgs(list[Argument] args){ 
	toReturn = ""; 	
	for(Argument arg <- args){
		switch(arg){
			case (Argument) `<Expression expr>` : {
				toReturn += ", <getExpression_NOT_FIRST_TIME(expr)>";
			}
		} 
	}	
	return toReturn;
}
/* FUNCTION (2->1): getExpression2 -> getVarList, getExpression_NOT_FIRST_TIME */
public str getExpression2(IdCon idc, Expression e){	
	switch(e){ 	
		case (Expression) `[ <{ Expression "," }* expressions> ]` :{
			<left, mid, right> = getVarList(e);
			return "{\nfinal Object <idc> = <mid>\n"; 
		}
	} 	
	return "{\nfinal Object <idc> = " + getExpression_NOT_FIRST_TIME(e)+";\n";
}
/* FUNCTION (4->1): getExpression2, toString, size, getStatementData, getMultipleStatementsData */
public str getAssignment(Assignment+ ass, list[Allocatie] assignments, Statement* stats, bool defaultStyle){
	toReturn = ""; 
	closingBrackets = ""; 
	containsStatements = true;
	visit(ass){
		case (Assignment) `<IdCon idc> = <Expression ex> ;`:{
			closingBrackets = "\n}\n" + closingBrackets;
			toReturn += "<getExpression2(idc, ex)>";
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
			toReturn +=	"{\nfinal Func<size(idConList)> <func_name> = new Func<size(idConList)>() {
				public void call(Writer $out, Markup $markup<constrParams>)
				throws IOException, SQLException {
			";
			toReturn += getStatementData(s, assignments, defaultStyle) + "\n\t}\n\t\t};\n";
			assignments += allocatie("<func_name>", idConList, s); 
			containsStatements = false;
		}
	}
	if(containsStatements){		
		toReturn += getMultipleStatementsData(stats, assignments, defaultStyle);	
	}
	else{
		for(Statement stat <- stats){
			toReturn += getStatementData(stat, assignments, defaultStyle);
		}
	}
	toReturn += closingBrackets;
	return toReturn;
}
/* FUNCTION (2->0): getData -> toString, printMarkupParameters, getMarkupData, printMethodName, getFormals */
public void getData(Module source, bool defaultStyle){
	visit(source){
		case (Module) `module <ModuleId mid> <_*>`:
			modul += toString(mid);
		case (Import) `import <ModuleId mid>`:
			impor += toString(mid);
		case (Mapping) `<Path path> : <Markup mu>`:
			sites += [<toString(path), printMarkupParameters(getMarkupData(mu))>];
		case (FunctionDef) `def <IdCon name> <Formals formals> <Statement* stat> end` :{
			metho0 += <printMethodName("<name>"), [ s | `<Statement s>` <- stat]>;
			metho += method(printMethodName("<name>"), [getFormals(formal) | formal <- formals], []);
		}
	}
	list[Method] newMetho = [];
	for(me <- metho){
		for(<str name2, list[Statement] stat> <- metho0){
			if(me.id==name2){ 
				if(me.body==[]){ 
					newMetho += method(me.id, me.args, [getStatementData(s, [], defaultStyle)| Statement s <- stat]); 
				}else{ 
					newMetho += me.body; 
				}
			}
		}
	}
	metho = newMetho;
}
/* FUNCTION (2->1): markupCalculation -> getMarkupData, unQuote, toString, getQuotedString, printAttributes, getStatementData, getArgs */
public str markupCalculation(Markup m, list[Allocatie] assignments){
	<xmlno, parameters> = getMarkupData(m);
	xmlarglist = xmlno.atrs;
	toReturn = "";
	for(par <- parameters){
		if(/`<IdCon idc> = <Expression expr>`:=par){
			str string = "\"<unQuote(toString(expr))>\"";
			for(key <- ["class", "id", "name", "type"]){
				if(key=="<idc>"){
					xmlarglist += xmlargument("<idc>", string);
				}
			}
		}else{
			xmlarglist += xmlargument("value", getQuotedString(unQuote(toString(par))));
		}
	}
	if(xmlarglist!=[]){
		toReturn += printAttributes(xmlarglist);
		toReturn += ";\n$out.write(\" /\>\");\n";
		return toReturn;
	}else{
		for(/`<Expression par>` <- parameters){
			for(ass <- assignments){
				if(ass.id==xmlno.id){	
					k = visit(ass.val){
						case (Expression) `<Expression var>` => par 
					}
					toReturn += getStatementData(k, assignments, false);
				}
			}
		}
		str pars = getArgs(parameters);
		if(toReturn==""){
			for(me <- metho, <name, list[Statement] statementList> <- metho0){ 
				if(name==xmlno.id && name==me.id){ 
					if(me.body==[]){ 
						me.body = [getStatementData(s, assignments, false)| Statement s <- statementList]; 
					} 
					return "<name>($out, $nil<pars>);\n";
				}
			}
			return "$out.write(\"\<\" + \"<"<xmlno.id>">\" + \" /\>\");\n";
		}
		return toReturn;
	}
}
/* FUNCTION (1->1): unQuote -> substring, size */
public str unQuote(str string){
	if(substring(string, 0, 1)=="\"" && substring(string, size(string)-1, size(string))=="\""){
		string = substring(string, 1, size(string)-1);
	}
	return string;
}
/* FUNCTION (3->1): getIfElse -> printIfElseALT, getStatementData, getPredicate */
public str getIfElse(Predicate p, Statement s, Statement s2){
	switch(p){
		case `<Expression expr> . <Type tpe> ?` : 
			return printIfElseALT(getPredicate(p, false), "<s>", "<s2>"); //ben ik hier een asf+sdf bug aan het wegwerken?
		case `! <Predicate p1>` : 
			return printIfElseALT(getPredicate(p, false), "<s>", "<s2>"); 	//ben ik hier een asf+sdf bug aan het wegwerken?
		case `<Predicate p1> && <Predicate p2>` : 
			return printIfElseALT(getPredicate(p, false), "<s>", "<s2>");	//ben ik hier een asf+sdf bug aan het wegwerken?
		case `<Predicate p1> || <Predicate p2>` : 
			return printIfElseALT(getPredicate(p, false), "<s>", "<s2>");	//ben ik hier een asf+sdf bug aan het wegwerken?
		default: {
			return ""; 
		}
	}
}
/* FUNCTION (2->1): getPredicate -> getExpression_NOT_FIRST_TIME, getExpression_FIRST_TIME, getPredicate, splitAtDot, printForEachArray1 */
public str getPredicate(Predicate p, bool defaultStyle){
	switch(p){
		case `<Expression expr>` :{
			if(defaultStyle)
				return "<getExpression_FIRST_TIME(expr)> != null";
			else
				return "<getExpression_FIRST_TIME(expr)>";
		}		
		case `<Expression expr> . <Type tpe> ?` : 
			return "<getExpression_NOT_FIRST_TIME(expr)>.<tpe>?";		
		case `! <Predicate p>` : 
			return "!"+getPredicate(p, false);
		case `<Predicate p1> && <Predicate p2>` : 
			return getPredicate(p1, false) + " && " + getPredicate(p2, false);
		case `<Predicate p1> || <Predicate p2>` : 
			return getPredicate(p1, false) + " || " + getPredicate(p2, false);
		default: {
			<begin, end> = splitAtDot("<p>");
			if(defaultStyle)
				if(begin!=""){
					return printForEachArray1("<begin>", "<end>")+" != null";
				}
				else
					return "<getExpression_FIRST_TIME(p)> != null";
			else
				return "<getExpression_FIRST_TIME(p)>";
		}
	}
}
/* FUNCTION (1->1): getMu1 -> getMarkupData */
public str getMu1(Markup m){
	<xmlno, parameters> = getMarkupData(m);
	if(xmlno.atrs!=[]){
		return "$out.write(\"\<\" + \"<xmlno.id>";
	}
	return "";
}
/*	Check for functions over markup.FUNCTION (3->2): getMuda -> getMarkupData, getArgs, subString, printMarkupData2, getMarkupData, printMethodName, getMu1, markupCalculation, printMethodName, printMarkupData */
public tuple[str, str] getMuda(Markup m, list[Allocatie] assignments, bool defaultStyle){
	toReturn = "";
	endings = "";
	if(me <- metho){
		if(endsWith(me.id, " ")){
			me.id = subString(me.id, 0, size(me.id)-1);
		}
		<xmlno, argus> = getMarkupData(m);
		k = {namcall| var <- assignments, namcall := "<var.id>.call"};
		if(xmlno.id==me.id || "<xmlno.id>.call" in k){
			if(xmlno.id==me.id){
				if(argus!=[]){
					if(defaultStyle){
						toReturn += "<xmlno.id>($out, $nil<getArgs(argus)>";
						endings += ");\n";
					}else{
						toReturn += printMarkupData2("<xmlno.id>");
						endings += "}}<getArgs(argus)>);";
					}
				}else{
					if(defaultStyle){
						toReturn += "<xmlno.id>($out, $nil";
						endings += ");";
					}else{
						toReturn += "<xmlno.id>($out, new Markup() {
			public void render(Writer $out) 
				throws IOException, SQLException {\n
";
						endings += "\n}});\n";
					}
				}
			}
			else if("<xmlno.id>.call" in k){
				if(argus!=[]){
					toReturn += "<xmlno.id>.call($out, $nil";
					endings += "<getArgs(argus)>);";
				}
				else{
					if(defaultStyle){
						toReturn += "<xmlno.id>.call($out, $nil";
						endings += ");";
					}else{
						toReturn += "<xmlno.id>.call($out, new Markup() {
			public void render(Writer $out) 
				throws IOException, SQLException {
";
						endings += "\n}});\n";	
					}
				}
			}
		}else{
			bool functionExists = false;
			theName = ""; theParms = []; theVals = [];
			for(met <- metho){
				<xmlno, argus> = getMarkupData(m);
				methname2 = printMethodName(xmlno.id);
				if(met.id==methname2){
					functionExists = true;
					theName = met.id;
					theVals = argus;
				}
			}
			if(!functionExists){
				if(defaultStyle){
					toReturn += getMu1(m);
					toReturn += markupCalculation(m, assignments);
				}else{
					toReturn += printMarkupData(getMarkupData(m));
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
						toReturn += "<printMethodName(xmlno.id)>($out, $nil<parame>);";
					}
				}
			}
		}
	}
	return <toReturn, endings>;
}
/* FUNCTION (3->1): getStatementData -> getMuda, getStatementData, printExpression, getEmbedding, printIf, getPredicate, getIfElse, getAssignment, getMultipleStatementsData, getEach */
public str getStatementData(Statement stat, list[Allocatie] assignments, bool defaultStyle){
	switch(stat){
		case (Statement) `<Markup+ ms> <Statement s>`: {
			toReturn = "";
			muEnding = "";
			for(Markup m <- ms){
				style = false;
				if("{}"=="<s>"){
					style = true;
				}
				<r1, r2> = getMuda(m, assignments, style);
				toReturn += r1;
				muEnding = r2 + muEnding;
			}
			toReturn += getStatementData(s, assignments, defaultStyle) + muEnding;
            return toReturn;
		}
		case (Statement) `<Markup m> ;`:{
			<r1,r2> = getMuda(m, assignments, true);
			toReturn = r1 + r2;
			return toReturn;
		}
		case (Statement) `<Markup+ ms> <Markup mu> ;`: { 
			toReturn = "";
			muEnding = "";
			for(Markup m <- ms){
				<r1, r2> = getMuda(m, assignments, false); 
				toReturn += r1;
				muEnding = r2 + muEnding;
			}
			<r1, r2> = getMuda(mu, assignments, true);
			toReturn += r1 + r2 + muEnding;  
            return toReturn;
		}
		case (Statement) `<Markup+ ms> <Expression e>;`: {
			toReturn = "";	
			muEnding = "";
			for(/`<Markup m>` <- ms){
				<r1, r2> = getMuda(m, assignments, false); 
				toReturn += r1;
				muEnding = r2 + muEnding;
			}
			toReturn += printExpression(e) + muEnding;
			return toReturn;
		}
		case (Statement) `<Markup+ ms> <Embedding embedding>;`: {
			toReturn = "";
			str muEnding = "";
			for(/`<Markup m>` <- ms){
				<r1, r2> = getMuda(m, assignments, false); 
				toReturn += r1;
				muEnding = r2 + muEnding;
			}
			toReturn += getEmbedding(embedding, assignments, defaultStyle) + muEnding;
			return toReturn;
		}
		case (Statement)`if ( <Predicate p> ) <Statement s> <NoElseMayFollow>`:{
			return printIf(getPredicate(p, true), getStatementData(s, assignments, defaultStyle));
		}
		case (Statement)`if ( <Predicate p> ) <Statement s> else <Statement s2>`:{
			toReturn = getIfElse(p, s, s2);
			if(toReturn!=""){
				return toReturn;
			}
			else{
				return printIfElse(getPredicate(p, true),  
				getStatementData(s, assignments, defaultStyle), 
				getStatementData(s2, assignments, defaultStyle));
			}
		}
		case (Statement)`let <Assignment+ ass> in <Statement* stat> end`:
			return "\n" + getAssignment(ass, assignments, stat, defaultStyle) + "\n";
		case (Statement)`{ <Statement* stat> }`:
			return getMultipleStatementsData(stat, assignments, defaultStyle);
		case (Statement)`comment <StrCon com> ;`:{
			strCom = "<com>";
			return "$out.write(\"\<!--<substring(strCom, 1, size(strCom)-1)>--\>\");";
		}
		case (Statement) `echo <Expression e> ;`:{
			return printExpression(e);
		}
		case (Statement) `echo <Embedding embedding> ;` :{
			return getEmbedding(embedding, assignments, defaultStyle);
		}
		case (Statement) `cdata <Expression e> ;`:
			return "CDATA"; //HIER ZIJN GEEN TESTS VOOR??
		case (Statement)`yield ;`:{
			return "$markup.render($out);\n";
		}
		default : return getEach(stat, assignments, defaultStyle);
	};
}
/* FUNCTION (3->1): getEmbedding */
public str getEmbedding(Embedding embedding, list[Allocatie] assignments, bool defaultStyle){
	if((Embedding) `<preText:_> <Embed e> <TextTail tail>` <- embedding){
		return getEmbedding("<preText>", e, tail, assignments, defaultStyle);
	}
}
/* FUNCTION (3->1): getEmbeddingRec -> toString, substring */
public str getEmbeddingRec(TextTail textTail, list[Allocatie] assignments, bool defaultStyle){
	if((TextTail) `<PostText text>` <- textTail){
		post = toString(text);
		return "$out.write(\"" + substring(post, 1, size(post)-1) + "\");\n";
	}
	else if((TextTail) `<preText:_> <Embed e> <TextTail tail>` <- textTail){
		return getEmbedding(toString(preText), e, tail, assignments, defaultStyle);
	}
}
/* FUNCTION (5->1): getEmbedding -> substring, printMarkupData, getMarkupData, printMarkupEnding, printExpression, getEmbeddingRec, getMu1, markupCalculation*/
public str getEmbedding(str pre, Embed e, TextTail textTail, list[Allocatie] assignments, bool defaultStyle){
	toReturn = "$out.write(\"" + substring(pre, 1, size(pre)-1) + "\");\n";
	if((Embed) `<Markup* ms><Expression expr>` <- e){
		toReturn += ( printExpression(expr) 
			| printMarkupData(mdata) + it + printMarkupEnding(mdata) 
			| m<-ms, mdata:=getMarkupData(m) ) 
		+ getEmbeddingRec(textTail, assignments, defaultStyle);
	}else if((Embed) `<Markup* ms> <Markup mu>` <- e){ 
		toReturn += ( getMu1(mu) + markupCalculation(mu, assignments) 
			| printMarkupData(mdata) + it + printMarkupEnding(mdata)
			| m<-ms, mdata:=getMarkupData(m) ) 
		+ getEmbeddingRec(textTail, assignments, defaultStyle);
	}
	return toReturn;
}
/* FUNCTION (3->1): getMultipleStatementsData -> getStatementData */
public str getMultipleStatementsData(Statement* stat, list[Allocatie] assignments, bool defaultStyle){
	return (""|it+getStatementData(s, assignments, defaultStyle)+"    "|s<-stat);
}
/*FUNCTION (1->2): getMarkupData -> getDesignator */
public tuple[XmlNode, list[Argument]] getMarkupData(Markup markup){
	switch(markup){
		case (Markup) `<Designator des> <Arguments args>` :{
			return <getDesignator(des), [arg| /`<Argument arg>` <- args]>;
		}
		case (Markup) `<Designator des>` :
			return <getDesignator(des), []>;
	}	
}
/* FUNCTION (1->1): getDesignator */
public XmlNode getDesignator(Designator des){
	if(`<IdCon idc> <Attribute* attrs>`:= des){
		toReturn = [];
		for(Attribute attr <- attrs){
			switch(attr){
				case (Attribute) `# <IdCon attribute>` :
					toReturn += xmlargument("id", "\"<attribute>\"");
				case (Attribute) `. <IdCon attribute>` :
					toReturn += xmlargument("class", "\"<attribute>\"");
				case (Attribute) `$ <IdCon attribute>` :
					toReturn += xmlargument("name", "\"<attribute>\"");
				case (Attribute) `: <IdCon attribute>` :
					toReturn += xmlargument("type", "\"<attribute>\"");
				case (Attribute) `@ <NatCon w> % <NatCon h>` :
					toReturn += xmlargument("width-height", "<w>, <h>");
				case (Attribute) `@ <NatCon w>` :
					toReturn += xmlargument("width", "<w>");
				default:{ 
					toReturn += xmlargument("<idc>", []);
				}
			}
		}
		return xmlnode("<idc>", toReturn);
	}
}
/* FUNCTION (1->1): getFormals */
public list[str] getFormals(Formals form){
	toReturn = [];
	visit(form){
		case `<IdCon i>` : {
			toReturn += "<i>";
		}
	}
	return toReturn;
}