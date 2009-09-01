package waebric.ast;


public class Yield extends Cons
{
	public Yield()
	{
		super();

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

