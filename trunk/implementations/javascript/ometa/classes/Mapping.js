/**************************************************************************** 
 * Specifies a Mapping used in Site
 * 
 * @author Nickolas Heirbaut 
 ****************************************************************************/

/**
 * Mapping Class
 * 
 * @param {Object} path
 * @param {Object} markup
 */
function Mapping (path, markup){
	this.path = path;
	this.markup = markup;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}
