/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.grammar.waebric.node;

import org.sablecc.grammar.waebric.analysis.*;

@SuppressWarnings("nls")
public final class TCdata extends Token
{
    public TCdata()
    {
        super.setText("cdata");
    }

    public TCdata(int line, int pos)
    {
        super.setText("cdata");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TCdata(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCdata(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TCdata text.");
    }
}
