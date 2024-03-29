/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.grammar.waebric.node;

import org.sablecc.grammar.waebric.analysis.*;

@SuppressWarnings("nls")
public final class TList extends Token
{
    public TList()
    {
        super.setText("list");
    }

    public TList(int line, int pos)
    {
        super.setText("list");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TList(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTList(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TList text.");
    }
}
