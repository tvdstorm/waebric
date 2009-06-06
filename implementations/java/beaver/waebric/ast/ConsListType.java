package waebric.ast;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ConsListType extends Cons
{
	public final Cons l;
	public final ArrayList r;
	
	protected ConsListType(Cons left, ArrayList right)
	{
		super();
		l = left;
		r = right;
	}
}