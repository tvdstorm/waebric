package waebric.ast;


public class Not extends OneCons
{
	public Not(Cons left)
	{
		super(left);

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

