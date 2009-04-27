package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 24:  MarkupOpt ::= $Empty
 *<li>Rule 25:  MarkupOpt ::= Markups
 *<li>Rule 26:  Markups ::= Markup Markups
 *<li>Rule 27:  Markups ::= Markup
 *</b>
 */
public class MarkupList extends AbstractAstList implements IMarkupOpt, IMarkups
{
    public Markup getMarkupAt(int i) { return (Markup) getElementAt(i); }

    public MarkupList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public MarkupList(Markup _Markup, boolean leftRecursive)
    {
        super((Ast) _Markup, leftRecursive);
        ((Ast) _Markup).setParent(this);
    }

    public void add(Markup _Markup)
    {
        super.add((Ast) _Markup);
        ((Ast) _Markup).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof MarkupList)) return false;
        if (! super.equals(o)) return false;
        MarkupList other = (MarkupList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            Markup element = getMarkupAt(i);
            if (! element.equals(other.getMarkupAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getMarkupAt(i).hashCode());
        return hash;
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) v.visit(getMarkupAt(i)); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) v.visit(getMarkupAt(i), o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getMarkupAt(i)));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getMarkupAt(i), o));
        return result;
    }
}


