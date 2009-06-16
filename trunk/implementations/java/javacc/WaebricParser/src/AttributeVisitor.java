public class AttributeVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTAttribute node, Object data){
		
		// Make a choice between kinds
		String[] dataFromStatement = node.image.split(":");
		
		if(	dataFromStatement[0].equals("id") ||
			dataFromStatement[0].equals("class") ||
			dataFromStatement[0].equals("name") ||
			dataFromStatement[0].equals("type")) {
				addToAST( dataFromStatement[0] + "(\"" + dataFromStatement[1] + "\")" );
		}
		
		else if(dataFromStatement[0].equals("width-height") ||
				dataFromStatement[0].equals("height")){
			addToAST( dataFromStatement[0] + "(" + dataFromStatement[1] + ")" );
		}

		return data;
	}
}