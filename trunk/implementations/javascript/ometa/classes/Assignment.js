/**
 * Assignment class
 *
 * @author Nickolas Heirbaut
 */

function VariableBinding (variable, expression){
	this.variable = variable;
	this.expression = expression;
}

function FunctionBinding (variable, formals, statement){
	this.variable = variable
	this.formals = formals;
	this.statement = statement;
}