/** 
 * OMeta Validator for Waebric language
 * 
 * The WaebricOMetaValidator converts a Waebric program into an AST (Module) and then
 * performs a semantic validation on it.
 * - Reads in the Waebric program from the filesystem using Rhino/Java
 * - Parses the program to an Abstract Syntax Tree {Module} using OMeta
 *	 (imports are automatically loaded in OMeta)
 * - Performes semantic validation on the AST using OMeta
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
 * - Arity mismatches: If a function is called with an incorrect numer of arguments
 *   (as follows from its definition), this is an error.
 *   
 * The WaebricOMetaValidator extends the WaebricOMetaParser to recognize the Waebric program 
 * and is so able to return an AST as well as the semantic exceptions. 
 * 
 * Imports in the Waebric program are automatically loaded from the filesystem and parsed 
 * to an new AST (Module). The new AST is then added to the parent AST (Module) under the
 * property "dependencies".
 *   
 * @author Nickolas Heirbaut [nickolas.heirbaut@dejasmijn.be]
 */
function WaebricValidator(){
	
	/**
	 * Validates a Waebric Program and returns an exceptionlist of semantic errors.
	 * 
	 * @param {String} path The path of the Waebric program
	 * @return {Array} An array of semantic errors
	 */
	this.parseAndValidate = function(path){
		var fileExists = (new File(path)).exists();
		if (fileExists) {			
			//Setup WaebricOMetaParser for correct Importing
			WaebricOMetaParser.parentPath = path;
			WaebricOMetaParser.subParser = WaebricOMetaValidator;
	
			//Load the source of the Waebric program
			var programSource = WaebricFileLoader.loadFile(path);
			
			//Parse the source of the Waebric program
			try {
				//Parsing + validation
				var module = WaebricOMetaValidator.matchAll(programSource, 'Module');
				var exceptions = WaebricOMetaValidator.environment.getExceptions();
				return new WaebricValidatorResult(module, exceptions);
			}catch(exception){
				throw new WaebricParserException("Parsing failed", path, exception);
			}
		}else{
			throw new NonExistingModuleException(path);
		}	
	}
}

/**
 * Parses and validates a Waebric program
 * 
 * @param {Module} module The module to be parsed and validated
 * @return {WaebricValidatorResult}
 * @exception {WaebricValidatorException}
 */
WaebricValidator.parseAndValidate = function(path){	
	try {
		var validator = new WaebricValidator();
		return validator.parseAndValidate(path);
	} catch (exception if exception instanceof WaebricValidatorException){
		throw exception;
	} catch(exception){
		throw new WaebricValidatorException("Parsing/validating failed", path, exception);
	}
}