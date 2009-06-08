package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 14:  Site ::= site MappingsOpt end
 *</b>
 */
public class Site extends Ast implements ISite
{
    private MappingList _MappingsOpt;

    public MappingList getMappingsOpt() { return _MappingsOpt; }

    public Site(IToken leftIToken, IToken rightIToken,
                MappingList _MappingsOpt)
    {
        super(leftIToken, rightIToken);

        this._MappingsOpt = _MappingsOpt;
        ((Ast) _MappingsOpt).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_MappingsOpt);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof Site)) return false;
        if (! super.equals(o)) return false;
        Site other = (Site) o;
        if (! _MappingsOpt.equals(other._MappingsOpt)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_MappingsOpt.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


