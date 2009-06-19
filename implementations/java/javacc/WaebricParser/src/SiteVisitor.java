public class SiteVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTSite node, Object data){		
		addToAST( "site(" );

		int numChildren = node.jjtGetNumChildren();
	  	for ( int currentChild = FIRST_CHILD; currentChild < numChildren; currentChild++ ) {
	  		if ( node.jjtGetChild(currentChild).toString().equals(NODE_MAPPINGS) ){
	  			MappingsVisitor mappingsVisitor = new MappingsVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(mappingsVisitor, null);
	  			addToAST( mappingsVisitor.getAST() );
	  		}
	    }
	  	
	  	addToAST( ")" );
	  	
		return data;
	}
}