package waebric.ast;


public class Cat extends TwoCons
{
	public Cat(Cons left, Cons right)
	{
		super(left, right);
		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

