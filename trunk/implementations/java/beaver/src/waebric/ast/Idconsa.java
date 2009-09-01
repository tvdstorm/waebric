package waebric.ast;


public class Idconsa extends Cons
{
	public final String valueLeft;
	public Idconsa(String left)
	{
		super();
		this.valueLeft = left;

		this.isString=true;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

