package waebric.ast;


public class Text extends OneCons
{
	public Text(Cons left)
	{
		super(left);

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

