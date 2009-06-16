public class AttributeVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTAttribute node, Object data){
		
		// Make a choice between kinds
		String[] dataFromJJT = node.image.split(":");
		
		if(	dataFromJJT[0].equals("id") ||
			dataFromJJT[0].equals("class") ||
			dataFromJJT[0].equals("name") ||
			dataFromJJT[0].equals("type")) {
				addToAST( dataFromJJT[0] + "(\"" +  safeGetStr(dataFromJJT, 1) + "\")" );
		}
		
		else if(dataFromJJT[0].equals("width-height") ||
				dataFromJJT[0].equals("height")){
			addToAST( dataFromJJT[0] + "(" + safeGetStr(dataFromJJT, 1) + ")" );
		}

		return data;
	}
}