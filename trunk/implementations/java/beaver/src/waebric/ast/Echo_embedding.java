package waebric.ast;


public class Echo_embedding extends OneCons
{
	public Echo_embedding(Cons left)
	{
		super(left);

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

