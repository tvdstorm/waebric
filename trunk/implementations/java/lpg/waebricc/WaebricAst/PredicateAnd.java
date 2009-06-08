package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 132:  Predicate ::= ( Predicate ) AND_AND$AndPredicate ( Predicate )
 *</b>
 */
public class PredicateAnd extends Ast implements IPredicate
{
    private IPredicate _Predicate;
    private AstToken _AndPredicate;
    private IPredicate _Predicate6;

    public IPredicate getPredicate() { return _Predicate; }
    public AstToken getAndPredicate() { return _AndPredicate; }
    public IPredicate getPredicate6() { return _Predicate6; }

    public PredicateAnd(IToken leftIToken, IToken rightIToken,
                        IPredicate _Predicate,
                        AstToken _AndPredicate,
                        IPredicate _Predicate6)
    {
        super(leftIToken, rightIToken);

        this._Predicate = _Predicate;
        ((Ast) _Predicate).setParent(this);
        this._AndPredicate = _AndPredicate;
        ((Ast) _AndPredicate).setParent(this);
        this._Predicate6 = _Predicate6;
        ((Ast) _Predicate6).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Predicate);
        list.add(_AndPredicate);
        list.add(_Predicate6);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof PredicateAnd)) return false;
        if (! super.equals(o)) return false;
        PredicateAnd other = (PredicateAnd) o;
        if (! _Predicate.equals(other._Predicate)) return false;
        if (! _AndPredicate.equals(other._AndPredicate)) return false;
        if (! _Predicate6.equals(other._Predicate6)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Predicate.hashCode());
        hash = hash * 31 + (_AndPredicate.hashCode());
        hash = hash * 31 + (_Predicate6.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


