package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 7:  ModuleBlockOpt ::= $Empty
 *<li>Rule 8:  ModuleBlockOpt ::= ModuleBlocks
 *<li>Rule 9:  ModuleBlocks ::= ModuleBlock ModuleBlocks
 *<li>Rule 10:  ModuleBlocks ::= ModuleBlock
 *</b>
 */
public class ModuleBlockList extends AbstractAstList implements IModuleBlockOpt, IModuleBlocks
{
    public IModuleBlock getModuleBlockAt(int i) { return (IModuleBlock) getElementAt(i); }

    public ModuleBlockList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public ModuleBlockList(IModuleBlock _ModuleBlock, boolean leftRecursive)
    {
        super((Ast) _ModuleBlock, leftRecursive);
        ((Ast) _ModuleBlock).setParent(this);
    }

    public void add(IModuleBlock _ModuleBlock)
    {
        super.add((Ast) _ModuleBlock);
        ((Ast) _ModuleBlock).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof ModuleBlockList)) return false;
        if (! super.equals(o)) return false;
        ModuleBlockList other = (ModuleBlockList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            IModuleBlock element = getModuleBlockAt(i);
            if (! element.equals(other.getModuleBlockAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getModuleBlockAt(i).hashCode());
        return hash;
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getModuleBlockAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getModuleBlockAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getModuleBlockAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getModuleBlockAt(i).accept(v, o));
        return result;
    }
}


