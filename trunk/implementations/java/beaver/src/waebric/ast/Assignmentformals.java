package waebric.ast;


public class Assignmentformals extends OneCons
{
	public Assignmentformals(Cons left)
	{
		super(left);

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

