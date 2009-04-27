package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 2:  ModuleIds ::= ModuleId . ModuleIds
 *<li>Rule 3:  ModuleIds ::= ModuleId
 *</b>
 */
public class ModuleIdList extends AbstractAstList implements IModuleIds
{
    public Name getModuleIdAt(int i) { return (Name) getElementAt(i); }

    public ModuleIdList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public ModuleIdList(Name _ModuleId, boolean leftRecursive)
    {
        super((Ast) _ModuleId, leftRecursive);
        ((Ast) _ModuleId).setParent(this);
    }

    public void add(Name _ModuleId)
    {
        super.add((Ast) _ModuleId);
        ((Ast) _ModuleId).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof ModuleIdList)) return false;
        if (! super.equals(o)) return false;
        ModuleIdList other = (ModuleIdList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            Name element = getModuleIdAt(i);
            if (! element.equals(other.getModuleIdAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getModuleIdAt(i).hashCode());
        return hash;
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) v.visit(getModuleIdAt(i)); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) v.visit(getModuleIdAt(i), o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getModuleIdAt(i)));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getModuleIdAt(i), o));
        return result;
    }
}


