module C2_Java

import Tools;
import List;
import String;
import languages::waebric::syntax::Waebric;
import ParseTree; 
import IO; 
import Set; 
import ToString; 
import Relation; 
import Map; 
import Node; 


/* VAL_IN: 5 VAL_OUT: 1
FUNCTION: printJava -> printConstructor, getOneFrom, printFunctions */
public str printJava(list[str] modul, list[str] impor, list[tuple[str, list[str], list[str]]] metho, list[tuple[str, str]] sites){ return 	
"<printImports> 
<printConstructor(getOneFrom(modul), sites)>
	<printFunctions(metho)>
<printInterfaces> 
<printInterfaces_2>
";}

/* VAL_IN: 4 VAL_OUT: 1 FUNCTION: printMarkupData -> printMarkupParametersRec, printAttributes */
public str printMarkupData(tuple[tuple[str, list[tuple[str, str]]], list[void]] markup){ 
	<<mu,atr>, pars> = markup;
	toReturn = "$out.write(\"\<<mu>";
	if(pars==[] && atr==[]){
		return toReturn + "\>\");\n";
	}else{
		if(pars!=[]){
			return toReturn + "\");\n" + printMarkupParametersRec(pars);
		}else{
			return toReturn + printAttributes(atr) + "\n$out.write(\"\>\");\n";
		}
	}
}

/* VAL_IN: 1 VAL_OUT: 1 FUNCTION: printMethodName -> replaceAll */
public str printMethodName(str name){
	name = replaceAll(name, " ", "");
	return replaceAll(name, "-", "_");
}

/* VAL_IN: 2 VAL_OUT: 1 FUNCTION: printAttributes -> getAttributeList */
public str printAttributes(list[tuple[str,str]] atr){
	<javaCode, iterator> = getAttributeList(atr, "class", 0);
	toReturn = javaCode; 
	<javaCode, iterator> = getAttributeList(atr, "id", iterator);
	toReturn += javaCode;
	<javaCode, iterator> = getAttributeList(atr, "name", iterator);
	toReturn += javaCode;  
	<javaCode, iterator> = getAttributeList(atr, "type", iterator);
	toReturn += javaCode; 
	<javaCode, iterator> = getAttributeList(atr, "value", iterator);
	toReturn += javaCode; 
	toReturn += "\");";
	return toReturn;
}

/* VAL_IN: 4 VAL_OUT: 2 FUNCTION: getAttributeList -> getOneFrom, head, size, tail */
public tuple[str, int] getAttributeList(list[tuple[str,str]] attr, str attribute_type, int iterator){
	default1 = "\");\n$out.write(\"";
	default2 = ");\n";
	default3 = "$out.write(";
	int currSize = iterator;
	toReturn = "";
	attributeList = [ val | <attribute_type, val> <- attr];
	attrLength = [tp| tuple[str,str] x:<tp, vl> <- attr];
	if(attributeList!=[]){
		currSize += 1;
		headVal = getOneFrom(head(attributeList, 1));
		if(size(attributeList)==1){
			if(currSize==size(attr)){
				toReturn += default1 + " "+attribute_type+"=\\\"\" + <"<headVal>"> + \"\\\"";
			}else{
				toReturn += default1 + " " + default1 + attribute_type+"=\\\"\" + <"<headVal>"> " + default2 + default3 + "\"\\\"";
			}
		}else{
			toReturn += default1 + " " + default1 + attribute_type+"=\\\"\" + <"<headVal>"> " + default2 + default3;
			for(val <- tail(attributeList, size(attributeList)-1)){
				currSize += 1;
				toReturn += "\" \" + <val>" + default2 + default3 + "\"\\\"";
			}
		}
	}
	return <toReturn, currSize>;
}

/* VAL_IN: 1 VAL_OUT: 1 FUNCTION: printMarkupData2 */
public str printMarkupData2(str name){ return 
"<name>($out, new Markup() {
	public void render(Writer $out) 
		throws IOException, SQLException {
";}

/* VAL_IN: 4 VAL_OUT: 1 FUNCTION: printMarkupEnding */
public str printMarkupEnding(tuple[tuple[str, list[tuple[str, str]]], list[void]] markup){ 
<<mu,atr>, pars> = markup;
return
"$out.write(\"\</<mu>\>\");
";}

/* VAL_IN: 1 VAL_OUT: 1 FUNCTION: printMarkupParametersRec -> head, getExpression, printMarkupParametersRec, tail */
public str printMarkupParametersRec(list[Argument] args){
	if(`<IdCon id> = <Expression e>` := head(args)){
		if(size(args)==1){ return 
"$out.write(\" <"<id>">=\\\"\" + <"<getExpression(e, false)>"> + \"\\\"\");
$out.write(\"\>\");\n";
		}else{ return 
"$out.write(\" \"); 
$out.write(\"<"<id>">=\\\"\" + <"<getExpression(e, false)>"> );
$out.write(\"\\\"\");\n" 
			+ printMarkupParametersRec(tail(args)) + "\n";
		}
	}
}

/* VAL_IN: 3 VAL_OUT: 1 FUNCTION: printIfElse */
public str printIfElse(str condition, str doIf, str doElse){ 
	return "
			if (<condition>) {
				<doIf>
			}
			else {
				<doElse>
			}
";
}

/* VAL_IN: 3 VAL_OUT: 1 FUNCTION: printIfElseALT */
public str printIfElseALT(str condition, str doIf, str doElse){ // Is dit wel de bedoeling?
	return "stat-to-jstats(if (<condition>)
			<doIf>
		else
			<doElse>)
";
}

/* VAL_IN: 2 VAL_OUT: 1 FUNCTION: printIf */
public str printIf(str condition, str doIf){ 
	return "
			if (<condition>) {
				<doIf>
			}
";
}

/* VAL_IN: 1 VAL_OUT: 1 FUNCTION: printIfALT */
public str printIfALT(str condition, str doIf){ 
	return "stat-to-jstats(if (<condition>)
			<doIf>)
";
}

/* The constructor of the java code, and the creation of the html files. 
VAL_IN: 3 VAL_OUT: 1 FUNCTION: printConstructor */
private str printConstructor(str module_id, list[tuple[str,str]] sites){ return 
"@SuppressWarnings(\"unchecked\")
public class <module_id> {
	private static final Markup $nil = new Markup() { public void render(Writer $out)  
			throws IOException, SQLException { } };
	public static void main(String args[]) throws IOException, SQLException {
		new <module_id>().generateSite();
	}
	public void generateSite(String root) throws IOException, SQLException  {
		Writer writer;
		<printSites(sites)>
	}
	public void generateSite() throws IOException, SQLException {
		generateSite(\"<".">\");
	}
";}

/* VAL_IN: 2 VAL_OUT: 1 FUNCTION: printSites -> printSite */
private str printSites(list[tuple[str, str]] sites) { 
	returnable = "";
	for(<str site, str pars> <- sites){
		returnable += printSite(site, pars);
	}
	return returnable;
}

/* VAL_IN: 2 VAL_OUT: 1 FUNCTION: printSite */
private str printSite(str site, str parameters) { return 
"writer = new FileWriter(new File(root,\"" + site + "\"));
		new Markup() {
			public void render(Writer $out)
				throws IOException, SQLException {
$out.write(\"\<!DOCTYPE html PUBLIC \\\"-//W3C//DTD XHTML 1.0 Transitional//EN\\\" \\\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\\\"\>\\n\");
				home($out, $nil<parameters>);
			}
		}.render(writer);
		writer.close();
";}

/* VAL_IN: 3 VAL_OUT: 1 FUNCTION: printFunctions -> printFunction */
private str printFunctions(list[tuple[str, list[str], list[str]]] methodes) {
	returnable = "";
	for(<str id, list[str] params, list[str] methodBody> <- methodes){
		returnable += printFunction(id, params, methodBody);
	}
	return returnable;
}

/* VAL_IN: 3 VAL_OUT: 1 FUNCTION: printFunction -> printConstuctorParams, printMarkup, printMethodParams */
private str printFunction(str id, list[str] params, list[str] mu){ return
"private void <id>(final Writer $out, final Markup $markup" + printConstuctorParams(params) + ") 
	throws IOException, SQLException {
	<printMarkup(mu)>
}

public void " + id + "(final Writer $out"+printConstuctorParams(params)+")
	throws IOException, SQLException {
	"+ id +"($out, $nil"+printMethodParams(params)+");
}
";}

/* VAL_IN: 1 VAL_OUT: 1 FUNCTION: printConstuctorParams */
public str printConstuctorParams(list[str] pars){ 
	toReturn = "";
	for(str p <- pars){
		toReturn += ", final Object "+p;
	}
	return toReturn;
}

/* VAL_IN: 1 VAL_OUT: 1 FUNCTION: printMarkup */
public str printMarkup(list[str] mu){
	returnable = "";
	for(str s <- mu){
		returnable += s;
	}
	return returnable;
}

/* VAL_IN: 1 VAL_OUT: 1 FUNCTION: printMethodParams */
public str printMethodParams(list[str] pars){
	toReturn = "";
	for(str p <- pars){
		toReturn += ", "+p;
	}
	return toReturn;
}

/* VAL_IN: 1 VAL_OUT: 1 FUNCTION: printForEach3 */
public str printForEach3(str var){ return "
public List\<Object\> list() {
	List\<Object\> $v = new ArrayList\<Object\>()
;
	$v.add(\"<var>\");";
}

/* VAL_IN: 2 VAL_OUT: 1 FUNCTION: printForEach8 */
public str printForEach8(str a, str b) { return "
	Iterable\<Object\> $iter;
	if ($temp instanceof Iterable) {
		$iter = (Iterable\<Object\>)$temp;
	}
	else if ($temp instanceof Map) {
		List\<Object\> $list = new ArrayList\<Object\>()

;
		for (Map.Entry\<String,Object\> $entry: (Map\<String,Object\>)$temp.entrySet()) {
			List\<Object\> $tuple = new ArrayList\<Object\>()

;
			$tuple.add($entry.getKey());
			$tuple.add($entry.getValue());
			$list.add($tuple);
		}
		$iter = $list;
	}
	else if ($temp instanceof ResultSet) {
		ResultSet $rs = (ResultSet)$temp;
		boolean $first = $rs.first();
		if (!$first) {
			return;
		}
		ResultSetMetaData $meta = 
			$rs.getMetaData();
		Map\<String,Object\> <a> = 
			new Hashtable\<String,Object\>();
		for (int $i = 0; $i \< $meta.getColumnCount(); $i++) {
			<a>.put($meta.getColumnName($i), \"null\");
		}
		while ($rs.next()) {
			for (String $k: <a>.keySet()) {
				Object $v = $rs.getObject($k);
				if ($v != null) {
					<a>.put($k, $v);
				}
				else {
					<a>.put($k, \"null\");
				}

				<strip(b)>;
			}
		}				
		return;
	}
	else {
		List\<Object\> $single = new ArrayList\<Object\>()

;
			$single.add($temp);
			$iter = $single;
		}
		for (final Object <a>: $iter) {
			<b>
		}
		}
	}.each($out);
";
}

/* VAL_IN: 2 VAL_OUT: 1 FUNCTION: printForEachArray1 */
public str printForEachArray1(str parent, str kids){ return 
"new Object() {
	public Object field() throws SQLException {
		Object $temp = <parent>;
		Object $result = \"null\";
		if ($temp instanceof Map) {
			$result = (Map\<String,Object\>)$temp.
				get(\"<kids>\");
		}
		else if ($temp instanceof ResultSet) {
			$result = (ResultSet)$temp.
				getObject(\"<kids>\");
			
		}
		else {
			$result = \"\<invalid type for field dereference \" +
				$temp.getClass().toString() + \"\>\";
		}
		return $result;
	}
}.field()";
}

/* VAL_IN: 1 VAL_OUT: 1 FUNCTION: printExpression -> printLine, getExpression */
public str printExpression(Expression e){
	return printLine(getExpression(e, true));
}

/* VAL_IN: 1 VAL_OUT: 1 FUNCTION: printLine */
public str printLine(str toPrint){
	return "$out.write(<toPrint>);\n";
}

/*
VAL_IN: 2
VAL_OUT: 1
FUNCTION: getExpression -> getKeyValuePairs, toString, getQuotedString, replaceAll, printForEachArray1
*/
public str getExpression(Expression e, bool firstTime){
	switch(e){
		case (Expression) `<Expression e1> + <Expression e2> ` :{
			if(firstTime)
				return getExpression(e1, false) + " + " + getExpression(e2, false) + ".toString()";
			else
				return getExpression(e1, false) + " + " + getExpression(e2, false);
		}
		case (Expression) `{ <{KeyValuePair ","}* kv> }` :{
			if(firstTime){
				return "new Hashtable\<String,Object\>()\n.toString()";
			}else{
				str toReturn = "";
				str ending = "";
				bool eerste = true; 
				for(KeyValuePair pair <- kv){
					if(eerste){
						eerste = false;
						ending += printArrayCloseNEW;
					}else{
						onlyOne = true;
						toReturn += printArray4;
						ending += printArrayClose2;
					}
					toReturn += getKeyValuePairs(pair);
				}
				return toReturn + ending;
			}			

		}
		case (Expression) `[ <{ Expression "," }* i> ]` :{
			if(firstTime){
				return "new ArrayList\<Object\>()\n.toString()";
			}else{
				str toReturn = "";
				str endings = "";
				bool firstTime = true;
				str listClose = "";
	
				for(Expression expr <- i, "<expr>"!=""){
					if(firstTime){
						firstTime = false;
						toReturn += printList1;
						toReturn += getExpression(expr, false);
						listClose = printListClose;
						endings += printForEach9;
					}
					else if(substring("<i>", 0, 1)=="\""){
						toReturn += printArray2;
						toReturn += getExpression(expr, false);
					}
					else if(substring("<i>", 0, 1)=="{"){
						toReturn += something + getExpression(expr, false);
						endings += printForEach9;
					}
					else{
						toReturn += something;
						toReturn += getExpression(expr, false);
						endings += printForEach9;
					}
				}
				return toReturn + listClose + endings;
			}
		}
		case (Expression) `<IdCon i>` :{
			if(firstTime){
				return "<toString(e)>.toString()";
			}
			else{
				return toString(e);
			}
		}
		case (Expression) `<SymbolCon s>` :{
			return getQuotedString("<s>");
		}
		case (Expression) `<NatCon n>` :{
			if(firstTime)
				return "\"" + toString(e) + "\"";
			else{
				return "\"<toString(e)>\"";
}
		}
		case (Expression) `<Text t>` :{
			toReturn = getQuotedString("<t>");
			toReturn = replaceAll(toReturn, "\n", "\\n");
			return toReturn;
		}

		case (Expression) `<Expression e1> . <IdCon idc>` :
			if(firstTime)
				return printForEachArray1("<e1>", "<idc>")+".toString()";
			else
				return printForEachArray1("<e1>", "<idc>");
		default : {
			if(isNumber("<e>")){
				return "\""+toString(e)+"\"";
			}else{
				return toString(e);
			}
		}
	}
}

/* VAL_IN: 1 VAL_OUT: 1 FUNCTION: getQuotedString -> startsWith, substring, size */
public str getQuotedString(str toReturn){
	if(startsWith(toReturn, "'")){
		return "\"" + substring(toReturn, 1, size(toReturn)) + "\"";
	}
	return toReturn; 
}

/* VAL_IN: 1 VAL_OUT: 1 FUNCTION: getKeyValuePairs -> getExpression, printArray3 */
public str getKeyValuePairs(KeyValuePair kv){
	toReturn = "";
	switch(kv){
		case (KeyValuePair) `<IdCon idc> : <Expression expr>` : {
			str expression = getExpression(expr, false);
			toReturn +=  printArray3("<idc>", expression);
		}
	}
	return toReturn;
}

/* VAL_IN: 2 VAL_OUT: 1 FUNCTION: printArray3 */
public str printArray3(str nam, str val) { return
	"new Object() {
			public Map\<String,Object\> map() {
				Map\<String,Object\> $v = new Hashtable\<String,Object\>()
;
	$v.put(\"<nam>\", <val>);";
}


private str printImports =
"import java.io.IOException;
import java.io.Writer;
import java.io.StringWriter;
import java.io.FileWriter;
import java.io.File;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;
";

private str printInterfaces = "}
interface Markup {
	public void render(Writer out) throws IOException, SQLException;
}
interface Func10 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3,
		Object arg4,
		Object arg5,
		Object arg6,
		Object arg7,
		Object arg8,
		Object arg9,
		Object arg10)
		throws IOException, SQLException;
}
interface Func9 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3,
		Object arg4,
		Object arg5,
		Object arg6,
		Object arg7,
		Object arg8,
		Object arg9)
		throws IOException, SQLException;
}
interface Func8 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3,
		Object arg4,
		Object arg5,
		Object arg6,
		Object arg7,
		Object arg8)
		throws IOException, SQLException;
}
interface Func7 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3,
		Object arg4,
		Object arg5,
		Object arg6,
		Object arg7)
		throws IOException, SQLException;
}
interface Func6 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3,
		Object arg4,
		Object arg5,
		Object arg6)
		throws IOException, SQLException;
}";

private str printInterfaces_2 = 
"interface Func5 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3,
		Object arg4,
		Object arg5)
		throws IOException, SQLException;
}
interface Func4 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3,
		Object arg4)
		throws IOException, SQLException;
}
interface Func3 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2,
		Object arg3)
		throws IOException, SQLException;
		}
interface Func2 {
	public void call(Writer out, Markup markup, Object arg1,
		Object arg2)
		throws IOException, SQLException;
}
interface Func1 {
	public void call(Writer out, Markup markup, Object arg1)
		throws IOException, SQLException;
}
interface Func0 {
	public void call(Writer out, Markup markup)
		throws IOException, SQLException;
}";

public str printForEach1 = "
new Object() {
public void each(final Writer $out) 
	throws IOException, 
		SQLException  {
";

public str printForEach2 = "
Object $temp = ";

public str printForEach2b = "
Object $temp = new ArrayList\<Object\>()
;";

public str printForEach4 = "
	$v.addAll(new Object() {";

public str printForEach5 = "
	$v.addAll(new ArrayList\<Object\>() 
);";

public str printForEach6 = "
	return $v;
	}}.list());
";

public str printForEach9 = ");
	return $v;
	}}.list()";

public str printForEachArray2 =
";
		Iterable\<Object\> $iter;
		if ($temp instanceof Iterable) {
			$iter = (Iterable\<Object\>)$temp;
		}
		else if ($temp instanceof Map) {
			List\<Object\> $list = new ArrayList\<Object\>()

;
			for (Map.Entry\<String,Object\> $entry: (Map\<String,Object\>)$temp.entrySet()) {
				List\<Object\> $tuple = new ArrayList\<Object\>()
;
				$tuple.add($entry.getKey());
				$tuple.add($entry.getValue());
				$list.add($tuple);
			}
			$iter = $list;
		}
		else if ($temp instanceof ResultSet) {
			ResultSet $rs = (ResultSet)$temp;
			boolean $first = $rs.first();
			if (!$first) {
				return;
			}
			ResultSetMetaData $meta = 
				$rs.getMetaData();
			Map\<String,Object\> kid = 
				new Hashtable\<String,Object\>();
			for (int $i = 0; $i \< $meta.getColumnCount(); $i++) {
				kid.put($meta.getColumnName($i), \"null\");
			}
			while ($rs.next()) {
				for (String $k: kid.keySet()) {
					Object $v = $rs.getObject($k);
					if ($v != null) {
						kid.put($k, $v);
					}
					else {
						kid.put($k, \"null\");
					}
					item($out, $nil, kid);;
				}
			}				
			return;
		}
		else {
			List\<Object\> $single = new ArrayList\<Object\>()

;
				$single.add($temp);
				$iter = $single;
			}
			for (final Object kid: $iter) {
				item($out, $nil, kid);
			}
			}
		}.each($out);
";

public str something = ");
				$v.addAll(new Object() {
			public List\<Object\> list() {
				List\<Object\> $v = new ArrayList\<Object\>()\n;\n\t\t\t\t$v.add(";

public str printList1 =
	"new Object() {
			public List\<Object\> list() {
				List\<Object\> $v = new ArrayList\<Object\>()
;
				$v.add(";

public str printArray2 = "
	$v.put(";

public str printArray4 = "
	$v.putAll(";

public str printArrayCloseNEW = "
	$v.putAll(new Hashtable\<String,Object\>()			
);
				return $v;
			}}.map()";

public str printArrayClose2 = ");
				return $v;
			}}.map()";

public str printListClose = ");
	$v.addAll(new ArrayList\<Object\>()
";