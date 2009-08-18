/** 
 * Validator Exception class 
 * 
 * Represents an error occured during semantic validation
 * 
 * @author Nickolas Heirbaut [nickolas.heirbaut@dejasmijn.be]
 * 
 * @param {String} message A description of the exception
 */
function WaebricValidatorException(message, filePath, childException){	
	this.message = message;
	this.filePath = filePath;
	this.childException = childException;
	
	this.toString = function(){
		if (this.childException) {
			return 	"\nWaebricValidatorException" 
					+ '\n====> ' + this.message + ': ' + this.filePath
					+ '\n\n' + this.childException;
		} else {
			return 	"\nWaebricValidatorException" 
					+ '\n====> ' + this.message + ': ' + this.filePath;
		}
	}
}
