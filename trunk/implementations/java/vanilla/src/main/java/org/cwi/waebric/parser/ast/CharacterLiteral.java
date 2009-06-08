package org.cwi.waebric.parser.ast;

public class CharacterLiteral extends AbstractSyntaxNode {

	private char literal;
	
	public CharacterLiteral(char literal) {
		this.literal = literal;
	}

	@Override
	public boolean equals(Object obj) {
		String data = obj.toString();
		if(data.length() > 1) { return false; }
		return literal == data.charAt(0);
	}
	
	@Override
	public String toString() {
		return "" + literal;
	}

	public char toCharacter() {
		return literal;
	}
	
	public AbstractSyntaxNode[] getChildren() {
		return new AbstractSyntaxNode[] { /* Leaf node */ };
	}
	
}