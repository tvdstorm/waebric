/*****************************************************************************
 * Performance Test Vanilla
 * 
 * This test converts a waebric file to HTML and measures the execution time 
 * of each individual component:
 * - Lexer
 * - Parser
 * - Lexer + Parser
 * - Validator
 * - Interpreter
 * - Global
 * 
 * @author Nickolas Heirbaut
 *****************************************************************************/

load("../metrics/efficiency/PerformanceTestBase.js")

/* PUBLIC TIMERS */
var syntacticTimer = new PerformanceTimer();    
var lexicalTimer = new PerformanceTimer();
var fileloaderTimer = new PerformanceTimer(); 

function PerformanceTestVanilla(){
    
    /* Timers */
    var parserTimer = new PerformanceTimer();
    var importParserTimer = new PerformanceTimer();
    var importASTTimer = new PerformanceTimer();
    var importLexicalTimer = new PerformanceTimer();
    var importSyntacticTimer = new PerformanceTimer();    
    var validatorTimingTimer = new PerformanceTimer();
    var interpreterTimer = new PerformanceTimer();
            
    this.runComponents = function(filePath){
        var parserResult = runParser(filePath);
        var validatorResult = runValidator(parserResult);
        var interpreterResult = runInterpreter(parserResult);		
    }
    
    function runParser(filePath){
        //Start timer
        parserTimer.start();
        
        //Load imports for this component
        runParserImports();
        runASTImports();
        runLexicalImports();
		runSyntacticImports();
        
        //Execute parser
        var parserResult = WaebricParser.parse(filePath);
        
        //Stop timer		
        parserTimer.stopAndWrite(this.reportPath, ";")
		return parserResult;
    }
    
    function runParserImports(){
        //Start timer
        importParserTimer.start();
        
        //Load imports for this component
        load("../vanilla/parser/WaebricParser.js");
        load("../vanilla/parser/WaebricParserResult.js");
        load("../vanilla/parser/WaebricParserException.js");
        
        //Stop timer
        importParserTimer.stopAndWrite(this.reportPath, ";");
    }
    
    function runASTImports(){
        //Start timer
        importASTTimer.start();
        
        //Load imports for this component
        load("../vanilla/ast/WaebricEnvironment.js");
        load("../vanilla/ast/Node.js");
        load("../vanilla/ast/Path.js");
        load("../vanilla/ast/Module.js");
        load("../vanilla/ast/ModuleId.js");
        load("../vanilla/ast/Import.js");
        load("../vanilla/ast/Site.js");
        load("../vanilla/ast/Mapping.js");
        load("../vanilla/ast/FunctionDefinition.js");
        load("../vanilla/ast/Statement.js");
        load("../vanilla/ast/Designator.js");
        load("../vanilla/ast/Attribute.js");
        load("../vanilla/ast/Argument.js");
        load("../vanilla/ast/Markup.js");
        load("../vanilla/ast/Embed.js");
        load("../vanilla/ast/Embedding.js");
        load("../vanilla/ast/Expression.js");
        load("../vanilla/ast/KeyValuePair.js");
        load("../vanilla/ast/Predicate.js");
        load("../vanilla/ast/TextTail.js");
        load("../vanilla/ast/Type.js");
        load("../vanilla/ast/Assignment.js");
        
        //Stop timer
        importASTTimer.stopAndWrite(this.reportPath, ";")
    }
    
    function runLexicalImports(){
        //Start timer
        importLexicalTimer.start();
        
        //Load imports for this component
        load("../vanilla/parser/lexical/WaebricTokenizer.js");
        load("../vanilla/parser/lexical/WaebricTokenizerResult.js");
        load("../vanilla/parser/lexical/WaebricTokenizerException.js");
        load("../vanilla/parser/lexical/WaebricLexicalException.js");
        load("../vanilla/parser/lexical/WaebricCharacter.js");
        load("../vanilla/parser/lexical/tokens/WaebricToken.js");
        load("../vanilla/parser/lexical/tokens/WaebricTokenIdentifier.js");
        load("../vanilla/parser/lexical/tokens/WaebricTokenComment.js");
        load("../vanilla/parser/lexical/tokens/WaebricTokenKeyword.js");
        load("../vanilla/parser/lexical/tokens/WaebricTokenNatural.js");
        load("../vanilla/parser/lexical/tokens/WaebricTokenSymbol.js");
        load("../vanilla/parser/lexical/tokens/WaebricTokenText.js");
        load("../vanilla/parser/lexical/tokens/WaebricTokenWhitespace.js");
        
        //Stop timer
        importLexicalTimer.stopAndWrite(this.reportPath, ";")
    }
    
    function runSyntacticImports(){
        //Start timer
        importSyntacticTimer.start();
        
        //Load imports for this component
        load("../vanilla/parser/syntactic/WaebricBaseParser.js");
        load("../vanilla/parser/syntactic/WaebricParserStack.js");
        load("../vanilla/parser/syntactic/WaebricSyntaxException.js");
        load("../vanilla/parser/syntactic/WaebricRootParser.js");
        load("../vanilla/parser/syntactic/WaebricModuleParser.js");
        load("../vanilla/parser/syntactic/WaebricSiteParser.js");
        load("../vanilla/parser/syntactic/WaebricFunctionDefinitionParser.js");
        load("../vanilla/parser/syntactic/WaebricMarkupParser.js");
        load("../vanilla/parser/syntactic/WaebricExpressionParser.js");
        load("../vanilla/parser/syntactic/WaebricParserToken.js");        
        load("../vanilla/parser/syntactic/WaebricStatementParser.js");
        load("../vanilla/parser/syntactic/WaebricPredicateParser.js");
        load("../vanilla/parser/syntactic/WaebricEmbeddingParser.js");
        
        //Stop timer
        importSyntacticTimer.stopAndWrite(this.reportPath, ";")
    }

    function runValidator(parserResult){
        //Start timer
        validatorTimingTimer.start();
        
        //Load imports for this component
        load("../vanilla/validator/WaebricValidator.js");
        load("../vanilla/validator/WaebricSemanticException.js");
        load("../vanilla/validator/WaebricValidatorException.js");
        load("../vanilla/validator/WaebricValidatorResult.js");
        load("../vanilla/validator/WaebricValidatorVisitor.js");
        load("../vanilla/validator/XHTML.js");
        
        //Execute validation
        var validatorResult = WaebricValidator.validate(parserResult.module);
        
        //Stop timer
        validatorTimingTimer.stopAndWrite(this.reportPath, ';');
		
		return validatorResult;
    }
    
    function runInterpreter(parserResult){
        //Start timer
        interpreterTimer.start();
        
        //Load imports for this component
        load('../vanilla/interpreter/WaebricInterpreter.js');
        load("../vanilla/interpreter/WaebricInterpreterException.js");
        load('../vanilla/interpreter/WaebricInterpreterResult.js');
        load("../vanilla/interpreter/WaebricInterpreterVisitor.js");
        load('../vanilla/interpreter/DOM.js');
        load('env.rhino.js');
        
        //Execute validation
        var interpreterResult = WaebricInterpreter.interprete(parserResult.module);
        
        //End timer
        interpreterTimer.stopAndWrite(this.reportPath, ';');
		
		return interpreterResult;
    }
}
PerformanceTestVanilla.prototype = new PerformanceTestBase();

//Run performance test
var performanceTest = new PerformanceTestVanilla();
var filePath = arguments[0]; //Rhino input argument
var reportPath = performanceTest.makeReportPath(filePath, '', 'vanilla');
performanceTest.runAll(filePath, '', 'vanilla');