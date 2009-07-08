/**************************************************************************** 
 * Specifies an assignment in a let-function
 *  
 * @author Nickolas Heirbaut 
 ****************************************************************************/

/**
 * Variable Binding Class 
 * 
 * IdCon "=" Expression ";" -> Assignment ("var-bind")
 * 
 * @param {object} variable
 * @param {object} expression
 */
function VariableBinding (variable, expression){
	this.variable = variable;
	this.expression = expression;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}
/**
 * Function Binding Class
 * 
 * IdCon Formals "=" Statement -> Assignment ("func-bind")
 * 
 * @param {object} variable
 * @param {object} formals
 * @param {object} statement
 */
function FunctionBinding (variable, formals, statement){
	this.variable = variable
	this.formals = formals;
	this.statement = statement;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}