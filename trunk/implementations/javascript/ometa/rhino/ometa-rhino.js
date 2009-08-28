/**
 * JAVASCRIPT INPUT FILE FOR RHINO
 * 
 * @author Nickolas Heirbaut [nickolas.heirbaut@dejasmijn.be]
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
load('../parser/WaebricParser.ometa.js')
load('../parser/WaebricParserResult.js')
load('../parser/WaebricParserException.js')
		
load('../validator/WaebricValidator.js')
load('../validator/WaebricValidator.ometa.js')
load('../validator/WaebricValidatorException.js')
load('../validator/WaebricValidatorResult.js')
load('../validator/WaebricSemanticException.js')
load('../validator/WaebricFunctionValidator.js')
load('../validator/WaebricVariableValidator.js')
load('../validator/XHTML.js')

load('../compiler/OMetaCompiler.js')

load('../utils/WaebricFileLoader.js')
load('../utils/WaebricDependencyParser.js')

/**
 * Outputs the HTML code to a set of files
 * 
 * @param {Array} An array of XML documents
 */
function createHTML(waebricEnvironments, siteName){
	for(var i = 0; i < waebricEnvironments.length; i++){	
		var waebricEnvironment = waebricEnvironments[i];
		var rootPath = '../../../../../demos/output_ometa/';
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
		output += '../../../../../demos/output_ometa/' + siteName + '/' + waebricEnvironment.path.toString() + ' ';	
	}
	//Write file
	var fw = new FileWriter('../../../../../demos/output_ometa/tidy.txt');
	var bf = new BufferedWriter(fw);
	bf.write(output);
	bf.close();
}

/**
 * Converts a Waebric program to HTML
 */
function convertToHTML(path, siteName){	
	try {			
		//Parsing + validation	
		var validatorResult = WaebricValidator.parseAndValidate(path);
		print(validatorResult.toString())
		
		//Interpreting
		var interpreterResult = WaebricInterpreter.interprete(validatorResult.module);	
		
		//Output results
		createHTML(interpreterResult.environments, siteName);
	
		//Create text file for pretty printer
		createTidyOutput(interpreterResult.environments, siteName);
	}catch(exception){
		//Unexcpected error thrown
		print('\n******************************************************************************')
		print(exception.toString());
		print('\n******************************************************************************\n')
	}
}

//OMetaCompiler.compileWaebricParser();
//OMetaCompiler.compileWaebricValidator();
	
convertToHTML('../../../../../demos/source/lava/lava.wae', 'lava')
//convertToHTML('../programs/program.wae', 'program')