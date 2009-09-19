/*****************************************************************************
 * Functionality Test Base
 * 
 * Base class for functionality tests
 * 
 * @author Nickolas Heirbaut
 *****************************************************************************/

function AcceptanceTestBase(){
	
	/**
	 * Run each test file
	 * 
	 * @param {Object} waebricTestFiles
	 * @param {Object} waebricSourceDirectory
	 * @param {Object} htmlOutputDirectory
	 */
	this.runAll = function(testOverview, sourceWaebricDirectory, sourceHtmlDirectory, outputHtmlDirectory){
		init(outputHtmlDirectory);
		
		var fis = new FileInputStream(testOverview);
        var bis = new BufferedInputStream(fis);
        var dis = new DataInputStream(bis);
		
        var reportPath = outputHtmlDirectory + 'report_' + new Date().getTime() + '.txt'
		var totalTests = 0;
		var totalSuceededTests = 0;
		var expectedFailedTests = 3;
		
        while (dis.available() != 0) {
			totalTests++;
			var waebricFilename = dis.readLine();
			var name = waebricFilename.substr(0, waebricFilename.length() - 4);
			try {
				//Create HTML output	            
				this.run(waebricFilename, sourceWaebricDirectory, outputHtmlDirectory);
				
				//Perform diff				
				var original = sourceHtmlDirectory + name + '.html';
				var generated = outputHtmlDirectory + name + '.html';
				var diffoutput = outputHtmlDirectory + name + '.diff';
				var exitStatus = runCommand('diffmerge', original, generated, '-diff', diffoutput);
				
				//Compute percentage succeeded
				if(exitStatus == 0){
					totalSuceededTests++
				}else{
					//runCommand('diffmerge', original, generated);
				}
				
				//Write result to report
				outputTestResult(exitStatus, waebricFilename, reportPath);
			} catch (exception) {
				outputErrorReport(name, outputHtmlDirectory, exception);
				outputTestResult(null, waebricFilename, reportPath);
			}
        }		
		
		outputStatistics(totalTests, totalSuceededTests, expectedFailedTests, reportPath);
		
        fis.close();
        bis.close();
        dis.close();	
	}
	
	/**
	 * Converts the exit status of DiffMerge
	 * 
	 * @param {Object} exitStatus
	 */
	function translateExitStatus(exitStatus){
		switch(exitStatus){
			case 0: return 'IDENTICAL';
			case 1: return 'DIFFERENT *';
			case 2: return 'FILE-ERROR *';
			case 3: return 'SYNTAX-ERROR *';
			default: return 'UNKNOWN EXIT STATUS *' 
		}
	}
			
	/**
	 * Outputs the HTML code to a set of files
	 * 
	 * @param {Object} filename
	 * @param {Object} htmlOutputDirectory
	 * @param {Object} waebricEnvironments
	 */
	this.createHTML = function(filename, htmlOutputDirectory, waebricEnvironments){
		for (var i = 0; i < waebricEnvironments.length; i++) {
			var waebricEnvironment = waebricEnvironments[i];
			if (waebricEnvironment.path != '') {
				var name = filename.substr(0, filename.length() - 4);
				var fw = new FileWriter(htmlOutputDirectory + name + '.html');
				var bf = new BufferedWriter(fw);				
				bf.write(waebricEnvironment.document);
				bf.close();
				fw.close();
			} else {
				print('Unable to write XHTML document for file ' + waebricEnvironment.name + '.wae. DOM document is empty.');
				throw new Error('Unable to write XHTML document for file ' + waebricEnvironment.name + '.wae. DOM document is empty.');
			}
		}
	}
	
	/**
	 * Output the result of an individual test file
	 * 
	 * @param {Object} exitStatus
	 * @param {Object} waebricFileName
	 * @param {Object} reportPath
	 */
	function outputTestResult(exitStatus, waebricFilename, reportPath){
		var fw = new FileWriter(reportPath, true);
		var bf = new BufferedWriter(fw);
		var output = waebricFilename + ' : ' + translateExitStatus(exitStatus) + '\n'
		bf.write(output);
		bf.close();	
		fw.close();
	}
	
	/**
	 * Output the acceptance percentage to the report
	 * 
	 * @param {Object} totalTests
	 * @param {Object} totalSuceededTests
	 * @param {Object} expectedFailedTests
	 * @param {Object} reportPath
	 */
	function outputStatistics(totalTests, totalSuceededTests, expectedFailedTests, reportPath){
		var fw = new FileWriter(reportPath, true);
		var bf = new BufferedWriter(fw);
		var output = '\n\nACCEPTANCE PERCENTAGE: ' + Math.ceil(((totalSuceededTests+expectedFailedTests)/totalTests)*100) + '%'
		bf.write(output);
		bf.close();	
		fw.close();	
		print(output)
	}
	
	/**
	 * Output an error report
	 * 
	 * @param {Object} name
	 * @param {Object} htmlOutputDirectory
	 * @param {Object} exception
	 */
	function outputErrorReport(name, htmlOutputDirectory, exception){
		//Create directory
		var fDir = new File(htmlOutputDirectory);
		fDir.mkdir();
		
		//Write file
		var fw = new FileWriter(htmlOutputDirectory + name + '.err');
		var bf = new BufferedWriter(fw);
		bf.write(exception.toString());
		bf.close();
		fw.close();
	}	
	
	/**
	 * Create directory output structure
	 * 
	 * @param {Object} outputHtmlDirectory
	 */
	function init(outputHtmlDirectory){
		var fDir = new File(outputHtmlDirectory);
		fDir.mkdir()
	}
}