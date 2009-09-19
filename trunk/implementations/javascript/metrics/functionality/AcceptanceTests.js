/*****************************************************************************
 * Acceptance Test Global
 * 
 * Converts waebric programs to HTML using the vanilla/OMeta implementation and 
 * compares the output with the output of the reference implementation 
 * (ASF Meta environment)
 * 
 * @author Nickolas Heirbaut
 *****************************************************************************/

function AcceptanceTests(){
	/* Parameters */
	var testFiles = '../metrics/functionality/source/tests.dat'
	var sourceWaebricDirectory = '../metrics/functionality/source/'
	var sourceHtmlDirectory = '../metrics/functionality/output/'
	var outputVanilla = '../vanilla/metrics/functionality/output/'
	var outputOMeta = '../ometa/metrics/functionality/output/'
	
	this.runAll = function(){
		//Vanilla
		load('../metrics/functionality/AcceptanceTestVanilla.js')
		var acceptanceTestVanilla = new AcceptanceTestVanilla();
		acceptanceTestVanilla.runAll(testFiles, sourceWaebricDirectory, 
			sourceHtmlDirectory, outputVanilla);
			
		//OMeta
		load('../metrics/functionality/AcceptanceTestOMeta.js')
		var acceptanceTestOMeta = new AcceptanceTestOMeta();
		acceptanceTestOMeta.runAll(testFiles, sourceWaebricDirectory, 
			sourceHtmlDirectory, outputOMeta);
	}
}
var acceptanceTest = new AcceptanceTests();
acceptanceTest.runAll();
