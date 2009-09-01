package waebric.ast;


public class Mid extends TwoCons
{
	public final String valueLeft;
	public Mid(String left, Cons right, Cons tirth)
	{
		super(right, tirth);
		this.valueLeft = left;
		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

