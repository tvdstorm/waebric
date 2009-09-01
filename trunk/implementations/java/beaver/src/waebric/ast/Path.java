package waebric.ast;


public class Path extends Cons
{
	public final String valueLeft;
	public final String valueRight;
	public Path(String left, String right)
	{
		super();
		this.valueLeft = left;
		this.valueRight = right;

		this.isString=true;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

