/**
 * Interprete the module and returns the HTML output
 */
function WaebricInterpreter(){
	
}

/**
 * Returns the HTML output for the main function and the site mappings
 * 
 * @param {Array} an array of WaebricEnvironments
 */
WaebricInterpreter.interpreteAll = function(module){
	var output = new Array();	
	
	var envMainDocument = getEvnMainDocument(module);
	if (envMainDocument.path != '') {
		output.push(envMainDocument);
	}
	
	var outputSiteMappings = getSiteMappings(module);
	output = output.concat(outputSiteMappings);
	return output;
}

/**
 * Returns the HTML output for the main function
 * 
 * @param {Object} module
 */
function getEvnMainDocument(module){
	//Visit module (preprocessing)
	var visitor = new WaebricInterpreterVisitor()
	var environment = new WaebricEnvironment();
	var document = new DOM(); 
	module.accept(visitor.getModuleVisitor(environment, document));	
	
	//Visit main function and write HTML output to document
	//Exceptions are logged in the environment	
	module.accept(visitor.getMainVisitor(environment, document));
	environment.document = document;
	
	//Returns the environment and the document
	return environment;
}

/**
 * Returns the HTML output for the site mappings function
 * 
 * @param {Array} an array of WaebricEnvironments
 */
function getSiteMappings(module){
	var siteEnvironments = new Array();
	for (var i = 0; i < module.site.mappings.length; i++) {
		//Visit module (preprocessing)
		var visitor = new WaebricInterpreterVisitor();
		var environment = new WaebricEnvironment();
		var document = new DOM(); 
		module.accept(visitor.getModuleVisitor(environment, document));		
		
		//Visit main function and write HTML output to document
		//Exceptions are logged in the environment
		var mapping = module.site.mappings[i]
		mapping.accept(visitor.getMappingVisitor(environment, document));
		environment.document = document;
		
		//Returns the environment and the document
		siteEnvironments.push(environment);
	}
	return siteEnvironments;
}
