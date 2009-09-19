/*****************************************************************************
 * Acceptance Test Vanilla
 * 
 * Converts waebric programs to HTML using the Vanilla implementation and compares 
 * the output with the output of the reference implementation (ASF Meta environment)
 * 
 * @author Nickolas Heirbaut
 *****************************************************************************/

load('../metrics/functionality/AcceptanceTestBase.js')
load('../vanilla/rhino/rhino-imports.js')

function AcceptanceTestVanilla(){	
	
	/**
	 * Run the individual components of the OMeta implementation
	 * 
	 * @param {Object} filename
	 * @param {Object} waebricSourceDirectory
	 * @param {Object} htmlOutputDirectory
	 */
	this.run = function(filename, waebricSourceDirectory, htmlOutputDirectory){	
		//Parsing
		var parserResult = WaebricParser.parse(waebricSourceDirectory + filename);
		
		//Validating		
		var validatorResult = WaebricValidator.validate(parserResult.module)
		
		//Interpreting
		var interpreterResult = WaebricInterpreter.interprete(parserResult.module);
		
		//Output results		
		this.createHTML(filename, htmlOutputDirectory, interpreterResult.environments);
	}
}
AcceptanceTestVanilla.prototype = new AcceptanceTestBase();


