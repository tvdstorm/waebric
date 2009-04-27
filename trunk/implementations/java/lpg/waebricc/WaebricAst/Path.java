package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<em>
 *<li>Rule 18:  Path ::= FileName
 *</em>
 *<p>
 *<b>
 *<li>Rule 17:  Path ::= DirNames FileName
 *</b>
 */
public class Path extends Ast implements IPath
{
    private DirNameList _DirNames;
    private FileName _FileName;

    public DirNameList getDirNames() { return _DirNames; }
    public FileName getFileName() { return _FileName; }

    public Path(IToken leftIToken, IToken rightIToken,
                DirNameList _DirNames,
                FileName _FileName)
    {
        super(leftIToken, rightIToken);

        this._DirNames = _DirNames;
        ((Ast) _DirNames).setParent(this);
        this._FileName = _FileName;
        ((Ast) _FileName).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_DirNames);
        list.add(_FileName);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof Path)) return false;
        if (! super.equals(o)) return false;
        Path other = (Path) o;
        if (! _DirNames.equals(other._DirNames)) return false;
        if (! _FileName.equals(other._FileName)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_DirNames.hashCode());
        hash = hash * 31 + (_FileName.hashCode());
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


