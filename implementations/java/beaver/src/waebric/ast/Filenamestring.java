package waebric.ast;


public class Filenamestring extends Cons
{
	public final String valueLeft;
	public Filenamestring(String left)
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

