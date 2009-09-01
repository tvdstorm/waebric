package waebric.ast;


public class Height extends Cons
{
	public final String valueLeft;
	public Height(String left)
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

