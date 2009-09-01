package waebric.ast;


public class Sym_text extends Cons
{
	public final String valueLeft;
	public Sym_text(String left)
	{
		super();
		this.valueLeft = left;

		this.isString=true;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

