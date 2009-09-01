package waebric.ast;


public class String_type extends Cons
{
	public String_type()
	{
		super();

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

