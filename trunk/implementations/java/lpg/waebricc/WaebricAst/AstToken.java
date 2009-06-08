package waebricc.WaebricAst;

import lpg.runtime.*;

public class AstToken extends Ast implements IAstToken
{
    public AstToken(IToken token) { super(token); }
    public IToken getIToken() { return leftIToken; }
    public String toString() { return leftIToken.toString(); }

    /**
     * A token class has no children. So, we return the empty list.
     */
    public java.util.ArrayList getAllChildren() { return new java.util.ArrayList(); }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof AstToken)) return false;
        AstToken other = (AstToken) o;
        return getIToken().getLexStream() == other.getIToken().getLexStream() &&
               getIToken().getTokenIndex() == other.getIToken().getTokenIndex();
    }

    public int hashCode()
    {
        int hash = 7;
        if (getIToken().getLexStream() != null) hash = hash * 31 + getIToken().getLexStream().hashCode();
        hash = hash * 31 + getIToken().getTokenIndex();
        return hash;
    }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


