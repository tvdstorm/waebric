package waebric.ast;


public class List_type extends Cons
{
	public List_type()
	{
		super();

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

