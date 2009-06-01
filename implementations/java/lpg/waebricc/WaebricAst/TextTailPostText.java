package waebricc.WaebricAst;

import lpg.runtime.*;

/**
 *<b>
 *<li>Rule 71:  TextTail ::= PostText$PostText
 *</b>
 */
public class TextTailPostText extends AstToken implements ITextTail
{
    public IToken getPostText() { return leftIToken; }

    public TextTailPostText(IToken token) { super(token); initialize(); }

    public void accept(Visitor v) { v.visit(this); }
    public void accept(ArgumentVisitor v, Object o) { v.visit(this, o); }
    public Object accept(ResultVisitor v) { return v.visit(this); }
    public Object accept(ResultArgumentVisitor v, Object o) { return v.visit(this, o); }
}


