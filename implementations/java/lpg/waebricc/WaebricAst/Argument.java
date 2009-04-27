package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<em>
 *<li>Rule 33:  Argument ::= Expression
 *</em>
 *<p>
 *<b>
 *<li>Rule 32:  Argument ::= Var = Expression
 *</b>
 */
public class Argument extends Ast implements IArgument
{
    private Var _Var;
    private IExpression _Expression;

    public Var getVar() { return _Var; }
    public IExpression getExpression() { return _Expression; }

    public Argument(IToken leftIToken, IToken rightIToken,
                    Var _Var,
                    IExpression _Expression)
    {
        super(leftIToken, rightIToken);

        this._Var = _Var;
        ((Ast) _Var).setParent(this);
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
        list.add(_Var);
        list.add(_Expression);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof Argument)) return false;
        if (! super.equals(o)) return false;
        Argument other = (Argument) o;
        if (! _Var.equals(other._Var)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Var.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


