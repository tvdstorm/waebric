package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 137:  Assignment ::= Var = Expression ;
 *</b>
 */
public class AssignmentExpression extends Ast implements IAssignment
{
    private Var _Var;
    private IExpression _Expression;

    public Var getVar() { return _Var; }
    public IExpression getExpression() { return _Expression; }

    public AssignmentExpression(IToken leftIToken, IToken rightIToken,
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
        if (! (o instanceof AssignmentExpression)) return false;
        if (! super.equals(o)) return false;
        AssignmentExpression other = (AssignmentExpression) o;
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


