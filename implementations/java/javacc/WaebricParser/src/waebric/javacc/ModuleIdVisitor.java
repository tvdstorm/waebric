package waebric.javacc;
public class ModuleIdVisitor extends WaebricParserVisitorAdapter {
	private static final int START_AT_2ND_ELEMENT = 1;
	private static final int FIRST_DATA_ELEMENT = 0;
	
	public Object visit(ASTModuleId node, Object data){	
		addToAST( "module-id([" );
		
		String[] dataFromJjt = node.image.split(SPLIT_SEPARATOR);
		String moduleIdStr = addQuotes( dataFromJjt[FIRST_DATA_ELEMENT] );

		for ( int index = START_AT_2ND_ELEMENT; index < dataFromJjt.length; index++ ){
			moduleIdStr += ", " + addQuotes( dataFromJjt[index] );
		}
	
		addToAST( moduleIdStr );
	  	addToAST( "])" );
	  	
		return data;
	}
}