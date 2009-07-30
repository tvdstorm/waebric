/**
 * Compiles the raw data from the OMeta parser and saves the output to a file
 */
function OMetaCompiler(){
		
	/**
	 * Compiles the parser and saves it to a file
	 *
	 * @return {Object} The parser
	 */
	this.compileWaebricParser = function(){
		try {
			this.compile('../parser/WaebricParser.ometa');
		} catch (exception) {
			throw exception;
		}
	}
	
	/**
	 * Compiles the parser and saves it to a file
	 *
	 * @return {Object} The parser
	 */
	this.compile = function(pathInput){
		try {
			var source = this.getOMetaSource(pathInput);
			var result = "/* Generated code by OMeta's Base Javascript Translator */\n\n";
			result += this.translateCode(source);
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
	this.getOMetaSource = function(path){
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
	 * Parses OMeta source code by OMeta base code
	 *
	 * @param {String} The OMeta source code
	 * @return {Object} Parser object
	 */
	this.translateCode = function(source){
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
	compiler.compileWaebricParser(pathInput)
}

OMetaCompiler.compileWaebricParser = function(){
	var compiler = new OMetaCompiler();
	compiler.compileWaebricParser()
}
