/** Semantic Exception class 
 * 
 * @param {String} The exception message
 * @return {Error} An error exception
 */
function SemanticException(exceptionMessage){
	return new Error(exceptionMessage);
}

/** Semantic Exception class for non existing modules
 * 
 * @param {String} The path of the non existing module
 * @return {SemanticException} A Semantic Exception
 */
function NonExistingModuleException(path){
	return new SemanticException("The dependency " + path + " was not found on the filesystem.");
}

/** Semantic Exception class for undefined functions
 * 
 * @param {Markup} The function call for which no function definition exists
 * @return {SemanticException} A Semantic Exception
 */
function UndefinedFunctionException(functionCall){
	return new SemanticException("The function " + functionCall + " was not found in any of the loaded modules, nor is the functionname part of XHTML");
}

/** Semantic Exception class for duplicate functions
 * 
 * @param {FunctionDefinition} The function definition 
 * @return {SemanticException} A Semantic Exception
 */
function DuplicateDefinitionException(func){
	return new SemanticException("Duplicate function found: " + func);
}

/** Semantic Exception class for functions calls with incorrect arguments 
 * 
 * @param {Markup} The function call with the incorrect number of arguments
 * @return {SemanticException} A Semantic Exception
 */
function IncorrectArgumentsException(functionCall){
	return new SemanticException("The functioncall " + functionCall + " has an incorrect number of arguments. ")
}

/** Semantic Exception class for undefined variables
 * 
 * @param {Object} exception
 * @return {SemanticException} A Semantic Exception
 */
function UndefinedVariableException(variable){
	return new SemanticException("Variable "+ variable + " not declared.")
}
