package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 19:  FileName ::= IDENTIFIER$Name . IDENTIFIER$Extension
 *</b>
 */
public class FileName extends Ast implements IFileName
{
    private AstToken _Name;
    private AstToken _Extension;

    public AstToken getName() { return _Name; }
    public AstToken getExtension() { return _Extension; }

    public FileName(IToken leftIToken, IToken rightIToken,
                    AstToken _Name,
                    AstToken _Extension)
    {
        super(leftIToken, rightIToken);

        this._Name = _Name;
        ((Ast) _Name).setParent(this);
        this._Extension = _Extension;
        ((Ast) _Extension).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_Name);
        list.add(_Extension);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof FileName)) return false;
        if (! super.equals(o)) return false;
        FileName other = (FileName) o;
        if (! _Name.equals(other._Name)) return false;
        if (! _Extension.equals(other._Extension)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_Name.hashCode());
        hash = hash * 31 + (_Extension.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


