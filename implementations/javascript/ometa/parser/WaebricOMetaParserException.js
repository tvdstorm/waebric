/** 
 * Semantic Exception class 
 * 
 * Represents exceptions found during semantic validation
 * 
 */
function WaebricOMetaParserException(message){
	this.message = message;
	
	this.toString = function(){
		return this.message;
	}
}