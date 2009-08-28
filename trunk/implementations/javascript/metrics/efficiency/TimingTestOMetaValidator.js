/*****************************************************************************
 * PERFORMANCE TEST
 * 
 * @author Nickolas Heirbaut
 *****************************************************************************/

/* SETTINGS TIMING TEST */
var timingOutput = '../../vanilla/metrics/efficiency/ldta.timing.validator.txt';
var path = '../../../../demos/ldta/ldta.wae';

/* TIMERS */
load("../efficiency/TimingTimer.js")
var validatorTimingTimer = new TimingTimer();

/* START VALIDATOR PERFORMANCE TEST */
validatorTimingTimer.start();
importPackage(java.io);
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
load('../../ometa/utils/WaebricFileLoader.js')
load('../../ometa/utils/WaebricDependencyParser.js')
load('../../ometa/validator/WaebricValidator.js')
load('../../ometa/parser/WaebricParser.ometa.js')
load('../../ometa/validator/WaebricValidator.ometa.js')
load('../../ometa/validator/WaebricValidatorException.js')
load('../../ometa/validator/WaebricValidatorResult.js')
load('../../ometa/validator/WaebricSemanticException.js')
load('../../ometa/validator/WaebricFunctionValidator.js')
load('../../ometa/validator/WaebricVariableValidator.js')
load('../../ometa/validator/XHTML.js')

var result = WaebricValidator.parseAndValidate(path);

/* END VALIDATOR PERFORMANCE TEST */
validatorTimingTimer.stopAndWrite(timingOutput, ';\n');