package waebric.ast;


import java.util.ArrayList;
import java.util.Collection;


public class Def extends ConsListType
{
	public final String valueLeft;
	public Def(String left, Cons right, ArrayList tirth)
	{
		super(right, tirth);
		this.valueLeft = left;
		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

