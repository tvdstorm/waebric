package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 138:  Assignment ::= IDENTIFIER$Name ParameterDeclOpt = Statement
 *</b>
 */
public class AssignmentStatement extends Ast implements IAssignment
{
    private AstToken _Name;
    private ParameterDeclList _ParameterDeclOpt;
    private IStatement _Statement;

    public AstToken getName() { return _Name; }
    public ParameterDeclList getParameterDeclOpt() { return _ParameterDeclOpt; }
    public IStatement getStatement() { return _Statement; }

    public AssignmentStatement(IToken leftIToken, IToken rightIToken,
                               AstToken _Name,
                               ParameterDeclList _ParameterDeclOpt,
                               IStatement _Statement)
    {
        super(leftIToken, rightIToken);

        this._Name = _Name;
        ((Ast) _Name).setParent(this);
        this._ParameterDeclOpt = _ParameterDeclOpt;
        ((Ast) _ParameterDeclOpt).setParent(this);
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
        list.add(_Name);
        list.add(_ParameterDeclOpt);
        list.add(_Statement);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof AssignmentStatement)) return false;
        if (! super.equals(o)) return false;
        AssignmentStatement other = (AssignmentStatement) o;
        if (! _Name.equals(other._Name)) return false;
        if (! _ParameterDeclOpt.equals(other._ParameterDeclOpt)) return false;
        if (! _Statement.equals(other._Statement)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Name.hashCode());
        hash = hash * 31 + (_ParameterDeclOpt.hashCode());
        hash = hash * 31 + (_Statement.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


