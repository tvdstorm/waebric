package waebric.ast;


public class Text_expression extends Cons
{
	public final String valueLeft;
	public Text_expression(String left)
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

