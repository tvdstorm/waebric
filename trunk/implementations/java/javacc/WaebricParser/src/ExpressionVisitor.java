public class ExpressionVisitor extends WaebricParserVisitorAdapter {
	private static final int LABEL_ELEMENT = 0;
	private static final int FIRST_DATA_ELEMENT = 1;
	
	public Object visit(ASTExpression node, Object data){
		
		// Split the LABEL_ELEMENT from the data (array element 1-x)
		String[] dataFromJjt = node.image.split(SPLIT_SEPARATOR);
		
		if(	dataFromJjt[LABEL_ELEMENT].equals("sym")) {
			// Because the sym data can contain elements equal to the SPLIT_SEPARATOR, we need
			// to reconstruct it.
			String text = reconstructText(dataFromJjt, FIRST_DATA_ELEMENT, SPLIT_SEPARATOR);
			if(lastCharacter(node.image).equals(SPLIT_SEPARATOR)){
				text += SPLIT_SEPARATOR;
			}
			
			addToAST( dataFromJjt[LABEL_ELEMENT] + "(\"" + text + "\")" );
		}
		
		else if(dataFromJjt[LABEL_ELEMENT].equals("text")){
			// Because the text data can contain elements equal to the SPLIT_SEPARATOR, we need
			// to reconstruct it.
			String text = reconstructText(dataFromJjt, FIRST_DATA_ELEMENT, SPLIT_SEPARATOR);
			if(lastCharacter(node.image).equals(SPLIT_SEPARATOR)){
				text += SPLIT_SEPARATOR;
			}
			
			addToAST( dataFromJjt[LABEL_ELEMENT] + "(\"\\\"" + text + "\\\"\")" );
		}
		
		else if(dataFromJjt[LABEL_ELEMENT].equals("num")){
			addToAST( dataFromJjt[LABEL_ELEMENT] + "(" + safeGetStr(dataFromJjt, FIRST_DATA_ELEMENT) + ")" );
		}
		
		else if(dataFromJjt[LABEL_ELEMENT].equals("list") || dataFromJjt[LABEL_ELEMENT].equals("record")) {
			addToAST( dataFromJjt[LABEL_ELEMENT] + "([" );
			processChildren(node);
			addToAST( "])" );
		}

		else if(dataFromJjt[0].equals("var")){
			VarVisitor varVisitor = new VarVisitor();
  			node.jjtGetChild(0).jjtAccept(varVisitor, null);
  			addToAST( varVisitor.getAST() );
		}
		
		return data;
	}
	
	/**
	 * This method controls which visitors can be used for scanning the children of Expression()
	 * @param node: holds the Expression node and all its children.
	 */
	private void processChildren(ASTExpression node) {
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) {
  			if (currentChild > 0){
  				addToAST( ", " );
  			}
			
			if (node.jjtGetChild(currentChild).toString().equals("Expression")){
  				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
  				addToAST( expressionVisitor.getAST() );
  			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("DotIdCon")){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				addToAST( dotIdConVisitor.getAST() );
  			}

			else if (node.jjtGetChild(currentChild).toString().equals("KeyValuePair")){
	  			KeyValuePairVisitor keyValuePairVisitor = new KeyValuePairVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(keyValuePairVisitor, null);
	  			addToAST( keyValuePairVisitor.getAST() );
		  	}
		}
	}
}