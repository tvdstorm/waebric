/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.grammar.waebric.node;

import org.sablecc.grammar.waebric.analysis.*;

@SuppressWarnings("nls")
public final class AListType extends PType
{
    private TList _list_;

    public AListType()
    {
        // Constructor
    }

    public AListType(
        @SuppressWarnings("hiding") TList _list_)
    {
        // Constructor
        setList(_list_);

    }

    @Override
    public Object clone()
    {
        return new AListType(
            cloneNode(this._list_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAListType(this);
    }

    public TList getList()
    {
        return this._list_;
    }

    public void setList(TList node)
    {
        if(this._list_ != null)
        {
            this._list_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._list_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._list_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._list_ == child)
        {
            this._list_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._list_ == oldChild)
        {
            setList((TList) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
