package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 122:  StatementMarkup ::= Markups Expression ;
 *</b>
 */
public class StatementMarkupWithExpression extends Ast implements IStatementMarkup
{
    private MarkupList _Markups;
    private IExpression _Expression;

    public MarkupList getMarkups() { return _Markups; }
    public IExpression getExpression() { return _Expression; }

    public StatementMarkupWithExpression(IToken leftIToken, IToken rightIToken,
                                         MarkupList _Markups,
                                         IExpression _Expression)
    {
        super(leftIToken, rightIToken);

        this._Markups = _Markups;
        ((Ast) _Markups).setParent(this);
        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Markups);
        list.add(_Expression);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementMarkupWithExpression)) return false;
        if (! super.equals(o)) return false;
        StatementMarkupWithExpression other = (StatementMarkupWithExpression) o;
        if (! _Markups.equals(other._Markups)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Markups.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


