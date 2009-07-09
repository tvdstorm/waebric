importPackage(java.io)

load("lib.js")
load("ometa-base.js")
load("parser.js")
load("bs-js-compiler.js")
load("bs-ometa-compiler.js")
load("bs-ometa-optimizer.js")
load("bs-ometa-js-compiler.js")

load("../classes/Node.js")
load("../classes/Module.js")
load("../classes/ModuleId.js")
load("../classes/Import.js")
load("../classes/Site.js")
load("../classes/Mapping.js")
load("../classes/FunctionDefinition.js")
load("../classes/Statement.js")
load("../classes/Designator.js")
load("../classes/Attribute.js")
load("../classes/Argument.js")
load("../classes/Markup.js")
load("../classes/Embed.js")
load("../classes/Embedding.js")
load("../classes/Expression.js")
load("../classes/KeyValuePair.js")
load("../classes/Predicate.js")
load("../classes/TextTail.js")
load("../classes/Type.js")
load("../classes/Assignment.js")
load("../checker/WaebricSemanticException.js")
load("../checker/XHTML.js")
load("../checker/WaebricSemanticVisitor.js")
load("../checker/Environment.js")


/**
 * Returns the Waebric grammar written in OMeta for parsing
 *
 * @return Waebric parser (String)
 */
function loadWaebricParser(){
    var fis = new FileInputStream('../parser.ometa');
    var bis = new BufferedInputStream(fis);
    var dis = new DataInputStream(bis);
    
    var parser = '';
    while (dis.available() != 0) {
        parser += dis.readLine() + '\n';
    }
    fis.close();
    bis.close();
    dis.close();
    return parser;
}

/**
 * Returns the Waebric grammar written in OMeta for interpreting
 *
 * @return Waebric interpreter (String)
 */
function loadWaebricInterpreter(){
    var fis = new FileInputStream('../interpreter.ometa');
    var bis = new BufferedInputStream(fis);
    var dis = new DataInputStream(bis);
    
    var interpreter = '';
    while (dis.available() != 0) {
        interpreter += dis.readLine() + '\n';
    }
    fis.close();
    bis.close();
    dis.close();
    return interpreter;
}

/**
 * Returns a waebric program without dependencies
 *
 * @return Waebric program (String)
 */
function loadWaebricProgram(path){
    try {
        var fis = new FileInputStream(path);
        var bis = new BufferedInputStream(fis);
        var dis = new DataInputStream(bis);
        
        var program = '';
        while (dis.available() != 0) {
            program += dis.readLine() + '\n';
        }
        fis.close();
        bis.close();
        dis.close();
        return program;
    } catch (exception) {
        throw new NonExistingModuleException(path);
    }
}

/**
 * Returns the parser object
 */
function getParser(){
	//Load the parser source from the filesystem
	var parserSource = loadWaebricParser();
	
	//Build parser with OMeta
	return eval(translateCode(parserSource));		
}

/**
 * Returns the interpreter object
 */
function getInterpreter(){
	//Load the interpreter source from the filesystem
	var interpreterSource = loadWaebricInterpreter();
	
	//Build the interpreter with OMeta
	return eval(translateCode(interpreterSource));
}

/**
 * Parse and interprete the waebric program
 * First, the Abstract Syntax Tree is generated by the Waebric parser as a String.
 * Then, the Abstract Syntax Tree is converted to a data object by the interpreter
 *
 * @return Output of the Waebric parser (AST)
 * @return Output of the Waebric interpreter (DATA OBJECT)
 */
function translateCode(source){
    var translationError = function(m, i){
        alert("Translation error - please tell Alex about this!");
        throw fail
    }, tree = BSOMetaJSParser.matchAll(source, "topLevel", undefined, function(m, i){
        throw fail.delegated({
            errorPos: i
        })
    })
    return BSOMetaJSTranslator.match(tree, "trans", undefined, translationError)
}

/**
 * Evaluates the waebric program and returns a module object
 * 
 * @param {Object} path
 * @return {Module} module
 */
function evaluateProgram(path){
    try {		
        //Load the program source from the filesystem		
        var programSource = loadWaebricProgram(path);
		
        //Parse the Waebric program with OMeta
        var tree = this.parser.matchAll(programSource, "Module");
        
        //Interprete the parse tree of the Waebric program
        var module = this.interpreter.match(tree, "interp");

		//Get dependencies	
        module.dependencies = getDependencies(path, module);   
		
		//Return module
		return module     
    } catch (exception) {
        throw exception;
    }
}

/**
 * Loads all transitive dependencies per module
 *
 * @param {Module} module
 */
function getDependencies(path, module){
    var dependencies = new Array();
	
	//Load all dependencies inside the module
    for (var i = 0; i < module.imports.length; i++) {
		//Determine relative path of parent module towards file system
        var directoriesParent = path.split('/');
        var directoryParent = directoriesParent.slice(0, directoriesParent.length - 1).join('/').concat("/");

		//Determine relative path of dependency towards parent module
		var directoryDependency = module.imports[i].moduleId.identifier.replace('.', '/');
				
		//Determine relative path of dependency towards file system
		var new_path = directoryParent + directoryDependency + ".wae"  
		
		//Load module based on path
        try {
            var dependency = evaluateProgram(new_path)
            dependencies.push(dependency)
		}catch(exception if exception instanceof NonExistingModuleException){
			//Dependency couldn't be found, save as SemanticException
			//Evaluation will be continued for remaining dependencies
			root.addException(exception)
		}catch(exception){
			//Unexpected exception thrown. Evaluation will be terminated
			throw exception;
		}
    }
    return dependencies;
}

//Setup parser and interpreter
var parser = getParser();
var interpreter = getInterpreter();

//Start new environment for logging exceptions	
var root = new Environment();
try {
	//Evaluate waebric program
	var module = evaluateProgram('../../../../demos/misc/menus.wae');
	
	//Perform semantic validation
	module.accept(new ModuleVisitor(), root);
}catch(exception if exception instanceof NonExistingModuleException){
	//Root module couldn't be found on the filesystem. Evaluation terminated.
	root.addException(exception);	
}catch(exception){
	//Unexpected exception thrown
	print('\n');
	print("BEGIN UNEXPECTED EXCEPTION THROWN")
	print(exception)
	print("END UNEXPECTED EXCEPTION THROWN")
}finally{
	//Print exceptions from environment
	print('\n');
	print("BEGIN SEMANTIC EXCEPTIONS")
	print(root.getExceptions());
	print("END SEMANTIC EXCEPTIONS")
	print('\n');
}

