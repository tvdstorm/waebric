/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.grammar.waebric.node;

import org.sablecc.grammar.waebric.analysis.*;

@SuppressWarnings("nls")
public final class AMultipleExpressionsExpressionNoPlus extends PExpressionNoPlus
{
    private TLBracket _lBracket_;
    private PExpressions _expressions_;
    private TRBracket _rBracket_;

    public AMultipleExpressionsExpressionNoPlus()
    {
        // Constructor
    }

    public AMultipleExpressionsExpressionNoPlus(
        @SuppressWarnings("hiding") TLBracket _lBracket_,
        @SuppressWarnings("hiding") PExpressions _expressions_,
        @SuppressWarnings("hiding") TRBracket _rBracket_)
    {
        // Constructor
        setLBracket(_lBracket_);

        setExpressions(_expressions_);

        setRBracket(_rBracket_);

    }

    @Override
    public Object clone()
    {
        return new AMultipleExpressionsExpressionNoPlus(
            cloneNode(this._lBracket_),
            cloneNode(this._expressions_),
            cloneNode(this._rBracket_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultipleExpressionsExpressionNoPlus(this);
    }

    public TLBracket getLBracket()
    {
        return this._lBracket_;
    }

    public void setLBracket(TLBracket node)
    {
        if(this._lBracket_ != null)
        {
            this._lBracket_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lBracket_ = node;
    }

    public PExpressions getExpressions()
    {
        return this._expressions_;
    }

    public void setExpressions(PExpressions node)
    {
        if(this._expressions_ != null)
        {
            this._expressions_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expressions_ = node;
    }

    public TRBracket getRBracket()
    {
        return this._rBracket_;
    }

    public void setRBracket(TRBracket node)
    {
        if(this._rBracket_ != null)
        {
            this._rBracket_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rBracket_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._lBracket_)
            + toString(this._expressions_)
            + toString(this._rBracket_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lBracket_ == child)
        {
            this._lBracket_ = null;
            return;
        }

        if(this._expressions_ == child)
        {
            this._expressions_ = null;
            return;
        }

        if(this._rBracket_ == child)
        {
            this._rBracket_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._lBracket_ == oldChild)
        {
            setLBracket((TLBracket) newChild);
            return;
        }

        if(this._expressions_ == oldChild)
        {
            setExpressions((PExpressions) newChild);
            return;
        }

        if(this._rBracket_ == oldChild)
        {
            setRBracket((TRBracket) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
