public class FormalsVisitor extends WaebricParserVisitorAdapter {
	private String ast = "";
	
	public Object visit(ASTFormals node, Object data){
		ast += "formals([";
		
		ast += node.image;

	  	ast += "])";
		return data;
	}
	
	public String getAST(){
		return ast;
	}
}