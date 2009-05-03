package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 44:  ExpressionConstant ::= IntegerLiteral$IntegerString
 *</b>
 */
public class ExpressionConstant extends AstToken implements IExpressionConstant
{
    public IToken getIntegerString() { return leftIToken; }

    public ExpressionConstant(IToken token) { super(token); initialize(); }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


