public class MappingsVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTMappings node, Object data){
		int numChildren = node.jjtGetNumChildren();
		
		addToAST( "[" );
		
	  	for ( int currentChild = 0; currentChild < numChildren; currentChild++ ) {
	  		if (node.jjtGetChild(currentChild).toString().equals("Mapping")){
	  			MappingVisitor mappingVisitor = new MappingVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(mappingVisitor, null);
	  			addToAST( mappingVisitor.getAST() );
	  		}
	    }
	  	
	  	addToAST( "]" );
	  	
		return data;
	}
}