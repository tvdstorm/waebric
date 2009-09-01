package waebric.ast;


import java.util.ArrayList;
import java.util.Collection;


public class Markup_stat extends ListTypeCons
{
	public Markup_stat(ArrayList left, Cons right)
	{
		super(left, right);
		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

