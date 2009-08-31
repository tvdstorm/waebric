package waebric.javacc;
public class FunctionDefVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTFunctionDef node, Object data){
		addToAST( "def(" + addQuotes(node.image) + ", " );
	  	
	  	if (node.jjtGetChild(0).toString().equals(NODE_FORMALS)){
	  		FormalsVisitor formalsVisitor = new FormalsVisitor();
  			node.jjtGetChild(0).jjtAccept(formalsVisitor, null);
  			addToAST( "formals(" );
  			addToAST( formalsVisitor.getAST() + ", " );
  			addToAST( ")" );
	  	} else {
	  		addToAST( "empty, " );
	  	}
	  	
	  	// Iterate through statements
		int numChildren = node.jjtGetNumChildren();
	  	for ( int currentChild = FIRST_CHILD; currentChild < numChildren; currentChild++ ) {
	  		if (1 < currentChild){
  				addToAST( ", " );
  			} 
	  		else if ( ( node.jjtGetChild(FIRST_CHILD).toString().equals(NODE_STATEMENT) ) &
	  			(FIRST_CHILD < currentChild) ){
  				addToAST( ", " );
  			}
	  		
	  		if ( node.jjtGetChild(currentChild).toString().equals(NODE_STATEMENT) ){
	  			StatementVisitor statementVisitor = new StatementVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
	  			addToAST( "[" );
	  			addToAST( statementVisitor.getAST() );
	  			addToAST( "]" );
	  		}
	    }
	  	
	  	addToAST( ")" );
		return data;
	}
}