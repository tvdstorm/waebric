package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 64:  KeyValuePairOpt ::= $Empty
 *<li>Rule 65:  KeyValuePairOpt ::= KeyValuePairs
 *<li>Rule 66:  KeyValuePairs ::= KeyValuePair , KeyValuePairs
 *<li>Rule 67:  KeyValuePairs ::= KeyValuePair
 *</b>
 */
public class KeyValuePairList extends AbstractAstList implements IKeyValuePairOpt, IKeyValuePairs
{
    public KeyValuePair getKeyValuePairAt(int i) { return (KeyValuePair) getElementAt(i); }

    public KeyValuePairList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public KeyValuePairList(KeyValuePair _KeyValuePair, boolean leftRecursive)
    {
        super((Ast) _KeyValuePair, leftRecursive);
        ((Ast) _KeyValuePair).setParent(this);
    }

    public void add(KeyValuePair _KeyValuePair)
    {
        super.add((Ast) _KeyValuePair);
        ((Ast) _KeyValuePair).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof KeyValuePairList)) return false;
        if (! super.equals(o)) return false;
        KeyValuePairList other = (KeyValuePairList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            KeyValuePair element = getKeyValuePairAt(i);
            if (! element.equals(other.getKeyValuePairAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getKeyValuePairAt(i).hashCode());
        return hash;
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) v.visit(getKeyValuePairAt(i)); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) v.visit(getKeyValuePairAt(i), o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getKeyValuePairAt(i)));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getKeyValuePairAt(i), o));
        return result;
    }
}


