﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Parser.Ast.Statements
{
    /// <summary>
    /// Node which contains an MarkupEmbeddingStatement
    /// </summary>
    public class MarkupEmbeddingStatement : Statement
    {
        #region Private Members

        private NodeList MarkupList;
        private Embedding.Embedding Embedding;

        #endregion

        #region Public Methods

        public MarkupEmbeddingStatement()
        {
            //Initialize member
            MarkupList = new NodeList();
        }

        public void AddMarkup(Markup.Markup markup)
        {
            MarkupList.Add(markup);
        }

        public NodeList GetMarkups()
        {
            return MarkupList;
        }

        public void SetEmbedding(Embedding.Embedding embedding)
        {
            Embedding = embedding;
        }

        public Embedding.Embedding GetEmbedding()
        {
            return Embedding;
        }

        public override String ToString()
        {   //To Implement
            return null;
        }

        public override ISyntaxNode[]  GetSubNodes()
        {
 	        return new ISyntaxNode[] {
                MarkupList,
                Embedding
            };
        }

        public override void  AcceptVisitor(ISyntaxNodeVisitor visitor)
        {
 	        visitor.Visit(this);
        }

        #endregion
    }
}
