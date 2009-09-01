package waebric.ast;


public class Attr extends OneCons
{
	public final String valueLeft;
	public Attr(String left, Cons right)
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

