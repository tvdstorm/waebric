public class PathVisitor extends WaebricParserVisitorAdapter {
	private String ast = "";
	
	public Object visit(ASTPath node, Object data){		
		ast += "";
		
		ast += node.image;
	  	
	  	ast += "";
		return data;
	}
	
	public String getAST(){
		return ast;
	}
}