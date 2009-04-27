package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 12:  MappingsOpt ::= $Empty
 *<li>Rule 13:  MappingsOpt ::= Mappings
 *<li>Rule 14:  Mappings ::= Mapping ; Mappings
 *<li>Rule 15:  Mappings ::= Mapping ;
 *</b>
 */
public class MappingList extends AbstractAstList implements IMappingsOpt, IMappings
{
    public Mapping getMappingAt(int i) { return (Mapping) getElementAt(i); }

    public MappingList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public MappingList(Mapping _Mapping, boolean leftRecursive)
    {
        super((Ast) _Mapping, leftRecursive);
        ((Ast) _Mapping).setParent(this);
    }

    public void add(Mapping _Mapping)
    {
        super.add((Ast) _Mapping);
        ((Ast) _Mapping).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof MappingList)) return false;
        if (! super.equals(o)) return false;
        MappingList other = (MappingList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            Mapping element = getMappingAt(i);
            if (! element.equals(other.getMappingAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getMappingAt(i).hashCode());
        return hash;
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) v.visit(getMappingAt(i)); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) v.visit(getMappingAt(i), o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getMappingAt(i)));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getMappingAt(i), o));
        return result;
    }
}


