package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 20:  DirNames ::= DirName DirNames
 *<li>Rule 21:  DirNames ::= DirName
 *</b>
 */
public class DirNameList extends AbstractAstList implements IDirNames
{
    public DirName getDirNameAt(int i) { return (DirName) getElementAt(i); }

    public DirNameList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public DirNameList(DirName _DirName, boolean leftRecursive)
    {
        super((Ast) _DirName, leftRecursive);
        ((Ast) _DirName).setParent(this);
    }

    public void add(DirName _DirName)
    {
        super.add((Ast) _DirName);
        ((Ast) _DirName).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof DirNameList)) return false;
        if (! super.equals(o)) return false;
        DirNameList other = (DirNameList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            DirName element = getDirNameAt(i);
            if (! element.equals(other.getDirNameAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getDirNameAt(i).hashCode());
        return hash;
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) v.visit(getDirNameAt(i)); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) v.visit(getDirNameAt(i), o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getDirNameAt(i)));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getDirNameAt(i), o));
        return result;
    }
}


