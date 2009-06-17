public class FormalsVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTFormals node, Object data){
		addToAST( "formals([" );
		
		String[] imageElements = node.image.split(",");
		int imageElementCount = imageElements.length;
		
		String formalsSet = "";
		for (int imageElementIndex = 0; imageElementIndex < imageElementCount; imageElementIndex++){
			if (imageElementIndex > 0) {
				formalsSet += ", ";
			}
			
			formalsSet += "\"" + imageElements[imageElementIndex] + "\"";
		}
		
		addToAST( formalsSet );

	  	addToAST( "])" );
		return data;
	}
}