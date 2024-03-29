package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>AttributeSharp
 *<li>AttributeDot
 *<li>AttributeDollar
 *<li>AttributeColon
 *<li>AttributeWidth
 *<li>AttributeWidthHeight
 *</ul>
 *</b>
 */
public interface IAttribute
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


