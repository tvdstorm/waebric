package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 134:  Var ::= IDENTIFIER$Name
 *</b>
 */
public class Var extends AstToken implements IVar
{
    public IToken getName() { return leftIToken; }

    public Var(IToken token) { super(token); initialize(); }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


