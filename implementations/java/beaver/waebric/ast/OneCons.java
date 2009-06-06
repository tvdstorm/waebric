package waebric.ast;

public abstract class OneCons extends Cons
{
	public final Cons l;

	
	protected OneCons(Cons left)
	{
		super();
		l = left;
	}
}