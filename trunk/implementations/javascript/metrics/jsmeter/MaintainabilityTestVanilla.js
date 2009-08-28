/*****************************************************************************
 * MAINTAINABILITY TEST FOR VANILLA PROJECT
 * 
 * @author Nickolas Heirbaut
 *****************************************************************************/

load('../jsmeter/MaintainabilityTest.js')
var analyzer = new MaintainabilityTest();
var projectPath = '../../vanilla/'
var directories = ['ast','parser','validator','interpreter'];	
analyzer.ananlyzeProject(projectPath, directories)
