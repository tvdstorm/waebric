/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.grammar.waebric.node;

import org.sablecc.grammar.waebric.analysis.*;

@SuppressWarnings("nls")
public final class APreEmbedding extends PEmbedding
{
    private TPreText _preText_;
    private PEmbed _embed_;
    private PTextTail _textTail_;

    public APreEmbedding()
    {
        // Constructor
    }

    public APreEmbedding(
        @SuppressWarnings("hiding") TPreText _preText_,
        @SuppressWarnings("hiding") PEmbed _embed_,
        @SuppressWarnings("hiding") PTextTail _textTail_)
    {
        // Constructor
        setPreText(_preText_);

        setEmbed(_embed_);

        setTextTail(_textTail_);

    }

    @Override
    public Object clone()
    {
        return new APreEmbedding(
            cloneNode(this._preText_),
            cloneNode(this._embed_),
            cloneNode(this._textTail_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPreEmbedding(this);
    }

    public TPreText getPreText()
    {
        return this._preText_;
    }

    public void setPreText(TPreText node)
    {
        if(this._preText_ != null)
        {
            this._preText_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._preText_ = node;
    }

    public PEmbed getEmbed()
    {
        return this._embed_;
    }

    public void setEmbed(PEmbed node)
    {
        if(this._embed_ != null)
        {
            this._embed_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._embed_ = node;
    }

    public PTextTail getTextTail()
    {
        return this._textTail_;
    }

    public void setTextTail(PTextTail node)
    {
        if(this._textTail_ != null)
        {
            this._textTail_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._textTail_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._preText_)
            + toString(this._embed_)
            + toString(this._textTail_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._preText_ == child)
        {
            this._preText_ = null;
            return;
        }

        if(this._embed_ == child)
        {
            this._embed_ = null;
            return;
        }

        if(this._textTail_ == child)
        {
            this._textTail_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._preText_ == oldChild)
        {
            setPreText((TPreText) newChild);
            return;
        }

        if(this._embed_ == oldChild)
        {
            setEmbed((PEmbed) newChild);
            return;
        }

        if(this._textTail_ == oldChild)
        {
            setTextTail((PTextTail) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}