package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 51:  KeyValuePair ::= IDENTIFIER$Key : Expression
 *</b>
 */
public class KeyValuePair extends Ast implements IKeyValuePair
{
    private AstToken _Key;
    private IExpression _Expression;

    public AstToken getKey() { return _Key; }
    public IExpression getExpression() { return _Expression; }

    public KeyValuePair(IToken leftIToken, IToken rightIToken,
                        AstToken _Key,
                        IExpression _Expression)
    {
        super(leftIToken, rightIToken);

        this._Key = _Key;
        ((Ast) _Key).setParent(this);
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
        list.add(_Key);
        list.add(_Expression);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof KeyValuePair)) return false;
        if (! super.equals(o)) return false;
        KeyValuePair other = (KeyValuePair) o;
        if (! _Key.equals(other._Key)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Key.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


