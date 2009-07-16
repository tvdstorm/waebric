/**
 * Interprete the module and converts it to HTML
 */
function WaebricInterpreter(){
	
}

WaebricInterpreter.interpreteAll = function(module){
	//Setup environment for logging exceptions and storing functions, 
	//variables and dependencies
	var env = new WaebricEnvironment();
	
	//Start semantic validation
	var document = new DOM();
	var visitor = new WaebricInterpreterVisitor();
	module.accept(visitor.getModuleVisitor(env, document));
	
	//Return DOM
	return document;
}