package waebric.ast;


public class Pre extends TwoCons
{
	public final String valueLeft;
	public Pre(String left, Cons right, Cons tirth)
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

