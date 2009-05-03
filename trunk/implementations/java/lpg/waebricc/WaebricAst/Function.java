package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 94:  Function ::= def IDENTIFIER$Name ( ParameterDeclOpt ) StatementOpt end
 *</b>
 */
public class Function extends Ast implements IFunction
{
    private AstToken _Name;
    private ParameterDeclList _ParameterDeclOpt;
    private StatementList _StatementOpt;

    public AstToken getName() { return _Name; }
    public ParameterDeclList getParameterDeclOpt() { return _ParameterDeclOpt; }
    public StatementList getStatementOpt() { return _StatementOpt; }

    public Function(IToken leftIToken, IToken rightIToken,
                    AstToken _Name,
                    ParameterDeclList _ParameterDeclOpt,
                    StatementList _StatementOpt)
    {
        super(leftIToken, rightIToken);

        this._Name = _Name;
        ((Ast) _Name).setParent(this);
        this._ParameterDeclOpt = _ParameterDeclOpt;
        ((Ast) _ParameterDeclOpt).setParent(this);
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
        list.add(_Name);
        list.add(_ParameterDeclOpt);
        list.add(_StatementOpt);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof Function)) return false;
        if (! super.equals(o)) return false;
        Function other = (Function) o;
        if (! _Name.equals(other._Name)) return false;
        if (! _ParameterDeclOpt.equals(other._ParameterDeclOpt)) return false;
        if (! _StatementOpt.equals(other._StatementOpt)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Name.hashCode());
        hash = hash * 31 + (_ParameterDeclOpt.hashCode());
        hash = hash * 31 + (_StatementOpt.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


