package waebric.ast;


public class Pair extends OneCons
{
	public final String valueLeft;
	public Pair(String left, Cons right)
	{
		super(right);
		this.valueLeft = left;
		this.isString=true;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

