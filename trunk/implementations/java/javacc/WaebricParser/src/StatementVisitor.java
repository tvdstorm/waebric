/**
 * class StatementVisitor
 * 
 * This class is the largest and most used class 
 * This class contains a list of methods which are containing a lot of repeated code
 * It is possible to use just one process method, but we decided to separate the concerns.
 * If there is a problem it is much easier to check if the problem occurs within the method or
 * within a level deeper. 
*/

public class StatementVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTStatement node, Object data){
		
		// Make a choice between kinds of statements
		String[] dataFromJJT = node.image.split(":");
		
		// Every type needs a different approach
		if(	dataFromJJT[0].equals("yield")){
			addToAST( dataFromJJT[0] );
		}
		
		else if(dataFromJJT[0].equals("comment")){
			addToAST( dataFromJJT[0] + "(" + safeGetStr(dataFromJJT, 1) + ")" );
		}
		
		else if(dataFromJJT[0].equals("markup")){
			addToAST( dataFromJJT[0] + "(" );
  			MarkupVisitor markupVisitor = new MarkupVisitor();
  			node.jjtGetChild(0).jjtAccept(markupVisitor, null);
  			addToAST( markupVisitor.getAST() );
			addToAST( ")" );
		}
		
		else if(dataFromJJT[0].equals("markup-exp")){
			addToAST( dataFromJJT[0] + "([" );
			processChildrenMarkup(node);
			addToAST( ")" );
		}
		
		else if(dataFromJJT[0].equals("markup-stat")){
			addToAST( dataFromJJT[0] + "([" );
			processChildrenMarkup(node);
			addToAST( ")" );
		}
		
		else if(dataFromJJT[0].equals("markup-markup")){
			addToAST( dataFromJJT[0] + "([" );
			processChildrenMarkup(node);
			addToAST( ")" );
		}
		
		else if(dataFromJJT[0].equals("markup-embedding")){
			addToAST( dataFromJJT[0] + "([" );
			processChildrenMarkup(node);
			addToAST( ")" );
		}
		
		else if(dataFromJJT[0].equals("block")){
			addToAST( dataFromJJT[0] + "([" );
			processChildrenBlock(node);
			addToAST( "])" );
		}
		
		else if(dataFromJJT[0].equals("if-else") || dataFromJJT[0].equals("if")) {
			addToAST( dataFromJJT[0] + "(" );
			processChildrenIfElse(node);
			addToAST( ")" );
		}
		
		else if(dataFromJJT[0].equals("each")) {
			addToAST( dataFromJJT[0] + "(" );
			processChildrenEach(node);
			addToAST( ")" );
		}
		
		else if(dataFromJJT[0].equals("echo")) {
			addToAST( dataFromJJT[0] + "(" );
			processChildrenEcho(node);
			addToAST( ")" );
		}
		
		else if(dataFromJJT[0].equals("let")) {
			addToAST( dataFromJJT[0] + "(" );
			processChildrenLet(node);
			addToAST( ")" );
		}
		else if(dataFromJJT[0].equals("cdata")) {
			addToAST( dataFromJJT[0] + "(" );
			processChildrenCdata(node);
			addToAST( ")" );
		}
		
		return data;
	}

	/**
	 * This method is used when a node type is "Markup"
	 * @param node: the node to process
	 */
	private void processChildrenMarkup(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		// Loop trough the childnodes
		for ( int currentChild = 0; currentChild < numberOfChildren; currentChild++ ) {
			if(node.jjtGetChild(currentChild).toString().equals("Markup")){
		  		MarkupVisitor markupVisitor = new MarkupVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(markupVisitor, null);
		  		
		  		// If this is the last node, the previous node must be closed with a "]"
				if((currentChild == numberOfChildren-1)&(currentChild != 0)) {
		  			addToAST( "], " + markupVisitor.getAST() );
		  		} 
		  		else{
		  			// Every not first node mest use a comma to serperate itselfs rom previous nodes
		  			if (currentChild > 0){
		  				addToAST( ", " );
		  			}
		  			addToAST( markupVisitor.getAST() );
		  		}
			}
			
			else if(node.jjtGetChild(currentChild).toString().equals("Statement")){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		if((currentChild == numberOfChildren-1)&(currentChild != 0)) {
		  			addToAST( "], " + statementVisitor.getAST() );
		  		}
		  		else{
		  			if (currentChild > 0){
		  				addToAST( ", " );
		  			}
		  			addToAST( statementVisitor.getAST() );
		  		}
			}
			
			else if(node.jjtGetChild(currentChild).toString().equals("Embedding")){
				EmbeddingVisitor embeddingVisitor = new EmbeddingVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(embeddingVisitor, null);
		  		if((currentChild == numberOfChildren-1)&(currentChild != 0)) {
		  			addToAST( "], " + embeddingVisitor.getAST() );
		  		}
		  		else{
		  			if (currentChild > 0){
		  				addToAST( ", " );
		  			}
		  			addToAST( embeddingVisitor.getAST() );
		  		}
			}
			
			else if(node.jjtGetChild(currentChild).toString().equals("Expression")){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
		  		if((currentChild == numberOfChildren-1)&(currentChild != 0)) {
		  			addToAST( "], " +  expressionVisitor.getAST() );
		  		}
		  		else{
		  			if (currentChild > 0){
		  				addToAST( ", " );
		  			}
		  			addToAST( expressionVisitor.getAST() );
		  		}
			}
		}
	}
	
	/**
	* This method is used when a node type is "Block"
	* @param node: the node to process
	*/
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

	/**
	* This method is used when a node type is if or if-else "Block"
	* @param node: the node to process
	*/
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

	/**
	* This method is used when a node type is "Each"
	* @param node: the node to process
	*/
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

	/**
	* This method is used when a node type is "Echo"
	* @param node: the node to process
	*/
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

	/**
	* This method is used when a node type is "Let"
	* @param node: the node to process
	*/
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

	/**
	* This method is used when a node type is Cdata
	* @param node: the node to process
	*/
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