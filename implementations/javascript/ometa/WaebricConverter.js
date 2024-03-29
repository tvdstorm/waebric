/**
 * Waebric Converter
 *
 * The WaebricConverter converts a Waebric file to a xHTML website
 * @see http://code.google.com/p/waebric/source/browse/trunk/doc/waebric.pdf
 * 
 * @author Nickolas Heirbaut [nickolas.heirbaut@dejasmijn.be]
 */
function WaebricConverter(){
	/**
	 * Converts a Waebric Program to a xHTML website
	 *
	 * @param {String} waebricFilePath Path Waebric file
	 * @param {String} htmlOutputDirectory Directory to output HTML files 
	 */
	this.convertToHTML = function(waebricFilePath, htmlOutputDirectory){
		try {
			//Validating		
			var parserResult = WaebricValidator.parseAndValidate(waebricFilePath)
			print(parserResult)
			
			//Interpreting
			WaebricInterpreter.interprete(parserResult.module, htmlOutputDirectory);
		} catch (exception) {
			print(exception.toString());
		}
	}
}