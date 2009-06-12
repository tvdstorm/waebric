public class VarVisitor extends WaebricParserVisitorAdapter {
	private String ast = "";
	
	public Object visit(ASTVar node, Object data){	
		ast += "var(\"";
		
		ast += node.image;		
	  	
	  	ast += "\")";
		return data;
	}
	
	public String getAST(){
		return ast;
	}
}