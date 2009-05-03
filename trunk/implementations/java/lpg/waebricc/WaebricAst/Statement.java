package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<em>
 *<li>Rule 58:  Statement ::= StatementEach
 *<li>Rule 59:  Statement ::= StatementLet
 *<li>Rule 60:  Statement ::= StatementComment
 *<li>Rule 61:  Statement ::= StatementBlock
 *<li>Rule 63:  Statement ::= StatementEchoEmbedding
 *<li>Rule 64:  Statement ::= StatementCData
 *<li>Rule 65:  Statement ::= StatementYield
 *</em>
 *<p>
 *<b>
 *<li>Rule 62:  Statement ::= StatementEchoExpression
 *</b>
 */
public class Statement extends AstToken implements IStatement
{
    public Statement(IToken token) { super(token); initialize(); }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


