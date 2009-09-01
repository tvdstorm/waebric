package waebric.ast;


public class If_else extends ThreeCons
{
	public If_else(Cons left, Cons right, Cons tirth)
	{
		super(left, right, tirth);

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

