public class VarVisitor extends WaebricParserVisitorAdapter {	
	public Object visit(ASTVar node, Object data){	
		addToAST( "var(" );
		addToAST( addQuotes( node.image ) );		
	  	addToAST( ")" );
	  	
		return data;
	}
}