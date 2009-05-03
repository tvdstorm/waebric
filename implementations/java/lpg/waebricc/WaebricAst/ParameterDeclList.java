package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 95:  ParameterDeclOpt ::= $Empty
 *<li>Rule 96:  ParameterDeclOpt ::= ParameterDecls
 *<li>Rule 97:  ParameterDecls ::= ParameterDecl , ParameterDecls
 *<li>Rule 98:  ParameterDecls ::= ParameterDecl
 *</b>
 */
public class ParameterDeclList extends AbstractAstList implements IParameterDeclOpt, IParameterDecls
{
    public Name getParameterDeclAt(int i) { return (Name) getElementAt(i); }

    public ParameterDeclList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public ParameterDeclList(Name _ParameterDecl, boolean leftRecursive)
    {
        super((Ast) _ParameterDecl, leftRecursive);
        ((Ast) _ParameterDecl).setParent(this);
    }

    public void add(Name _ParameterDecl)
    {
        super.add((Ast) _ParameterDecl);
        ((Ast) _ParameterDecl).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof ParameterDeclList)) return false;
        if (! super.equals(o)) return false;
        ParameterDeclList other = (ParameterDeclList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            Name element = getParameterDeclAt(i);
            if (! element.equals(other.getParameterDeclAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getParameterDeclAt(i).hashCode());
        return hash;
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) v.visit(getParameterDeclAt(i)); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) v.visit(getParameterDeclAt(i), o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getParameterDeclAt(i)));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getParameterDeclAt(i), o));
        return result;
    }
}


