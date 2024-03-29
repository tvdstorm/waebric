package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 121:  StatementMarkup ::= Markups Designator ArgumentsOpt ;
 *</b>
 */
public class StatementMarkupWithDesignator extends Ast implements IStatementMarkup
{
    private MarkupList _Markups;
    private Designator _Designator;
    private ArgumentList _ArgumentsOpt;

    public MarkupList getMarkups() { return _Markups; }
    public Designator getDesignator() { return _Designator; }
    public ArgumentList getArgumentsOpt() { return _ArgumentsOpt; }

    public StatementMarkupWithDesignator(IToken leftIToken, IToken rightIToken,
                                         MarkupList _Markups,
                                         Designator _Designator,
                                         ArgumentList _ArgumentsOpt)
    {
        super(leftIToken, rightIToken);

        this._Markups = _Markups;
        ((Ast) _Markups).setParent(this);
        this._Designator = _Designator;
        ((Ast) _Designator).setParent(this);
        this._ArgumentsOpt = _ArgumentsOpt;
        ((Ast) _ArgumentsOpt).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Markups);
        list.add(_Designator);
        list.add(_ArgumentsOpt);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementMarkupWithDesignator)) return false;
        if (! super.equals(o)) return false;
        StatementMarkupWithDesignator other = (StatementMarkupWithDesignator) o;
        if (! _Markups.equals(other._Markups)) return false;
        if (! _Designator.equals(other._Designator)) return false;
        if (! _ArgumentsOpt.equals(other._ArgumentsOpt)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Markups.hashCode());
        hash = hash * 31 + (_Designator.hashCode());
        hash = hash * 31 + (_ArgumentsOpt.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


