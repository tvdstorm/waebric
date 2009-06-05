/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.grammar.waebric.node;

import org.sablecc.grammar.waebric.analysis.*;

@SuppressWarnings("nls")
public final class ASingleMappings extends PMappings
{
    private PMapping _mapping_;

    public ASingleMappings()
    {
        // Constructor
    }

    public ASingleMappings(
        @SuppressWarnings("hiding") PMapping _mapping_)
    {
        // Constructor
        setMapping(_mapping_);

    }

    @Override
    public Object clone()
    {
        return new ASingleMappings(
            cloneNode(this._mapping_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASingleMappings(this);
    }

    public PMapping getMapping()
    {
        return this._mapping_;
    }

    public void setMapping(PMapping node)
    {
        if(this._mapping_ != null)
        {
            this._mapping_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mapping_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._mapping_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._mapping_ == child)
        {
            this._mapping_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._mapping_ == oldChild)
        {
            setMapping((PMapping) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
