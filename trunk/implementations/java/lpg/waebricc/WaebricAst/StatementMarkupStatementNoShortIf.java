package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 125:  StatementMarkupStatementNoShortIf ::= Markups StatementWithoutMarkupNoShortIf
 *</b>
 */
public class StatementMarkupStatementNoShortIf extends Ast implements IStatementMarkupStatementNoShortIf
{
    private MarkupList _Markups;
    private IStatementWithoutMarkupNoShortIf _StatementWithoutMarkupNoShortIf;

    public MarkupList getMarkups() { return _Markups; }
    public IStatementWithoutMarkupNoShortIf getStatementWithoutMarkupNoShortIf() { return _StatementWithoutMarkupNoShortIf; }

    public StatementMarkupStatementNoShortIf(IToken leftIToken, IToken rightIToken,
                                             MarkupList _Markups,
                                             IStatementWithoutMarkupNoShortIf _StatementWithoutMarkupNoShortIf)
    {
        super(leftIToken, rightIToken);

        this._Markups = _Markups;
        ((Ast) _Markups).setParent(this);
        this._StatementWithoutMarkupNoShortIf = _StatementWithoutMarkupNoShortIf;
        ((Ast) _StatementWithoutMarkupNoShortIf).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Markups);
        list.add(_StatementWithoutMarkupNoShortIf);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementMarkupStatementNoShortIf)) return false;
        if (! super.equals(o)) return false;
        StatementMarkupStatementNoShortIf other = (StatementMarkupStatementNoShortIf) o;
        if (! _Markups.equals(other._Markups)) return false;
        if (! _StatementWithoutMarkupNoShortIf.equals(other._StatementWithoutMarkupNoShortIf)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Markups.hashCode());
        hash = hash * 31 + (_StatementWithoutMarkupNoShortIf.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


