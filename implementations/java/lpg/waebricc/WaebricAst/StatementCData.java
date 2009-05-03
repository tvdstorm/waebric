package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 77:  StatementCData ::= cdata Expression ;
 *</b>
 */
public class StatementCData extends Ast implements IStatementCData
{
    private IExpression _Expression;

    public IExpression getExpression() { return _Expression; }

    public StatementCData(IToken leftIToken, IToken rightIToken,
                          IExpression _Expression)
    {
        super(leftIToken, rightIToken);

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
        list.add(_Expression);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementCData)) return false;
        if (! super.equals(o)) return false;
        StatementCData other = (StatementCData) o;
        if (! _Expression.equals(other._Expression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Expression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


