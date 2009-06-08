package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 129:  Predicate ::= Expression
 *<li>Rule 130:  Predicate ::= Expression . Type
 *</b>
 */
public class PredicateCheckType extends Ast implements IPredicate
{
    private IExpression _Expression;
    private IType _Type;

    public IExpression getExpression() { return _Expression; }
    /**
     * The value returned by <b>getType</b> may be <b>null</b>
     */
    public IType getType() { return _Type; }

    public PredicateCheckType(IToken leftIToken, IToken rightIToken,
                              IExpression _Expression,
                              IType _Type)
    {
        super(leftIToken, rightIToken);

        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
        this._Type = _Type;
        if (_Type != null) ((Ast) _Type).setParent(this);
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
        if (! (o instanceof PredicateCheckType)) return false;
        if (! super.equals(o)) return false;
        PredicateCheckType other = (PredicateCheckType) o;
        if (! _Expression.equals(other._Expression)) return false;
        if (_Type == null)
            if (other._Type != null) return false;
            else; // continue
        else if (! _Type.equals(other._Type)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Expression.hashCode());
        hash = hash * 31 + (_Type == null ? 0 : _Type.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


