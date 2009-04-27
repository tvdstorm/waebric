package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 * is implemented by <b>Markup</b>
 */
public interface IMarkup
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


