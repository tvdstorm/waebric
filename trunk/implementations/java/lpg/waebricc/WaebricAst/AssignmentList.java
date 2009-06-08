package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 135:  Assignments ::= Assignments Assignment
 *<li>Rule 136:  Assignments ::= Assignment
 *</b>
 */
public class AssignmentList extends AbstractAstList implements IAssignments
{
    public IAssignment getAssignmentAt(int i) { return (IAssignment) getElementAt(i); }

    public AssignmentList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public AssignmentList(IAssignment _Assignment, boolean leftRecursive)
    {
        super((Ast) _Assignment, leftRecursive);
        ((Ast) _Assignment).setParent(this);
    }

    public void add(IAssignment _Assignment)
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
            IAssignment element = getAssignmentAt(i);
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

    public void accept(Visitor v) { for (int i = 0; i < size(); i++) getAssignmentAt(i).accept(v); }
    public void accept(ArgumentVisitor v, Object o) { for (int i = 0; i < size(); i++) getAssignmentAt(i).accept(v, o); }
    public Object accept(ResultVisitor v)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getAssignmentAt(i).accept(v));
        return result;
    }
    public Object accept(ResultArgumentVisitor v, Object o)
    {
        java.util.ArrayList result = new java.util.ArrayList();
        for (int i = 0; i < size(); i++)
            result.add(getAssignmentAt(i).accept(v, o));
        return result;
    }
}


