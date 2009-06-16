public class StatementVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTStatement node, Object data){
		
		// Make a choice between kinds of statements
		String[] dataFromStatement = node.image.split(":");
		
		if(	dataFromStatement[0].equals("yield")){
			addToAST( dataFromStatement[0] );
		}
		
		else if(dataFromStatement[0].equals("comment")){
			addToAST( dataFromStatement[0] + "(" + dataFromStatement[1] + ")" );
		}
		
		else if(dataFromStatement[0].equals("markup")){
			addToAST( dataFromStatement[0] + "(" );
  			MarkupVisitor markupVisitor = new MarkupVisitor();
  			node.jjtGetChild(0).jjtAccept(markupVisitor, null);
  			addToAST( markupVisitor.getAST() );
			addToAST( ")" );
		}
		
		else if(dataFromStatement[0].equals("markup-exp")){
			addToAST( dataFromStatement[0] + "([" );
			processChildrenMarkup(node);
			addToAST( ")" );
		}
		
		else if(dataFromStatement[0].equals("markup-stat")){
			addToAST( dataFromStatement[0] + "([" );
			processChildrenMarkup(node);
			addToAST( ")" );
		}
		
		else if(dataFromStatement[0].equals("markup-markup")){
			addToAST( dataFromStatement[0] + "([" );
			processChildrenMarkup(node);
			addToAST( ")" );
		}
		
		else if(dataFromStatement[0].equals("markup-embedding")){
			addToAST( dataFromStatement[0] + "([" );
			processChildrenMarkup(node);
			addToAST( ")" );
		}
		
		else if(dataFromStatement[0].equals("block")){
			addToAST( dataFromStatement[0] + "([" );
			processChildrenBlock(node);
			addToAST( "])" );
		}
		
		else if(dataFromStatement[0].equals("if-else") || dataFromStatement[0].equals("if")) {
			addToAST( dataFromStatement[0] + "(" );
			processChildrenIfElse(node);
			addToAST( ")" );
		}
		
		else if(dataFromStatement[0].equals("each")) {
			addToAST( dataFromStatement[0] + "(" );
			processChildrenEach(node);
			addToAST( ")" );
		}
		
		else if(dataFromStatement[0].equals("echo")) {
			addToAST( dataFromStatement[0] + "(" );
			processChildrenEcho(node);
			addToAST( ")" );
		}
		
		else if(dataFromStatement[0].equals("let")) {
			addToAST( dataFromStatement[0] + "(" );
			processChildrenLet(node);
			addToAST( ")" );
		}
		else if(dataFromStatement[0].equals("cdata")) {
			addToAST( dataFromStatement[0] + "(" );
			processChildrenCdata(node);
			addToAST( ")" );
		}
		
		return data;
	}
	
	private void processChildrenMarkup(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) {
			if(node.jjtGetChild(currentChild).toString().equals("Markup")){
		  		MarkupVisitor markupVisitor = new MarkupVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(markupVisitor, null);
		  		
		  		if((currentChild == numberOfChildren-1)&(currentChild != 0)) {
		  			addToAST( "], " + markupVisitor.getAST() );
		  		} 
		  		else{
		  			
		  			if (currentChild > 0){
		  				addToAST( ", " );
		  			}
		  			
		  			addToAST( markupVisitor.getAST() );
		  		}
			}
			
			// Last 
			else if(node.jjtGetChild(currentChild).toString().equals("Statement")){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		addToAST( "], " + statementVisitor.getAST() );
			}
			else if(node.jjtGetChild(currentChild).toString().equals("Embedding")){
				EmbeddingVisitor embeddingVisitor = new EmbeddingVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(embeddingVisitor, null);
		  		addToAST( "], " + embeddingVisitor.getAST() );
			}
			else if(node.jjtGetChild(currentChild).toString().equals("Expression")){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
		  		addToAST( "], " +  expressionVisitor.getAST() );
			}
		}
	}
	
	private void processChildrenBlock(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) { 
			
			if (currentChild > 0){
				addToAST( ", " );
			}
			
			if(node.jjtGetChild(currentChild).toString().equals("Statement")){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		addToAST( statementVisitor.getAST() );
			}
		}
	}
	
	private void processChildrenIfElse(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) { 
			
			if (currentChild > 0){
				addToAST( ", " );
			}
			
			if(node.jjtGetChild(currentChild).toString().equals("Statement")){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		addToAST( statementVisitor.getAST() );
			}
			
			else if(node.jjtGetChild(currentChild).toString().equals("Predicate")){
				PredicateVisitor predicateVisitor = new PredicateVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(predicateVisitor, null);
		  		addToAST( predicateVisitor.getAST() );
			}
		}
	}
	
	private void processChildrenEach(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) { 
			
			if (currentChild > 0){
				addToAST( ", " );
			}
			
			if(node.jjtGetChild(currentChild).toString().equals("Statement")){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		addToAST( statementVisitor.getAST() );
			}
			
			else if(node.jjtGetChild(currentChild).toString().equals("Expression")){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
		  		addToAST( expressionVisitor.getAST() );
			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("DotIdCon")){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				addToAST( dotIdConVisitor.getAST() );
  			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("Var")){
				VarVisitor varVisitor = new VarVisitor();
				node.jjtGetChild(0).jjtAccept(varVisitor, null);
				addToAST( varVisitor.getAST() );
			}
		}
	}
	
	private void processChildrenEcho(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) { 
			
			if (currentChild > 0){
				addToAST( ", " );
			}
			
			if(node.jjtGetChild(currentChild).toString().equals("Expression")){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
		  		addToAST( expressionVisitor.getAST() );
			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("DotIdCon")){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				addToAST( dotIdConVisitor.getAST() );
  			}
			
			else if(node.jjtGetChild(currentChild).toString().equals("Embedding")){
				EmbeddingVisitor embeddingVisitor = new EmbeddingVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(embeddingVisitor, null);
		  		addToAST( embeddingVisitor.getAST() );
			}
		}
	}
	
	private void processChildrenLet(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) { 
			
			if (currentChild > 0){
				addToAST( ", " );
			}
			
			if(node.jjtGetChild(currentChild).toString().equals("Statement")){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		addToAST( "[" );
		  		addToAST( statementVisitor.getAST() );
		  		addToAST( "]" );
			}
			
			else if(node.jjtGetChild(currentChild).toString().equals("Assignment")){
				AssignmentVisitor assignmentVisitor = new AssignmentVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(assignmentVisitor, null);
		  		addToAST( assignmentVisitor.getAST() );
			}
		}
	}
	
	private void processChildrenCdata(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) { 
			
			if (currentChild > 0){
				addToAST( ", " );
			}
			
			if(node.jjtGetChild(currentChild).toString().equals("Expression")){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
		  		addToAST( expressionVisitor.getAST() );
			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("DotIdCon")){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				addToAST( dotIdConVisitor.getAST() );
  			}
		}
	}
}