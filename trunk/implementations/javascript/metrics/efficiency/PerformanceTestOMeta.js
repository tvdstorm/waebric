/*****************************************************************************
 * Performance Test OMeta
 * 
 * This test converts a waebric file to HTML and measures the execution time 
 * of each individual component:
 * - Parser (excl. validation)
 * - Interpreter
 * - Global
 * 
 * @author Nickolas Heirbaut
 *****************************************************************************/

load("../metrics/efficiency/PerformanceTestBase.js")

function PerformanceTestOMeta(){
	
	/* Timers */
	var parserTimer = new PerformanceTimer();
	var interpreterTimer = new PerformanceTimer();
		
	this.runComponents = function(filePath){		
		var parserResult = this.runParser(filePath);
		var interpreterResult = this.runInterpreter(parserResult);
	}
	
	this.runParser = function(filePath){
		//Start timer
		parserTimer.start();
		
		//Load imports for this component
		load('../ometa/base/lib.js')
		load('../ometa/base/ometa-base.js')
		load('../ometa/base/parser.js')
		load('../ometa/base/bs-js-compiler.js')
		load('../ometa/base/bs-ometa-compiler.js')
		load('../ometa/base/bs-ometa-optimizer.js')
		load('../ometa/base/bs-ometa-js-compiler.js')
		load("../vanilla/ast/WaebricEnvironment.js")
		load("../vanilla/ast/Node.js")
		load("../vanilla/ast/Path.js")
		load("../vanilla/ast/Module.js")
		load("../vanilla/ast/ModuleId.js")
		load("../vanilla/ast/Import.js")
		load("../vanilla/ast/Site.js")
		load("../vanilla/ast/Mapping.js")
		load("../vanilla/ast/FunctionDefinition.js")
		load("../vanilla/ast/Statement.js")
		load("../vanilla/ast/Designator.js")
		load("../vanilla/ast/Attribute.js")
		load("../vanilla/ast/Argument.js")
		load("../vanilla/ast/Markup.js")
		load("../vanilla/ast/Embed.js")
		load("../vanilla/ast/Embedding.js")
		load("../vanilla/ast/Expression.js")
		load("../vanilla/ast/KeyValuePair.js")
		load("../vanilla/ast/Predicate.js")
		load("../vanilla/ast/TextTail.js")
		load("../vanilla/ast/Type.js")
		load("../vanilla/ast/Assignment.js")
		load('../ometa/parser/WaebricParser.ometa.js')
		load('../ometa/parser/WaebricParser.js')
		load('../ometa/parser/WaebricParserResult.js')
		load('../ometa/parser/WaebricParserException.js')
		load('../ometa/utils/WaebricFileLoader.js')
		load('../ometa/utils/WaebricDependencyParser.js')
		load('../ometa/validator/WaebricSemanticException.js')
		
		//Execute parsing
		var result = WaebricParser.parse(filePath);
		
		//End timer
		parserTimer.stopAndWrite(this.reportPath, ";")
		
		return result;
	}

	this.runInterpreter = function(parserResult){
		//Start timer
		interpreterTimer.start();
		
		//Imports
		load('../vanilla/interpreter/WaebricInterpreter.js');
		load("../vanilla/interpreter/WaebricInterpreterException.js");
		load('../vanilla/interpreter/WaebricInterpreterResult.js');
		load("../vanilla/interpreter/WaebricInterpreterVisitor.js");
		load('../vanilla/interpreter/DOM.js');
		load('env.rhino.js');
		
		//Execute interpreting
		var interpreterResult = WaebricInterpreter.interprete(parserResult.module);

		//End timer
		interpreterTimer.stopAndWrite(this.reportPath, ';');
	}
}
PerformanceTestOMeta.prototype = new PerformanceTestBase();

//Run performance test
var performanceTest = new PerformanceTestOMeta();
var filePath = arguments[0]; //Rhino input argument
performanceTest.runAll(filePath, '', 'ometa');
