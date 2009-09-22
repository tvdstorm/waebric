/**
 * Compiles the OMeta grammar
 * 
 * @author Nickolas Heirbaut [nickolas.heirbaut@dejasmijn.be]
 */
function OMetaCompiler(){
		
	/**
	 * Compiles the parser and outputs it to a file
	 *
	 * @return {Object} The parser
	 */
	this.compile = function(pathInput){
		try {
			print('\n---- Compiling ' + pathInput)
			var source = getOMetaSource(pathInput);
			var result = "/**\n"
						+ " * Generated code by OMeta's Base Javascript Translator\n"
						+ " *\n" 
						+ " * @author Nickolas Heirbaut [nickolas.heirbaut@dejasmijn.be]\n"
						+ " */\n\n"
			result += translateCode(source);
			var fw = new FileWriter(pathInput + '.js');
			var bf = new BufferedWriter(fw);
			bf.write(result);
			bf.close();
		} catch (exception) {
			throw exception;
		}
	}
	
	/**
	 * Returns the source of an OMeta file
	 *
	 * @return {String} Parser source
	 */
	function getOMetaSource(path){
		try {
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
		} catch (exception) {
			throw exception;
		}
	}
	
	/**
	 * Parses OMeta source code with OMeta base code
	 *
	 * @param {String} The OMeta source code
	 * @return {Object} Parser object
	 */
	function translateCode(source){
		var translationError = function(m, i){
			print("Translation error - please tell Alex about this!");
			throw fail
		}, tree = BSOMetaJSParser.matchAll(source, "topLevel", undefined, function(m, i){
			throw fail.delegated({
				errorPos: i
			})
		})
		return BSOMetaJSTranslator.match(tree, "trans", undefined, translationError)
	}	
}

OMetaCompiler.compile = function(pathInput){	
	var compiler = new OMetaCompiler();
	compiler.compile(pathInput)
}