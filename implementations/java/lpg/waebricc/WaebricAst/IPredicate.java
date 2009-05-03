package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>ExpressionString
 *<li>ExpressionConstant
 *<li>ExpressionCollection
 *<li>ExpressionPair
 *<li>Predicate
 *<li>Var
 *</ul>
 *</b>
 */
public interface IPredicate
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


