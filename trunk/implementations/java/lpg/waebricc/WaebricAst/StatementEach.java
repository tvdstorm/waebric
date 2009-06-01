package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 107:  StatementEach ::= each ( Var : Expression ) Statement
 *</b>
 */
public class StatementEach extends Ast implements IStatementEach
{
    private Var _Var;
    private IExpression _Expression;
    private IStatement _Statement;

    public Var getVar() { return _Var; }
    public IExpression getExpression() { return _Expression; }
    public IStatement getStatement() { return _Statement; }

    public StatementEach(IToken leftIToken, IToken rightIToken,
                         Var _Var,
                         IExpression _Expression,
                         IStatement _Statement)
    {
        super(leftIToken, rightIToken);

        this._Var = _Var;
        ((Ast) _Var).setParent(this);
        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
        this._Statement = _Statement;
        ((Ast) _Statement).setParent(this);
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
        list.add(_Statement);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementEach)) return false;
        if (! super.equals(o)) return false;
        StatementEach other = (StatementEach) o;
        if (! _Var.equals(other._Var)) return false;
        if (! _Expression.equals(other._Expression)) return false;
        if (! _Statement.equals(other._Statement)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Var.hashCode());
        hash = hash * 31 + (_Expression.hashCode());
        hash = hash * 31 + (_Statement.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


