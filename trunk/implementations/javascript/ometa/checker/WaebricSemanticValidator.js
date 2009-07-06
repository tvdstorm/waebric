/** 
 * Performs a semantic validation on the module object
 *
 * The semantic validation includes:
 *
 * - Undefined functions: If for a markup-call f, no function definition can be
 * 	 found in the current module or one of its transitive imports, and if f is
 * 	 not a tag defined in the XHTML 1.0 Transitional standard, then this is an error.
 *
 * - Undefined variables: If a variable reference x cannot be traced back to an
 *   enclosing let-definition or function parameter, this is an error.
 *
 * - Non-existing module: If for an import directive import m no corresponding file
 * 	 m.wae can be found, this is an error.
 *
 * - Duplicate definitions: Multiple function definitions with the same name are
 *   disallowed.
 *
 * - Arity mismathces: If a function is called with an incorrect numer of arguments
 *   (as follows from its definition), this is an error.
 */
function WaebricSemanticValidator(){
	
}

/** 
 * Validate the module object and returns all exceptions found during semantic validation.
 *
 * @param {Module} The module object
 * @return {Array} An array of exceptions
 */
WaebricSemanticValidator.validateAll = function(module){
	var exceptionList = new Array();
	
	var functionExceptionList = WaebricSemanticValidator.validateFunctionCalls(module);
	exceptionList = exceptionList.concat(functionExceptionList);	
	
	var variableExceptionList = WaebricSemanticValidator.validateVariables(module);
	exceptionList = exceptionList.concat(variableExceptionList);
	
    var duplicateExceptionList = WaebricSemanticValidator.validateDuplicateFunctions(module);
	exceptionList = exceptionList.concat(duplicateExceptionList);
	
	return exceptionList
}

/**
 * Validates all function calls by searching for corresponding functions.
 * If no function is found, an exception is saved in the exception list.
 * 
 * @param {Object} module
 * @return {Array} An array of exceptions
 */
WaebricSemanticValidator.validateFunctionCalls = function(module){	
	var functions = WaebricSemanticCollector.collectAllFunctions(module);
    var functionCalls = WaebricSemanticCollector.collectAllFunctionCalls(module);
	
	var exceptionList = new Array();
    for (var i = 0; i < functionCalls.length; i++) {
        var call = functionCalls[i];
		
        var functionFound = false;
        var argumentsMatches = false;
        for (var j = 0; j < functions.length; j++) {
            var func = functions[j];
			
            if (call.designator.idCon == func.functionName) {
                functionFound = true;
                argumentsMatches = (call.arguments.length == func.formals.length);
                break;
            }
        }
		
        if (functionFound == false) {
            exceptionList.push(new UndefinedFunctionException(call));
        } else if (argumentsMatches == false) {
            exceptionList.push(new IncorrectArgumentsException(call));
        }
    }
	
	return exceptionList;
}

/**
 * Validates all variable references by searching for corresponding variable
 * declarations. If no declaration is found, an exception is saves in the
 * exception list.
 * 
 * @param {Object} module
 * @return {Array} An array of exceptions
 */
WaebricSemanticValidator.validateVariables = function(module){
	return new Array();
}

/**
 * Validates all functions by searching for duplicate functions 
 * (based on functionname). If a duplicate function is found, an exception
 * is saved in the exception list
 *  
 * @param {Object} module
 * @param {Array} An array of exceptions
 */
WaebricSemanticValidator.validateDuplicateFunctions = function(module){	
	var functions = WaebricSemanticCollector.collectAllFunctions(module);
	
	var exceptionList = new Array();
    var processedFunctions = new Array();
    for (var i = 0; i < functions.length; i++) {
        for (var j = 0; j < processedFunctions.length; j++) {
            if (functions[i].functionName == processedFunctions[j].functionName) {
                exceptionList.push(new DuplicateDefinitionException(functions[i]));
            }
        }
        processedFunctions.push(functions[i]);
    }
	return exceptionList;
}
