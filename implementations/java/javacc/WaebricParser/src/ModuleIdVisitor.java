public class ModuleIdVisitor extends WaebricParserVisitorAdapter {
	private static final int START_AT_2ND_ELEMENT = 1;
	
	public Object visit(ASTModuleId node, Object data){	
		addToAST( "module-id([" );
		
		String[] dataFromJjt = node.image.split(SPLIT_SEPARATOR);

		String moduleIdStr = addQuotes(dataFromJjt[0]);
		for (int index = START_AT_2ND_ELEMENT; index < dataFromJjt.length; index++){
			moduleIdStr += ", " + addQuotes(dataFromJjt[index]);
		}
	
		addToAST( moduleIdStr );
	  	
	  	addToAST( "])" );
		return data;
	}
}