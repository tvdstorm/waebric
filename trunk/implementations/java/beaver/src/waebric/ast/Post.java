package waebric.ast;


public class Post extends Cons
{
	public final String valueLeft;
	public Post(String left)
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

