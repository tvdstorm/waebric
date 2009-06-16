public class DotIdConVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTDotIdCon node, Object data){	
		addToAST( "\"" + node.image + "\"" );
		return data;
	}
}