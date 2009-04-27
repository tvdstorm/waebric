package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 22:  DirName ::= IDENTIFIER$Name /
 *</b>
 */
public class DirName extends Ast implements IDirName
{
    private AstToken _Name;

    public AstToken getName() { return _Name; }

    public DirName(IToken leftIToken, IToken rightIToken,
                   AstToken _Name)
    {
        super(leftIToken, rightIToken);

        this._Name = _Name;
        ((Ast) _Name).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Name);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof DirName)) return false;
        if (! super.equals(o)) return false;
        DirName other = (DirName) o;
        if (! _Name.equals(other._Name)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Name.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


