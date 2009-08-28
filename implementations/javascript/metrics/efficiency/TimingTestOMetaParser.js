/*****************************************************************************
 * PERFORMANCE TEST
 * 
 * @author Nickolas Heirbaut
 *****************************************************************************/

/* SETTINGS TIMING TEST */
var timingOutput = '../../ometa/metrics/efficiency/menus.timing.txt';
var path = '../../../../demos/misc/menus.wae';

/* TIMERS */
load("../efficiency/TimingTimer.js")

var overallTimingTimer = new TimingTimer();
var parserTimingTimer = new TimingTimer();
var interpreterTimingTimer = new TimingTimer();

/*****************************************************************************/

/* START OVERALL PERFORMANCE TEST */
overallTimingTimer.start();
importPackage(java.io);

/*****************************************************************************/


/* START PARSER PERFORMANCE TEST */
parserTimingTimer.start();
load('../../ometa/base/lib.js')
load('../../ometa/base/ometa-base.js')
load('../../ometa/base/parser.js')
load('../../ometa/base/bs-js-compiler.js')
load('../../ometa/base/bs-ometa-compiler.js')
load('../../ometa/base/bs-ometa-optimizer.js')
load('../../ometa/base/bs-ometa-js-compiler.js')
load("../../vanilla/ast/WaebricEnvironment.js")
load("../../vanilla/ast/Node.js")
load("../../vanilla/ast/Path.js")
load("../../vanilla/ast/Module.js")
load("../../vanilla/ast/ModuleId.js")
load("../../vanilla/ast/Import.js")
load("../../vanilla/ast/Site.js")
load("../../vanilla/ast/Mapping.js")
load("../../vanilla/ast/FunctionDefinition.js")
load("../../vanilla/ast/Statement.js")
load("../../vanilla/ast/Designator.js")
load("../../vanilla/ast/Attribute.js")
load("../../vanilla/ast/Argument.js")
load("../../vanilla/ast/Markup.js")
load("../../vanilla/ast/Embed.js")
load("../../vanilla/ast/Embedding.js")
load("../../vanilla/ast/Expression.js")
load("../../vanilla/ast/KeyValuePair.js")
load("../../vanilla/ast/Predicate.js")
load("../../vanilla/ast/TextTail.js")
load("../../vanilla/ast/Type.js")
load("../../vanilla/ast/Assignment.js")
load('../../ometa/parser/WaebricParser.ometa.js')
load('../../ometa/parser/WaebricParser.js')
load('../../ometa/parser/WaebricParserResult.js')
load('../../ometa/parser/WaebricParserException.js')
load('../../ometa/utils/WaebricFileLoader.js')
load('../../ometa/utils/WaebricDependencyParser.js')

var result = WaebricParser.parse(path);

/* END PARSER PERFORMANCE TEST */
parserTimingTimer.stopAndWrite(timingOutput, ";")

/*****************************************************************************/

/* START INTERPRETER PERFORMANCE TEST */
interpreterTimingTimer.start();

load('../../vanilla/interpreter/WaebricInterpreter.js');
load("../../vanilla/interpreter/WaebricInterpreterException.js");
load('../../vanilla/interpreter/WaebricInterpreterResult.js');
load("../../vanilla/interpreter/WaebricInterpreterVisitor.js");
load('../../vanilla/interpreter/DOM.js');
load('env.rhino.js');

var interpreterResult = WaebricInterpreter.interprete(result.module);

/* END VALIDATOR PERFORMANCE TEST */
interpreterTimingTimer.stopAndWrite(timingOutput, ';');

/*****************************************************************************/


/* END OVERALL PERFORMANCE TEST */
overallTimingTimer.stopAndWrite(timingOutput, ';\n')