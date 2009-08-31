package waebric.javacc;
/**
 * class StatementVisitor
 * 
 * Statement() is the largest and most complex syntactical specification.
 * The final result is a class with quite a bit of repeated code.
 * We choose to do so because not all of the visitors act the same in every possible
 * choice. Thats why we decided to separate the concerns.
 * 
 * We found that it is much easier to make changes this way.
*/

public class StatementVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	private static final int LABEL_ELEMENT = 0;
	
	private static final String CHOICE_YIELD = "yield";
	private static final String CHOICE_COMMENT = "comment";
	private static final String CHOICE_MARKUP = "markup";
	private static final String CHOICE_MARKUP_EXP = "markup-exp";
	private static final String CHOICE_MARKUP_STAT = "markup-stat";
	private static final String CHOICE_MARKUP_MARKUP = "markup-markup";
	private static final String CHOICE_MARKUP_EMBEDDING = "markup-embedding";
	private static final String CHOICE_BLOCK = "block";
	private static final String CHOICE_IF_ELSE = "if-else";
	private static final String CHOICE_IF = "if";
	private static final String CHOICE_EACH = "each";
	private static final String CHOICE_ECHO = "echo";
	private static final String CHOICE_LET = "let";
	private static final String CHOICE_CDATA = "cdata";
	
	public Object visit(ASTStatement node, Object data){
		
		// Get the label so we can determine which choice we have to make.
		String[] dataFromJJT = node.image.split(SPLIT_SEPARATOR);
		
		/* BEGIN List of possible choices
		 ******************************************************
		 */
		if(	dataFromJJT[LABEL_ELEMENT].equals(CHOICE_YIELD) ){
			addToAST( dataFromJJT[LABEL_ELEMENT] );
		}
		
		else if( dataFromJJT[LABEL_ELEMENT].equals(CHOICE_COMMENT) ){
			addToAST( dataFromJJT[LABEL_ELEMENT] + "(" + safeGetStr(dataFromJJT, 1) + ")" );
		}
		
		else if( dataFromJJT[LABEL_ELEMENT].equals(CHOICE_MARKUP) ){
			addToAST( dataFromJJT[LABEL_ELEMENT] + "(" );
  			MarkupVisitor markupVisitor = new MarkupVisitor();
  			node.jjtGetChild(FIRST_CHILD).jjtAccept(markupVisitor, null);
  			addToAST( markupVisitor.getAST() );
			addToAST( ")" );
		}
		
		else if( dataFromJJT[LABEL_ELEMENT].equals(CHOICE_MARKUP_EXP) ){
			addToAST( dataFromJJT[LABEL_ELEMENT] + "([" );
			processChildrenMarkup( node );
			addToAST( ")" );
		}
		
		else if( dataFromJJT[LABEL_ELEMENT].equals(CHOICE_MARKUP_STAT) ){
			addToAST( dataFromJJT[LABEL_ELEMENT] + "([" );
			processChildrenMarkup( node );
			addToAST( ")" );
		}
		
		else if( dataFromJJT[LABEL_ELEMENT].equals(CHOICE_MARKUP_MARKUP) ){
			addToAST( dataFromJJT[LABEL_ELEMENT] + "([" );
			processChildrenMarkup( node );
			addToAST( ")" );
		}
		
		else if( dataFromJJT[LABEL_ELEMENT].equals(CHOICE_MARKUP_EMBEDDING )){
			addToAST( dataFromJJT[LABEL_ELEMENT] + "([" );
			processChildrenMarkup( node );
			addToAST( ")" );
		}
		
		else if( dataFromJJT[LABEL_ELEMENT].equals(CHOICE_BLOCK) ){
			addToAST( dataFromJJT[LABEL_ELEMENT] + "([" );
			processChildrenBlock( node );
			addToAST( "])" );
		}
		
		else if( dataFromJJT[LABEL_ELEMENT].equals(CHOICE_IF_ELSE) 
				|| dataFromJJT[LABEL_ELEMENT].equals(CHOICE_IF) ) {
			addToAST( dataFromJJT[LABEL_ELEMENT] + "(" );
			processChildrenIfElse( node );
			addToAST( ")" );
		}
		
		else if( dataFromJJT[LABEL_ELEMENT].equals(CHOICE_EACH) ) {
			addToAST( dataFromJJT[LABEL_ELEMENT] + "(" );
			processChildrenEach( node );
			addToAST( ")" );
		}
		
		else if( dataFromJJT[LABEL_ELEMENT].equals(CHOICE_ECHO) ) {
			addToAST( dataFromJJT[LABEL_ELEMENT] + "(" );
			processChildrenEcho( node );
			addToAST( ")" );
		}
		
		else if( dataFromJJT[LABEL_ELEMENT].equals(CHOICE_LET) ) {
			addToAST( dataFromJJT[LABEL_ELEMENT] + "(" );
			processChildrenLet( node );
			addToAST( ")" );
		}
		else if( dataFromJJT[LABEL_ELEMENT].equals(CHOICE_CDATA) ) {
			addToAST( dataFromJJT[LABEL_ELEMENT] + "(" );
			processChildrenCdata( node );
			addToAST( ")" );
		}
		/* END List of possible choices
		 ******************************************************
		 */
		
		return data;
	}

	/**
	 * This method is used for choices:
	 * CHOICE_MARKUP_EXP, CHOICE_MARKUP_STAT, CHOICE_MARKUP_MARKUP, CHOICE_MARKUP_EMBEDDING
	 * @param node: the node and its children
	 */
	private void processChildrenMarkup(ASTStatement node){
		
		int numberOfChildren = node.jjtGetNumChildren();
		for ( int currentChild = FIRST_CHILD; currentChild < numberOfChildren; currentChild++ ) {
			if( node.jjtGetChild(currentChild).toString().equals(NODE_MARKUP) ){
		  		MarkupVisitor markupVisitor = new MarkupVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(markupVisitor, null);
		  		
		  		// If this is the last node, the previous node must be closed with a "]"
				if( (currentChild == numberOfChildren -1) 
						& (currentChild != FIRST_CHILD) ) {
		  			addToAST( "], " + markupVisitor.getAST() );
		  		} else{
		  			if (FIRST_CHILD < currentChild){
		  				addToAST( ", " );
		  			}
		  			addToAST( markupVisitor.getAST() );
		  		}
			}
			
			else if( node.jjtGetChild(currentChild).toString().equals(NODE_STATEMENT) ){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		if( (currentChild == numberOfChildren -1) 
		  				& (currentChild != FIRST_CHILD) ) {
		  			addToAST( "], " + statementVisitor.getAST() );
		  		}
		  		else{
		  			if (FIRST_CHILD < currentChild){
		  				addToAST( ", " );
		  			}
		  			addToAST( statementVisitor.getAST() );
		  		}
			}
			
			else if( node.jjtGetChild(currentChild).toString().equals(NODE_EMBEDDING) ){
				EmbeddingVisitor embeddingVisitor = new EmbeddingVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(embeddingVisitor, null);
		  		if( (currentChild == numberOfChildren -1) 
		  				& (currentChild != FIRST_CHILD) ) {
		  			addToAST( "], " + embeddingVisitor.getAST() );
		  		}
		  		else{
		  			if (FIRST_CHILD < currentChild){
		  				addToAST( ", " );
		  			}
		  			addToAST( embeddingVisitor.getAST() );
		  		}
			}
			
			else if( node.jjtGetChild(currentChild).toString().equals(NODE_EXPRESSION) ){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
		  		if( (currentChild == numberOfChildren -1) 
		  				& (currentChild != FIRST_CHILD) ) {
		  			addToAST( "], " +  expressionVisitor.getAST() );
		  		}
		  		else{
		  			if (FIRST_CHILD < currentChild){
		  				addToAST( ", " );
		  			}
		  			addToAST( expressionVisitor.getAST() );
		  		}
			}
		}
	}
	
	/**
	 * This method is used for choices:
	 * CHOICE_BLOCK
	 * @param node: the node and its children
	 */
	private void processChildrenBlock(ASTStatement node){
		
		int numberOfChildren = node.jjtGetNumChildren();
		for ( int currentChild = FIRST_CHILD; currentChild < numberOfChildren; currentChild++ ) { 
			
			if (FIRST_CHILD < currentChild){
				addToAST( ", " );
			}
			
			if( node.jjtGetChild(currentChild).toString().equals(NODE_STATEMENT) ){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		addToAST( statementVisitor.getAST() );
			}
		}
	}

	/**
	 * This method is used for choices:
	 * CHOICE_IF_ELSE, CHOICE_IF
	 * @param node: the node and its children
	 */
	private void processChildrenIfElse(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = FIRST_CHILD; currentChild < numberOfChildren; currentChild++ ) { 
			
			if ( FIRST_CHILD < currentChild ){
				addToAST( ", " );
			}
			
			if( node.jjtGetChild(currentChild).toString().equals(NODE_STATEMENT) ){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		addToAST( statementVisitor.getAST() );
			}
			
			else if( node.jjtGetChild(currentChild).toString().equals(NODE_PREDICATE) ){
				PredicateVisitor predicateVisitor = new PredicateVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(predicateVisitor, null);
		  		addToAST( predicateVisitor.getAST() );
			}
		}
	}

	/**
	 * This method is used for choices:
	 * CHOICE_EACH
	 * @param node: the node and its children
	 */
	private void processChildrenEach(ASTStatement node){
		
		int numberOfChildren = node.jjtGetNumChildren();
		for ( int currentChild = FIRST_CHILD; currentChild < numberOfChildren; currentChild++ ) { 
			
			if ( FIRST_CHILD < currentChild ){
				addToAST( ", " );
			}
			
			if( node.jjtGetChild(currentChild).toString().equals(NODE_STATEMENT) ){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		addToAST( statementVisitor.getAST() );
			}
			
			else if( node.jjtGetChild(currentChild).toString().equals(NODE_EXPRESSION) ){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
		  		addToAST( expressionVisitor.getAST() );
			}
			
			else if ( node.jjtGetChild(currentChild).toString().equals(NODE_DOTIDCON) ){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				addToAST( dotIdConVisitor.getAST() );
  			}
			
			else if ( node.jjtGetChild(currentChild).toString().equals(NODE_VAR) ){
				VarVisitor varVisitor = new VarVisitor();
				node.jjtGetChild(FIRST_CHILD).jjtAccept(varVisitor, null);
				addToAST( varVisitor.getAST() );
			}
		}
	}

	/**
	 * This method is used for choices:
	 * CHOICE_ECHO
	 * @param node: the node and its children
	 */
	private void processChildrenEcho(ASTStatement node){
		
		int numberOfChildren = node.jjtGetNumChildren();
		for ( int currentChild = FIRST_CHILD; currentChild < numberOfChildren; currentChild++ ) { 
			
			if ( FIRST_CHILD < currentChild ){
				addToAST( ", " );
			}
			
			if( node.jjtGetChild(currentChild).toString().equals(NODE_EXPRESSION) ){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
		  		addToAST( expressionVisitor.getAST() );
			}
			
			else if ( node.jjtGetChild(currentChild).toString().equals(NODE_DOTIDCON) ){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				addToAST( dotIdConVisitor.getAST() );
  			}
			
			else if( node.jjtGetChild(currentChild).toString().equals(NODE_EMBEDDING) ){
				EmbeddingVisitor embeddingVisitor = new EmbeddingVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(embeddingVisitor, null);
		  		addToAST( embeddingVisitor.getAST() );
			}
		}
	}

	/**
	 * This method is used for choices:
	 * CHOICE_LET
	 * @param node: the node and its children
	 */
	private void processChildrenLet(ASTStatement node){
		int numberOfChildren = node.jjtGetNumChildren();
		
		for ( int currentChild = FIRST_CHILD; currentChild < numberOfChildren; currentChild++ ) { 
			
			if ( FIRST_CHILD < currentChild ){
				addToAST( ", " );
			}
			
			if( node.jjtGetChild(currentChild).toString().equals(NODE_STATEMENT) ){
				StatementVisitor statementVisitor = new StatementVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(statementVisitor, null);
		  		addToAST( "[" );
		  		addToAST( statementVisitor.getAST() );
		  		addToAST( "]" );
			}
			
			else if( node.jjtGetChild(currentChild).toString().equals(NODE_ASSIGNMENT) ){
				AssignmentVisitor assignmentVisitor = new AssignmentVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(assignmentVisitor, null);
		  		addToAST( assignmentVisitor.getAST() );
			}
		}
	}

	/**
	 * This method is used for choices:
	 * CHOICE_LET
	 * @param node: the node and its children
	 */
	private void processChildrenCdata(ASTStatement node){
		
		int numberOfChildren = node.jjtGetNumChildren();
		for ( int currentChild = FIRST_CHILD; currentChild < numberOfChildren; currentChild++ ) { 
			
			if ( FIRST_CHILD < currentChild ){
				addToAST( ", " );
			}
			
			if( node.jjtGetChild(currentChild).toString().equals(NODE_EXPRESSION) ){
				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
		  		node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
		  		addToAST( expressionVisitor.getAST() );
			}
			
			else if ( node.jjtGetChild(currentChild).toString().equals(NODE_DOTIDCON) ){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				addToAST( dotIdConVisitor.getAST() );
  			}
		}
	}
}