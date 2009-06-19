public class MarkupVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTMarkup node, Object data){
		int numChildren = node.jjtGetNumChildren();
		String suffix = EMPTY_STRING;
		
	  	// Markup is a call if markup has arguments, so there are at least 2 children		
		if ( 2 <= (node.jjtGetNumChildren() ) ) {
			addToAST( "call(" );
			suffix = ")";
		}
		
	  	for ( int currentChild = FIRST_CHILD; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if ( FIRST_CHILD < currentChild ){
  				addToAST( ", " );
  			}
	  		
	  		if ( node.jjtGetChild(currentChild).toString().equals(NODE_DESIGNATOR) ){
	  			DesignatorVisitor designatorVisitor = new DesignatorVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(designatorVisitor, null);
	  			addToAST( designatorVisitor.getAST() );
	  		} 
	  		else if ( node.jjtGetChild(currentChild).toString().equals(NODE_ARGUMENTS) ){
	  			ArgumentsVisitor argumentsVisitor = new ArgumentsVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(argumentsVisitor, null);
	  			addToAST( argumentsVisitor.getAST() );
	  		}
	    }
	  	
	  	addToAST( suffix );
		
		return data;
	}
}