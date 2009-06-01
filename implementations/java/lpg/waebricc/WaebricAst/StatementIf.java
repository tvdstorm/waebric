package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 104:  StatementIf ::= if ( Predicate ) Statement
 *</b>
 */
public class StatementIf extends Ast implements IStatementIf
{
    private IPredicate _Predicate;
    private IStatement _Statement;

    public IPredicate getPredicate() { return _Predicate; }
    public IStatement getStatement() { return _Statement; }

    public StatementIf(IToken leftIToken, IToken rightIToken,
                       IPredicate _Predicate,
                       IStatement _Statement)
    {
        super(leftIToken, rightIToken);

        this._Predicate = _Predicate;
        ((Ast) _Predicate).setParent(this);
        this._Statement = _Statement;
        ((Ast) _Statement).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Predicate);
        list.add(_Statement);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementIf)) return false;
        if (! super.equals(o)) return false;
        StatementIf other = (StatementIf) o;
        if (! _Predicate.equals(other._Predicate)) return false;
        if (! _Statement.equals(other._Statement)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Predicate.hashCode());
        hash = hash * 31 + (_Statement.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


