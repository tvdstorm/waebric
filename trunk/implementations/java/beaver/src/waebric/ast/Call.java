package waebric.ast;


public class Call extends TwoCons
{
	public Call(Cons left, Cons right)
	{
		super(left, right);
		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

