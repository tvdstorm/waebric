/** 
 * Waebric Tokenizer Exception class 
 * 
 * Represents exceptions found during tokenization
 * 
 * @author Nickolas Heirbaut [nickolas.heirbaut@dejasmijn.be]
 */
function WaebricTokenizerException(message){
	this.message = message;
	
	this.toString = function(){
		return this.message;
	}
}