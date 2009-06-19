public class DotIdConVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTDotIdCon node, Object data){	
		addToAST( addQuotes( node.image ) );
		return data;
	}
}