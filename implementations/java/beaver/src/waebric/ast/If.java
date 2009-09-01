package waebric.ast;


public class If extends TwoCons
{
	public If(Cons left, Cons right)
	{
		super(left, right);
		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

