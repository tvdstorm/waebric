package waebric.ast;


public class Num extends Cons
{
	public final String valueLeft;
	public Num(String left)
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

