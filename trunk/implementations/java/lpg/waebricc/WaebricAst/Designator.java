package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 88:  Designator ::= IDENTIFIER$Name AttributeOpt
 *</b>
 */
public class Designator extends Ast implements IDesignator
{
    private AstToken _Name;
    private AttributeList _AttributeOpt;

    public AstToken getName() { return _Name; }
    public AttributeList getAttributeOpt() { return _AttributeOpt; }

    public Designator(IToken leftIToken, IToken rightIToken,
                      AstToken _Name,
                      AttributeList _AttributeOpt)
    {
        super(leftIToken, rightIToken);

        this._Name = _Name;
        ((Ast) _Name).setParent(this);
        this._AttributeOpt = _AttributeOpt;
        ((Ast) _AttributeOpt).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Name);
        list.add(_AttributeOpt);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof Designator)) return false;
        if (! super.equals(o)) return false;
        Designator other = (Designator) o;
        if (! _Name.equals(other._Name)) return false;
        if (! _AttributeOpt.equals(other._AttributeOpt)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Name.hashCode());
        hash = hash * 31 + (_AttributeOpt.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


