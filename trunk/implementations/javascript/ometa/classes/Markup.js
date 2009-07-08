/**************************************************************************** 
 * Specifies Markup used in Statements
 * 
 * @author Nickolas Heirbaut 
 ****************************************************************************/

/** 
 * Markup Call Class
 *
 * Designator Arguments -> Markup ("call")
 * 
 * @param {object} designator
 * @param {Array} Array of arguments
 */
function MarkupCall (designator, arguments){
	this.designator = designator;
	this.arguments = arguments;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}	
	
	//To string methods
	this.toString = function(){
		return this.designator.idCon + "(" + this.arguments + ")";
	}
	this.arguments.toString = function(){
		var argumentsString = '';
		for(var i = 0; i < this.length; i++){
			argumentsString += this[i] + ',';	
		}
		argumentsString = argumentsString.substr(0, argumentsString.length-1);
		return argumentsString;
	}
}