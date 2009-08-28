/**
 * Metric tool based on JSMeter 
 * 
 * More info JSMeter: http://code.google.com/p/jsmeter
 * The file complexity.js was modified and extended for the purpose of the research
 * 
 * @author Nickolas Heirbaut [nickolas.heirbaut@dejasmijn.be]
 */
importPackage(java.io);
load('../jsmeter/tokens.js');
load('../jsmeter/parse.js');
load('../jsmeter/complexity.js');

function MaintainabilityTest(){	

	/**
	 * Analyze the whole project and outputs the result
	 * 
	 * @param {String} rootDirectory
	 */
	this.ananlyzeProject = function(rootDirectory, projectDirectories){		
		
		var result;
		
		var body_html = "";
		for(var i = 0; i < projectDirectories.length; i++){
			var subdirectoryName = projectDirectories[i];
			var path = rootDirectory + subdirectoryName;
			var source = mergeFileContent(path);

			body_html += '<h4>' + subdirectoryName.toString().toUpperCase() +'</h4>'			
			body_html += analyze(source);
		}	
		outputStatistics(body_html, rootDirectory);		
	}
	
	/**
	 * Start measuring
	 * Copied from jsmeter.html
	 */
	function analyze(source){
		//Build parser
		parse = make_parse();     
		
		//Parse the javascript file to an AST   
        tree = parse(source);
		
		//Calculate the complexity
        COMPLEXITY.complexity(tree, "code");
		
		//The metrics
		return COMPLEXITY.renderStats();
	}
	
	/**
	 * Concats the content of each file in the directory and
	 * returns it.
	 * 
	 * @param {String} directory The directory
	 * @return {String}
	 */
	function mergeFileContent(directory){
		var dir = new File(directory);
		var files = dir.listFiles();
		var result = '';		
		for (var i = 0; i < files.length; i++) {
			var file = files[i];
			if (file.isDirectory() && file.getName != '.svn') {
				result += mergeFileContent(file);
			} else if(isValidFileExtension(file.getName().toString())) {
				result += getFileSource(file);
			}
		}
		
		return result;	
	}
	
	function isValidFileExtension(fileName){
		if (fileName.length() > 3) {
			var extension = fileName.substring(fileName.length() - 2)
			if (fileName.length() > 7) {
				var longExtension = fileName.substring(fileName.length() - 8)
				var isJavaScriptFile = (extension == "js");
				var isCompilerOMetaFile = (longExtension == "ometa.js")
				return isJavaScriptFile && !isCompilerOMetaFile;
			}else{
				return isJavaScriptFile
			}
			
		}else{
			return false;
		}
	}
	
	/**
	 * Returns the content of the file
	 * 
	 * @param {String} path The path of the file
	 * @return {String} The source
	 */
	function getFileSource(path){
		var fis = new FileInputStream(path);
		var bis = new BufferedInputStream(fis);
		var dis = new DataInputStream(bis);
		
		var source = '';
		while (dis.available() != 0) {
			source += dis.readLine() + '\n';
		}
		fis.close();
		bis.close();
		dis.close();
		return source;
	}
	
	/**
	 * Outputs the results to a file
	 * 
	 * @param {String} source The output
	 */
	function outputStatistics(source, rootDirectory){
		var fw = new FileWriter(rootDirectory + 'metrics/maintainability/maintainability.html');
		var bf = new BufferedWriter(fw);
		htmlPage = '<html><head><title>Metrics Waebric Project - Vanilla implementation/>'
		htmlPage += '<link rel="stylesheet" type="text/css" href="style.css"/></head>'
		htmlPage += '<body><h1>Metrics Waebric Project</h1><h3>Vanilla implementation</h3>' 
		htmlPage += source;
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