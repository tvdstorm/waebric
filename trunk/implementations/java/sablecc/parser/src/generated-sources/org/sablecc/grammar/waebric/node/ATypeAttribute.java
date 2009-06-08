/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.grammar.waebric.node;

import org.sablecc.grammar.waebric.analysis.*;

@SuppressWarnings("nls")
public final class ATypeAttribute extends PAttribute
{
    private TIdCon _idCon_;

    public ATypeAttribute()
    {
        // Constructor
    }

    public ATypeAttribute(
        @SuppressWarnings("hiding") TIdCon _idCon_)
    {
        // Constructor
        setIdCon(_idCon_);

    }

    @Override
    public Object clone()
    {
        return new ATypeAttribute(
            cloneNode(this._idCon_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATypeAttribute(this);
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._idCon_);
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

        throw new RuntimeException("Not a child.");
    }
}
