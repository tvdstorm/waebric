package waebric.ast;


public class Echo extends OneCons
{
	public Echo(Cons left)
	{
		super(left);

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

