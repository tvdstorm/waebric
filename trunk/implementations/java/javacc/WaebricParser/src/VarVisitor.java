public class VarVisitor extends WaebricParserVisitorAdapter {	
	public Object visit(ASTVar node, Object data){	
		addToAST( "var(\"" );
		
		addToAST( node.image );		
	  	
	  	addToAST( "\")" );
		return data;
	}
}