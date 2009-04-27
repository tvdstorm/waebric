package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 46:  ExpressionMember ::= Expression . IDENTIFIER$Member
 *</b>
 */
public class ExpressionMember extends Ast implements IExpressionMember
{
    private IExpression _Expression;
    private AstToken _Member;

    public IExpression getExpression() { return _Expression; }
    public AstToken getMember() { return _Member; }

    public ExpressionMember(IToken leftIToken, IToken rightIToken,
                            IExpression _Expression,
                            AstToken _Member)
    {
        super(leftIToken, rightIToken);

        this._Expression = _Expression;
        ((Ast) _Expression).setParent(this);
        this._Member = _Member;
        ((Ast) _Member).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Expression);
        list.add(_Member);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof ExpressionMember)) return false;
        if (! super.equals(o)) return false;
        ExpressionMember other = (ExpressionMember) o;
        if (! _Expression.equals(other._Expression)) return false;
        if (! _Member.equals(other._Member)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Expression.hashCode());
        hash = hash * 31 + (_Member.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


