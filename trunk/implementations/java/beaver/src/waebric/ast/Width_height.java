package waebric.ast;


public class Width_height extends Cons
{
	public final String valueLeft;
	public final String valueRight;
	public Width_height(String left, String right)
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

