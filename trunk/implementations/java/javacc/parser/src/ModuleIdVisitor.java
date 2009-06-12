public class ModuleIdVisitor extends WaebricParserVisitorAdapter {
	private String ast = "";
	
	public Object visit(ASTModuleId node, Object data){	
		ast += "module-id([";
		
		ast += node.image;
	  	
	  	ast += "])";
		return data;
	}
	
	public String getAST(){
		return ast;
	}
}