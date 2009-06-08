package waebricc.WaebricAst;

import lpg.runtime.*;

public abstract class Ast implements IAst
{
    public IAst getNextAst() { return null; }
    protected IToken leftIToken,
                     rightIToken;
    protected IAst parent = null;
    protected void setParent(IAst parent) { this.parent = parent; }
    public IAst getParent() { return parent; }

    public IToken getLeftIToken() { return leftIToken; }
    public IToken getRightIToken() { return rightIToken; }
    public IToken[] getPrecedingAdjuncts() { return leftIToken.getPrecedingAdjuncts(); }
    public IToken[] getFollowingAdjuncts() { return rightIToken.getFollowingAdjuncts(); }

    public String toString()
    {
        return leftIToken.getLexStream().toString(leftIToken.getStartOffset(), rightIToken.getEndOffset());
    }

    public Ast(IToken token) { this.leftIToken = this.rightIToken = token; }
    public Ast(IToken leftIToken, IToken rightIToken)
    {
        this.leftIToken = leftIToken;
        this.rightIToken = rightIToken;
    }

    void initialize() {}

    /**
     * A list of all children of this node, excluding the null ones.
     */
    public java.util.ArrayList getChildren()
    {
        java.util.ArrayList list = getAllChildren();
        int k = -1;
        for (int i = 0; i < list.size(); i++)
        {
            Object element = list.get(i);
            if (element != null)
            {
                if (++k != i)
                    list.set(k, element);
            }
        }
        for (int i = list.size() - 1; i > k; i--) // remove extraneous elements
            list.remove(i);
        return list;
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public abstract java.util.ArrayList getAllChildren();

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof Ast)) return false;
        Ast other = (Ast) o;
        return getLeftIToken().getLexStream() == other.getLeftIToken().getLexStream() &&
               getLeftIToken().getTokenIndex() == other.getLeftIToken().getTokenIndex() &&
               getRightIToken().getLexStream() == other.getRightIToken().getLexStream() &&
               getRightIToken().getTokenIndex() == other.getRightIToken().getTokenIndex();
    }

    public int hashCode()
    {
        int hash = 7;
        if (getLeftIToken().getLexStream() != null) hash = hash * 31 + getLeftIToken().getLexStream().hashCode();
        hash = hash * 31 + getLeftIToken().getTokenIndex();
        if (getRightIToken().getLexStream() != null) hash = hash * 31 + getRightIToken().getLexStream().hashCode();
        hash = hash * 31 + getRightIToken().getTokenIndex();
        return hash;
    }
    public abstract void accept(Visitor v);
    public abstract void accept(ArgumentVisitor v, Object o);
    public abstract Object accept(ResultVisitor v);
    public abstract Object accept(ResultArgumentVisitor v, Object o);
    public void accept(IAstVisitor v) {}
}


