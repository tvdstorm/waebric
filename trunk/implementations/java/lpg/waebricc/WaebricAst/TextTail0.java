package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 55:  TextTail ::= MidText Embed TextTail
 *</b>
 */
public class TextTail0 extends Ast implements ITextTail
{
    private Embed _Embed;
    private ITextTail _TextTail;

    public Embed getEmbed() { return _Embed; }
    public ITextTail getTextTail() { return _TextTail; }

    public TextTail0(IToken leftIToken, IToken rightIToken,
                     Embed _Embed,
                     ITextTail _TextTail)
    {
        super(leftIToken, rightIToken);

        this._Embed = _Embed;
        ((Ast) _Embed).setParent(this);
        this._TextTail = _TextTail;
        ((Ast) _TextTail).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Embed);
        list.add(_TextTail);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof TextTail0)) return false;
        if (! super.equals(o)) return false;
        TextTail0 other = (TextTail0) o;
        if (! _Embed.equals(other._Embed)) return false;
        if (! _TextTail.equals(other._TextTail)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Embed.hashCode());
        hash = hash * 31 + (_TextTail.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


