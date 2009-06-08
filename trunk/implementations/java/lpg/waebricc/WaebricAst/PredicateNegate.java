package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 131:  Predicate ::= ! Predicate
 *</b>
 */
public class PredicateNegate extends Ast implements IPredicate
{
    private IPredicate _Predicate;

    public IPredicate getPredicate() { return _Predicate; }

    public PredicateNegate(IToken leftIToken, IToken rightIToken,
                           IPredicate _Predicate)
    {
        super(leftIToken, rightIToken);

        this._Predicate = _Predicate;
        ((Ast) _Predicate).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Predicate);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof PredicateNegate)) return false;
        if (! super.equals(o)) return false;
        PredicateNegate other = (PredicateNegate) o;
        if (! _Predicate.equals(other._Predicate)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Predicate.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


