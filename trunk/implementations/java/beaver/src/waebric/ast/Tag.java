package waebric.ast;


import java.util.ArrayList;
import java.util.Collection;


public class Tag extends ListType
{
	public final String valueLeft;
	public Tag(String left, ArrayList right)
	{
		super(right);
		this.valueLeft = left;
		this.isString=true;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

