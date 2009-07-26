/** 
 * Semantic Exception class 
 * 
 * Represents exceptions found during semantic validation
 * 
 */
function WaebricSemanticException(){
	this.message = "";
	
	this.toString = function(){
		return this.message;
	}
}

/** 
 * Semantic Exception class for non existing modules
 * 
 * @param {String} The path of the non existing module
 * @return {WaebricSemanticException} A Semantic Exception
 */
function NonExistingModuleException(path){
	this.path = path;
	this.message = "The module " + path + " was not found on the filesystem.";
}
NonExistingModuleException.prototype = new WaebricSemanticException();

/** 
 * Semantic Exception class for undefined functions
 * 
 * @param {Markup} The function call for which no function definition exists
 * @return {WaebricSemanticException} A Semantic Exception
 */
function UndefinedFunctionException(functionCall, env){
	this.message = "The function '" + functionCall + "' in module '" + env.getParentModule().name + "'was not found in any of the loaded modules, nor is the functionname part of XHTML";
}
UndefinedFunctionException.prototype = new WaebricSemanticException();

/** 
 * Semantic Exception class for duplicate functions
 * 
 * @param {FunctionDefinition} The function definition 
 * @return {WaebricSemanticException} A Semantic Exception
 */
function DuplicateDefinitionException(func, env){
	this.message = "Duplicate function found: " + func + "' in module '" + env.getParentModule().name + "'";
}
DuplicateDefinitionException.prototype = new WaebricSemanticException();

/** 
 * Semantic Exception class for functions calls with incorrect arguments 
 * 
 * @param {Markup} The function call with the incorrect number of arguments
 * @return {WaebricSemanticException} A Semantic Exception
 */
function IncorrectArgumentsException(functionCall, env){
	this.message = "The functioncall '" + functionCall + "' in module '" + env.getParentModule().name + "' has an incorrect number of arguments. ";
}
IncorrectArgumentsException.prototype = new WaebricSemanticException();

/** 
 * Semantic Exception class for undefined variables
 * 
 * @param {Object} exception
 * @return {WaebricSemanticException} A Semantic Exception
 */
function UndefinedVariableException(variable, env){
	this.message = "The variable '" + variable + "' in module '" + env.getParentModule().name + "' is not declared.";
}
UndefinedVariableException.prototype = new WaebricSemanticException();
