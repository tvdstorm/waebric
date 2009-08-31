package waebric.javacc;
public class ModuleElementVisitor extends WaebricParserVisitorAdapter {
	private static final int FIRST_CHILD = 0;
	
	public Object visit(ASTModuleElement node, Object data){

		int numChildren = node.jjtGetNumChildren();
	  	for ( int currentChild = FIRST_CHILD; currentChild < numChildren; currentChild++ ) {
	  		if ( FIRST_CHILD < currentChild ){
  				addToAST( ", " );
  			}
	  		
	  		if ( node.jjtGetChild(currentChild).toString().equals(NODE_IMPORT) ){
	  			ImportVisitor importVisitor = new ImportVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(importVisitor, null);
	  			addToAST( importVisitor.getAST() );
	  		} 
	  		else if ( node.jjtGetChild(currentChild).toString().equals(NODE_SITE) ){
	  			SiteVisitor siteVisitor = new SiteVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(siteVisitor, null);			
	  			addToAST( siteVisitor.getAST() );
	  		} 
	  		else if ( node.jjtGetChild(currentChild).toString().equals(NODE_FUNCTIONDEF) ){
	  			FunctionDefVisitor functionDefVisitor = new FunctionDefVisitor();
	  			node.jjtGetChild(currentChild).jjtAccept(functionDefVisitor, null);			
	  			addToAST( functionDefVisitor.getAST() );
	  		}
	    }
	  	
		return data;
	}
}