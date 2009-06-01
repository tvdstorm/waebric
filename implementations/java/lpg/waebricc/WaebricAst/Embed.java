package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 72:  Embed ::= MarkupOpt Expression
 *</b>
 */
public class Embed extends Ast implements IEmbed
{
    private MarkupList _MarkupOpt;
    private IExpression _Expression;

    public MarkupList getMarkupOpt() { return _MarkupOpt; }
    public IExpression getExpression() { return _Expression; }

    public Embed(IToken leftIToken, IToken rightIToken,
                 MarkupList _MarkupOpt,
                 IExpression _Expression)
    {
        super(leftIToken, rightIToken);

        this._MarkupOpt = _MarkupOpt;
        ((Ast) _MarkupOpt).setParent(this);
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
        list.add(_MarkupOpt);
        list.add(_Expression);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof Embed)) return false;
        if (! super.equals(o)) return false;
        Embed other = (Embed) o;
        if (! _MarkupOpt.equals(other._MarkupOpt)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_MarkupOpt.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


