package waebric.ast;


public class Or extends TwoCons
{
	public Or(Cons left, Cons right)
	{
		super(left, right);
		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

