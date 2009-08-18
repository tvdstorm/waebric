/** 
 * Parser Exception class 
 * 
 * Represents an exceptions occured during Parsing 
 * 
 * @author Nickolas Heirbaut [nickolas.heirbaut@dejasmijn.be]
 * 
 * @param {String} message The error message
 * @param {String} filePath The path of the Waebric program on the filesystem
 */
function WaebricParserException(message, filePath, childException){
	this.message = message;
	this.filePath = filePath;
	this.childException = childException;
	
	this.toString = function(){
		if (this.childException) {
			return 	"\nWaebricParserException" 
					+ '\n====> ' + this.message + ': ' + this.filePath
					+ '\n\n' + this.childException;
		} else {
			return 	"\nWaebricParserException" 
					+ '\n====> ' + this.message + ': ' + this.filePath;
		}
	}
}