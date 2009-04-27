package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 1:  Module ::= module ModuleIds ModuleBlockOpt
 *</b>
 */
public class Module extends Ast implements IModule
{
    private ModuleIdList _ModuleIds;
    private ModuleBlockList _ModuleBlockOpt;

    public ModuleIdList getModuleIds() { return _ModuleIds; }
    public ModuleBlockList getModuleBlockOpt() { return _ModuleBlockOpt; }

    public Module(IToken leftIToken, IToken rightIToken,
                  ModuleIdList _ModuleIds,
                  ModuleBlockList _ModuleBlockOpt)
    {
        super(leftIToken, rightIToken);

        this._ModuleIds = _ModuleIds;
        ((Ast) _ModuleIds).setParent(this);
        this._ModuleBlockOpt = _ModuleBlockOpt;
        ((Ast) _ModuleBlockOpt).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_ModuleIds);
        list.add(_ModuleBlockOpt);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof Module)) return false;
        if (! super.equals(o)) return false;
        Module other = (Module) o;
        if (! _ModuleIds.equals(other._ModuleIds)) return false;
        if (! _ModuleBlockOpt.equals(other._ModuleBlockOpt)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_ModuleIds.hashCode());
        hash = hash * 31 + (_ModuleBlockOpt.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


