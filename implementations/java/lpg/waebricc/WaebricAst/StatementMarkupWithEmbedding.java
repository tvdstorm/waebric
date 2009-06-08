package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 123:  StatementMarkup ::= Markups Embedding ;
 *</b>
 */
public class StatementMarkupWithEmbedding extends Ast implements IStatementMarkup
{
    private MarkupList _Markups;
    private Embedding _Embedding;

    public MarkupList getMarkups() { return _Markups; }
    public Embedding getEmbedding() { return _Embedding; }

    public StatementMarkupWithEmbedding(IToken leftIToken, IToken rightIToken,
                                        MarkupList _Markups,
                                        Embedding _Embedding)
    {
        super(leftIToken, rightIToken);

        this._Markups = _Markups;
        ((Ast) _Markups).setParent(this);
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
        list.add(_Markups);
        list.add(_Embedding);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementMarkupWithEmbedding)) return false;
        if (! super.equals(o)) return false;
        StatementMarkupWithEmbedding other = (StatementMarkupWithEmbedding) o;
        if (! _Markups.equals(other._Markups)) return false;
        if (! _Embedding.equals(other._Embedding)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Markups.hashCode());
        hash = hash * 31 + (_Embedding.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


