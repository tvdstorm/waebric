package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 70:  TextTail ::= MidText$MidText Embed TextTail
 *</b>
 */
public class TextTailMidText extends Ast implements ITextTail
{
    private AstToken _MidText;
    private Embed _Embed;
    private ITextTail _TextTail;

    public AstToken getMidText() { return _MidText; }
    public Embed getEmbed() { return _Embed; }
    public ITextTail getTextTail() { return _TextTail; }

    public TextTailMidText(IToken leftIToken, IToken rightIToken,
                           AstToken _MidText,
                           Embed _Embed,
                           ITextTail _TextTail)
    {
        super(leftIToken, rightIToken);

        this._MidText = _MidText;
        ((Ast) _MidText).setParent(this);
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
        list.add(_MidText);
        list.add(_Embed);
        list.add(_TextTail);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof TextTailMidText)) return false;
        if (! super.equals(o)) return false;
        TextTailMidText other = (TextTailMidText) o;
        if (! _MidText.equals(other._MidText)) return false;
        if (! _Embed.equals(other._Embed)) return false;
        if (! _TextTail.equals(other._TextTail)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_MidText.hashCode());
        hash = hash * 31 + (_Embed.hashCode());
        hash = hash * 31 + (_TextTail.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


