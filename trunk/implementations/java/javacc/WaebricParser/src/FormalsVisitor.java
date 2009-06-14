public class FormalsVisitor extends WaebricParserVisitorAdapter {
	public Object visit(ASTFormals node, Object data){
		ast += "formals([";
		
		ast += node.image;

	  	ast += "])";
		return data;
	}
}