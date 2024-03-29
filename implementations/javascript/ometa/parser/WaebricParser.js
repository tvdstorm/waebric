/**
 * OMeta parser for Waebric language
 *
 * The WaebricOMetaParser converts a Waebric program into an AST (Module).
 * - Reads in the Waebric program from the filesystem
 * - Parses the tokens to an Abstract Syntax Tree {Module}
 *
 * Imports in the Waebric program are automatically loaded from the filesystem and parsed
 * to an new AST (Module). The new AST is then added to the parent AST (Module) under the
 * property "dependencies".
 *
 * Translated from the SDF specification (Meta-Environment: www.meta-environment.org/):
 * http://code.google.com/p/waebric/source/browse/trunk/doc/waebric.pdf
 *
 * @author Nickolas Heirbaut [nickolas.heirbaut@dejasmijn.be]
 */
function WaebricParser(){

	/**
	 * Parses a Waebric program to a {Module} AST
	 *
	 * @param {String} path The path of the Waebric program
	 * @return {WaebricParserResult} Contains the AST
	 * @exceptions {WaebricParserException}
	 * @exceptions {NonExistingModuleException}
	 */
	this.parse = function(path){
		var fileExists = (new File(path)).exists();
		if (fileExists) {
			//Setup WaebricOMetaParser variables
			WaebricOMetaParser.parentPath = path;
			WaebricOMetaParser.currentDependencies = new Array();
			WaebricOMetaParser.allDependencies = new Array();
			WaebricOMetaParser.environment = new WaebricEnvironment();
			WaebricOMetaParser.lineNumber = 1;

			//Load the source of the Waebric program
			var programSource = WaebricFileLoader.loadFile(path);
			
			//Parse the source of the Waebric program
			try {
				print('---- Parsing module ' + path)
				var module = WaebricOMetaParser.matchAll(programSource, 'Module');
				return new WaebricParserResult(module);
			}catch(exception){
				throw new WaebricParserException("Parsing failed", path, exception, WaebricOMetaParser.lineNumber);
			}
		}else{
			throw new NonExistingModuleException(path);
		}
	}
}

/**
 * Parses a Waebric program to a {Module} AST
 *
 * @param {String} path The path of the Waebric program on the filesystem
 * @return {WaebricParserResult} Contains the AST
 * @exception {WaebricParserException}
 */
WaebricParser.parse = function(path){
	try {
		var parser = new WaebricParser();
		return parser.parse(path);
	}catch(exception if exception instanceof WaebricParserException){
		throw exception;
	}catch(exception){		
		throw new WaebricParserException(exception.message, path, exception);
	}
}