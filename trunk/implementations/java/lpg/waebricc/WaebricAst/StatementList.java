package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 111:  StatementOpt ::= $Empty
 *<li>Rule 112:  StatementOpt ::= Statements
 *<li>Rule 113:  Statements ::= Statements Statement
 *<li>Rule 114:  Statements ::= Statement
 *</b>
 */
public class StatementList extends AbstractAstList implements IStatementOpt, IStatements
{
    public IStatement getStatementAt(int i) { return (IStatement) getElementAt(i); }

    public StatementList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public StatementList(IStatement _Statement, boolean leftRecursive)
    {
        super((Ast) _Statement, leftRecursive);
        ((Ast) _Statement).setParent(this);
    }

    public void add(IStatement _Statement)
    {
        super.add((Ast) _Statement);
        ((Ast) _Statement).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof StatementList)) return false;
        if (! super.equals(o)) return false;
        StatementList other = (StatementList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            IStatement element = getStatementAt(i);
            if (! element.equals(other.getStatementAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getStatementAt(i).hashCode());
        return hash;
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getStatementAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getStatementAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getStatementAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getStatementAt(i).accept(v, o));
        return result;
    }
}


