package waebric.ast;


public class Cdata extends OneCons
{
	public Cdata(Cons left)
	{
		super(left);

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

