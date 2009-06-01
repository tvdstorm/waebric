package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 * is always implemented by <b>AstToken</b>. It is also implemented by:
 *<b>
 *<ul>
 *<li>Name
 *<li>ExpressionString
 *<li>ExpressionConstant
 *<li>ExpressionSymbol
 *<li>TextTailMidText
 *<li>TextTailPostText
 *<li>TypeList
 *<li>TypeRecord
 *<li>TypeString
 *<li>Var
 *</ul>
 *</b>
 */
public interface IAstToken
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


