package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 28:  Mapping ::= Path$Path : Markup
 *</b>
 */
public class Mapping extends Ast implements IMapping
{
    private AstToken _Path;
    private IMarkup _Markup;

    public AstToken getPath() { return _Path; }
    public IMarkup getMarkup() { return _Markup; }

    public Mapping(IToken leftIToken, IToken rightIToken,
                   AstToken _Path,
                   IMarkup _Markup)
    {
        super(leftIToken, rightIToken);

        this._Path = _Path;
        ((Ast) _Path).setParent(this);
        this._Markup = _Markup;
        ((Ast) _Markup).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Path);
        list.add(_Markup);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof Mapping)) return false;
        if (! super.equals(o)) return false;
        Mapping other = (Mapping) o;
        if (! _Path.equals(other._Path)) return false;
        if (! _Markup.equals(other._Markup)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Path.hashCode());
        hash = hash * 31 + (_Markup.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


