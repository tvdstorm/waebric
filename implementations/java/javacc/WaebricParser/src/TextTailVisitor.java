public class TextTailVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTTextTail node, Object data){
		String[] dataFromJjt = node.image.split(":");
		if (dataFromJjt[0].equals("post")){
			addToAST( "), " + dataFromJjt[0] + "(\"" + dataFromJjt[1].substring(0,dataFromJjt[1].length() -1) + "\\\"\")" );			
		} else 
	    if (dataFromJjt[0].equals("mid")){
			addToAST( "), " + dataFromJjt[0] + "(\"" + dataFromJjt[1] + "\", " );
		}

		
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) {
			if (node.jjtGetChild(currentChild).toString().equals("Embed")){
				EmbedVisitor embedVisitor = new EmbedVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(embedVisitor, null);
  				addToAST( embedVisitor.getAST() );
  			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("TextTail")){
				TextTailVisitor textTailVisitor = new TextTailVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(textTailVisitor, null);
  				addToAST( textTailVisitor.getAST() + ")" );
  			}
		}
		
		return data;
	}
}