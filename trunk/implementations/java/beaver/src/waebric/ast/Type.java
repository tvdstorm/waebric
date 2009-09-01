package waebric.ast;


public class Type extends Cons
{
	public final String valueLeft;
	public Type(String left)
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

