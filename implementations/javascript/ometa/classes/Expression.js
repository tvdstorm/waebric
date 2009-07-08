/**************************************************************************** 
 * Specifies an Expression used in Statements, Assignments, Embeds, 
 * Predicates, Argument, KeyValuePair
 * 
 * @author Nickolas Heirbaut 
 ****************************************************************************/

/**
 * Field Expression Class
 * 
 * Expression "." IdCon -> Expression ("field")
 * 
 * @param {object} expression
 * @param {object} field
 */
function FieldExpression (expression, field){
	this.expression = expression;
	this.field = field;
	
	this.toString = fieldExpressionToString;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Cat Expression Class
 * 
 * Expression "+" Expression -> Expression ("cat")
 * 
 * @param {Object} expressionLeft
 * @param {Object} expressionRight
 */
function CatExpression (expressionLeft, expressionRight){
	this.expressionLeft = expressionLeft;
	this.expressionRight = expressionRight;
	
	this.toString = catExpressionToString;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Text Expression Class
 * 
 * Text -> Expression ("text")
 * 
 * @param {Object} text
 */
function TextExpression(text){
	this.text = text;
	
	this.toString = textExpressionToString;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Variable Expression Class
 * 
 * IdCon -> Expression ("var")
 * 
 * @param {Object} variable
 */
function VarExpression(variable){
	this.variable = variable;
	
	this.toString = varExpressionToString;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Natural Expression Class
 * 
 * NatCon -> Expression ("num")
 * 
 * @param {Object} natural
 */
function NatExpression(natural){
	this.natural = natural;
	
	this.toString = natExpressionToString;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Symbol Expression Class
 * 
 * SymbolCon -> Expression ("sym")
 * 
 * @param {Object} symbol
 */
function SymbolExpression(symbol){
	this.symbol = symbol;
	
	this.toString = sybmolExpressionToString;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * List Expression Class
 * 
 * "[" (Expression ',')* "]" -> Expression ("list")
 * 
 * @param {Object} list
 */
function ListExpression(list){
	this.list = list;
	
	this.toString = listExpressionToString;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Record Expression Class
 * 
 * CB (KeyValuePair ',')* CB -> Expression ("record")
 * 
 * @param {Object} record
 */
function RecordExpression(record){
	this.record = record;
	
	this.toString = recordExpressionToString;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}



function fieldExpressionToString() {
    return this.expression + "." + this.field;
}

function catExpressionToString() {
    return this.expressionLeft + "+" + expressionRight;
}

function textExpressionToString() {
    return this.text;
}

function varExpressionToString() {
    return this.variable;
}

function natExpressionToString() {
    return this.natural;
}

function sybmolExpressionToString() {
    return this.symbol;
}

function listExpressionToString(){
	return this.list;
}

function recordExpressionToString(){
	return this.record;
}
