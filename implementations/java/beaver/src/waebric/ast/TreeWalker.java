package waebric.ast;

import java.io.PrintStream;

public class TreeWalker
{
	
	private final PrintStream myOutput;
	
	public TreeWalker() {
		this(System.out);
	}
	
	public TreeWalker(PrintStream output) {
		myOutput = output;
	}
	
	public String addSlashes(String input)
	{
		String result="";
		if(input!=null)
		{
			result=input.replaceAll("\\n","\\\\n");
			result=result.replaceAll("\\r","\\\\r");
			result=result.replaceAll("\\t","\\\\t");
			result=result.replaceAll("\\\"","\\\\\"");
		}
		return result;
	}

	public void visit(Module cons)
	{
		myOutput.print("module(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		int cons_r_size=0;
		if(cons.r!=null)
		{
		cons_r_size=cons.r.size();
		}
		if(cons_r_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_r_size;index++)
		{
		Cons listitem = (Cons)cons.r.get(index);
		listitem.accept(this);
		if(index<(cons_r_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Module_id cons)
	{
		myOutput.print("module-id(");
		if(cons.l!=null){

		myOutput.print("[");
		
			cons.l.accept(this);

		myOutput.print("]");
		
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Idconsa cons)
	{
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		//leaf
	}
	public void visit(Idconslist cons)
	{
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueRight)
		+ "\"");
	}
	public void visit(Import cons)
	{
		myOutput.print("import(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Def cons)
	{
		myOutput.print("def(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		myOutput.print(", ");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		int cons_r_size=0;
		if(cons.r!=null)
		{
		cons_r_size=cons.r.size();
		}
		if(cons_r_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_r_size;index++)
		{
		Cons listitem = (Cons)cons.r.get(index);
		listitem.accept(this);
		if(index<(cons_r_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Var_bind cons)
	{
		myOutput.print("var-bind(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		myOutput.print(", ");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Func_bind cons)
	{
		myOutput.print("func-bind(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		myOutput.print(", ");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Empty cons)
	{
		myOutput.print("empty");
		//leaf
	}
	public void visit(Formals cons)
	{
		myOutput.print("formals(");
		if(cons.l!=null){

		myOutput.print("[");
		
			cons.l.accept(this);

		myOutput.print("]");
		
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Formal_a cons)
	{
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		//leaf
	}
	public void visit(Formallist cons)
	{
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		myOutput.print(", ");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
	}
	public void visit(Emptyformallist cons)
	{
		myOutput.print("[");
		//leaf
		myOutput.print("]");
	}
	public void visit(Assignmentformals cons)
	{
		myOutput.print("[");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print("]");
	}
	public void visit(Var cons)
	{
		myOutput.print("var(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		//leaf
		myOutput.print(")");
	}
	public void visit(Field cons)
	{
		myOutput.print("field(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueRight)
		+ "\"");
		myOutput.print(")");
	}
	public void visit(Cat cons)
	{
		myOutput.print("cat(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Sym cons)
	{
		myOutput.print("sym(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Num cons)
	{
		myOutput.print("num(");
		//leaf
		myOutput.print(
		 addSlashes(cons.valueLeft)
		);
		//leaf
		myOutput.print(")");
	}
	public void visit(Text cons)
	{
		myOutput.print("text(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(List cons)
	{
		myOutput.print("list(");
		int cons_l_size=0;
		if(cons.l!=null)
		{
		cons_l_size=cons.l.size();
		}
		if(cons_l_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_l_size;index++)
		{
		Cons listitem = (Cons)cons.l.get(index);
		listitem.accept(this);
		if(index<(cons_l_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Record cons)
	{
		myOutput.print("record(");
		int cons_l_size=0;
		if(cons.l!=null)
		{
		cons_l_size=cons.l.size();
		}
		if(cons_l_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_l_size;index++)
		{
		Cons listitem = (Cons)cons.l.get(index);
		listitem.accept(this);
		if(index<(cons_l_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Text_expression cons)
	{
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		//leaf
	}
	public void visit(Sym_text cons)
	{
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		//leaf
	}
	public void visit(Pair cons)
	{
		myOutput.print("pair(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		myOutput.print(", ");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Mid cons)
	{
		myOutput.print("mid(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		myOutput.print(", ");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Post cons)
	{
		myOutput.print("post(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		//leaf
		myOutput.print(")");
	}
	public void visit(Pre cons)
	{
		myOutput.print("pre(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		myOutput.print(", ");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Exp_embedding cons)
	{
		myOutput.print("exp-embedding(");
		int cons_l_size=0;
		if(cons.l!=null)
		{
		cons_l_size=cons.l.size();
		}
		if(cons_l_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_l_size;index++)
		{
		Cons listitem = (Cons)cons.l.get(index);
		listitem.accept(this);
		if(index<(cons_l_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Args cons)
	{
		myOutput.print("args(");
		int cons_l_size=0;
		if(cons.l!=null)
		{
		cons_l_size=cons.l.size();
		}
		if(cons_l_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_l_size;index++)
		{
		Cons listitem = (Cons)cons.l.get(index);
		listitem.accept(this);
		if(index<(cons_l_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Attr cons)
	{
		myOutput.print("attr(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		myOutput.print(", ");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Call cons)
	{
		myOutput.print("call(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Tag cons)
	{
		myOutput.print("tag(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		myOutput.print(", ");
		int cons_l_size=0;
		if(cons.l!=null)
		{
		cons_l_size=cons.l.size();
		}
		if(cons_l_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_l_size;index++)
		{
		Cons listitem = (Cons)cons.l.get(index);
		listitem.accept(this);
		if(index<(cons_l_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(If cons)
	{
		myOutput.print("if(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
myOutput.print(", appl(prod([], cf(sort(\"NoElseMayFollow\")), no-attrs), [])");		myOutput.print(")");
	}
	public void visit(If_else cons)
	{
		myOutput.print("if-else(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.t!=null){
			cons.t.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Let cons)
	{
		myOutput.print("let(");
		int cons_l_size=0;
		if(cons.l!=null)
		{
		cons_l_size=cons.l.size();
		}
		if(cons_l_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_l_size;index++)
		{
		Cons listitem = (Cons)cons.l.get(index);
		listitem.accept(this);
		if(index<(cons_l_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(", ");
		int cons_r_size=0;
		if(cons.r!=null)
		{
		cons_r_size=cons.r.size();
		}
		if(cons_r_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_r_size;index++)
		{
		Cons listitem = (Cons)cons.r.get(index);
		listitem.accept(this);
		if(index<(cons_r_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Block cons)
	{
		myOutput.print("block(");
		int cons_l_size=0;
		if(cons.l!=null)
		{
		cons_l_size=cons.l.size();
		}
		if(cons_l_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_l_size;index++)
		{
		Cons listitem = (Cons)cons.l.get(index);
		listitem.accept(this);
		if(index<(cons_l_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Comment cons)
	{
		myOutput.print("comment(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		//leaf
		myOutput.print(")");
	}
	public void visit(Echo cons)
	{
		myOutput.print("echo(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Echo_embedding cons)
	{
		myOutput.print("echo-embedding(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Cdata cons)
	{
		myOutput.print("cdata(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Yield cons)
	{
		myOutput.print("yield");
		//leaf
	}
	public void visit(Markup cons)
	{
		myOutput.print("markup(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Markup_markup cons)
	{
		myOutput.print("markup-markup(");
		int cons_l_size=0;
		if(cons.l!=null)
		{
		cons_l_size=cons.l.size();
		}
		if(cons_l_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_l_size;index++)
		{
		Cons listitem = (Cons)cons.l.get(index);
		listitem.accept(this);
		if(index<(cons_l_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Markup_exp cons)
	{
		myOutput.print("markup-exp(");
		int cons_l_size=0;
		if(cons.l!=null)
		{
		cons_l_size=cons.l.size();
		}
		if(cons_l_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_l_size;index++)
		{
		Cons listitem = (Cons)cons.l.get(index);
		listitem.accept(this);
		if(index<(cons_l_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Markup_embedding cons)
	{
		myOutput.print("markup-embedding(");
		int cons_l_size=0;
		if(cons.l!=null)
		{
		cons_l_size=cons.l.size();
		}
		if(cons_l_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_l_size;index++)
		{
		Cons listitem = (Cons)cons.l.get(index);
		listitem.accept(this);
		if(index<(cons_l_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Markup_stat cons)
	{
		myOutput.print("markup-stat(");
		int cons_l_size=0;
		if(cons.l!=null)
		{
		cons_l_size=cons.l.size();
		}
		if(cons_l_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_l_size;index++)
		{
		Cons listitem = (Cons)cons.l.get(index);
		listitem.accept(this);
		if(index<(cons_l_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Id cons)
	{
		myOutput.print("id(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		//leaf
		myOutput.print(")");
	}
	public void visit(Name cons)
	{
		myOutput.print("name(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		//leaf
		myOutput.print(")");
	}
	public void visit(Type cons)
	{
		myOutput.print("type(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		//leaf
		myOutput.print(")");
	}
	public void visit(Width_height cons)
	{
		myOutput.print("width-height(");
		//leaf
		myOutput.print(
		 addSlashes(cons.valueLeft)
		);
		myOutput.print(", ");
		//leaf
		myOutput.print(
		 addSlashes(cons.valueRight)
		);
		myOutput.print(")");
	}
	public void visit(Height cons)
	{
		myOutput.print("height(");
		//leaf
		myOutput.print(
		 addSlashes(cons.valueLeft)
		);
		//leaf
		myOutput.print(")");
	}
	public void visit(Site cons)
	{
		myOutput.print("site(");
		int cons_l_size=0;
		if(cons.l!=null)
		{
		cons_l_size=cons.l.size();
		}
		if(cons_l_size>0)
		{
		myOutput.print("[");
		for(int index=0;index<cons_l_size;index++)
		{
		Cons listitem = (Cons)cons.l.get(index);
		listitem.accept(this);
		if(index<(cons_l_size-1))
		{
		myOutput.print(", ");
		}
		}
		myOutput.print("]");
		}
		else
		{
		myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Mapping cons)
	{
		myOutput.print("mapping(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Path cons)
	{
		myOutput.print("path(");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		myOutput.print(", ");
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueRight)
		+ "\"");
		myOutput.print(")");
	}
	public void visit(Filenamestring cons)
	{
		//leaf
		myOutput.print("\"" + 
		 addSlashes(cons.valueLeft)
		+ "\"");
		//leaf
	}
	public void visit(List_type cons)
	{
		myOutput.print("list-type");
		//leaf
	}
	public void visit(Record_type cons)
	{
		myOutput.print("record-type");
		//leaf
	}
	public void visit(String_type cons)
	{
		myOutput.print("string-type");
		//leaf
	}
	public void visit(Is_a cons)
	{
		myOutput.print("is-a(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Not cons)
	{
		myOutput.print("not(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(And cons)
	{
		myOutput.print("and(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}
	public void visit(Or cons)
	{
		myOutput.print("or(");
		if(cons.l!=null){
			cons.l.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(", ");
		if(cons.r!=null){
			cons.r.accept(this);
		}
		else{
			myOutput.print("[]");
		}
		myOutput.print(")");
	}

}
