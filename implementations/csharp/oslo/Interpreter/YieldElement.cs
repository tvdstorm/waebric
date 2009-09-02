using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Common;
using System.Dataflow;

namespace Interpreter
{
    /// <summary>
    /// This elements holds an environment and AST structure for a specific yield statement
    /// </summary>
    public class YieldElement
    {
        #region Private Members

        private SymbolTable SymbolTable;
        private Node RootElement;

        #endregion

        #region Public Methods

        public void SetSymbolTable(SymbolTable symbolTable)
        {
            SymbolTable = symbolTable;
        }

        public SymbolTable GetSymbolTable()
        {
            return SymbolTable;
        }

        public void SetRootElement(Node node)
        {
            RootElement = node;
        }

        public Node GetRootElement()
        {
            return RootElement;
        }

        #endregion
    }
}
