function WaebricVariableValidator(parentParser){
	
	this.parentParser = parentParser;
	
	this.validateVariableReference = function(varExpr){
		if (!parentParser.environment.containsVariable(varExpr.variable)) {
			parentParser.environment.addException(
				new parentParser(varExpr.variable, parentParser.environment));
		}
	}
}

WaebricVariableValidator.validateVariableReference = function(varExpr, parentParser){
	var validator = new WaebricVariableValidator(parentParser);
	validator.validateVariableReference(varExpr)
}
