package waebric.ast;


public class Field extends OneCons
{
	public final String valueRight;
	public Field(Cons left, String right)
	{
		super(left);
		this.valueRight = right;
		this.isString=true;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

