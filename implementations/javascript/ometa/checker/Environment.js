function Environment(){	
	
	this.parent = null;
	this.children = new Array();
	this.functions = new Array();
	this.variables = new Array();
	this.exceptions = new Array();
	
	this.addFunction = function(func){
		this.functions.push(func);
	}
	
	this.addVariable = function(variable){
		this.variables.push(variable);
	}
	
	this.addException = function(exception){
		this.exceptions.push(exception);
	}
	
	this.addEnvironment = function(){
		var env = new Environment();
		env.parent = this;
		this.children.push(env);		
		return env;
	}
	
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
