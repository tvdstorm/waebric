package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 61:  ExpressionSymbol ::= SymbolLiteral$SymbolString
 *</b>
 */
public class ExpressionSymbol extends AstToken implements IExpressionSymbol
{
    public IToken getSymbolString() { return leftIToken; }

    public ExpressionSymbol(IToken token) { super(token); initialize(); }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


