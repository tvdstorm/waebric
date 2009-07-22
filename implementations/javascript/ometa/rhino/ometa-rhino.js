importPackage(java.io)

load('env.rhino.js')

load("../ometa/base/lib.js")
load("../ometa/base/ometa-base.js")
load("../ometa/base/parser.js")
load("../ometa/base/bs-js-compiler.js")
load("../ometa/base/bs-ometa-compiler.js")
load("../ometa/base/bs-ometa-optimizer.js")
load("../ometa/base/bs-ometa-js-compiler.js")


load("../javascript/WaebricEnvironment.js")
load("../javascript/VisitorNode.js")
load("../javascript/classes/Node.js")
load("../javascript/classes/Path.js")
load("../javascript/classes/Module.js")
load("../javascript/classes/ModuleId.js")
load("../javascript/classes/Import.js")
load("../javascript/classes/Site.js")
load("../javascript/classes/Mapping.js")
load("../javascript/classes/FunctionDefinition.js")
load("../javascript/classes/Statement.js")
load("../javascript/classes/Designator.js")
load("../javascript/classes/Attribute.js")
load("../javascript/classes/Argument.js")
load("../javascript/classes/Markup.js")
load("../javascript/classes/Embed.js")
load("../javascript/classes/Embedding.js")
load("../javascript/classes/Expression.js")
load("../javascript/classes/KeyValuePair.js")
load("../javascript/classes/Predicate.js")
load("../javascript/classes/TextTail.js")
load("../javascript/classes/Type.js")
load("../javascript/classes/Variable.js")
load("../javascript/classes/Assignment.js")
load('../javascript/interpreter/WaebricInterpreter.js')
load("../javascript/interpreter/WaebricInterpreterVisitor.js")
load('../javascript/interpreter/DOM.js')
load("../javascript/validator/WaebricSemanticValidator.js")
load("../javascript/validator/WaebricSemanticValidatorVisitor.js")
load("../javascript/validator/WaebricSemanticValidatorException.js")
load("../javascript/validator/XHTML.js")


/**
 * Returns the Waebric grammar written in OMeta for parsing
 *
 * @return Waebric parser (String)
 */
function loadWaebricOMetaParser(){
    var fis = new FileInputStream('../ometa/parser/WaebricOmetaParser.ometa');
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
function loadWaebricOMetaInterpreter(){
    var fis = new FileInputStream('../ometa/interpreter/WabericOMetaInterpreter.ometa');
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
function getWaebricOMetaParser(){
	//Load the parser source from the filesystem
	var parserSource = loadWaebricOMetaParser();
	
	//Build parser with OMeta
	return eval(translateCode(parserSource));		
}

/**
 * Returns the interpreter object
 */
function getWaebricOMetaInterpreter(){
	//Load the interpreter source from the filesystem
	var interpreterSource = loadWaebricOMetaInterpreter();
	
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
        var module = this.parser.matchAll(programSource, "Module");

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
			//Dependency couldn't be found, save as WaebricSemanticException
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
var parser = getWaebricOMetaParser();
var interpreter = getWaebricOMetaInterpreter();
var module;
var exceptions = new Array();
var html_output = "";

//Try evaluating the waebric program
try {
	//Evaluate waebric program
	module = evaluateProgram('../programs/program.wae');
	
	//Semantic validation
	//exceptions = WaebricSemanticValidator.validateAll(module);	
	
	//Interprete
	html_output = WaebricInterpreter.interpreteAll(module);	
}catch(exception if exception instanceof NonExistingModuleException){
	//Waebric program not found
	print(exception)
}finally{
	if (exceptions.length != 0) {
		print(exceptions);
	}
	print(html_output)
}

//Write html 
var fw = new FileWriter("output.html");
var bf = new BufferedWriter(fw);
bf.write(html_output);
bf.close();



