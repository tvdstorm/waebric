package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 45:  ExpressionCollection ::= [ ExpressionOpt ]
 *</b>
 */
public class ExpressionCollection extends Ast implements IExpressionCollection
{
    private ExpressionList _ExpressionOpt;

    public ExpressionList getExpressionOpt() { return _ExpressionOpt; }

    public ExpressionCollection(IToken leftIToken, IToken rightIToken,
                                ExpressionList _ExpressionOpt)
    {
        super(leftIToken, rightIToken);

        this._ExpressionOpt = _ExpressionOpt;
        ((Ast) _ExpressionOpt).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_ExpressionOpt);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof ExpressionCollection)) return false;
        if (! super.equals(o)) return false;
        ExpressionCollection other = (ExpressionCollection) o;
        if (! _ExpressionOpt.equals(other._ExpressionOpt)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_ExpressionOpt.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


