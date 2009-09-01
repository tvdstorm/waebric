package waebric.ast;


public class Idconslist extends OneCons
{
	public final String valueRight;
	public Idconslist(Cons left, String right)
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

