package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 120:  StatementMarkup ::= Markup ;
 *</b>
 */
public class StatementMarkup extends Ast implements IStatementMarkup
{
    private IMarkup _Markup;

    public IMarkup getMarkup() { return _Markup; }

    public StatementMarkup(IToken leftIToken, IToken rightIToken,
                           IMarkup _Markup)
    {
        super(leftIToken, rightIToken);

        this._Markup = _Markup;
        ((Ast) _Markup).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Markup);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementMarkup)) return false;
        if (! super.equals(o)) return false;
        StatementMarkup other = (StatementMarkup) o;
        if (! _Markup.equals(other._Markup)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Markup.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


