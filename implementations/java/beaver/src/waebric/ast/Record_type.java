package waebric.ast;


public class Record_type extends Cons
{
	public Record_type()
	{
		super();

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

