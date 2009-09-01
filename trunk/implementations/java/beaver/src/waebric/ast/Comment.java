package waebric.ast;


public class Comment extends Cons
{
	public final String valueLeft;
	public Comment(String left)
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

