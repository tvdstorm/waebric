/*****************************************************************************
 * MAINTAINABILITY TEST FOR OMETA PROJECT
 * 
 * @author Nickolas Heirbaut
 *****************************************************************************/

load('../metrics/jsmeter/MaintainabilityTest.js')
var analyzer = new MaintainabilityTest();
var projectPath = '../ometa/'
var directories = ['parser','utils','validator'];	
analyzer.ananlyzeProject(projectPath, directories)
