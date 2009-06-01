package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 115:  StatementComment ::= comment CommentLiteral$Comment ;
 *</b>
 */
public class StatementComment extends Ast implements IStatementComment
{
    private AstToken _Comment;

    public AstToken getComment() { return _Comment; }

    public StatementComment(IToken leftIToken, IToken rightIToken,
                            AstToken _Comment)
    {
        super(leftIToken, rightIToken);

        this._Comment = _Comment;
        ((Ast) _Comment).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Comment);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementComment)) return false;
        if (! super.equals(o)) return false;
        StatementComment other = (StatementComment) o;
        if (! _Comment.equals(other._Comment)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Comment.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


