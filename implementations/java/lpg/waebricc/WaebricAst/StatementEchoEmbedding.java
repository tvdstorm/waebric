package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 76:  StatementEchoEmbedding ::= echo Embedding ;
 *</b>
 */
public class StatementEchoEmbedding extends Ast implements IStatementEchoEmbedding
{
    private Embedding _Embedding;

    public Embedding getEmbedding() { return _Embedding; }

    public StatementEchoEmbedding(IToken leftIToken, IToken rightIToken,
                                  Embedding _Embedding)
    {
        super(leftIToken, rightIToken);

        this._Embedding = _Embedding;
        ((Ast) _Embedding).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Embedding);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementEchoEmbedding)) return false;
        if (! super.equals(o)) return false;
        StatementEchoEmbedding other = (StatementEchoEmbedding) o;
        if (! _Embedding.equals(other._Embedding)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Embedding.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


