/**
 * JAVASCRIPT INPUT FILE FOR RHINO
 * 
 * @author Nickolas Heirbaut
 */

importPackage(java.io)

load('env.rhino.js')
load('vanilla-rhino.js')
load('../base/lib.js')
load('../base/ometa-base.js')
load('../base/parser.js')
load('../base/bs-js-compiler.js')
load('../base/bs-ometa-compiler.js')
load('../base/bs-ometa-optimizer.js')
load('../base/bs-ometa-js-compiler.js')
load('../parser/WaebricParser.js')
load('../parser/WaebricParserException.js')
load('../compiler/OMetaCompiler.js')

/**
 * Outputs the HTML code to a set of files
 * 
 * @param {Array} An array of XML documents
 */
function write(waebricEnvironments){
	for(var i = 0; i < waebricEnvironments.length; i++){	
		var waebricEnvironment = waebricEnvironments[i];
		var path = waebricEnvironment.path.toString();		
		
		//Create directory
		var pathElements = path.split('/');
		var directory = pathElements.slice(0, pathElements.length - 1).join('');
		
		var fDir = new File(directory);
		if (!fDir.exists()) {
			fDir.mkdir();
		}
		
		//Write file
		var fw = new FileWriter(waebricEnvironment.path);
		var bf = new BufferedWriter(fw);
		bf.write(waebricEnvironment.document);
		bf.close();
	}
}

/**
 * Returns the HTML output of a Waebric program
 */
function convertToHTML(path){
	
	try {
		//Parsing
		var parserResult = WaebricParser.parseAll(path);
		//print(parserResult.module.functionDefinitions)
		
		//Validation		
		var validationResult = WaebricSemanticValidator.validateAll(parserResult.module)
		//print(validationResult.exceptions)
		
		//Interpreting
		var interpreterResult = WaebricInterpreter.interpreteAll(parserResult.module);		
		
		//Output results
		print(interpreterResult.environments[0].document)
		write(interpreterResult.environments);
	}catch(exception){
		//Unexcpected error thrown
		print(exception)
	}
}

//OMetaCompiler.compileWaebricParser();
convertToHTML('../../../../demos/lava/lava.wae')

