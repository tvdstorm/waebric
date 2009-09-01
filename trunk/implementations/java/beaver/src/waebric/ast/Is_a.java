package waebric.ast;


public class Is_a extends TwoCons
{
	public Is_a(Cons left, Cons right)
	{
		super(left, right);
		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

