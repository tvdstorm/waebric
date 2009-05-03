package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 85:  Assignments ::= Assignment Assignments
 *<li>Rule 86:  Assignments ::= Assignment
 *</b>
 */
public class AssignmentList extends AbstractAstList implements IAssignments
{
    public Assignment getAssignmentAt(int i) { return (Assignment) getElementAt(i); }

    public AssignmentList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public AssignmentList(Assignment _Assignment, boolean leftRecursive)
    {
        super((Ast) _Assignment, leftRecursive);
        ((Ast) _Assignment).setParent(this);
    }

    public void add(Assignment _Assignment)
    {
        super.add((Ast) _Assignment);
        ((Ast) _Assignment).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof AssignmentList)) return false;
        if (! super.equals(o)) return false;
        AssignmentList other = (AssignmentList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            Assignment element = getAssignmentAt(i);
            if (! element.equals(other.getAssignmentAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getAssignmentAt(i).hashCode());
        return hash;
    }

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) v.visit(getAssignmentAt(i)); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) v.visit(getAssignmentAt(i), o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getAssignmentAt(i)));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(v.visit(getAssignmentAt(i), o));
        return result;
    }
}


