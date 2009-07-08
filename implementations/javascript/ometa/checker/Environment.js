/**
 * An environment used during Semantic Validation which
 * hold all data (functions, variables and exceptions) of 
 * a certain environment such as a module, functionmodule,
 * a let statement or an each statement
 */

function Environment(){	
	
	this.parent = null;
	this.children = new Array();
	this.functions = new Array();
	this.variables = new Array();
	this.exceptions = new Array();
	
	/**
	 * Adds a function to the functionlist
	 * @param {FunctionDefinition} func
	 */
	this.addFunction = function(func){
		this.functions.push(func);
	}
	
	/**
	 * Adds a variable to the variable list
	 * @param {VariableName} variable
	 */
	this.addVariable = function(variable){
		this.variables.push(variable);
	}
	
	/**
	 * Adds an exception to the exceptionlist
	 * @param {WaebricSemanticException} exception
	 */
	this.addException = function(exception){
		this.exceptions.push(exception);
	}
	
	/**
	 * Adds an environment to the current environment
	 * The new environment becomes child of the current environment
	 * @return The new environment
	 */
	this.addEnvironment = function(){
		var env = new Environment();
		env.parent = this;
		this.children.push(env);		
		return env;
	}
	
	/**
	 * Returns a funtion from the functionlist in the current environment
	 * or in it's parent environment. If no function is found in the current environment,
	 * nor in the parent environment, then null is returned
	 * 
	 * @param {String} funcName
	 * @return The requested function. Null if not found.
	 */
	this.getFunction = function(funcName){
		//Search function local environment
		for(var i = 0; i < this.functions.length; i++){
			var func = this.functions[i];
			if(func.functionName == funcName){
				return func;
			}
		}
		
		//Search function parent environment
		if (this.parent != null) {
			return this.parent.getFunction(funcName);
		}else{
			return null;
		}
	}
	
	/**
	 * Returns wheter a function from the functionlist exists in the current environment
	 * or in it's parent environment. If no function is found in the current environment,
	 * nor in the parent environment, then false is returned.
	 * 
	 * @param {String} funcName
	 * @return {Boolean} The existence of the requested function. False if not found.
	 */
	this.containsFunction = function(funcName){
		//Search function local environment
		for(var i = 0; i < this.functions.length; i++){
			var func = this.functions[i];
			if(func.functionName == funcName){
				return true;
			}
		}
		
		//Search function parent environment
		if (this.parent != null) {
			return this.parent.getFunction(funcName);
		}

		return false
	}
	
	/**
	 * Returns a variable from the variablelist in the current environment or in it's
	 * parent environment. If no variable is found in the current environment,
	 * nor in the parent environment, then null is returned.
	 * 
	 * @param {String} variable
	 * @return The requested variable. Null if not found
	 */
	this.getVariable = function(variable){
		//Search variable local environment
		for(var i =0; i < this.variables.length; i++){
			var _var = this.variables[i];
			if(_var == variable){
				return _var;
			}
		}
		
		//Search variable parent environment
		if (this.parent != null) {
			return this.parent.getVariable(variable);
		}else{
			return null;
		}
	}
	
	/**
	 * Returns all exceptions found in the current environment or in it's children's
	 * environment. 
	 * 
	 * @return Array of exceptions
	 */
	this.getExceptions = function(){
		var exceptionList = new Array();
		exceptionList = exceptionList.concat(this.exceptions);
		for(var i = 0; i < this.children.length; i++){
			var child = this.children[i];
			exceptionList = exceptionList.concat(child.getExceptions());
		}
		return exceptionList;
	}
}
