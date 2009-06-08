package waebricc.WaebricAst;

/**
 * is implemented by:
 *<b>
 *<ul>
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
 *</ul>
 *</b>
 */
public interface IStatementWithoutSubstatement extends IStatement, IStatementNoShortIf {}


