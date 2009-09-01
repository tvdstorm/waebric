package waebric.ast;

import java.util.ArrayList;
import java.util.Collection;

public abstract class TwoListTypes extends Cons
{
	public final ArrayList l;
	public final ArrayList r;
	
	protected TwoListTypes(ArrayList left,ArrayList right)
	{
		super();
		l = left;
		r = right;
	}
}