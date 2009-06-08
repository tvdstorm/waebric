package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 1:  Modules ::= $Empty
 *<li>Rule 2:  Modules ::= Modules Module
 *</b>
 */
public class ModuleList extends AbstractAstList implements IModules
{
    public Module getModuleAt(int i) { return (Module) getElementAt(i); }

    public ModuleList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public ModuleList(Module _Module, boolean leftRecursive)
    {
        super((Ast) _Module, leftRecursive);
        ((Ast) _Module).setParent(this);
    }

    public void add(Module _Module)
    {
        super.add((Ast) _Module);
        ((Ast) _Module).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof ModuleList)) return false;
        if (! super.equals(o)) return false;
        ModuleList other = (ModuleList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            Module element = getModuleAt(i);
            if (! element.equals(other.getModuleAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getModuleAt(i).hashCode());
        return hash;
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) v.visit(getModuleAt(i)); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) v.visit(getModuleAt(i), o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getModuleAt(i)));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getModuleAt(i), o));
        return result;
    }
}


