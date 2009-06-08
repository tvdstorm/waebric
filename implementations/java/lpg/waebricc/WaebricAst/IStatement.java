package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>StatementIf
 *<li>StatementIfElse
 *<li>StatementEach
 *<li>StatementLet
 *<li>StatementBlock
 *<li>StatementComment
 *<li>StatementEchoExpression
 *<li>StatementEchoEmbedding
 *<li>StatementCData
 *<li>StatementYield
 *<li>StatementMarkup
 *<li>StatementMarkupWithDesignator
 *<li>StatementMarkupWithExpression
 *<li>StatementMarkupWithEmbedding
 *<li>StatementMarkupStatement
 *</ul>
 *</b>
 */
public interface IStatement
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


