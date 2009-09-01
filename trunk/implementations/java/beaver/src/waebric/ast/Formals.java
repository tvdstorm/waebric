package waebric.ast;


public class Formals extends OneCons
{
	public Formals(Cons left)
	{
		super(left);

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

