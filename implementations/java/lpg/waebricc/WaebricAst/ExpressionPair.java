package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 63:  ExpressionPair ::= { KeyValuePairOpt }
 *</b>
 */
public class ExpressionPair extends Ast implements IExpressionPair
{
    private KeyValuePairList _KeyValuePairOpt;

    public KeyValuePairList getKeyValuePairOpt() { return _KeyValuePairOpt; }

    public ExpressionPair(IToken leftIToken, IToken rightIToken,
                          KeyValuePairList _KeyValuePairOpt)
    {
        super(leftIToken, rightIToken);

        this._KeyValuePairOpt = _KeyValuePairOpt;
        ((Ast) _KeyValuePairOpt).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_KeyValuePairOpt);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof ExpressionPair)) return false;
        if (! super.equals(o)) return false;
        ExpressionPair other = (ExpressionPair) o;
        if (! _KeyValuePairOpt.equals(other._KeyValuePairOpt)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_KeyValuePairOpt.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


