package waebric.ast;


public class Id extends Cons
{
	public final String valueLeft;
	public Id(String left)
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

