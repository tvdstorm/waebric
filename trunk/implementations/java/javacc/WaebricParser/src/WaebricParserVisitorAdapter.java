public class WaebricParserVisitorAdapter implements WaebricParserVisitor
{	
	static final String EMPTRY_STRING = "";
	static final String PRODUCTION_MODULE = "Module";
	
	protected String ast = EMPTRY_STRING;
	
	/**
	 * 
	 * @return retrieves the constructed ast from the node
	 */
	public String getAST(){
		return ast;
	}
	
	/**
	 * @param stringArray: the string array you want to retrieve the string from
	 * @param index: index of the element you want the string from
	 * @return data from array when within bounds, otherwise an empty string
	 */
	protected String safeGetStr(String[] stringArray, int index){
		if (stringArray.length > index){
			return stringArray[index];
		} else {
			return EMPTRY_STRING;
		}	
	}
	
	public Object visit(SimpleNode node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTModules node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTModule node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTModuleId node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTModuleElement node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTImport node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTSite node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTMappings node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTMapping node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTPath node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTFunctionDef node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTFormals node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTStatement node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTPredicate node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTAssignment node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTEmbedding node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTEmbed node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTTextTail node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTMarkup node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTDesignator node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTAttribute node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTArguments node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTArgument node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTVar node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTExpression node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTDotIdCon node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTKeyValuePair node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTMoreMarkup node, Object data){
		return node.childrenAccept(this, data);
	}
}
