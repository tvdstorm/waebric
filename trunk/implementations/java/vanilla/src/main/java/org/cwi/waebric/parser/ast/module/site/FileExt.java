package org.cwi.waebric.parser.ast.module.site;

import org.cwi.waebric.parser.ast.AbstractSyntaxNode;
import org.cwi.waebric.parser.ast.INodeVisitor;
import org.cwi.waebric.parser.ast.StringLiteral;

public class FileExt extends AbstractSyntaxNode {

	private StringLiteral literal;
	
	public FileExt(String literal) {
		this.literal = new StringLiteral(literal);
	}

	public AbstractSyntaxNode[] getChildren() {
		return new AbstractSyntaxNode[] { literal };
	}
	
	@Override
	public String toString() {
		return literal.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return literal.equals(obj);
	}
	
	@Override
	public void accept(INodeVisitor visitor, Object[] args) {
		visitor.visit(this, args);
	}
	
}