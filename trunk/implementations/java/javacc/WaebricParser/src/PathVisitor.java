public class PathVisitor extends WaebricParserVisitorAdapter {	
	private static final int LABEL_ELEMENT = 0;
	private static final int START_OF_DATA = 1;
	private static final int DIR_NAME = 1;
	private static final int FILENAME_ONLY = 2;
	
	public Object visit(ASTPath node, Object data){		
		String[] imageElements = node.image.split(SPLIT_SEPARATOR);
		
		String astSuffix = EMPTY_STRING;
		if (imageElements[LABEL_ELEMENT].equals("path-dirfile")){
			addToAST("path(");
			astSuffix = ")";
		}
		
		int imageElementCount = imageElements.length;
		String formalsSet = EMPTY_STRING;
		for (int index = START_OF_DATA; index < imageElementCount; index++){
			if (1 < index) {
				formalsSet += ", ";
			}
			
			boolean hasDirName = FILENAME_ONLY < imageElementCount;
			if (hasDirName){
				imageElements[DIR_NAME] = imageElements[DIR_NAME].substring(0, imageElements[DIR_NAME].length()-1);
			}
			
			formalsSet += addQuotes(imageElements[index]);
		}
		
		addToAST( formalsSet + astSuffix );
		return data;
	}
}