package waebric.javacc;
public class AttributeVisitor extends WaebricParserVisitorAdapter {
	private static final int LABEL_ELEMENT = 0;
	private static final int FIRST_DATA_ELEMENT = 1;
	
	private static final String CHOICE_ID = "id";
	private static final String CHOICE_CLASS = "class";
	private static final String CHOICE_NAME = "name";
	private static final String CHOICE_TYPE = "type";
	private static final String CHOICE_WIDTH_HEIGHT = "width-height";
	private static final String CHOICE_HEIGHT = "height";
	
	public Object visit(ASTAttribute node, Object data){
		
		// Make a choice between kinds
		String[] dataFromJJT = node.image.split(SPLIT_SEPARATOR);
		
		if(	dataFromJJT[LABEL_ELEMENT].equals(CHOICE_ID) ||
			dataFromJJT[LABEL_ELEMENT].equals(CHOICE_CLASS) ||
			dataFromJJT[LABEL_ELEMENT].equals(CHOICE_NAME) ||
			dataFromJJT[LABEL_ELEMENT].equals(CHOICE_TYPE)) {
				addToAST( dataFromJJT[LABEL_ELEMENT] + "(" + 
					addQuotes( safeGetStr(dataFromJJT, FIRST_DATA_ELEMENT) ) + ")" );
		}
		
		else if(dataFromJJT[LABEL_ELEMENT].equals(CHOICE_WIDTH_HEIGHT) ||
				dataFromJJT[LABEL_ELEMENT].equals(CHOICE_HEIGHT)){
			addToAST( dataFromJJT[LABEL_ELEMENT] + "(" + safeGetStr(dataFromJJT, FIRST_DATA_ELEMENT) + ")" );
		}

		return data;
	}
}