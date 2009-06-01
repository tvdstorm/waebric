package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 149:  Attribute ::= @ IntegerLiteral$Width % IntegerLiteral$Height
 *</b>
 */
public class AttributeWidthHeight extends Ast implements IAttribute
{
    private AstToken _Width;
    private AstToken _Height;

    public AstToken getWidth() { return _Width; }
    public AstToken getHeight() { return _Height; }

    public AttributeWidthHeight(IToken leftIToken, IToken rightIToken,
                                AstToken _Width,
                                AstToken _Height)
    {
        super(leftIToken, rightIToken);

        this._Width = _Width;
        ((Ast) _Width).setParent(this);
        this._Height = _Height;
        ((Ast) _Height).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Width);
        list.add(_Height);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof AttributeWidthHeight)) return false;
        if (! super.equals(o)) return false;
        AttributeWidthHeight other = (AttributeWidthHeight) o;
        if (! _Width.equals(other._Width)) return false;
        if (! _Height.equals(other._Height)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Width.hashCode());
        hash = hash * 31 + (_Height.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


