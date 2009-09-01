package waebric.ast;


public class Var_bind extends OneCons
{
	public final String valueLeft;
	public Var_bind(String left, Cons right)
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

