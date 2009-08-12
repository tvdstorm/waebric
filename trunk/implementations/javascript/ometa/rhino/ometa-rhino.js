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
function createHTML(waebricEnvironments, siteName){
	for(var i = 0; i < waebricEnvironments.length; i++){	
		var waebricEnvironment = waebricEnvironments[i];
		var rootPath = '../../demos/ometa/';
		var sitePath = siteName + '/' + waebricEnvironment.path.toString();	
		createDirectories(rootPath, sitePath)
		
		//Write file
		var fw = new FileWriter(rootPath + sitePath);
		var bf = new BufferedWriter(fw);
		bf.write(waebricEnvironment.document);
		bf.close();
	}	
}

/**
 * Creates the directory structure for the HTML output
 * 
 * @param {String} rootPath
 * @param {String} sitePath
 */
function createDirectories(rootPath, sitePath){		
	var fDir = new File(rootPath);
	if (!fDir.exists()) {
		fDir.mkdir();
	}
	
	var lastDirectory = rootPath;
	var pathElements = sitePath.split('/')
	for(var itemIndex = 0; itemIndex < pathElements.length - 1; itemIndex++){
		var pathElement = pathElements[itemIndex];
		var fDir = new File(lastDirectory+pathElement);
		if (!fDir.exists()) {
			fDir.mkdir();
		}
		lastDirectory += pathElement + '/';
	}
	
}

/**
 * Creates a text file that serves as the input for Tidy,
 * a pretty printer for HTML
 * 
 * @param {Array} An array of XML documents
 */
function createTidyOutput(waebricEnvironments, siteName){
	var output = '';
	for(var i = 0; i < waebricEnvironments.length; i++){	
		var waebricEnvironment = waebricEnvironments[i];
		output += '../../demos/ometa/' + siteName + '/' + waebricEnvironment.path.toString() + ' ';	
	}
	//Write file
	var fw = new FileWriter('../../demos/ometa/tidy.txt');
	var bf = new BufferedWriter(fw);
	bf.write(output);
	bf.close();
}


/**
 * Converts a Waebric program to HTML
 */
function convertToHTML(path, siteName){
	
	try {
		//Parsing
		var parserResult = WaebricParser.parseAll(path);
		
		//Validation		
		var validationResult = WaebricSemanticValidator.validateAll(parserResult.module)
		print('---------------VALIDATOR --------------------')
		print(validationResult.exceptions)
		print('---------------------------------------------')
		
		//Interpreting
		var interpreterResult = WaebricInterpreter.interpreteAll(parserResult.module);		
		
		//Output results
		createHTML(interpreterResult.environments, siteName);
	
		//Create text file for pretty printer
		createTidyOutput(interpreterResult.environments, siteName);
	}catch(exception){
		//Unexcpected error thrown
		print(exception)
	}
}

//OMetaCompiler.compileWaebricParser();
convertToHTML('../../../../demos/lava/lava.wae', 'lava')

