/*****************************************************************************
 * Performance Test Base
 * 
 * Base class for performance tests
 * 
 * @author Nickolas Heirbaut
 *****************************************************************************/

load("../metrics/efficiency/PerformanceTimer.js")

function PerformanceTestBase(){	
	
	this.globalTimer = new PerformanceTimer();	
	this.reportPath = 0;
	
	this.runAll = function(filePath, suffix, implName){
		//Set path output file report
		this.reportPath = this.makeReportPath(filePath, suffix, implName);		
		
		//Start global timer		
		this.globalTimer.start();
		
		//Run components
		this.runGlobalImports();
		this.runComponents(filePath);
		
		//End global timer
		this.globalTimer.stopAndWrite(this.reportPath, ';\n')
	}
	
	this.runGlobalImports = function(){
		importPackage(java.io);
	}
	
	this.runComponents = function(){
		//Override this method
	}

	this.makeReportPath = function(filePath, suffix, implName){
		var fileArray = filePath.split('/');
		var fileName = fileArray[fileArray.length-1];
		return  '../' + implName + '/metrics/efficiency/' + fileName + suffix + '.timing';
	}
}