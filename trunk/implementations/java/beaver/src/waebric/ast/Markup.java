package waebric.ast;


public class Markup extends OneCons
{
	public Markup(Cons left)
	{
		super(left);

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

