/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.grammar.waebric.node;

import org.sablecc.grammar.waebric.analysis.*;

@SuppressWarnings("nls")
public final class AEachStatement extends PStatement
{
    private TIdCon _idCon_;
    private PExpression _expression_;
    private PStatement _statement_;

    public AEachStatement()
    {
        // Constructor
    }

    public AEachStatement(
        @SuppressWarnings("hiding") TIdCon _idCon_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") PStatement _statement_)
    {
        // Constructor
        setIdCon(_idCon_);

        setExpression(_expression_);

        setStatement(_statement_);

    }

    @Override
    public Object clone()
    {
        return new AEachStatement(
            cloneNode(this._idCon_),
            cloneNode(this._expression_),
            cloneNode(this._statement_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEachStatement(this);
    }

    public TIdCon getIdCon()
    {
        return this._idCon_;
    }

    public void setIdCon(TIdCon node)
    {
        if(this._idCon_ != null)
        {
            this._idCon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._idCon_ = node;
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

    public PStatement getStatement()
    {
        return this._statement_;
    }

    public void setStatement(PStatement node)
    {
        if(this._statement_ != null)
        {
            this._statement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._statement_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._idCon_)
            + toString(this._expression_)
            + toString(this._statement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._idCon_ == child)
        {
            this._idCon_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        if(this._statement_ == child)
        {
            this._statement_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._idCon_ == oldChild)
        {
            setIdCon((TIdCon) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        if(this._statement_ == oldChild)
        {
            setStatement((PStatement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
