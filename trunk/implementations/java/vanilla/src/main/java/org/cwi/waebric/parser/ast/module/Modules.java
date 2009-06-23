package org.cwi.waebric.parser.ast.module;

import org.cwi.waebric.parser.ast.INodeVisitor;
import org.cwi.waebric.parser.ast.NodeList;

/**
 * Module* -> Modules
 * 
 * @author Jeroen van Schagen
 * @date 19-05-2009
 */
public class Modules extends NodeList<Module> {

	/**
	 * Check if a module identifier is contained by modules.
	 * @param identifier
	 * @return
	 */
	public boolean contains(ModuleId identifier) {
		for(Module module: this) {
			if(module.getIdentifier().equals(identifier)) { return true; }
		} 
		
		return false;
	}
	
	@Override
	public void accept(INodeVisitor visitor) {
		visitor.visit(this);
	}
	
}