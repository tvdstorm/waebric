public class WaebricParserVisitorAdapter implements WaebricParserVisitor
{
	public Object visit(SimpleNode node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTModules node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTmodule node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTModuleId node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTImport node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTsite node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTmapping node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTpath node, Object data){
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
	
	public Object visit(ASTcall node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTtag node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTAttribute node, Object data){
		return node.childrenAccept(this, data);
	}
	
	public Object visit(ASTargs node, Object data){
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
}
