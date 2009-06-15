public class TextTailVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTTextTail node, Object data){
		int numberOfChildren = node.jjtGetNumChildren();
		
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
		
		return data;
	}
}