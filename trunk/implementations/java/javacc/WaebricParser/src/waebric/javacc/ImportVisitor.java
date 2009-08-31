package waebric.javacc;
public class ImportVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTImport node, Object data){
		addToAST( "import(" );

		int numChildren = node.jjtGetNumChildren();
	  	for ( int currentChild = FIRST_CHILD; currentChild < numChildren; currentChild++ ) {
	  		if (node.jjtGetChild(currentChild).toString().equals(NODE_MODULEID) ){
	  			ModuleIdVisitor moduleidVisitor = new ModuleIdVisitor();
	  			node.jjtAccept(moduleidVisitor, null);
	  			addToAST( moduleidVisitor.getAST() );
	  		}
	    }
	  	
	  	addToAST( ")" );
		return data;
	}
}