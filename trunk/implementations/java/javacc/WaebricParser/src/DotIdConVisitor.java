public class DotIdConVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTDotIdCon node, Object data){	
		ast += "\"" + node.image + "\"";
		return data;
	}
}