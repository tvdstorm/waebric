package waebric.ast;


import java.util.ArrayList;
import java.util.Collection;


public class Block extends ListType
{
	public Block(ArrayList left)
	{
		super(left);

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

