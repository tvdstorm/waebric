/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.grammar.waebric.node;

import java.util.*;
import org.sablecc.grammar.waebric.analysis.*;

@SuppressWarnings("nls")
public final class AMarkupEmbeddingEmbed extends PEmbed
{
    private final LinkedList<PMarkup> _head_ = new LinkedList<PMarkup>();
    private PMarkup _tail_;

    public AMarkupEmbeddingEmbed()
    {
        // Constructor
    }

    public AMarkupEmbeddingEmbed(
        @SuppressWarnings("hiding") List<PMarkup> _head_,
        @SuppressWarnings("hiding") PMarkup _tail_)
    {
        // Constructor
        setHead(_head_);

        setTail(_tail_);

    }

    @Override
    public Object clone()
    {
        return new AMarkupEmbeddingEmbed(
            cloneList(this._head_),
            cloneNode(this._tail_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMarkupEmbeddingEmbed(this);
    }

    public LinkedList<PMarkup> getHead()
    {
        return this._head_;
    }

    public void setHead(List<PMarkup> list)
    {
        this._head_.clear();
        this._head_.addAll(list);
        for(PMarkup e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public PMarkup getTail()
    {
        return this._tail_;
    }

    public void setTail(PMarkup node)
    {
        if(this._tail_ != null)
        {
            this._tail_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tail_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._head_)
            + toString(this._tail_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._head_.remove(child))
        {
            return;
        }

        if(this._tail_ == child)
        {
            this._tail_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PMarkup> i = this._head_.listIterator(); i.hasNext();)
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

        if(this._tail_ == oldChild)
        {
            setTail((PMarkup) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
