/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.grammar.waebric.node;

import org.sablecc.grammar.waebric.analysis.*;

@SuppressWarnings("nls")
public final class AAndPredicatePredicate extends PPredicate
{
    private PPredicateNoAndOr _predicateNoAndOr_;
    private TAnd _and_;
    private PPredicate _predicate_;

    public AAndPredicatePredicate()
    {
        // Constructor
    }

    public AAndPredicatePredicate(
        @SuppressWarnings("hiding") PPredicateNoAndOr _predicateNoAndOr_,
        @SuppressWarnings("hiding") TAnd _and_,
        @SuppressWarnings("hiding") PPredicate _predicate_)
    {
        // Constructor
        setPredicateNoAndOr(_predicateNoAndOr_);

        setAnd(_and_);

        setPredicate(_predicate_);

    }

    @Override
    public Object clone()
    {
        return new AAndPredicatePredicate(
            cloneNode(this._predicateNoAndOr_),
            cloneNode(this._and_),
            cloneNode(this._predicate_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAndPredicatePredicate(this);
    }

    public PPredicateNoAndOr getPredicateNoAndOr()
    {
        return this._predicateNoAndOr_;
    }

    public void setPredicateNoAndOr(PPredicateNoAndOr node)
    {
        if(this._predicateNoAndOr_ != null)
        {
            this._predicateNoAndOr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._predicateNoAndOr_ = node;
    }

    public TAnd getAnd()
    {
        return this._and_;
    }

    public void setAnd(TAnd node)
    {
        if(this._and_ != null)
        {
            this._and_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._and_ = node;
    }

    public PPredicate getPredicate()
    {
        return this._predicate_;
    }

    public void setPredicate(PPredicate node)
    {
        if(this._predicate_ != null)
        {
            this._predicate_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._predicate_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._predicateNoAndOr_)
            + toString(this._and_)
            + toString(this._predicate_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._predicateNoAndOr_ == child)
        {
            this._predicateNoAndOr_ = null;
            return;
        }

        if(this._and_ == child)
        {
            this._and_ = null;
            return;
        }

        if(this._predicate_ == child)
        {
            this._predicate_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._predicateNoAndOr_ == oldChild)
        {
            setPredicateNoAndOr((PPredicateNoAndOr) newChild);
            return;
        }

        if(this._and_ == oldChild)
        {
            setAnd((TAnd) newChild);
            return;
        }

        if(this._predicate_ == oldChild)
        {
            setPredicate((PPredicate) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
