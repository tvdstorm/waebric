package waebric.ast;


import java.util.ArrayList;
import java.util.Collection;


public class Let extends TwoListTypes
{
	public Let(ArrayList left, ArrayList right)
	{
		super(left, right);
		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

