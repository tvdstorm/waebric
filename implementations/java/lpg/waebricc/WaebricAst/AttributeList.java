package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 89:  AttributeOpt ::= $Empty
 *<li>Rule 90:  AttributeOpt ::= Attributes
 *<li>Rule 91:  Attributes ::= Attribute Attributes
 *<li>Rule 92:  Attributes ::= Attribute
 *</b>
 */
public class AttributeList extends AbstractAstList implements IAttributeOpt, IAttributes
{
    public Attribute getAttributeAt(int i) { return (Attribute) getElementAt(i); }

    public AttributeList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public AttributeList(Attribute _Attribute, boolean leftRecursive)
    {
        super((Ast) _Attribute, leftRecursive);
        ((Ast) _Attribute).setParent(this);
    }

    public void add(Attribute _Attribute)
    {
        super.add((Ast) _Attribute);
        ((Ast) _Attribute).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof AttributeList)) return false;
        if (! super.equals(o)) return false;
        AttributeList other = (AttributeList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            Attribute element = getAttributeAt(i);
            if (! element.equals(other.getAttributeAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getAttributeAt(i).hashCode());
        return hash;
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) v.visit(getAttributeAt(i)); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) v.visit(getAttributeAt(i), o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getAttributeAt(i)));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getAttributeAt(i), o));
        return result;
    }
}


