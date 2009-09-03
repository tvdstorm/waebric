
public class CheckerAction {
 public class Environment {
	public static ArrayList<String> variables;
	public static HashMap<String, Integer> functions;
 }
	
 public void module() {
	 Environment.variables = new ArrayList<String>();
	 Environment.functions = new HashMap<String, Integer>();
 }
 
 public void moduleId() {
	 boolean eval;
	 String path = "";
	 path += ".wae";
	 path = $id.getText();
	 path += "/" + $id.getText();
 	java.io.File file = new java.io.File(path);
	if(! file.isFile() && eval) {
		exceptions.add(new NonExistingModuleException($moduleId.tree));
	}
 }
 
 public void markup() {
	 if(isDefinedFunction($IDCON.getText())) {
			int expected = getFunctionArgs($IDCON.getText());
			int actual = $arguments.args;
			if(expected != actual) {
				exceptions.add(new ArityMismatchException($IDCON, expected));
			}
		} else if(! XHTMLTag.isXHTMLTag($IDCON.getText())) {
			exceptions.add(new UndefinedFunctionException($IDCON));
		}
 }
 
 public void arguments() {
	 int args = 0;
	 args++;
 }
 
 public void expression() {
	 if(! isDefinedVariable($id.getText())) {
			// Verify that all variable references are made to defined variables
			exceptions.add(new UndefinedVariableException($id.tree));
		} 
 }
 
 public void function() {
	 Environment.variables = new ArrayList<String>();
	 Environment.functions = new HashMap<String, Integer>();
 }
 
 public void formals() {
	 int args = 0;
	 defineVariable($IDCON.getText()); $args++;
 }
 
 public void eachStatement() {
	 Environment.variables = new ArrayList<String>();
	 Environment.functions = new HashMap<String, Integer>();
	 defineVariable($IDCON.getText()); // Define variable before statement is executed
 }
 
 public void letStatement() {
	 Environment.variables = new ArrayList<String>();
	 Environment.functions = new HashMap<String, Integer>();
 }
 
 public void assignment() {
	 defineVariable($IDCON.getText());
 }
 
 public void funcBinding() {
	 Environment.variables = new ArrayList<String>();
	 Environment.functions = new HashMap<String, Integer>();
	// Define function after poping local stack so the definition stays
		defineFunction($id, $f.args);
 }
}
