package waebric.ast;


public class Formal_a extends Cons
{
	public final String valueLeft;
	public Formal_a(String left)
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

