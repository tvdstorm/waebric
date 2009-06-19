public class MappingsVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTMappings node, Object data){
		addToAST( "[" );

		int numChildren = node.jjtGetNumChildren();
	  	for ( int currentChild = FIRST_CHILD; currentChild < numChildren; currentChild++ ) {
	  		if (node.jjtGetChild(currentChild).toString().equals(NODE_MAPPING)){
	  			MappingVisitor mappingVisitor = new MappingVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(mappingVisitor, null);
	  			addToAST( mappingVisitor.getAST() );
	  		}
	    }
	  	
	  	addToAST( "]" );
	  	
		return data;
	}
}