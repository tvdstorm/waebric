package waebric.ast;


public class Empty extends Cons
{
	public Empty()
	{
		super();

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

