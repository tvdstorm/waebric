package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 15:  Import ::= import ModuleIds
 *</b>
 */
public class Import extends Ast implements IImport
{
    private ModuleIdList _ModuleIds;

    public ModuleIdList getModuleIds() { return _ModuleIds; }

    public Import(IToken leftIToken, IToken rightIToken,
                  ModuleIdList _ModuleIds)
    {
        super(leftIToken, rightIToken);

        this._ModuleIds = _ModuleIds;
        ((Ast) _ModuleIds).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_ModuleIds);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof Import)) return false;
        if (! super.equals(o)) return false;
        Import other = (Import) o;
        if (! _ModuleIds.equals(other._ModuleIds)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_ModuleIds.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


