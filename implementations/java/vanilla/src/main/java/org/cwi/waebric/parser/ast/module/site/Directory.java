package org.cwi.waebric.parser.ast.module.site;

import org.cwi.waebric.WaebricSymbol;
import org.cwi.waebric.parser.ast.AbstractSyntaxNodeList.AbstractSeparatedSyntaxNodeList;

/**
 * { PathElement "/" }+ -> Directory
 * 
 * @author Jeroen van Schagen
 * @date 20-05-2009
 */
public class Directory extends AbstractSeparatedSyntaxNodeList<PathElement> {
	
	/**
	 * Separate path elements with a slash /
	 */
	public Directory() {
		super(WaebricSymbol.SLASH);
	}

}