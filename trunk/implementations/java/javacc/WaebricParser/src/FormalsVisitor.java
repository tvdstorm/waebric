public class FormalsVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTFormals node, Object data){
		addToAST( "formals([" );
		
		addToAST( node.image );

	  	addToAST( "])" );
		return data;
	}
}