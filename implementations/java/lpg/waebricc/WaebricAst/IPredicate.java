package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>ExpressionString
 *<li>ExpressionPlus
 *<li>ExpressionConstant
 *<li>ExpressionSymbol
 *<li>ExpressionCollection
 *<li>ExpressionPair
 *<li>PredicateCheckType
 *<li>PredicateNegate
 *<li>PredicateAnd
 *<li>PredicateOr
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


