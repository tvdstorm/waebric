public class FormalsVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTFormals node, Object data){
		addToAST( "[" );
		
		String[] imageElements = node.image.split(SPLIT_SEPARATOR);
		int imageElementCount = imageElements.length;
		String formalsSet = EMPTY_STRING;
		
		for ( int imageElementIndex = FIRST_CHILD; imageElementIndex < imageElementCount; imageElementIndex++ ){
			if ( FIRST_CHILD < imageElementIndex ) {
				formalsSet += ", ";
			}
			
			formalsSet += addQuotes( imageElements[imageElementIndex] );
		}
		
		addToAST( formalsSet );
	  	addToAST( "]" );
	  	
		return data;
	}
}