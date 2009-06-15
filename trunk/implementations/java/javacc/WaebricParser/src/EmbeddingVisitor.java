public class EmbeddingVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTEmbedding node, Object data){
		int numberOfChildren = node.jjtGetNumChildren();
		
		ast+= "embedding(pre(" + node.image + "), ";
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) {
			if (node.jjtGetChild(currentChild).toString().equals("Embed")){
				EmbedVisitor embedVisitor = new EmbedVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(embedVisitor, null);
  				ast += embedVisitor.getAST();
  			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("TextTail")){
				TextTailVisitor textTailVisitor = new TextTailVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(textTailVisitor, null);
  				ast += textTailVisitor.getAST();
  			}
		}
		
		ast+= ")";
		
		return data;
	}
}