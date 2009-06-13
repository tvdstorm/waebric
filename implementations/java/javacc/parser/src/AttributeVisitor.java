public class AttributeVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTAttribute node, Object data){
		ast += "";
		
		ast += node.image;
	  	
	  	ast += "";
		return data;
	}
}