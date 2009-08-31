package waebric.javacc;
public class EmbedVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTEmbed node, Object data){
		int numberOfChildren = node.jjtGetNumChildren();
		
		// Check if it is a "exp-embedding" or "markupembedding"
		if( node.jjtGetChild(numberOfChildren - 1).toString().equals(NODE_EXPRESSION) ) {
			addToAST( "exp-embedding(" );
		} else {
			addToAST( "markup-embedding" );
		}
		
		for ( int currentChild = FIRST_CHILD; currentChild < numberOfChildren; currentChild++ ) {
  			if ( currentChild > FIRST_CHILD ){
  				addToAST( ", " );
  			}
			
			if ( node.jjtGetChild(currentChild).toString().equals(NODE_EXPRESSION) ){
  				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
  				addToAST( expressionVisitor.getAST() );
  			}
			
			else if ( node.jjtGetChild(currentChild).toString().equals(NODE_MARKUP) ){
				MarkupVisitor markupVisitor = new MarkupVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(markupVisitor, null);
  				addToAST( "[" + markupVisitor.getAST() + "], " );
  			}
			
			else if ( node.jjtGetChild(currentChild).toString().equals(NODE_DOTIDCON) ){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				addToAST( ", " + dotIdConVisitor.getAST() );
  			}
		}
		
		return data;
	}
}