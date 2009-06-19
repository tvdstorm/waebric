﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Parser.Ast.Statements;

namespace Parser.Ast.Functions
{
    /// <summary>
    /// Node which contains FunctionDefinition
    /// </summary>
    public class FunctionDefinition : ISyntaxNode
    {
        #region Private Members

        private String Identifier;
        private List<Formal> FormalList;
        private List<Statement> StatementList;

        #endregion

        #region Public Methods

        /// <summary>
        /// Set identifier of FunctionDefinition
        /// </summary>
        /// <param name="identifier">Identifier to set</param>
        public void SetIdentifier(String identifier)
        {
            Identifier = identifier;
        }

        /// <summary>
        /// Get identifier of FunctionDefinition
        /// </summary>
        /// <returns>Identifier</returns>
        public String GetIdentifier()
        {
            return Identifier;
        }

        /// <summary>
        /// Add formal to FunctionDefinition
        /// </summary>
        /// <param name="formal">Formal to add</param>
        public void AddFormal(Formal formal)
        {
            FormalList.Add(formal);
        }

        /// <summary>
        /// Get formals of FunctionDefinition
        /// </summary>
        /// <returns>FormalList</returns>
        public List<Formal> GetFormals()
        {
            return FormalList;
        }

        /// <summary>
        /// Add statement to FunctionDefinition
        /// </summary>
        /// <param name="statement">Statement to add</param>
        public void AddStatement(Statement statement)
        {
            StatementList.Add(statement);
        }

        /// <summary>
        /// Get statements of FunctionDefinition
        /// </summary>
        /// <returns>StatementList</returns>
        public List<Statement> GetStatements()
        {
            return StatementList;
        }

        /// <summary>
        /// To Implement
        /// </summary>
        /// <returns></returns>
        public override String ToString()
        {
            return null;
        }

        #endregion

    }
}
