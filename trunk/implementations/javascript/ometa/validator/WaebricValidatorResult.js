/**
 * Holds the result of the semantic validation
 * 
 * @author Nickolas Heirbaut [nickolas.heirbaut@dejasmijn.be]
 * 
 * @param {Array} exceptions The list of Semantic exceptions
 */
function WaebricValidatorResult(module, exceptions){
	
	this.module = module;
	this.exceptions = exceptions;
	
	/**
	 * Adds a token to the tokenlist
	 * 
	 * @param {WaebricSemanticException} exception The semantic exception
	 * @return {Array} The new exceptionlist
	 */
	this.addException = function(exception){
		return this.exceptions.push(exception);
	}
	
	this.toString = function(){
		var exceptionString = "";
		for(var exceptionIndex = 0; exceptionIndex < this.exceptions.length; exceptionIndex++){
			var exception = this.exceptions[exceptionIndex];			
			exceptionString += '\nWarning: ' + exception.toString() + '\n';
		}
		return exceptionString
	}
}
