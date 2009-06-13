public class PathVisitor extends WaebricParserVisitorAdapter {	
	public Object visit(ASTPath node, Object data){		
		ast += "";
		
		ast += node.image;
	  	
	  	ast += "";
		return data;
	}
}