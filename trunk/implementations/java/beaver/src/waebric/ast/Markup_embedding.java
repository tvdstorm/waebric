package waebric.ast;


import java.util.ArrayList;
import java.util.Collection;


public class Markup_embedding extends ListTypeCons
{
	public Markup_embedding(ArrayList left, Cons right)
	{
		super(left, right);
		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

