package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>Path
 *<li>FileName
 *</ul>
 *</b>
 */
public interface IPath
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(Visitor v);
    void accept(ArgumentVisitor v, Object o);
    Object accept(ResultVisitor v);
    Object accept(ResultArgumentVisitor v, Object o);
}


