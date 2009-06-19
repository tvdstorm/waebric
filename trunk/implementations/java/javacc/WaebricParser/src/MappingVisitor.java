public class MappingVisitor extends WaebricParserVisitorAdapter {	
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTMapping node, Object data){
		addToAST( "mapping(" );
		
		int numChildren = node.jjtGetNumChildren();
	  	for ( int currentChild = FIRST_CHILD; currentChild < numChildren; currentChild++ ) {
	  		if ( FIRST_CHILD < currentChild ){
  				addToAST( ", " );
  			}
	  		
	  		if ( node.jjtGetChild(currentChild).toString().equals(NODE_PATH) ){
	  			PathVisitor pathVisitor = new PathVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(pathVisitor, null);
	  			addToAST( pathVisitor.getAST() ); 
	  		} 
	  		else if ( node.jjtGetChild(currentChild).toString().equals(NODE_MARKUP) ){
	  			MarkupVisitor markupVisitor = new MarkupVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(markupVisitor, null);
	  			addToAST( markupVisitor.getAST() );
	  		}
	    }
	  	
	  	addToAST( ")" );
		return data;
	}
}