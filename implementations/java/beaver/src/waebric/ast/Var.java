package waebric.ast;


public class Var extends Cons
{
	public final String valueLeft;
	public Var(String left)
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

