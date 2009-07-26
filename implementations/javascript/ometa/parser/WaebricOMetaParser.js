load('../parser/WaebricOMetaParserResult.js')
/**
 * Returns the Waebric OMeta Parser
 * 
 * @return Waebric Parser
 */
function WaebricOMetaParser(){	
	
	this.exceptions = new Array();
	
	/**
	 * Parses the program source to a Module
	 * 
	 * @param {String} The source of the Waebric program
	 * @return {Module} The parsed Module
	 * @exception 
	 */
	this.parseModule = function(path){	
		try {
			print('---- Parsing ' + path)			
			//Get Waebric program
			var programSource = this.getSourceWaebricProgram(path);			
			//Parse the module
			var module = this.parser.matchAll(programSource, "Module");
			//Parse the dependencies
			module.dependencies = this.parseDependencies(path, module);
			return module;
		}catch(exception if (exception instanceof NonExistingModuleException)){
			//Dependency couldn't be found, save as WaebricSemanticException
			//Evaluation will be continued for remaining dependencies
			this.exceptions.push(exception);
			print('! FAILED !')
		}catch(exception){
			//Unexpected exception thrown. Evaluation will be terminated
			throw exception;
		}
	}
	
	
	/**
	 * Returns all transitive dependencies for a given module
	 *
	 * @param {String} The path of the waebric program
	 * @param {Module} The module for which the transitive dependencies will be returned
	 * @return An array of {Module}
	 */
	this.parseDependencies = function(parentPath, parentModule){
	    var dependencies = new Array();
		
		//Load all dependencies inside the module
	    for (var i = 0; i < parentModule.imports.length; i++) {
			var dependency = parentModule.imports[i];			
	        try {				
	            var dependencyModule = this.parseModule(this.getDependencyPath(parentPath, dependency))
	            dependencies.push(dependencyModule)
			}catch(exception){
				//Unexpected exception thrown. Evaluation will be terminated				
				throw exception;
			}
	    }	
	    return dependencies;
	}
	
	/**
	 * Returns the path of the dependency based on the parentpath
	 * 
	 * @param {String} Path of the parent module
	 * @param {Module} The dependency for which the path should be generated
	 * @return {String} The path of the dependency
	 */
	this.getDependencyPath = function(parentPath, dependency){
		try {
			//Determine relative path of parent module towards file system
			var directoriesParent = parentPath.split('/');
			var directoryParent = directoriesParent.slice(0, directoriesParent.length - 1).join('/').concat("/");
			
			//Determine relative path of dependency towards parent module
			var directoryDependency = dependency.moduleId.identifier.replace('.', '/');
			
			//Determine relative path of dependency towards file system
			var path = directoryParent + directoryDependency + ".wae"
			
			return path;
		}catch(exception){
			throw exception;
		}
	}
	
	
	/**
	 * Returns the source of a Waebric program
	 *
	 * @param {String} The path of the Waebric program
	 * @return The source of the Waebric program
	 */
	this.getSourceWaebricProgram = function(path){
	    try {
	        var fis = new FileInputStream(path);
	        var bis = new BufferedInputStream(fis);
	        var dis = new DataInputStream(bis);
	        
	        var program = '';
	        while (dis.available() != 0) {
	            program += dis.readLine() + '\n';
	        }
	        fis.close();
	        bis.close();
	        dis.close();
	        return program;
	    } catch (exception) {
	        throw new NonExistingModuleException(path);
	    }
	}
	
	/**
	 * Returns the source of the parser
	 * 
	 * @return {String} Parser source
	 */
	this.getSourceWaebricOMetaParser = function(){
		try {
			var fis = new FileInputStream('../parser/WaebricOmetaParser.ometa');
			var bis = new BufferedInputStream(fis);
			var dis = new DataInputStream(bis);
			
			var source = '';
			while (dis.available() != 0) {
				source += dis.readLine() + '\n';
			}
			fis.close();
			bis.close();
			dis.close();
			return source;
		}catch(exception){
			throw exception;
		}
	}
	
	/**
	 * Parses OMeta source code by OMeta base code
	 * 
	 * @param {String} The OMeta source code
	 * @return {Object} Parser object
	 */	
	this.translateCode = function(source){
	    var translationError = function(m, i){
	        print("Translation error - please tell Alex about this!");
	        throw fail
	    }, tree = BSOMetaJSParser.matchAll(source, "topLevel", undefined, function(m, i){
	        throw fail.delegated({
	            errorPos: i
	        })
	    })
	    return BSOMetaJSTranslator.match(tree, "trans", undefined, translationError)
	}
	
	/**
	 * Returns the parser
	 * 
	 * @return {Object} The parser
	 */
	this.buildWaebricOMetaParser = function(){	
		print('\n**** Building parser...');
		try{
			var source = this.getSourceWaebricOMetaParser();		
			return eval(this.translateCode(source));
		}catch(exception){
			throw exception;
		}
	}
	
	//Global variable
	this.parser = this.buildWaebricOMetaParser();
	
}

/**
 * Parses a Waebric program to a {Module} object
 * 
 * @param {Array} The path of the Waebric program on the filesystem
 * @return {Module} The module
 */
WaebricOMetaParser.parseAll = function(path){	
	try {
		var fileExists = (new File(path)).exists();
		if (fileExists) {
			var parser = new WaebricOMetaParser();
			var module = parser.parseModule(path, true);
			return new WaebricOMetaParserResult(module, parser.exceptions);
		}else{
			throw "Waebric program doesn't exists";
		}
	}catch(exception){
		throw new WaebricOMetaParserException(exception);
	}
}
