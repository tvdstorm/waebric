package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 68:  StatementBlock ::= { Var }
 *</b>
 */
public class StatementBlock extends Ast implements IStatementBlock
{
    private Var _Var;

    public Var getVar() { return _Var; }

    public StatementBlock(IToken leftIToken, IToken rightIToken,
                          Var _Var)
    {
        super(leftIToken, rightIToken);

        this._Var = _Var;
        ((Ast) _Var).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Var);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementBlock)) return false;
        if (! super.equals(o)) return false;
        StatementBlock other = (StatementBlock) o;
        if (! _Var.equals(other._Var)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Var.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


