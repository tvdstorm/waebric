package waebric.ast;


public class Func_bind extends TwoCons
{
	public final String valueLeft;
	public Func_bind(String left, Cons right, Cons tirth)
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

