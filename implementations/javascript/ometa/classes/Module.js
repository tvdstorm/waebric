/**
 * Module class
 * 
 * @author Nickolas Heirbaut
 */

function Module(moduleId, moduleElements){
	this.moduleId = moduleId;
	this.imports = new Array();
	this.sites = new Array();
	this.functionDefinitions = new Array();
	
	for(i = 0; i < moduleElements.length; i++){
		if(moduleElements[i] instanceof Site){
			this.sites.push(moduleElements[i]);
		}else if(moduleElements[i] instanceof Import){
			this.imports.push(moduleElements[i]);
		}else if(moduleElements[i] instanceof FunctionDefinition){
			this.functionDefinitions.push(moduleElements[i]);
		}
	}
	
}