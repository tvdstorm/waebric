package org.cwi.waebric.parser.ast;

public class IntegerLiteral implements ISyntaxNode {

	private int literal;
	
	public IntegerLiteral(int literal) {
		this.literal = literal;
	}
	
	public IntegerLiteral(String identifier) throws NumberFormatException {
		this.literal = (int) Double.parseDouble(identifier);
	}
	
	public int toInteger() {
		return literal;
	}
	
	@Override
	public String toString() {
		return "" + literal;
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			int value = Integer.parseInt(obj.toString());
			return value == literal;
		} catch(NumberFormatException e) {
			return false;
		}
	}

	public ISyntaxNode[] getChildren() {
		return null;
	}
	
}