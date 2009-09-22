/**
 * Metric tool based on JSMeter 
 * 
 * More info JSMeter: http://code.google.com/p/jsmeter
 * The file complexity.js was modified and extended for the purpose of the research
 * 
 * @author Nickolas Heirbaut [nickolas.heirbaut@dejasmijn.be]
 */
importPackage(java.io);
load('../metrics/maintainability/tokens.js');
load('../metrics/maintainability/parse.js');
load('../metrics/maintainability/complexity.js');

function MaintainabilityTest(){	

	var html;
	
	/**
	 * Analyze the whole project and outputs the result
	 * 
	 * @param {String} allTestsPath
	 * @parem {String} title
	 */
	this.runAll = function(allTestsPath, outputPath, title){
		var source = getSource(allTestsPath);
		var metrics = analyze(source, title);					
		outputStatistics(outputPath, metrics, title);		
	}
	
	/**
	 * Merge the content of all files listed in the input file
	 * 
	 * @param {Object} allTestsPath
	 * @return {String} Merged file content
	 */
	function getSource(allTestsPath){
		var source = '';
		
		var fis = new FileInputStream(allTestsPath);
        var bis = new BufferedInputStream(fis);
        var dis = new DataInputStream(bis);
		
		//Get file content of each file/directory
		while (dis.available() != 0) {
			var inputFile = new File(dis.readLine());
			var inputFileExists = inputFile.exists();
			var isDirectory = inputFile.isDirectory();
			
			if(!inputFileExists){
				print('Unable to load file: ' + inputFile.toString());
			} else if(isDirectory){
				source += getDirectorySource(inputFile);
			}else{
				source += getFileSource(inputFile);
			}
		}		
		return source;
	}
		
	/**
	 * Merge the file content of all files in the directory
	 * 
	 * @param {String} directory The directory
	 * @return {String}
	 */
	function getDirectorySource(dir){
		var files = dir.listFiles();
		var source = '';
		for (var i = 0; i < files.length; i++) {
			var file = files[i];
			if (file.isDirectory()) {
				source += getDirectorySource(file);
			} else if(isValidFileExtension(file.getName().toString())) {
				source += getFileSource(file);
			}
		}		
		return source;	
	}	
	
	/**
	 * Returns the content of the file
	 * 
	 * @param {String} path The path of the file
	 * @return {String} filePath source
	 */
	function getFileSource(filePath){
		return readFile(filePath)
	}
	
	/**
	 * Start measuring
	 * Copied from jsmeter.html
	 */
	function analyze(source, title){
		try {
			//Build parser
			parse = make_parse();
			
			//Parse the javascript file to an AST   
			tree = parse(source);
			
			//Calculate the complexity
			COMPLEXITY.complexity(tree, "code");
			
			//The metrics
			return COMPLEXITY.renderStats();
		}catch(exception){
			print('Analysis failed for ' + title);
			return 'ANALYSIS FAILED!';
		}
	}
	
	/**
	 * Filter files
	 * 
	 * @param {Object} fileName
	 */
	function isValidFileExtension(fileName){
		var startIndexFileExt = fileName.lastIndexOf('.') + 1;
		if(startIndexFileExt > 0){			
			var fileExt = fileName.substring(startIndexFileExt, fileName.length());
			return fileExt == 'js'
		}else{
			return false;
		}
	}
		
	/**
	 * Outputs the results to a file
	 * 
	 * @param {String} outputPath The output
	 */
	function outputStatistics(outputPath, metrics, title){
		var fw = new FileWriter(outputPath);
		var bf = new BufferedWriter(fw);
		htmlPage = '<html><head><title>Metrics Waebric Project - Vanilla implementation/>'
		htmlPage += '<link rel="stylesheet" type="text/css" href="style.css"/></head>'
		htmlPage += '<body><h1>Metrics Waebric Project</h1><h3>Vanilla implementation</h3>'
		htmlPage += '<h4>' + title.toString().toUpperCase() +'</h4>'	
		htmlPage += metrics;
		htmlPage += '</body></html>'
		bf.write(htmlPage);
		bf.close();
	}
	
	/**
	 * Initialization of JSMeter 
	 * Copied from jsmeter.html
	 */
	function initialize(){
		if (typeof Object.create !== 'function') {
		    Object.create = function (o) {
		        function F() {}
		        F.prototype = o;
		        return new F();
		    };
		}
		
		Object.prototype.error = function (message, t) {
		    t = t || this;
		    t.name = "SyntaxError";
		    t.message = message;
		    debugger;
		    throw t;
		};
	}
	
	initialize();
}
