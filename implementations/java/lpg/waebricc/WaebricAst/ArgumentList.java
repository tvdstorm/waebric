package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 28:  ArgumentsOpt ::= ( )
 *<li>Rule 29:  ArgumentsOpt ::= ( Arguments )
 *<li>Rule 30:  Arguments ::= Argument , Arguments
 *<li>Rule 31:  Arguments ::= Argument
 *</b>
 */
public class ArgumentList extends AbstractAstList implements IArgumentsOpt, IArguments
{
    public IArgument getArgumentAt(int i) { return (IArgument) getElementAt(i); }

    public ArgumentList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public ArgumentList(IArgument _Argument, boolean leftRecursive)
    {
        super((Ast) _Argument, leftRecursive);
        ((Ast) _Argument).setParent(this);
    }

    public void add(IArgument _Argument)
    {
        super.add((Ast) _Argument);
        ((Ast) _Argument).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof ArgumentList)) return false;
        if (! super.equals(o)) return false;
        ArgumentList other = (ArgumentList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            IArgument element = getArgumentAt(i);
            if (! element.equals(other.getArgumentAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getArgumentAt(i).hashCode());
        return hash;
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getArgumentAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getArgumentAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getArgumentAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getArgumentAt(i).accept(v, o));
        return result;
    }
}


