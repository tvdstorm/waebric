package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<em>
 *<li>Rule 82:  Predicate ::= Expression
 *</em>
 *<p>
 *<b>
 *<li>Rule 83:  Predicate ::= Expression . Type
 *</b>
 */
public class Predicate extends Ast implements IPredicate
{
    private IExpression _Expression;
    private IType _Type;

    public IExpression getExpression() { return _Expression; }
    public IType getType() { return _Type; }

    public Predicate(IToken leftIToken, IToken rightIToken,
                     IExpression _Expression,
                     IType _Type)
    {
        super(leftIToken, rightIToken);

        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
        this._Type = _Type;
        ((Ast) _Type).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Expression);
        list.add(_Type);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof Predicate)) return false;
        if (! super.equals(o)) return false;
        Predicate other = (Predicate) o;
        if (! _Expression.equals(other._Expression)) return false;
        if (! _Type.equals(other._Type)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Expression.hashCode());
        hash = hash * 31 + (_Type.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


