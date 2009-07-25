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
	//Fields
	this.expression = expression;
	this.field = field;
	
	//Methods
	this.toString = new function(){
		return this.expression + "." + this.field;
	}
}
FieldExpression.prototype = new Node(); //Inheritance base class

/**
 * Cat Expression Class
 * 
 * Expression "+" Expression -> Expression ("cat")
 * 
 * @param {Object} expressionLeft
 * @param {Object} expressionRight
 */
function CatExpression (expressionLeft, expressionRight){
	//Fields
	this.expressionLeft = expressionLeft;
	this.expressionRight = expressionRight;
	
	//Methods
	this.toString = new function(){
		 return this.expressionLeft + "+" + expressionRight;
	}
}
CatExpression.prototype = new Node(); //Inheritance base class

/**
 * Text Expression Class
 * 
 * Text -> Expression ("text")
 * 
 * @param {Object} text
 */
function TextExpression(text){
	//Fields
	this.text = text;
	
	//Methods
	this.toString = function(){
		return this.text;
	}
}
TextExpression.prototype = new Node(); //Inheritance base class

/**
 * Variable Expression Class
 * 
 * IdCon -> Expression ("var")
 * 
 * @param {Object} variable
 */
function VarExpression(variable){
	//Fields
	this.variable = variable;
	
	//Methods
	this.toString = function(){
		return this.variable;
	}
}
VarExpression.prototype = new Node(); //Inheritance base class

/**
 * Natural Expression Class
 * 
 * NatCon -> Expression ("num")
 * 
 * @param {Object} natural
 */
function NatExpression(natural){
	//Fields
	this.natural = natural;
	
	//Methods
	this.toString = function(){
		return this.natural;
	}
}
NatExpression.prototype = new Node(); //Inheritance base class

/**
 * Symbol Expression Class
 * 
 * SymbolCon -> Expression ("sym")
 * 
 * @param {Object} symbol
 */
function SymbolExpression(symbol){
	//Fields
	this.symbol = symbol;
	
	//Methods
	this.toString = function(){
		return this.symbol;
	}
}
SymbolExpression.prototype = new Node(); //Inheritance base class

/**
 * List Expression Class
 * 
 * "[" (Expression ',')* "]" -> Expression ("list")
 * 
 * @param {Object} list
 */
function ListExpression(list){
	//Fields
	this.list = list;
	
	//Methods
	this.toString = function(){
		return this.list;
	}
}
ListExpression.prototype = new Node(); //Inheritance base class

/**
 * Record Expression Class
 * 
 * CB (KeyValuePair ',')* CB -> Expression ("record")
 * 
 * @param {Object} record
 */
function RecordExpression(record){
	//Fields
	this.record = record;
	
	//Methods
	this.toString = function(){
		return this.record;
	}
}
RecordExpression.prototype = new Node(); //Inheritance base class