/** 
 * Parser Exception class 
 * 
 * Represents an exceptions occured during Parsing 
 * 
 * @author Nickolas Heirbaut [nickolas.heirbaut@dejasmijn.be]
 * 
 * @param {String} message The error message
 * @param {String} filePath The path of the Waebric program on the filesystem
 * @param {Object} childException The encapsulated exception
 */
function WaebricParserException(message, filePath, childException, lineNumber){
	this.message = message;
	this.filePath = filePath;
	this.childException = childException;
	this.lineNumber = lineNumber;
	
	this.toString = function(){
		if (this.childException) {
			return 	"\nWaebricParserException" 
					+ '\n====> ' + this.message + ': ' + this.filePath					
					+ '\nLine number: ' + this.lineNumber
					+ '\n\n' + this.childException;
		} else {
			return 	"\nWaebricParserException" 			
					//+ '\nLine number: ' + this.lineNumber
					//+ '\n====> ' + this.message + ': ' + this.filePath;
		}
	}
}