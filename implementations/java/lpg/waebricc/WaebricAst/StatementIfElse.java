package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 66:  StatementIfElse ::= StatementIf else Statement
 *</b>
 */
public class StatementIfElse extends Ast implements IStatementIfElse
{
    private StatementIf _StatementIf;
    private IStatement _Statement;

    public StatementIf getStatementIf() { return _StatementIf; }
    public IStatement getStatement() { return _Statement; }

    public StatementIfElse(IToken leftIToken, IToken rightIToken,
                           StatementIf _StatementIf,
                           IStatement _Statement)
    {
        super(leftIToken, rightIToken);

        this._StatementIf = _StatementIf;
        ((Ast) _StatementIf).setParent(this);
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
        list.add(_StatementIf);
        list.add(_Statement);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementIfElse)) return false;
        if (! super.equals(o)) return false;
        StatementIfElse other = (StatementIfElse) o;
        if (! _StatementIf.equals(other._StatementIf)) return false;
        if (! _Statement.equals(other._Statement)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_StatementIf.hashCode());
        hash = hash * 31 + (_Statement.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


