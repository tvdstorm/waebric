/*****************************************************************************
 * Acceptance Test OMeta
 * 
 * Converts waebric programs to HTML using the OMeta implementation and compares 
 * the output with the output of the reference implementation (ASF Meta environment)
 * 
 * @author Nickolas Heirbaut
 *****************************************************************************/

load('../metrics/functionality/AcceptanceTestBase.js')
load('../ometa/rhino/rhino-imports.js')

function AcceptanceTestOMeta(){
	
	/**
	 * Run the individual components of the OMeta implementation
	 * 
	 * @param {Object} filename
	 * @param {Object} waebricSourceDirectory
	 * @param {Object} htmlOutputDirectory
	 */
	this.run = function(filename, waebricSourceDirectory, htmlOutputDirectory){
		//Parsing + validation	
		var validatorResult = WaebricValidator.parseAndValidate(waebricSourceDirectory + filename);

		//Interpreting
		var interpreterResult = WaebricInterpreter.interprete(validatorResult.module);		
		
		//Output results
		this.createHTML(filename, htmlOutputDirectory, interpreterResult.environments);
	}
}
AcceptanceTestOMeta.prototype = new AcceptanceTestBase();


