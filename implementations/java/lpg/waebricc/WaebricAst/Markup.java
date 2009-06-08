package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<em>
 *<li>Rule 29:  Markup ::= Designator
 *</em>
 *<p>
 *<b>
 *<li>Rule 30:  Markup ::= Designator ArgumentsOpt
 *</b>
 */
public class Markup extends Ast implements IMarkup
{
    private Designator _Designator;
    private ArgumentList _ArgumentsOpt;

    public Designator getDesignator() { return _Designator; }
    public ArgumentList getArgumentsOpt() { return _ArgumentsOpt; }

    public Markup(IToken leftIToken, IToken rightIToken,
                  Designator _Designator,
                  ArgumentList _ArgumentsOpt)
    {
        super(leftIToken, rightIToken);

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
        list.add(_Designator);
        list.add(_ArgumentsOpt);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof Markup)) return false;
        if (! super.equals(o)) return false;
        Markup other = (Markup) o;
        if (! _Designator.equals(other._Designator)) return false;
        if (! _ArgumentsOpt.equals(other._ArgumentsOpt)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Designator.hashCode());
        hash = hash * 31 + (_ArgumentsOpt.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


