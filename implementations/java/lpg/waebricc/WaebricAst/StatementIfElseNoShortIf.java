package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 106:  StatementIfElseNoShortIf ::= if ( Predicate ) StatementNoShortIf else StatementNoShortIf
 *</b>
 */
public class StatementIfElseNoShortIf extends Ast implements IStatementIfElseNoShortIf
{
    private IPredicate _Predicate;
    private IStatementNoShortIf _StatementNoShortIf;
    private IStatementNoShortIf _StatementNoShortIf7;

    public IPredicate getPredicate() { return _Predicate; }
    public IStatementNoShortIf getStatementNoShortIf() { return _StatementNoShortIf; }
    public IStatementNoShortIf getStatementNoShortIf7() { return _StatementNoShortIf7; }

    public StatementIfElseNoShortIf(IToken leftIToken, IToken rightIToken,
                                    IPredicate _Predicate,
                                    IStatementNoShortIf _StatementNoShortIf,
                                    IStatementNoShortIf _StatementNoShortIf7)
    {
        super(leftIToken, rightIToken);

        this._Predicate = _Predicate;
        ((Ast) _Predicate).setParent(this);
        this._StatementNoShortIf = _StatementNoShortIf;
        ((Ast) _StatementNoShortIf).setParent(this);
        this._StatementNoShortIf7 = _StatementNoShortIf7;
        ((Ast) _StatementNoShortIf7).setParent(this);
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
        list.add(_StatementNoShortIf7);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementIfElseNoShortIf)) return false;
        if (! super.equals(o)) return false;
        StatementIfElseNoShortIf other = (StatementIfElseNoShortIf) o;
        if (! _Predicate.equals(other._Predicate)) return false;
        if (! _StatementNoShortIf.equals(other._StatementNoShortIf)) return false;
        if (! _StatementNoShortIf7.equals(other._StatementNoShortIf7)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Predicate.hashCode());
        hash = hash * 31 + (_StatementNoShortIf.hashCode());
        hash = hash * 31 + (_StatementNoShortIf7.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


