package waebric.ast;


public class Sym extends OneCons
{
	public Sym(Cons left)
	{
		super(left);

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

