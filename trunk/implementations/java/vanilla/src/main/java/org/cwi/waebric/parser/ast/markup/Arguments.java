package org.cwi.waebric.parser.ast.markup;

import org.cwi.waebric.WaebricSymbol;
import org.cwi.waebric.parser.ast.CharacterLiteral;
import org.cwi.waebric.parser.ast.AbstractSyntaxNode;
import org.cwi.waebric.parser.ast.AbstractSyntaxNodeList.AbstractSeparatedSyntaxNodeList;

/**
 * "(" { Argument "," }* ")" -> Arguments
 * 
 * @author Jeroen van Schagen
 * @date 19-05-2009
 */
public class Arguments extends AbstractSeparatedSyntaxNodeList<Argument> {

	public Arguments() {
		super(WaebricSymbol.COMMA);
	}

	public AbstractSyntaxNode[] getChildren() {
		AbstractSyntaxNode[] children = super.getChildren();
		AbstractSyntaxNode[] elements = new AbstractSyntaxNode[children.length + 2];
		elements[0] = new CharacterLiteral(WaebricSymbol.LPARANTHESIS);
		System.arraycopy(children, 0, elements, 1, children.length);
		elements[elements.length - 1] = new CharacterLiteral(WaebricSymbol.RPARANTHESIS);
		return elements;
	}
	
}