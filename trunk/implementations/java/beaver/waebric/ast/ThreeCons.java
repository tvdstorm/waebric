package waebric.ast;

public abstract class ThreeCons extends Cons
{
	public final Cons l;
	public final Cons r;
	public final Cons t;
	
	protected ThreeCons(Cons left, Cons right, Cons tirth)
	{
		super();
		l = left;
		r = right;
		t = tirth; 
	}
}