/*****************************************************************************
 * Acceptance Test Global
 * 
 * Converts waebric programs to HTML using the vanilla/OMeta implementation and 
 * compares the output with the output of the reference implementation 
 * (ASF Meta environment)
 * 
 * @author Nickolas Heirbaut
 *****************************************************************************/

importPackage(java.io);
load('../metrics/maintainability/MaintainabilityTest.js')

function MaintainabilityTests(){
	
	/* PARAMETERS */
	var inputDirectory = '../metrics/maintainability/source/';
	var pathTestFileOMeta = '../metrics/maintainability/tests-ometa.dat'
	var pathTestFileVanilla = '../metrics/maintainability/tests-vanilla.dat'
	var outputDirectoryOMeta = '../ometa/metrics/maintainability/';
	var outputDirectoryVanilla = '../vanilla/metrics/maintainability/';
	
	var maintainabilityTest = new MaintainabilityTest();
	
	this.runAll = function(){
		/* OMETA */	
		run(pathTestFileOMeta, inputDirectory, outputDirectoryOMeta)
		
		/* VANILLA */
		run(pathTestFileVanilla, inputDirectory, outputDirectoryVanilla)
	}
	
	function run(pathTestFile, inputDirectory, outputDirectory){
		var fis = new FileInputStream(pathTestFile);
		var bis = new BufferedInputStream(fis);
		var dis = new DataInputStream(bis);
		
		while (dis.available() != 0) {
			var input = dis.readLine();
			var projectName = input.toLowerCase().replace(' ', '-');
			var outputPath = outputDirectory + projectName + '.html'
			var allTestsPath = inputDirectory + projectName + '.dat'
			maintainabilityTest.runAll(allTestsPath, outputPath, projectName);
		}
		
		fis.close();
		bis.close();
		dis.close();
	}
}

var test = new MaintainabilityTests();
test.runAll();

