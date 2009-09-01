package waebric.ast;


import java.util.ArrayList;
import java.util.Collection;


public class Record extends ListType
{
	public Record(ArrayList left)
	{
		super(left);

		this.isString=false;
	}

	public void accept(TreeWalker walker)
	{
		walker.visit(this);
	}
}

