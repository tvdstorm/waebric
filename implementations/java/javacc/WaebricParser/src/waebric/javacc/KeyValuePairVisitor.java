package waebric.javacc;
public class KeyValuePairVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTKeyValuePair node, Object data){
		addToAST( "pair(" );
		addToAST( addQuotes( node.image ) + ", " );
		
		int numChildren = node.jjtGetNumChildren();
	  	for ( int currentChild = FIRST_CHILD; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if ( currentChild > FIRST_CHILD ){
  				addToAST( ", " );
  			}
	  		
	  		if ( node.jjtGetChild(currentChild).toString().equals(NODE_EXPRESSION) ){
	  			ExpressionVisitor expressionVisitor = new ExpressionVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
	  			addToAST( expressionVisitor.getAST() );
	  		}
	    }
	  	
	  	if ( node.parent.toString().equals(NODE_EXPRESSION) ){
	  		// close record
	  		addToAST( "])" );
	  	}
	  	
	  	addToAST( ")" );
		
	  	return data;
	}
}