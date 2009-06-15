public class AssignmentVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTAssignment node, Object data){
		ast += "[";
		
		// Make a choice between kinds of statements
		String[] dataFromStatement = node.image.split(":");
		
		if(	dataFromStatement[0].equals("func-bind")){
			ast += dataFromStatement[0] + "([" + dataFromStatement[1];
			StatementVisitor statementVisitor = new StatementVisitor();
	  		node.jjtGetChild(0).jjtAccept(statementVisitor, null);
	  		ast += statementVisitor.getAST();
			ast += "])";
		}
		
		else if(dataFromStatement[0].equals("var-bind")){
			ast += dataFromStatement[0] + "(\"" + dataFromStatement[1] + "\"";
			processChildren(node);
			ast += ")";
		}
		
		ast += "]";
		return data;
	}
	
	private void processChildren(ASTAssignment node){
		int numberOfChildren = node.jjtGetNumChildren();
			
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) { 
			
			if(node.jjtGetChild(currentChild).toString().equals("Formals")){
				FormalsVisitor formalsVisitor = new FormalsVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(formalsVisitor, null);
		  		ast += ", " + formalsVisitor.getAST();
			}
				
			else if(node.jjtGetChild(currentChild).toString().equals("Expression")){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
				node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
				ast +=  ", " + expressionVisitor.getAST();
			}
			
		}
	}
}