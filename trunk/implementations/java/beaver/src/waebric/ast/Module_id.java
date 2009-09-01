package waebric.ast;


public class Module_id extends OneCons
{
	public Module_id(Cons left)
	{
		super(left);

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

