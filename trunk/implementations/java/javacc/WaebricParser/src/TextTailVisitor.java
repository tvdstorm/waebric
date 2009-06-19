public class TextTailVisitor extends WaebricParserVisitorAdapter {
	private static final int LABEL_ELEMENT = 0;
	private static final int FIRST_DATA_ELEMENT = 1;
	
	public Object visit(ASTTextTail node, Object data){
		String imageData = node.image;
		if(lastCharacter(node.image).equals("\"")){
			// if the last character is a "\"", remove it.
			imageData = imageData.substring(0, imageData.length() -1);
		}
		String[] dataFromJjt = imageData.split(":");
		
		if (dataFromJjt[LABEL_ELEMENT].equals("post")){
			// Reconstruction required to counter the effects of splitting when the data contains a colon.
			String text = reconstructText(dataFromJjt, FIRST_DATA_ELEMENT, SPLIT_SEPARATOR);
			if(lastCharacter(node.image).equals(SPLIT_SEPARATOR)){
				text += SPLIT_SEPARATOR;
			}
			
			addToAST( "), " + dataFromJjt[LABEL_ELEMENT] + "(\"" + text + "\\\"\")");			
		} 
		
		else if (dataFromJjt[LABEL_ELEMENT].equals("mid")){
			// Reconstruction required to counter the effects of splitting when the data contains a colon.
			String text = reconstructText(dataFromJjt, FIRST_DATA_ELEMENT, SPLIT_SEPARATOR);
			if(lastCharacter(node.image).equals(SPLIT_SEPARATOR)){
				text += SPLIT_SEPARATOR;
			}
	    	
	    	addToAST( "), " + dataFromJjt[LABEL_ELEMENT] + "(\"" + text + "\", " );
		}
	
		// Visit the children of TextTail
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