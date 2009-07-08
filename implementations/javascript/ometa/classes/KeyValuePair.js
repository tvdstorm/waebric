/**************************************************************************** 
 * Specifies a KeyValuePair used in Expression
 * 
 * @author Nickolas Heirbaut 
 ****************************************************************************/

/**
 * KeyValuePair Class
 * 
 * IdCon ":" Expression -> KeyValuePair ("pair")
 * 
 * @param {Object} key
 * @param {Object} value
 */
function KeyValuePair(key, value){
	this.key = key;
	this.value = value;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}
