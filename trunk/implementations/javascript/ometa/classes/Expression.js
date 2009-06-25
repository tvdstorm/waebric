/**
 * Expression class
 *
 * @author Nickolas Heirbaut
 */

function FieldExpression (expression, field){
	this.expression = expression;
	this.field = field;
}

function CatExpression (expressionLeft, expressionRight){
	this.expressionLeft = expressionLeft;
	this.expressionRight = expressionRight;
}

function TextExpression(text){
	this.text = text;
}

function VarExpression(variable){
	this.variable = variable;
}

function NatExpression(natural){
	this.natural = natural;
}

function SymbolExpression(symbol){
	this.symbol = symbol;
}

function ListExpression(list){
	this.list = list;
}

function RecordExpression(record){
	this.record = record;
}
