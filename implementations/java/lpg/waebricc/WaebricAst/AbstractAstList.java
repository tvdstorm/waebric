package waebricc.WaebricAst;

import lpg.runtime.*;

public abstract class AbstractAstList extends Ast
{
    private boolean leftRecursive;
    private java.util.ArrayList list;
    public int size() { return list.size(); }
    public Ast getElementAt(int i) { return (Ast) list.get(leftRecursive ? i : list.size() - 1 - i); }
    public java.util.ArrayList getArrayList()
    {
        if (! leftRecursive) // reverse the list 
        {
            for (int i = 0, n = list.size() - 1; i < n; i++, n--)
            {
                Object ith = list.get(i),
                       nth = list.get(n);
                list.set(i, nth);
                list.set(n, ith);
            }
            leftRecursive = true;
        }
        return list;
    }
    public void add(Ast element)
    {
        list.add(element);
        if (leftRecursive)
             rightIToken = element.getRightIToken();
        else leftIToken = element.getLeftIToken();
    }

    public AbstractAstList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken);
        this.leftRecursive = leftRecursive;
        list = new java.util.ArrayList();
    }

    public AbstractAstList(Ast element, boolean leftRecursive)
    {
        this(element.getLeftIToken(), element.getRightIToken(), leftRecursive);
        list.add(element);
    }

    /**
     * Make a copy of the list and return it. Note that we obtain the local list by
     * invoking getArrayList so as to make sure that the list we return is in proper order.
     */
    public java.util.ArrayList getAllChildren()
    {
        return (java.util.ArrayList) getArrayList().clone();
    }

}


