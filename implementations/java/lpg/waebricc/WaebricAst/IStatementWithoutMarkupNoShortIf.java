package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>StatementIfElseNoShortIf
 *<li>StatementEachNoShortIf
 *<li>StatementLet
 *<li>StatementBlock
 *<li>StatementComment
 *<li>StatementEchoExpression
 *<li>StatementEchoEmbedding
 *<li>StatementCData
 *<li>StatementYield
 *</ul>
 *</b>
 */
public interface IStatementWithoutMarkupNoShortIf
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


