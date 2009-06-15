public class StatementVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTStatement node, Object data){
		
		// Make a choice between kinds of statements
		String[] dataFromStatement = node.image.split(":");
		
		if(	dataFromStatement[0].equals("yield")){
			ast += dataFromStatement[0];
		}
		
		else if(dataFromStatement[0].equals("comment")){
			ast += dataFromStatement[0] + "(" + dataFromStatement[1] + ")";
		}
		
		else if(dataFromStatement[0].equals("markup")){
			ast += dataFromStatement[0] + "(";
  			MarkupVisitor markupVisitor = new MarkupVisitor();
  			node.jjtGetChild(0).jjtAccept(markupVisitor, null);
  			ast += markupVisitor.getAST();
			ast += ")";
		}
		
		else if(dataFromStatement[0].equals("markup-exp")){
			ast += dataFromStatement[0] + "([";
			processChildrenMarkup(node);
			ast += ")";
		}
		
		else if(dataFromStatement[0].equals("markup-stat")){
			ast += dataFromStatement[0] + "([";
			processChildrenMarkup(node);
			ast += ")";
		}
		
		else if(dataFromStatement[0].equals("markup-markup")){
			ast += dataFromStatement[0] + "([";
			processChildrenMarkup(node);
			ast += ")";
		}
		
		else if(dataFromStatement[0].equals("markup-embedding")){
			ast += dataFromStatement[0] + "([";
			processChildrenMarkup(node);
			ast += ")";
		}
		
		else if(dataFromStatement[0].equals("block")){
			ast += dataFromStatement[0] + "([";
			processChildrenBlock(node);
			ast += "])";
		}
		
		else if(dataFromStatement[0].equals("if-else") || dataFromStatement[0].equals("if")) {
			ast += dataFromStatement[0] + "(";
			processChildrenIfElse(node);
			ast += ")";
		}
		
		else if(dataFromStatement[0].equals("each")) {
			ast += dataFromStatement[0] + "(";
			processChildrenEach(node);
			ast += ")";
		}
		
		else if(dataFromStatement[0].equals("echo")) {
			ast += dataFromStatement[0] + "(";
			processChildrenEcho(node);
			ast += ")";
		}
		
		else if(dataFromStatement[0].equals("let")) {
			ast += dataFromStatement[0] + "(";
			processChildrenLet(node);
			ast += ")";
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
		  			ast += "], " + markupVisitor.getAST();
		  		} 
		  		else{
		  			
		  			if (currentChild > 0){
		  				ast += ", ";
		  			}
		  			
		  			ast += markupVisitor.getAST();
		  		}
			}
			
			// Last 
			else if(node.jjtGetChild(currentChild).toString().equals("Statement")){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		ast += "], " + statementVisitor.getAST();
			}
			else if(node.jjtGetChild(currentChild).toString().equals("Embedding")){
				EmbeddingVisitor embeddingVisitor = new EmbeddingVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(embeddingVisitor, null);
		  		ast += "], " + embeddingVisitor.getAST();
			}
			else if(node.jjtGetChild(currentChild).toString().equals("Expression")){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
		  		ast += "], " +  expressionVisitor.getAST();
			}
		}
	}
	
	private void processChildrenBlock(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) { 
			
			if (currentChild > 0){
				ast += ", ";
			}
			
			if(node.jjtGetChild(currentChild).toString().equals("Statement")){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		ast += statementVisitor.getAST();
			}
		}
	}
	
	private void processChildrenIfElse(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) { 
			
			if (currentChild > 0){
				ast += ", ";
			}
			
			if(node.jjtGetChild(currentChild).toString().equals("Statement")){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		ast += statementVisitor.getAST();
			}
			
			else if(node.jjtGetChild(currentChild).toString().equals("Predicate")){
				PredicateVisitor predicateVisitor = new PredicateVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(predicateVisitor, null);
		  		ast += predicateVisitor.getAST();
			}
		}
	}
	
	private void processChildrenEach(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) { 
			
			if (currentChild > 0){
				ast += ", ";
			}
			
			if(node.jjtGetChild(currentChild).toString().equals("Statement")){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		ast += statementVisitor.getAST();
			}
			
			else if(node.jjtGetChild(currentChild).toString().equals("Expression")){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
		  		ast += expressionVisitor.getAST();
			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("DotIdCon")){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				ast += dotIdConVisitor.getAST();
  			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("Var")){
				VarVisitor varVisitor = new VarVisitor();
				node.jjtGetChild(0).jjtAccept(varVisitor, null);
				ast += varVisitor.getAST();
			}
		}
	}
	
	private void processChildrenEcho(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) { 
			
			if (currentChild > 0){
				ast += ", ";
			}
			
			if(node.jjtGetChild(currentChild).toString().equals("Expression")){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
		  		ast += expressionVisitor.getAST();
			}
			
			else if (node.jjtGetChild(currentChild).toString().equals("DotIdCon")){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				ast += dotIdConVisitor.getAST();
  			}
			
			else if(node.jjtGetChild(currentChild).toString().equals("Embedding")){
				EmbeddingVisitor embeddingVisitor = new EmbeddingVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(embeddingVisitor, null);
		  		ast += embeddingVisitor.getAST();
			}
		}
	}
	
	private void processChildrenLet(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) { 
			
			if (currentChild > 0){
				ast += ", ";
			}
			
			if(node.jjtGetChild(currentChild).toString().equals("Statement")){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		ast += statementVisitor.getAST();
			}
			
			else if(node.jjtGetChild(currentChild).toString().equals("Assignment")){
				AssignmentVisitor assignmentVisitor = new AssignmentVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(assignmentVisitor, null);
		  		ast += assignmentVisitor.getAST();
			}
		}
	}
}