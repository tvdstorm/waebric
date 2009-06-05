/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.grammar.waebric.node;

import java.util.*;
import org.sablecc.grammar.waebric.analysis.*;

@SuppressWarnings("nls")
public final class AMarkupExpressionEmbed extends PEmbed
{
    private final LinkedList<PMarkup> _markup_ = new LinkedList<PMarkup>();
    private PExpression _expression_;

    public AMarkupExpressionEmbed()
    {
        // Constructor
    }

    public AMarkupExpressionEmbed(
        @SuppressWarnings("hiding") List<PMarkup> _markup_,
        @SuppressWarnings("hiding") PExpression _expression_)
    {
        // Constructor
        setMarkup(_markup_);

        setExpression(_expression_);

    }

    @Override
    public Object clone()
    {
        return new AMarkupExpressionEmbed(
            cloneList(this._markup_),
            cloneNode(this._expression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMarkupExpressionEmbed(this);
    }

    public LinkedList<PMarkup> getMarkup()
    {
        return this._markup_;
    }

    public void setMarkup(List<PMarkup> list)
    {
        this._markup_.clear();
        this._markup_.addAll(list);
        for(PMarkup e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public PExpression getExpression()
    {
        return this._expression_;
    }

    public void setExpression(PExpression node)
    {
        if(this._expression_ != null)
        {
            this._expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._markup_)
            + toString(this._expression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._markup_.remove(child))
        {
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PMarkup> i = this._markup_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PMarkup) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
