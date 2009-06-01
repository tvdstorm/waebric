package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 124:  StatementMarkupStatement ::= Markups StatementWithoutMarkup
 *</b>
 */
public class StatementMarkupStatement extends Ast implements IStatementMarkupStatement
{
    private MarkupList _Markups;
    private IStatementWithoutMarkup _StatementWithoutMarkup;

    public MarkupList getMarkups() { return _Markups; }
    public IStatementWithoutMarkup getStatementWithoutMarkup() { return _StatementWithoutMarkup; }

    public StatementMarkupStatement(IToken leftIToken, IToken rightIToken,
                                    MarkupList _Markups,
                                    IStatementWithoutMarkup _StatementWithoutMarkup)
    {
        super(leftIToken, rightIToken);

        this._Markups = _Markups;
        ((Ast) _Markups).setParent(this);
        this._StatementWithoutMarkup = _StatementWithoutMarkup;
        ((Ast) _StatementWithoutMarkup).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Markups);
        list.add(_StatementWithoutMarkup);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementMarkupStatement)) return false;
        if (! super.equals(o)) return false;
        StatementMarkupStatement other = (StatementMarkupStatement) o;
        if (! _Markups.equals(other._Markups)) return false;
        if (! _StatementWithoutMarkup.equals(other._StatementWithoutMarkup)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Markups.hashCode());
        hash = hash * 31 + (_StatementWithoutMarkup.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


