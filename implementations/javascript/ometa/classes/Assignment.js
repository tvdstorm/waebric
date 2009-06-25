/**
 * Assignment class
 *
 * @author Nickolas Heirbaut
 */

function VariableBinding (variable, expression){
	this.variable = variable;
	this.expression = expression;
}

function FunctionBinding (formals, statement){
	this.formals = formals;
	this.statement = statement;
}