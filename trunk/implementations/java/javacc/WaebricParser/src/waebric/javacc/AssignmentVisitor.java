package waebric.javacc;
public class AssignmentVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	private static final int LABEL_ELEMENT = 0;
	private static final int FIRST_DATA_ELEMENT = 1;
	
	private static final String CHOICE_FUNC_BIND = "func-bind";
	private static final String CHOICE_VAR_BIND = "var-bind";
	
	public Object visit(ASTAssignment node, Object data){
		addToAST( "[" );
		
		// Make a choice between kinds of statements
		String[] dataFromJJT = node.image.split(SPLIT_SEPARATOR);
		
		if(	dataFromJJT[LABEL_ELEMENT].equals(CHOICE_FUNC_BIND)){
			addToAST( dataFromJJT[LABEL_ELEMENT] + "(" + addQuotes(safeGetStr(dataFromJJT, FIRST_DATA_ELEMENT)));
			processChildren(node);
			addToAST( ")" );
		}
		
		else if(dataFromJJT[LABEL_ELEMENT].equals(CHOICE_VAR_BIND)){
			addToAST( dataFromJJT[LABEL_ELEMENT] + "(" + addQuotes(safeGetStr(dataFromJJT, FIRST_DATA_ELEMENT)));
			processChildren(node);
			addToAST( ")" );
		}
		
		addToAST( "]" );
		return data;
	}
	
	private void processChildren(ASTAssignment node){
		int numberOfChildren = node.jjtGetNumChildren();
			
		for ( int currentChild = FIRST_CHILD; currentChild < numberOfChildren; currentChild++ ) { 
			
			if(node.jjtGetChild(currentChild).toString().equals(NODE_FORMALS)){
				FormalsVisitor formalsVisitor = new FormalsVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(formalsVisitor, null);
		  		addToAST( ", " + formalsVisitor.getAST() );
			}
				
			else if(node.jjtGetChild(currentChild).toString().equals(NODE_EXPRESSION)){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
				node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
				addToAST( ", " + expressionVisitor.getAST() );
			}
			
			if(node.jjtGetChild(currentChild).toString().equals(NODE_STATEMENT)){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		addToAST( ", " + statementVisitor.getAST() );
			}
			
		}
	}
}