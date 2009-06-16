public class EmbedVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTEmbed node, Object data){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) {
			
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