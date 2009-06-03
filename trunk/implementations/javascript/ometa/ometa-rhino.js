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
      tree             = BSOMetaJSParser.matchAll(s, "topLevel", undefined, function(m, i) { throw fail.delegated({errorPos: i}) })
  return BSOMetaJSTranslator.match(tree, "trans", undefined, translationError)
}

getGrammar = function() { 
	fis = new FileInputStream('grammar.txt');  
	bis = new BufferedInputStream(fis);
	dis = new DataInputStream(bis);
	
	grammar = '';
	while(dis.available() != 0){
		grammar += dis.readLine() + '\n'; 
	}
	fis.close();
	bis.close();
	dis.close();
	return grammar;
} 

getProgram = function() { 
	fis = new FileInputStream('program.txt');  
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
	return getGrammar() + '; alert(Waebric.matchAll(getProgram(), "Modules"))'
}

compile = function() { 
	return eval(translateCode(getSource()))
}

compile()