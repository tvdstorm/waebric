/**
 * Helper class for loading and parsing Dependencies in OMeta
 *  
 * @param {OMetaParser} rootParser The parser that holds the dependencies
 * @param {OMetaParser} subParser The parser that holds the environments
 */
function WaebricDependencyParser(rootParser, subParser){
	
	var rootParser = rootParser;
	var subParser = subParser;	
	
	/**
	 * Loads the dependency from the filesystem and parses it
	 * 
	 * @param {Import} imprt
	 */
	this.parse = function(imprt){				
		//Visit only unprocessed dependencies
		var existingDependencyEnv = subParser.environment.getDependency(imprt.moduleId.toString())
		var existingDependency = this.getExistingDependency(imprt.moduleId.toString());

		if (!existingDependencyEnv) {
			//Make new environment for the Import in the current Environment
			subParser.environment = subParser.environment.addDependency(imprt.moduleId.toString())
			
			//Make new environment for the Import in the current Module
			var previousDependencies = rootParser.currentDependencies;
			rootParser.currentDependencies = new Array();
			
			//Load the source of the Waebric program  						
			var path = this.getDependencyPath(imprt);
			
			//Make sure that imports in the current import 
			//are searched relative to it
			var previousParentPath = rootParser.parentPath;
			rootParser.parentPath = this.getCurrentDirectoryPath(imprt);
			
			//Check if path exists
			var fileExists = (new File(path)).exists();
			var module;
			if (fileExists) {
				//Parse the dependency  								
				var programSource = WaebricFileLoader.loadFile(path);
				
				//Parse the import module to new Module AST object
				try {
					module = subParser.matchAll(programSource, 'Module');
				} catch (exception) {
					throw new WaebricParserException("Parsing import failed", path, exception);
				}
			} else {
				subParser.environment.addException(new NonExistingModuleException(path))
			}
			
			//Reset the environment back to the one just before parsing the Import
			subParser.environment = subParser.environment.parent;
			
			//Make sure that the parsed Import Module is added to it's parent Module and not to itself
			rootParser.currentDependencies = previousDependencies;
			
			//Set parentPath back
			rootParser.parentPath = previousParentPath;
			
			if (module != null) {
				rootParser.currentDependencies.push(module);
				rootParser.allDependencies.push(module)
			}
		} else {
			subParser.environment.addExistingDependency(existingDependencyEnv);
			rootParser.currentDependencies.push(existingDependency);
		}
	}
	
	/**
	 * Returns the relative path of the dependency against the parentPath
	 * 
	 * @param {Object} imprt
	 * @return {String} The path of the dependency
	 */
	this.getDependencyPath = function(imprt){
		//Determine relative path of parent module towards file system
		var directoriesParent = rootParser.parentPath.split('/');
		var directoryParent = directoriesParent.slice(0, directoriesParent.length - 1).join('/').concat("/");
		
		//Determine relative path of dependency towards parent module
		var directoryDependency = imprt.moduleId.identifier.replace(/\./g, '/');

		//Determine relative path of dependency towards file system
		return directoryParent + directoryDependency + ".wae"		
	}
	
	/**
	 * Returns the directory path of the dependency
	 * 
	 * @param {Object} imprt
	 * @return {String} The directory path of the dependency
	 */
	this.getCurrentDirectoryPath = function(imprt){
		//Determine relative path of parent module towards file system
		var directoriesParent = rootParser.parentPath.split('/');
		var directoryParent = directoriesParent.slice(0, directoriesParent.length - 1).join('/').concat("/");
		
		//Determine relative path of dependency towards parent module
		var directoriesImport = imprt.moduleId.identifier.split('.');
		var directoryImport = directoriesImport.slice(0, directoriesImport.length - 1).join('/').concat("/");

		//Determine relative path of dependency towards file system
		return(directoryParent + directoryImport)
	}
	
	/**
	 * Returns an existing Dependency AST
	 * 
	 * @param {Object} dependencyName
	 * @return {Module} AST
	 */
	this.getExistingDependency = function(dependencyName){
		for(var i = 0; i < rootParser.allDependencies.length; i++){
			var dependency = rootParser.allDependencies[i];
			if(dependency.moduleId.identifier.toString() == dependencyName){
				return dependency;
			}
		}
	}
}

/**
 * Loads the dependency from the filesystem and parses it.
 * Dependencies are added to the rootParser.
 * Environment (scopes) are added to the subparser
 *  
 * @param {Import} imprt The AST Import object
 * @param {OMetaParser} parentParser The OMeta parser
 */
WaebricDependencyParser.parse = function(imprt, rootParser, subParser){
	var parser = new WaebricDependencyParser(rootParser, subParser);
	parser.parse(imprt);
}
