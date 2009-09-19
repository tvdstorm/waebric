load('../ometa/rhino/rhino-imports.js')

/**
 * Outputs the HTML code to a set of files
 * 
 * @param {Array} An array of XML documents
 */
function createHTML(waebricEnvironments, siteName){
	for(var i = 0; i < waebricEnvironments.length; i++){	
		var waebricEnvironment = waebricEnvironments[i];
		if (waebricEnvironment.path.toString()) {			
			var rootPath = '../ometa/generated_html/';
			var sitePath = siteName + '/' + waebricEnvironment.path.toString();
			createDirectories(rootPath, sitePath)
			
			//Write file
			var fw = new FileWriter(rootPath + sitePath);
			var bf = new BufferedWriter(fw);
			bf.write(waebricEnvironment.document);
			bf.close();
		}else{
			print('\nNo main function found!\n')
		}
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
	}catch(exception){
		print(exception.toString());
	}
}

//OMetaCompiler.compileWaebricParser();
//OMetaCompiler.compileWaebricValidator();	
convertToHTML('lava/lava.wae', 'lava')