/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.grammar.waebric.node;

import java.util.*;
import org.sablecc.grammar.waebric.analysis.*;

@SuppressWarnings("nls")
public final class AEmbeddingStatementMarkupNoStatement extends PStatementMarkupNoStatement
{
    private final LinkedList<PMarkup> _markup_ = new LinkedList<PMarkup>();
    private PEmbedding _embedding_;
    private TSemiColon _semiColon_;

    public AEmbeddingStatementMarkupNoStatement()
    {
        // Constructor
    }

    public AEmbeddingStatementMarkupNoStatement(
        @SuppressWarnings("hiding") List<PMarkup> _markup_,
        @SuppressWarnings("hiding") PEmbedding _embedding_,
        @SuppressWarnings("hiding") TSemiColon _semiColon_)
    {
        // Constructor
        setMarkup(_markup_);

        setEmbedding(_embedding_);

        setSemiColon(_semiColon_);

    }

    @Override
    public Object clone()
    {
        return new AEmbeddingStatementMarkupNoStatement(
            cloneList(this._markup_),
            cloneNode(this._embedding_),
            cloneNode(this._semiColon_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEmbeddingStatementMarkupNoStatement(this);
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

    public PEmbedding getEmbedding()
    {
        return this._embedding_;
    }

    public void setEmbedding(PEmbedding node)
    {
        if(this._embedding_ != null)
        {
            this._embedding_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._embedding_ = node;
    }

    public TSemiColon getSemiColon()
    {
        return this._semiColon_;
    }

    public void setSemiColon(TSemiColon node)
    {
        if(this._semiColon_ != null)
        {
            this._semiColon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semiColon_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._markup_)
            + toString(this._embedding_)
            + toString(this._semiColon_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._markup_.remove(child))
        {
            return;
        }

        if(this._embedding_ == child)
        {
            this._embedding_ = null;
            return;
        }

        if(this._semiColon_ == child)
        {
            this._semiColon_ = null;
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

        if(this._embedding_ == oldChild)
        {
            setEmbedding((PEmbedding) newChild);
            return;
        }

        if(this._semiColon_ == oldChild)
        {
            setSemiColon((TSemiColon) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
