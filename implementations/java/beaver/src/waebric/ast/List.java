package waebric.ast;


import java.util.ArrayList;
import java.util.Collection;


public class List extends ListType
{
	public List(ArrayList left)
	{
		super(left);

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

