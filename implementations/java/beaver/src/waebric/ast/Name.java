package waebric.ast;


public class Name extends Cons
{
	public final String valueLeft;
	public Name(String left)
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

