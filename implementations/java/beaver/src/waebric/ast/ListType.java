package waebric.ast;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ListType extends Cons
{
	public final ArrayList l;
	
	protected ListType(ArrayList left)
	{
		super();
		l = left;
	}
}