package waebric.ast;


import java.util.ArrayList;
import java.util.Collection;


public class Module extends ConsListType
{
	public Module(Cons left, ArrayList right)
	{
		super(left, right);
		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

