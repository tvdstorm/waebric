public class ModuleIdVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTModuleId node, Object data){	
		addToAST( "module-id([" );
		
		addToAST( node.image );
	  	
	  	addToAST( "])" );
		return data;
	}
}