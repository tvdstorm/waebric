module compiler_rascal_v2::C2_Java
import compiler_rascal_v2::Tools;
import compiler_rascal_v2::Datatypes;
import languages::waebric::syntax::Waebric;
import List;
import String;
import ParseTree; 
import IO; 
import Set; 
import ToString; 
import Relation; 
import Map; 
import Node; 
/* FUNCTION (3->1): printJava -> printConstructor, getOneFrom, printFunctions */
public str printJava(list[str] modul, list[Method] metho, list[Website] sites){ return 
	"<printImports> 
	<printConstructor(getOneFrom(modul), sites)>
		<(""|it+printFunction(me)| me <- metho)>
	<printInterfaces> 
	<printInterfaces_2>
	";
}
/* FUNCTION (1->1): printMarkupData -> printMarkupParametersRec, printAttributes */
public str printMarkupData(MarkupData markupData){ 
	toReturn = "$out.write(\"\<<markupData.nod.node_type>";
	if(markupData.args==[] && markupData.nod.atrs==[]){
		return toReturn + "\>\");\n";
	}else{
		if(markupData.args!=[]){
			return toReturn + "\");\n" + printMarkupParametersRec(markupData.args);
		}else{
			return toReturn + printAttributes(markupData.nod.atrs) + "\n$out.write(\"\>\");\n";
		}
	}
}
/* FUNCTION (1->1): printMethodName -> replaceAll */
public str printMethodName(str name){
	name = replaceAll(name, " ", "");
	return replaceAll(name, "-", "_");
}
/* FUNCTION (1->1): printAttributes -> getAttributeList */
public str printAttributes(list[XmlArgument] atr){
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
/* FUNCTION (3->2): getAttributeList -> getOneFrom, head, size, tail */
public tuple[str, int] getAttributeList(list[XmlArgument] attr, str attribute_type, int iterator){
	default1 = "\");\n$out.write(\"";
	default2 = ");\n";
	default3 = "$out.write(";
	int currSize = iterator;
	toReturn = "";
	attributeList = [ xmlarg.attribute | xmlarg <- attr, attribute_type:=xmlarg.id];
	attrLength = [xmlarg.id| xmlarg <- attr];
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
/* FUNCTION (1->1): printMarkupData2 */
public str printMarkupData2(str name){ return 
"<name>($out, new Markup() {
	public void render(Writer $out) 
		throws IOException, SQLException {
";}
/* FUNCTION (1->1): printMarkupEnding */
public str printMarkupEnding(MarkupData markupData){ return
"$out.write(\"\</<markupData.nod.node_type>\>\");
";}
/* FUNCTION (1->1): printMarkupParametersRec -> head, getExpression_NOT_FIRST_TIME, printMarkupParametersRec, tail */
public str printMarkupParametersRec(list[Argument] args){
	if(`<IdCon id> = <Expression e>` := head(args)){
		if(size(args)==1){ return 
"$out.write(\" <"<id>">=\\\"\" + <"<getExpression_NOT_FIRST_TIME(e)>"> + \"\\\"\");
$out.write(\"\>\");\n";
		}else{ return 
"$out.write(\" \"); 
$out.write(\"<"<id>">=\\\"\" + <"<getExpression_NOT_FIRST_TIME(e)>"> );
$out.write(\"\\\"\");\n" 
			+ printMarkupParametersRec(tail(args)) + "\n";
		}
	}
}
/* FUNCTION (3->1): printIfElse */
public str printIfElse(str condition, str doIf, str doElse){ return "
			if (<condition>) {
				<doIf>
			}
			else {
				<doElse>
			}
";}
/* FUNCTION (3->1): printIfElseALT */
public str printIfElseALT(str condition, str doIf, str doElse){ // Is dit wel de bedoeling?
	return "stat-to-jstats(if (<condition>)
			<doIf>
		else
			<doElse>)
";}
/* FUNCTION (2->1): printIf */
public str printIf(str condition, str doIf){ return "
			if (<condition>) {
				<doIf>
			}
";}
/* FUNCTION (2->1): printConstructor */
private str printConstructor(str module_id, list[Website] sites){ return 
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
/* FUNCTION (1->1): printSites -> printSite */
private str printSites(list[Website] sites) { 
	return (""|printSite(siteId)+printSiteParameters(siteVal)+it|site<-sites, siteId:=site.id, siteVal:=site.val);
}
/* FUNCTION (1->1): printSite */
private str printSite(str site) { return 
"writer = new FileWriter(new File(root,\"" + site + "\"));
";}
/* FUNCTION (1->1): printSiteParameters */
private str printSiteParameters(str parameters){ return
"new Markup() {
			public void render(Writer $out)
				throws IOException, SQLException {
$out.write(\"\<!DOCTYPE html PUBLIC \\\"-//W3C//DTD XHTML 1.0 Transitional//EN\\\" \\\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\\\"\>\\n\");
				home($out, $nil<parameters>);
			}
		}.render(writer);
		writer.close();
";}
/* FUNCTION (1->1): printFunction -> printConstuctorParams, printMarkup, printMethodParams */
private str printFunction(Method me){ return
"private void <me.id>(final Writer $out, final Markup $markup" + printConstuctorParams(me.args) + ") 
	throws IOException, SQLException {
	<printMarkup(me.body)>
}
public void " + me.id + "(final Writer $out"+printConstuctorParams(me.args)+")
	throws IOException, SQLException {
	"+ me.id +"($out, $nil"+printMethodParams(me.args)+");
}
";}
/* FUNCTION (1->1): printConstuctorParams */
public str printConstuctorParams(list[str] pars){ 
	toReturn = "";
	for(str p <- pars){
		toReturn += ", final Object "+p;
	}
	return toReturn;
}
/* FUNCTION (1->1): printMarkup */
public str printMarkup(list[str] mu){
	return (""|it+x|x<-mu);	
}
/* FUNCTION (1->1): printMethodParams */
public str printMethodParams(list[str] pars){
	return (""|it+", <x>"|x<-pars);
}
/* FUNCTION (1->1): printForEach3 */
public str printForEach3(str var){ return "
public List\<Object\> list() {
	List\<Object\> $v = new ArrayList\<Object\>()
;
	$v.add(\"<var>\");";
}
/* FUNCTION (2->1): printForEach8 -> strip */
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
/* FUNCTION (2->1): printForEachArray1 */
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
/* FUNCTION (1->1): printExpression -> printLine, getExpression */
public str printExpression(Expression e){
	return printLine(getExpression_FIRST_TIME(e));
}
/* FUNCTION (1->1): printLine */
public str printLine(str toPrint){
	return "$out.write(<toPrint>);\n";
}
/* FUNCTION (1->1): getExpression_FIRST_TIME -> getQuotedString, replaceAll, toString */
public str getExpression_FIRST_TIME(Expression e){
	switch(e){
		case (Expression) `<Expression e1> + <Expression e2> ` :{ 
			return getExpression_NOT_FIRST_TIME(e1) + " + " + getExpression_NOT_FIRST_TIME(e2) + ".toString()";
		}
		case (Expression) `{ <{KeyValuePair ","}* kv> }` :{
			return "new Hashtable\<String,Object\>()\n.toString()";
		}
		case (Expression) `[ <{ Expression "," }* i> ]` :{ 
			return "new ArrayList\<Object\>()\n.toString()";
		}
		case (Expression) `<IdCon i>` :{
			return "<toString(e)>.toString()";
		}
		case (Expression) `<SymbolCon s>` :{
			return getQuotedString("<s>");
		}
		case (Expression) `<NatCon n>` :{
			return "\"" + toString(e) + "\"";
		}
		case (Expression) `<Text t>` :{
			toReturn = getQuotedString("<t>");
			toReturn = replaceAll(toReturn, "\n", "\\n");
			return toReturn;
		}
		case (Expression) `<Expression e1> . <IdCon idc>` :
			return printForEachArray1("<e1>", "<idc>")+".toString()";
		default : {
			if(isNumber("<e>")){
				return "\""+toString(e)+"\"";
			}else{
				return toString(e);
			}
		}
	}
}
/* FUNCTION (1->1): getExpression_NOT_FIRST_TIME -> getKeyValuePairs, getQuotedString, replaceAll, printForEachArray1 */
public str getExpression_NOT_FIRST_TIME(Expression e){
	switch(e){
		case (Expression) `<Expression e1> + <Expression e2> ` :{
			return getExpression_NOT_FIRST_TIME(e1) + " + " + getExpression_NOT_FIRST_TIME(e2);
		}
		case (Expression) `{ <{KeyValuePair ","}* kv> }` :{
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
		case (Expression) `[ <{ Expression "," }* i> ]` :{
			str toReturn = "";
			str endings = "";
			bool firstTime = true;
			str listClose = "";
	
			for(Expression expr <- i, "<expr>"!=""){
				if(firstTime){
					firstTime = false;
					toReturn += printList1;
					toReturn += getExpression_NOT_FIRST_TIME(expr);
					listClose = printListClose;
					endings += printForEach9;
				}
				else if(substring("<i>", 0, 1)=="\""){
					toReturn += printArray2;
					toReturn += getExpression_NOT_FIRST_TIME(expr);
				}
				else if(substring("<i>", 0, 1)=="{"){
					toReturn += something + getExpression_NOT_FIRST_TIME(expr);
					endings += printForEach9;
				}
				else{
					toReturn += something;
					toReturn += getExpression_NOT_FIRST_TIME(expr);
					endings += printForEach9;
				}
			}
			return toReturn + listClose + endings;
		}
		case (Expression) `<IdCon i>` :{
			return toString(e);
		}
		case (Expression) `<SymbolCon s>` :{
			return getQuotedString("<s>");
		}
		case (Expression) `<NatCon n>` :{
			return "\"<toString(e)>\"";
		}
		case (Expression) `<Text t>` :{
			toReturn = getQuotedString("<t>");
			toReturn = replaceAll(toReturn, "\n", "\\n");
			return toReturn;
		}
		case (Expression) `<Expression e1> . <IdCon idc>` :
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
/* FUNCTION (1->1): getQuotedString -> startsWith, substring, size */
public str getQuotedString(str toReturn){
	if(startsWith(toReturn, "'")){
		return "\"" + substring(toReturn, 1, size(toReturn)) + "\"";
	}
	return toReturn; 
}
/* FUNCTION (1->1): getKeyValuePairs -> getExpression_NOT_FIRST_TIME, printArray3 */
public str getKeyValuePairs(KeyValuePair kv){
	toReturn = "";
	switch(kv){
		case (KeyValuePair) `<IdCon idc> : <Expression expr>` : {
			str expression = getExpression_NOT_FIRST_TIME(expr);
			toReturn +=  printArray3("<idc>", expression);
		}
	}
	return toReturn;
}
/* FUNCTION (2->1): printArray3 */
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