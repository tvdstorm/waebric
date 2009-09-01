package waebric.ast;


public class Formallist extends OneCons
{
	public final String valueLeft;
	public Formallist(String left, Cons right)
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

