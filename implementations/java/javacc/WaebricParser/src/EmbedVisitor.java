public class EmbedVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTEmbed node, Object data){
		int numberOfChildren = node.jjtGetNumChildren();
		
		// Check if it is a "exp-embedding" or "markupembedding"
		if(node.jjtGetChild(numberOfChildren - 1).toString().equals("Expression")) {
			addToAST( "exp-embedding(" );
		}else {
			addToAST( "markup-embedding" );
		}
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) {
  			if (currentChild > 0){
  				addToAST( ", " );
  			}
			
			if (node.jjtGetChild(currentChild).toString().equals("Expression")){
  				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
  				addToAST( expressionVisitor.getAST());
  			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("Markup")){
				MarkupVisitor markupVisitor = new MarkupVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(markupVisitor, null);
  				addToAST( "[" + markupVisitor.getAST() + "], " );
  			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("DotIdCon")){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				addToAST( ", " + dotIdConVisitor.getAST());
  			}
		}
		
		return data;
	}
}