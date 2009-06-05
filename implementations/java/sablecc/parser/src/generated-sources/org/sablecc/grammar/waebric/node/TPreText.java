/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.grammar.waebric.node;

import org.sablecc.grammar.waebric.analysis.*;

@SuppressWarnings("nls")
public final class TPreText extends Token
{
    public TPreText(String text)
    {
        setText(text);
    }

    public TPreText(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TPreText(getText(), getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTPreText(this);
    }
}
