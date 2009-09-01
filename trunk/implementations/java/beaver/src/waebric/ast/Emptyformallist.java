package waebric.ast;


public class Emptyformallist extends Cons
{
	public Emptyformallist()
	{
		super();

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

