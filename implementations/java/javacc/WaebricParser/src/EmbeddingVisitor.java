public class EmbeddingVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTEmbedding node, Object data){
		addToAST( "pre(" + addQuotes("\\" + node.image) + ", " );

		int numberOfChildren = node.jjtGetNumChildren();
		for ( int currentChild = FIRST_CHILD; currentChild < numberOfChildren; currentChild++ ) {
			if (node.jjtGetChild(currentChild).toString().equals(NODE_EMBED) ){
				EmbedVisitor embedVisitor = new EmbedVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(embedVisitor, null);
  				addToAST( embedVisitor.getAST() );
  			}
			
			else if (node.jjtGetChild(currentChild).toString().equals(NODE_TEXTTAIL) ){
				TextTailVisitor textTailVisitor = new TextTailVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(textTailVisitor, null);
  				addToAST( textTailVisitor.getAST() );
  			}
		}
		
		addToAST( ")" );
		
		return data;
	}
}