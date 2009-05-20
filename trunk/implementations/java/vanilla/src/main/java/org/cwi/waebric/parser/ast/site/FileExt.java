package org.cwi.waebric.parser.ast.site;

import org.cwi.waebric.parser.ast.ISyntaxNode;
import org.cwi.waebric.parser.ast.StringLiteral;

public class FileExt implements ISyntaxNode {

	private StringLiteral literal;
	
	public FileExt(String literal) {
		this.literal = new StringLiteral(literal);
	}

	public ISyntaxNode[] getChildren() {
		return new ISyntaxNode[] { literal };
	}
	
	@Override
	public String toString() {
		return literal.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return literal.equals(obj);
	}
	
}