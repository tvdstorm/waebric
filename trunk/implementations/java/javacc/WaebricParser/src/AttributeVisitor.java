public class AttributeVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTAttribute node, Object data){
		ast += "";
		
		// Make a choice between kinds of statements
		String[] dataFromStatement = node.image.split(":");
		
		if(	dataFromStatement[0].equals("id") ||
			dataFromStatement[0].equals("class") ||
			dataFromStatement[0].equals("name") ||
			dataFromStatement[0].equals("type")) {
				ast += dataFromStatement[0] + "(\"" + dataFromStatement[1] + "\")";
		}
		
		else if(dataFromStatement[0].equals("width-height") ||
				dataFromStatement[0].equals("height")){
			ast += dataFromStatement[0] + "(" + dataFromStatement[1] + ")";
		}
		
		else {
			ast += node.image;
		}

		return data;
	}
}