/**************************************************************************** 
 * Specifies a Predicate used in Statement
 * 
 * @author Nickolas Heirbaut 
 ****************************************************************************/

/**
 * Not Predicate Class
 * 
 * "!" Predicate -> Predicate ("not")
 * 
 * @param {Object} predicate
 */
function NotPredicate (predicate){
	this.predicate = predicate;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * And Predicate Class
 * 
 * Predicate "&&" Predicate -> Predicate ("and")
 * 
 * @param {Object} predicateLeft
 * @param {Object} predicateRight
 */
function AndPredicate (predicateLeft, predicateRight){
	this.predicateLeft = predicateLeft;
	this.predicateRight = predicateRight;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Or Predicate Class 
 * 
 * Predicate "||" Predicate -> Predicate ("or")
 * 
 * @param {Object} predicateLeft
 * @param {Object} predicateRight
 */
function OrPredicate (predicateLeft, predicateRight){
	this.predicateLeft = predicateLeft;
	this.predicateRight = predicateRight;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Is-a Predicate Class
 * 
 * Expression "." Type "?" -> Predicate
 * 
 * @param {Object} expression
 * @param {Object} type
 */
function isAPredicate (expression, type){
	this.expression = expression;
	this.type = type;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}