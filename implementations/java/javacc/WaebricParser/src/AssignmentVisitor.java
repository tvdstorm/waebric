public class AssignmentVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTAssignment node, Object data){
		addToAST( "[" );
		
		// Make a choice between kinds of statements
		String[] dataFromStatement = node.image.split(":");
		
		if(	dataFromStatement[0].equals("func-bind")){
			addToAST( dataFromStatement[0] + "([" + dataFromStatement[1] );
			StatementVisitor statementVisitor = new StatementVisitor();
	  		node.jjtGetChild(0).jjtAccept(statementVisitor, null);
	  		addToAST( statementVisitor.getAST() );
			addToAST( "])" );
		}
		
		else if(dataFromStatement[0].equals("var-bind")){
			addToAST( dataFromStatement[0] + "(\"" + dataFromStatement[1] + "\"" );
			processChildren(node);
			addToAST( ")" );
		}
		
		addToAST( "]" );
		return data;
	}
	
	private void processChildren(ASTAssignment node){
		int numberOfChildren = node.jjtGetNumChildren();
			
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) { 
			
			if(node.jjtGetChild(currentChild).toString().equals("Formals")){
				FormalsVisitor formalsVisitor = new FormalsVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(formalsVisitor, null);
		  		addToAST( ", " + formalsVisitor.getAST() );
			}
				
			else if(node.jjtGetChild(currentChild).toString().equals("Expression")){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
				node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
				addToAST( ", " + expressionVisitor.getAST() );
			}
			
		}
	}
}