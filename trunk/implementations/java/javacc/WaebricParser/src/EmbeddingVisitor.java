public class EmbeddingVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTEmbedding node, Object data){
		int numberOfChildren = node.jjtGetNumChildren();
		
		addToAST( "pre(\"\\" + node.image + "\", " );
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) {
			if (node.jjtGetChild(currentChild).toString().equals("Embed")){
				EmbedVisitor embedVisitor = new EmbedVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(embedVisitor, null);
  				addToAST( embedVisitor.getAST());
  			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("TextTail")){
				TextTailVisitor textTailVisitor = new TextTailVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(textTailVisitor, null);
  				addToAST( textTailVisitor.getAST());
  			}
		}
		
		addToAST( ")" );
		
		return data;
	}
}