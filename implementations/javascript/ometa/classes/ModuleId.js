/**************************************************************************** 
 * Specifies a ModuleId used in Module and Import
 * 
 * @author Nickolas Heirbaut 
 ****************************************************************************/

/**
 * ModuleId Class
 * 
 * (IdCon ",")* -> ModuleId ("module-id")
 * 
 * @param {Object} identifier
 */
function ModuleId (identifier){
	this.identifier = identifier;	
}