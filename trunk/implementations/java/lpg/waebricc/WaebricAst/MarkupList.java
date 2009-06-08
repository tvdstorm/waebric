package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 31:  MarkupOpt ::= $Empty
 *<li>Rule 32:  MarkupOpt ::= Markups
 *<li>Rule 33:  Markups ::= Markups Markup
 *<li>Rule 34:  Markups ::= Markup
 *</b>
 */
public class MarkupList extends AbstractAstList implements IMarkupOpt, IMarkups
{
    public IMarkup getMarkupAt(int i) { return (IMarkup) getElementAt(i); }

    public MarkupList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public MarkupList(IMarkup _Markup, boolean leftRecursive)
    {
        super((Ast) _Markup, leftRecursive);
        ((Ast) _Markup).setParent(this);
    }

    public void add(IMarkup _Markup)
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
            IMarkup element = getMarkupAt(i);
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

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getMarkupAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getMarkupAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getMarkupAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getMarkupAt(i).accept(v, o));
        return result;
    }
}


