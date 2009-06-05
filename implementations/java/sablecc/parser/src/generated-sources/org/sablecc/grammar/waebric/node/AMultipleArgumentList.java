/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.grammar.waebric.node;

import org.sablecc.grammar.waebric.analysis.*;

@SuppressWarnings("nls")
public final class AMultipleArgumentList extends PArgumentList
{
    private PArgumentList _argumentList_;
    private TComma _comma_;
    private PArgument _argument_;

    public AMultipleArgumentList()
    {
        // Constructor
    }

    public AMultipleArgumentList(
        @SuppressWarnings("hiding") PArgumentList _argumentList_,
        @SuppressWarnings("hiding") TComma _comma_,
        @SuppressWarnings("hiding") PArgument _argument_)
    {
        // Constructor
        setArgumentList(_argumentList_);

        setComma(_comma_);

        setArgument(_argument_);

    }

    @Override
    public Object clone()
    {
        return new AMultipleArgumentList(
            cloneNode(this._argumentList_),
            cloneNode(this._comma_),
            cloneNode(this._argument_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultipleArgumentList(this);
    }

    public PArgumentList getArgumentList()
    {
        return this._argumentList_;
    }

    public void setArgumentList(PArgumentList node)
    {
        if(this._argumentList_ != null)
        {
            this._argumentList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._argumentList_ = node;
    }

    public TComma getComma()
    {
        return this._comma_;
    }

    public void setComma(TComma node)
    {
        if(this._comma_ != null)
        {
            this._comma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comma_ = node;
    }

    public PArgument getArgument()
    {
        return this._argument_;
    }

    public void setArgument(PArgument node)
    {
        if(this._argument_ != null)
        {
            this._argument_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._argument_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._argumentList_)
            + toString(this._comma_)
            + toString(this._argument_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._argumentList_ == child)
        {
            this._argumentList_ = null;
            return;
        }

        if(this._comma_ == child)
        {
            this._comma_ = null;
            return;
        }

        if(this._argument_ == child)
        {
            this._argument_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._argumentList_ == oldChild)
        {
            setArgumentList((PArgumentList) newChild);
            return;
        }

        if(this._comma_ == oldChild)
        {
            setComma((TComma) newChild);
            return;
        }

        if(this._argument_ == oldChild)
        {
            setArgument((PArgument) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
