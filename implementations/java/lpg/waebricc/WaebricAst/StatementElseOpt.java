package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<em>
 *<li>Rule 68:  StatementElseOpt ::= $Empty
 *</em>
 *<p>
 *<b>
 *<li>Rule 69:  StatementElseOpt ::= else Statement
 *</b>
 */
public class StatementElseOpt extends Ast implements IStatementElseOpt
{
    private IStatement _Statement;

    public IStatement getStatement() { return _Statement; }

    public StatementElseOpt(IToken leftIToken, IToken rightIToken,
                            IStatement _Statement)
    {
        super(leftIToken, rightIToken);

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
        list.add(_Statement);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementElseOpt)) return false;
        if (! super.equals(o)) return false;
        StatementElseOpt other = (StatementElseOpt) o;
        if (! _Statement.equals(other._Statement)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Statement.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


