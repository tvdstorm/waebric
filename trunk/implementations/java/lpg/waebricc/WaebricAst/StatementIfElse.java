package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 105:  StatementIfElse ::= if ( Predicate ) StatementNoShortIf else Statement
 *</b>
 */
public class StatementIfElse extends Ast implements IStatementIfElse
{
    private IPredicate _Predicate;
    private IStatementNoShortIf _StatementNoShortIf;
    private IStatement _Statement;

    public IPredicate getPredicate() { return _Predicate; }
    public IStatementNoShortIf getStatementNoShortIf() { return _StatementNoShortIf; }
    public IStatement getStatement() { return _Statement; }

    public StatementIfElse(IToken leftIToken, IToken rightIToken,
                           IPredicate _Predicate,
                           IStatementNoShortIf _StatementNoShortIf,
                           IStatement _Statement)
    {
        super(leftIToken, rightIToken);

        this._Predicate = _Predicate;
        ((Ast) _Predicate).setParent(this);
        this._StatementNoShortIf = _StatementNoShortIf;
        ((Ast) _StatementNoShortIf).setParent(this);
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
        list.add(_StatementNoShortIf);
        list.add(_Statement);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementIfElse)) return false;
        if (! super.equals(o)) return false;
        StatementIfElse other = (StatementIfElse) o;
        if (! _Predicate.equals(other._Predicate)) return false;
        if (! _StatementNoShortIf.equals(other._StatementNoShortIf)) return false;
        if (! _Statement.equals(other._Statement)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Predicate.hashCode());
        hash = hash * 31 + (_StatementNoShortIf.hashCode());
        hash = hash * 31 + (_Statement.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


