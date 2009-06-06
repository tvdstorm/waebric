package waebric.ast;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ListTypeCons extends Cons
{
	public final ArrayList l;
	public final Cons r;
	
	protected ListTypeCons(ArrayList left,Cons right)
	{
		super();
		l = left;
		r = right;
	}
}