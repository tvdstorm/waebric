/**
 * Helper class for loading and parsing Dependencies in OMeta
 * 
 * There are two parsers that needs to be supplied:
 * 1. ROOTPARSER
 * 	  The parser which imports the dependencies and constructs the AST
 * 	  This parser should have the public property "dependencies" {Array} 
 * 	  which holds a collection of {Module} AST's. (i.e. {WaebricOMetaParser})
 *    
 * 2. SUBPARSER
 * 	  The parser for which the public property "environment" {WaebricEnvironment}
 * 	  is updated (i.e. {WaebricOMetaValidator} or {WaebricOMetaParser})
 * 
 * 
 * @param {OMetaParser} parentParser The OMeta parser
 */
function WaebricDependencyParser(rootParser, subParser){
	
	var rootParser = rootParser;
	var subParser = subParser;	
	
	/**
	 * Loads the dependency from the filesystem and parses it.
	 * The dependency is then added to the dependency list of the
	 * parentParser.
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
			var previousDependencies = rootParser.dependencies;
			rootParser.dependencies = new Array();
			
			//Load the source of the Waebric program  						
			var path = this.getDependencyPath(imprt);

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
			rootParser.dependencies = previousDependencies;
			rootParser.dependencies.push(module);
			rootParser.deps.push(module)
		} else {
			subParser.environment.addExistingDependency(existingDependencyEnv);
			rootParser.dependencies.push(existingDependency);
		}
	}
	
	/**
	 * Returns the relative path of the dependency against the parentPath
	 * 
	 * @param {Object} imprt
	 * @param {Object} parentPath
	 * @return {String} The path of the dependency
	 */
	this.getDependencyPath = function(imprt){
		//Determine relative path of parent module towards file system
		var directoriesParent = rootParser.parentPath.split('/');
		var directoryParent = directoriesParent.slice(0, directoriesParent.length - 1).join('/').concat("/");
		
		//Determine relative path of dependency towards parent module
		var directoryDependency = imprt.moduleId.identifier.replace('.', '/');
		
		//Determine relative path of dependency towards file system
		return directoryParent + directoryDependency + ".wae"
	}
	
	/**
	 * Returns an existing Dependency AST
	 * 
	 * @param {Object} dependencyName
	 * @return {Module} AST
	 */
	this.getExistingDependency = function(dependencyName){
		for(var i = 0; i < rootParser.deps.length; i++){
			var dependency = rootParser.deps[i];
			if(dependency.moduleId.identifier.toString() == dependencyName){
				return dependency;
			}
		}
	}
}

/**
 * Loads the dependency from the filesystem and parses it.
 * The dependency is then added to the dependency list of the
 * parentParser. Properties of the parentParser are updated
 * during parsing.
 *  
 * @param {Import} imprt The AST Import object
 * @param {OMetaParser} parentParser The OMeta parser
 */
WaebricDependencyParser.parse = function(imprt, rootParser, subParser){
	var parser = new WaebricDependencyParser(rootParser, subParser);
	parser.parse(imprt);
}

