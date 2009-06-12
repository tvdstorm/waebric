public class AttributeVisitor extends WaebricParserVisitorAdapter {
	private String ast = "";
	
	public Object visit(ASTAttribute node, Object data){
		ast += "";
		
		ast += node.image;
	  	
	  	ast += "";
		return data;
	}
	
	public String getAST(){
		return ast;
	}
}