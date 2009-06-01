package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 148:  Attribute ::= @ IntegerLiteral$Width
 *</b>
 */
public class AttributeWidth extends Ast implements IAttribute
{
    private AstToken _Width;

    public AstToken getWidth() { return _Width; }

    public AttributeWidth(IToken leftIToken, IToken rightIToken,
                          AstToken _Width)
    {
        super(leftIToken, rightIToken);

        this._Width = _Width;
        ((Ast) _Width).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Width);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof AttributeWidth)) return false;
        if (! super.equals(o)) return false;
        AttributeWidth other = (AttributeWidth) o;
        if (! _Width.equals(other._Width)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Width.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


