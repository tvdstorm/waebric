package waebric.javacc;
public class ArgumentVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTArgument node, Object data){
		int numChildren = node.jjtGetNumChildren();

	  	for ( int currentChild = FIRST_CHILD; currentChild < numChildren; currentChild++ ) {
  			// if list
	  		if (currentChild > FIRST_CHILD){
  				addToAST(", ");
  			}
			
	  		if (node.jjtGetChild(currentChild).toString().equals(NODE_DOTIDCON)){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				addToAST(dotIdConVisitor.getAST());
  			}
	  		
	  		else if (node.jjtGetChild(currentChild).toString().equals(NODE_EXPRESSION)){
	  			String nodeImage = node.image;
	  			if (!nodeImage.equals("")){
	  				addToAST("attr(" +  addQuotes(node.image) + ", ");
	  			}
	  			
	  			ExpressionVisitor expressionVisitor = new ExpressionVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
	  			addToAST(expressionVisitor.getAST());
	  			
	  			if (!nodeImage.equals(EMPTY_STRING)){
	  				addToAST(")");
	  			}
	  		}
	    }
		return data;
	}
}