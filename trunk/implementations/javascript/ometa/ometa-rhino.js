importPackage(java.io)

load("lib.js")
load("ometa-base.js")
load("parser.js")
load("bs-js-compiler.js")
load("bs-ometa-compiler.js")
load("bs-ometa-optimizer.js")
load("bs-ometa-js-compiler.js")

alert = print

translateCode = function(s) {
	var translationError = function(m, i) { alert("Translation error - please tell Alex about this!"); throw fail },
    tree = BSOMetaJSParser.matchAll(s, "topLevel", undefined, function(m, i) { throw fail.delegated({errorPos: i}) })
  	return BSOMetaJSTranslator.match(tree, "trans", undefined, translationError)
}

getParser = function() {
	fis = new FileInputStream('parser.ometa');
	bis = new BufferedInputStream(fis);
	dis = new DataInputStream(bis);

	parser = '';
	while(dis.available() != 0){
		parser += dis.readLine() + '\n';
	}
	fis.close();
	bis.close();
	dis.close();
	return parser;
}

getInterpreter = function() {
	fis = new FileInputStream('interpreter.ometa');
    bis = new BufferedInputStream(fis);
    dis = new DataInputStream(bis);

    interpreter = '';
    while(dis.available() != 0){
    	interpreter += dis.readLine() + '\n';
    }
    fis.close();
    bis.close();
    dis.close();
    return interpreter;
}

getProgram = function() {
    fis = new FileInputStream('interpreter.wae');
    bis = new BufferedInputStream(fis);
    dis = new DataInputStream(bis);

    program = '';
    while(dis.available() != 0){
    	program += dis.readLine() + '\n';
	}
	fis.close();
	bis.close();
	dis.close();
	return program;
}

getSource = function(){
	program = getProgram();

	source 	= getParser() + ';'
	        + 'tree = WaebricParser.matchAll(program, "Modules");'
	        + 'alert("\n");'
	        + 'alert("\n");'
	        + 'alert("\n");'
	        + 'alert("--------------------------------------------------------------------------------------------------------");'
	        + 'alert(tree);'
	        + 'alert("--------------------------------------------------------------------------------------------------------");'
	        + 'alert("\n");'
	        + 'alert("\n");'
	        + 'alert("\n");'
			+ getInterpreter() + ';'
			+ 'html_output = WaebricInterpreter.match(tree, "interp");'
			+ 'alert(html_output);'

	return source;
}

compile = function() {
	alert(getProgram());
    return eval(translateCode(getSource()))
}

compile()
