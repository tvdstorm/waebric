function WaebricFunctionValidator(parentParser){
	
	this.parentParser = parentParser;
	
	this.validateFunctionCall = function(markup, addToQueue){
		//Gather function information
		var functionName;
		var functionArguments;
		var hasAttributes;	
		//Search function in environment
		if (markup instanceof MarkupCall) {
			functionName = markup.designator.idCon;
			functionArguments = markup.arguments;		
			hasAttributes = (markup.designator.attributes.length > 0);
		}else if(markup instanceof DesignatorTag){								
			functionName = markup.idCon;
			functionArguments = [];
			hasAttributes = (markup.attributes.length > 0);
		}	
		
		//Search for XHTML tag & Function definition
		var functionDefinition = parentParser.environment.getLocalFunction(functionName);
		var isXHTMLTag = XHTML.isXHTMLTag(functionName);
		
		//Validate the Markup
		if(hasAttributes && !isXHTMLTag){		
			parentParser.environment.addException(new UndefinedFunctionException(markup, parentParser.environment));
		}else if(functionDefinition != null){
			var hasEqualArguments = (functionDefinition.formals.length == functionArguments.length);
			if(!hasEqualArguments){
				parentParser.environment.addException(new IncorrectArgumentsException(markup, parentParser.environment));
			}
		}else if(!isXHTMLTag && !addToQueue){	
			parentParser.environment.addException(new UndefinedFunctionException(markup, parentParser.environment));
		}else if(!isXHTMLTag && addToQueue){
			parentParser.environment.addMarkupCallToQueue(markup);
		}
	}
	
	this.validateFunctionCallQueue = function(){
		//Check for items in MarkupCallQueue and search corresponding function					
		var queue = parentParser.environment.getMarkupCallQueue();
		
		for(var i = 0; i < queue.length; i++){
			var markup = queue[i];
			this.validateFunctionCall(markup, false);
		}
	}
	
	this.validateFunction = function(func){
		//Evaluate if the function already exists in the environment
		if(parentParser.environment.containsFunction(func.functionName)){
			parentParser.environment.addException(new DuplicateDefinitionException(func, parentParser.environment))
		}else{
			parentParser.environment.addFunction(func)
		}
	}
}
WaebricFunctionValidator.validateFunctionCall = function(markup, addToQueue, parentParser){
	var validator = new WaebricFunctionValidator(parentParser);
	validator.validateFunctionCall(markup, addToQueue)
}

WaebricFunctionValidator.validateFunctionCallQueue = function(parentParser){
	var validator = new WaebricFunctionValidator(parentParser);
	validator.validateFunctionCallQueue()
}

WaebricFunctionValidator.validateFunction = function(func, parentParser){
	var validator = new WaebricFunctionValidator(parentParser);
	validator.validateFunction(func)
}
