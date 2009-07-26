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
load('../parser/WaebricOMetaParser.js')
load('../parser/WaebricOMetaParserException.js')

/**
 * Outputs the HTML code to a set of files
 * 
 * @param {Array} An array of XML documents
 */
function write(waebricEnvironments){
	for(var i = 0; i < waebricEnvironments.length; i++){
		var waebricEnvironment = waebricEnvironments[i];
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
		var parserResult = WaebricOMetaParser.parseAll(path);
		
		//Validation		
		var validationResult = WaebricSemanticValidator.validateAll(parserResult.module)
		
		//Interpreting
		var interpreterResult = WaebricInterpreter.interpreteAll(parserResult.module);
		
		//Output results
		write(interpreterResult);
	}catch(exception){
		//Unexcpected error thrown
		print(exception)
	}
}

convertToHTML('../../../../demos/lava/lava.waes')

