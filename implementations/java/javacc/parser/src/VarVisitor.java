public class VarVisitor extends WaebricParserVisitorAdapter {	
	public Object visit(ASTVar node, Object data){	
		ast += "var(\"";
		
		ast += node.image;		
	  	
	  	ast += "\")";
		return data;
	}
}