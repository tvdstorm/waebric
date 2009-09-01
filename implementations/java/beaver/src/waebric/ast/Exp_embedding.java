package waebric.ast;


import java.util.ArrayList;
import java.util.Collection;


public class Exp_embedding extends ListTypeCons
{
	public Exp_embedding(ArrayList left, Cons right)
	{
		super(left, right);
		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

