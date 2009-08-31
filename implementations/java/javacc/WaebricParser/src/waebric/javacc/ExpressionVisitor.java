package waebric.javacc;
public class ExpressionVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	private static final int LABEL_ELEMENT = 0;
	private static final int FIRST_DATA_ELEMENT = 1;
	
	private static final String CHOICE_SYM = "sym";
	private static final String CHOICE_TEXT = "text";
	private static final String CHOICE_NUM = "num";
	private static final String CHOICE_LIST = "list";
	private static final String CHOICE_RECORD = "record";
	private static final String CHOICE_VAR = "var";

	
	public Object visit(ASTExpression node, Object data){
		
		// Split the LABEL_ELEMENT from the data (array element 1-x)
		String[] dataFromJjt = node.image.split(SPLIT_SEPARATOR);
		
		if(	dataFromJjt[LABEL_ELEMENT].equals(CHOICE_SYM)) {
			// Because the sym data can contain elements equal to the SPLIT_SEPARATOR, we need
			// to reconstruct it.
			String text = reconstructText(dataFromJjt, FIRST_DATA_ELEMENT, SPLIT_SEPARATOR);
			if(lastCharacter(node.image).equals(SPLIT_SEPARATOR)){
				text += SPLIT_SEPARATOR;
			}
			
			addToAST( dataFromJjt[LABEL_ELEMENT]  + "(" + addQuotes(text) + ")" );
		}
		
		else if(dataFromJjt[LABEL_ELEMENT].equals(CHOICE_TEXT)){
			// Because the text data can contain elements equal to the SPLIT_SEPARATOR, we need
			// to reconstruct it.
			String text = reconstructText(dataFromJjt, FIRST_DATA_ELEMENT, SPLIT_SEPARATOR);		
			if(lastCharacter(text).equals("\"")){
				// if the last character is a "\"", remove both the first and last character.
				text = text.substring(1, text.length() -1);
			}
			
			addToAST( dataFromJjt[LABEL_ELEMENT] + "(" + addEscQuotes(text) + ")" );
		}
		
		else if(dataFromJjt[LABEL_ELEMENT].equals(CHOICE_NUM)){
			addToAST( dataFromJjt[LABEL_ELEMENT] + "(" + safeGetStr(dataFromJjt, FIRST_DATA_ELEMENT) + ")" );
		}
		
		else if(dataFromJjt[LABEL_ELEMENT].equals(CHOICE_LIST) || dataFromJjt[LABEL_ELEMENT].equals(CHOICE_RECORD)) {
			addToAST( dataFromJjt[LABEL_ELEMENT] + "([" );
			processChildren(node);
			addToAST( "])" );
		}

		else if(dataFromJjt[LABEL_ELEMENT].equals(CHOICE_VAR)){
			VarVisitor varVisitor = new VarVisitor();
  			node.jjtGetChild(FIRST_CHILD).jjtAccept(varVisitor, null);
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
		
		for ( int currentChild = FIRST_CHILD; currentChild < numberOfChildren; currentChild++ ) {
  			if (currentChild > FIRST_CHILD){
  				addToAST( ", " );
  			}
			
			if (node.jjtGetChild(currentChild).toString().equals(NODE_EXPRESSION)){
  				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
  				addToAST( expressionVisitor.getAST() );
  			}
			
			else if (node.jjtGetChild(currentChild).toString().equals(NODE_DOTIDCON)){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				addToAST( dotIdConVisitor.getAST() );
  			}

			else if (node.jjtGetChild(currentChild).toString().equals(NODE_KEYVALUEPAIR)){
	  			KeyValuePairVisitor keyValuePairVisitor = new KeyValuePairVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(keyValuePairVisitor, null);
	  			addToAST( keyValuePairVisitor.getAST() );
		  	}
		}
	}
}