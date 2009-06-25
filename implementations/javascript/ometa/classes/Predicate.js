/**
 * Predicate class
 *
 * @author Nickolas Heirbaut
 */

function NotPredicate (predicate){
	this.predicate = predicate;
}

function AndPredicate (predicateLeft, predicateRight){
	this.predicateLeft = predicateLeft;
	this.predicateRight = predicateRight;
}

function OrPredicate (predicateLeft, predicateRight){
	this.predicateLeft = predicateLeft;
	this.predicateRight = predicateRight;
}

function isAPredicate (expression, type){
	this.expression = expression;
	this.type = type;
}