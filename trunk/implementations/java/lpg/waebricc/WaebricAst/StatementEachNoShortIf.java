package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 108:  StatementEachNoShortIf ::= each ( Var : Expression ) StatementNoShortIf
 *</b>
 */
public class StatementEachNoShortIf extends Ast implements IStatementEachNoShortIf
{
    private Var _Var;
    private IExpression _Expression;
    private IStatementNoShortIf _StatementNoShortIf;

    public Var getVar() { return _Var; }
    public IExpression getExpression() { return _Expression; }
    public IStatementNoShortIf getStatementNoShortIf() { return _StatementNoShortIf; }

    public StatementEachNoShortIf(IToken leftIToken, IToken rightIToken,
                                  Var _Var,
                                  IExpression _Expression,
                                  IStatementNoShortIf _StatementNoShortIf)
    {
        super(leftIToken, rightIToken);

        this._Var = _Var;
        ((Ast) _Var).setParent(this);
        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
        this._StatementNoShortIf = _StatementNoShortIf;
        ((Ast) _StatementNoShortIf).setParent(this);
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
        list.add(_StatementNoShortIf);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementEachNoShortIf)) return false;
        if (! super.equals(o)) return false;
        StatementEachNoShortIf other = (StatementEachNoShortIf) o;
        if (! _Var.equals(other._Var)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        if (! _StatementNoShortIf.equals(other._StatementNoShortIf)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Var.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        hash = hash * 31 + (_StatementNoShortIf.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


