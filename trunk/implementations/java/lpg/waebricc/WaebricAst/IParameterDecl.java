package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 * is always implemented by <b>AstToken</b>. It is also implemented by <b>Name</b>
 */
public interface IParameterDecl
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


