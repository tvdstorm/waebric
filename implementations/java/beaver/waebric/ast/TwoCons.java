package waebric.ast;

public abstract class TwoCons extends Cons
{
	public final Cons l;
	public final Cons r;
	
	protected TwoCons(Cons left, Cons right)
	{
		super();
		l = left;
		r = right;
	}
}