package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 41:  ExpressionOpt ::= $Empty
 *<li>Rule 42:  ExpressionOpt ::= Expressions
 *<li>Rule 43:  Expressions ::= Expression , Expressions
 *<li>Rule 44:  Expressions ::= Expression
 *</b>
 */
public class ExpressionList extends AbstractAstList implements IExpressionOpt, IExpressions
{
    public IExpression getExpressionAt(int i) { return (IExpression) getElementAt(i); }

    public ExpressionList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public ExpressionList(IExpression _Expression, boolean leftRecursive)
    {
        super((Ast) _Expression, leftRecursive);
        ((Ast) _Expression).setParent(this);
    }

    public void add(IExpression _Expression)
    {
        super.add((Ast) _Expression);
        ((Ast) _Expression).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof ExpressionList)) return false;
        if (! super.equals(o)) return false;
        ExpressionList other = (ExpressionList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            IExpression element = getExpressionAt(i);
            if (! element.equals(other.getExpressionAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getExpressionAt(i).hashCode());
        return hash;
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getExpressionAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getExpressionAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getExpressionAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getExpressionAt(i).accept(v, o));
        return result;
    }
}


