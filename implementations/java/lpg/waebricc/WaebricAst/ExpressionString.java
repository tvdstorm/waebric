package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 58:  ExpressionString ::= StringLiteral$String
 *</b>
 */
public class ExpressionString extends AstToken implements IExpressionString
{
    public IToken getString() { return leftIToken; }

    public ExpressionString(IToken token) { super(token); initialize(); }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


