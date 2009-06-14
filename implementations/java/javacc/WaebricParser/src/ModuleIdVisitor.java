public class ModuleIdVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTModuleId node, Object data){	
		ast += "module-id([";
		
		ast += node.image;
	  	
	  	ast += "])";
		return data;
	}
}