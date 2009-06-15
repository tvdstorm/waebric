public class PathVisitor extends WaebricParserVisitorAdapter {	
	public Object visit(ASTPath node, Object data){		
		// eind node bevat logica in de jjt
		ast += node.image;
		return data;
	}
}