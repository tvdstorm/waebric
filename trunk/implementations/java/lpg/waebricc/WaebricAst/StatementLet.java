package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 67:  StatementLet ::= let Assignments in StatementOpt end
 *</b>
 */
public class StatementLet extends Ast implements IStatementLet
{
    private AssignmentList _Assignments;
    private StatementList _StatementOpt;

    public AssignmentList getAssignments() { return _Assignments; }
    public StatementList getStatementOpt() { return _StatementOpt; }

    public StatementLet(IToken leftIToken, IToken rightIToken,
                        AssignmentList _Assignments,
                        StatementList _StatementOpt)
    {
        super(leftIToken, rightIToken);

        this._Assignments = _Assignments;
        ((Ast) _Assignments).setParent(this);
        this._StatementOpt = _StatementOpt;
        ((Ast) _StatementOpt).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Assignments);
        list.add(_StatementOpt);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementLet)) return false;
        if (! super.equals(o)) return false;
        StatementLet other = (StatementLet) o;
        if (! _Assignments.equals(other._Assignments)) return false;
        if (! _StatementOpt.equals(other._StatementOpt)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Assignments.hashCode());
        hash = hash * 31 + (_StatementOpt.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


