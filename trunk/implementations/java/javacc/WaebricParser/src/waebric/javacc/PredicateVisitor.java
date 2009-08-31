package waebric.javacc;
public class PredicateVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTPredicate node, Object data){
		
		int numberOfChildren = node.jjtGetNumChildren();
		for ( int currentChild = FIRST_CHILD; currentChild < numberOfChildren; currentChild++ ) {
			
			if ( node.jjtGetChild(currentChild).toString().equals(NODE_EXPRESSION) ){
  				ExpressionVisitor expressionVisitor = new ExpressionVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(expressionVisitor, null);
  				addToAST( expressionVisitor.getAST() );
  			}

			else if ( node.jjtGetChild(currentChild).toString().equals(NODE_DOTIDCON) ){
				DotIdConVisitor dotIdConVisitor = new DotIdConVisitor();
  				node.jjtGetChild(currentChild).jjtAccept(dotIdConVisitor, null);
  				addToAST( ", " + dotIdConVisitor.getAST() );
  			}
		}
		
		return data;
	}
}