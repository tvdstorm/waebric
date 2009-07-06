/**************************************************************************** 
 * Specifies the arguments in a designator call
 *  
 * @author Nickolas Heirbaut 
 ****************************************************************************/

/** 
 * Argument class
 * 
 * IdCon "=" Expression -> Argument ("attr")
 */
function Argument (variable, expression){
	this.variable = variable;
	this.expression = expression;
	
	this.toString = attributeToString;
}