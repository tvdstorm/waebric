importPackage(java.io);
load('env.rhino.js');

load("../ast/WaebricEnvironment.js");
load("../ast/Node.js");
load("../ast/Path.js");
load("../ast/Module.js");
load("../ast/ModuleId.js");
load("../ast/Import.js");
load("../ast/Site.js");
load("../ast/Mapping.js");
load("../ast/FunctionDefinition.js");
load("../ast/Statement.js");
load("../ast/Designator.js");
load("../ast/Attribute.js");
load("../ast/Argument.js");
load("../ast/Markup.js");
load("../ast/Embed.js");
load("../ast/Embedding.js");
load("../ast/Expression.js");
load("../ast/KeyValuePair.js");
load("../ast/Predicate.js");
load("../ast/TextTail.js");
load("../ast/Type.js");
load("../ast/Assignment.js");

load("../parser/lexical/WaebricTokenizer.js");
load("../parser/lexical/WaebricTokenizerResult.js");
load("../parser/lexical/WaebricTokenizerException.js");
load("../parser/lexical/WaebricLexicalException.js");
load("../parser/lexical/WaebricCharacter.js");
load("../parser/lexical/tokens/WaebricToken.js");
load("../parser/lexical/tokens/WaebricTokenIdentifier.js");
load("../parser/lexical/tokens/WaebricTokenComment.js");
load("../parser/lexical/tokens/WaebricTokenKeyword.js");
load("../parser/lexical/tokens/WaebricTokenNatural.js");
load("../parser/lexical/tokens/WaebricTokenSymbol.js");
load("../parser/lexical/tokens/WaebricTokenText.js");
load("../parser/lexical/tokens/WaebricTokenWhitespace.js");

load("../parser/WaebricParser.js");
load("../parser/WaebricParserResult.js");
load("../parser/WaebricParserException.js");

load("../parser/syntactic/WaebricBaseParser.js");
load("../parser/syntactic/WaebricParserStack.js");
load("../parser/syntactic/WaebricSyntaxException.js");
load("../parser/syntactic/WaebricRootParser.js");
load("../parser/syntactic/WaebricModuleParser.js");
load("../parser/syntactic/WaebricSiteParser.js");
load("../parser/syntactic/WaebricFunctionDefinitionParser.js");
load("../parser/syntactic/WaebricMarkupParser.js");
load("../parser/syntactic/WaebricExpressionParser.js");
load("../parser/syntactic/WaebricParserToken.js");

load("../parser/syntactic/WaebricStatementParser.js");
load("../parser/syntactic/WaebricPredicateParser.js");
load("../parser/syntactic/WaebricEmbeddingParser.js");

load("../validator/WaebricValidator.js");
load("../validator/WaebricSemanticException.js");
load("../validator/WaebricValidatorException.js");
load("../validator/WaebricValidatorResult.js");
load("../validator/WaebricValidatorVisitor.js");
load("../validator/XHTML.js");

load('../interpreter/WaebricInterpreter.js');
load("../interpreter/WaebricInterpreterException.js");
load('../interpreter/WaebricInterpreterResult.js');
load("../interpreter/WaebricInterpreterVisitor.js");
load('../interpreter/DOM.js');

/**
 * Outputs the HTML code to a set of files
 * 
 * @param {Array} An array of XML documents
 */
function createHTML(waebricEnvironments, siteName){
	for(var i = 0; i < waebricEnvironments.length; i++){			
		var waebricEnvironment = waebricEnvironments[i];
		if (waebricEnvironment.path != '') {
			var rootPath = '../../demos/vanilla/';
			var sitePath = siteName + '/' + waebricEnvironment.path.toString();
			createDirectories(rootPath, sitePath)
			
			//Write file
			var fw = new FileWriter(rootPath + sitePath);
			var bf = new BufferedWriter(fw);
			bf.write(waebricEnvironment.document);
			bf.close();
		}else{
			print('Unable to write XHTML document for file ' + waebricEnvironment.name + '.wae. DOM document is empty.')
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
 * Creates a text file that serves as the input for Tidy,
 * a pretty printer for HTML
 * 
 * @param {Array} An array of XML documents
 */
function createTidyOutput(waebricEnvironments, siteName){
	var output = '';
	for(var i = 0; i < waebricEnvironments.length; i++){	
		var waebricEnvironment = waebricEnvironments[i];
		output += '../../demos/vanilla/' + siteName + '/' + waebricEnvironment.path.toString() + ' ';	
	}
	//Write file
	var fw = new FileWriter('../../demos/vanilla/tidy.txt');
	var bf = new BufferedWriter(fw);
	bf.write(output);
	bf.close();
}

/**
 * Converts a Waebric Program to HTML
 * 
 * @param {String} path
 * @param {String} siteName
 */
function convertToHTML(path, siteName){	
	try {
		//Parsing
		var parserResult = WaebricParser.parse(path);
		
		//Validating		
		var validatorResult = WaebricValidator.validate(parserResult.module)
		print(validatorResult)
		
		//Interpreting
		var interpreterResult = WaebricInterpreter.interprete(parserResult.module);
		
		//Output results		
		createHTML(interpreterResult.environments, siteName);
		
		//Create text file for pretty printer
		createTidyOutput(interpreterResult.environments, siteName);
	}catch(exception){
		print('\n******************************************************************************')
		print(exception.toString());
		print('\n******************************************************************************\n')
	}
}

convertToHTML('../../../../demos/lava/lava.wae', 'lava');
//convertToHTML('../programs/program.wae', 'program');
