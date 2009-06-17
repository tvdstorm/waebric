public class PathVisitor extends WaebricParserVisitorAdapter {	
	public Object visit(ASTPath node, Object data){		
		String[] imageElements = node.image.split(":");
		
		String astSuffix = "";
		if (imageElements[0].equals("path-dirfile")){
			addToAST("path(");
			astSuffix = ")";
		}
		
		int imageElementCount = imageElements.length;
		String formalsSet = "";
		for (int imageElementIndex = 1; imageElementIndex < imageElementCount; imageElementIndex++){
			if (imageElementIndex > 1) {
				formalsSet += ", ";
			}
			
			formalsSet += "\"" + imageElements[imageElementIndex] + "\"";
		}
		
		addToAST( formalsSet + astSuffix );
		return data;
	}
}