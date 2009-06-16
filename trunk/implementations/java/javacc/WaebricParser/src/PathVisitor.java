public class PathVisitor extends WaebricParserVisitorAdapter {	
	public Object visit(ASTPath node, Object data){		
		addToAST( node.image );
		return data;
	}
}