using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Dataflow;
using Common;

namespace Interpreter
{
    /// <summary>
    /// Class which contains the interpreter
    /// </summary>
    public class WaebricInterpreter
    {
        #region Private Members

        private StreamWriter Writer;
        private SymbolTable SymbolTable;

        #endregion

        #region Public Methods

        public WaebricInterpreter()
        {
            Writer = null;
            SymbolTable = null;
        }

        /// <summary>
        /// Interpret the AST
        /// </summary>
        /// <param name="root">Node which is root of tree</param>
        public void InterpretAST(Node root)
        {
            //Fill SymbolTable with functiondefinitions of all dependency's
            SymbolTable = new SymbolTable();
            List<Node> dependencyList = ModuleCache.Instance.RequestDependencies(root);
            foreach (Node dependency in dependencyList)
            {
                IndexFunctionDefinitions(dependency);
            }

            //Interpret main method if one available
            if (ContainsMainFunction(root))
            {
                //Interpret main function
                Interpreter interpreter = new Interpreter(SymbolTable);
                interpreter.VisitFunctionDefinition(SymbolTable.GetFunctionDefinition("main"));

                //Write XHTML output here!!!
            }
            
            //Interpret all sites
            foreach (Node dependency in dependencyList)
            {

            }
        }

        #endregion

        #region Private Methods
        
        /// <summary>
        /// Checks if an module contains an main function
        /// </summary>
        /// <param name="module">Module to check</param>
        /// <returns>ContainsMainFunction</returns>
        private bool ContainsMainFunction(Node module)
        {
            foreach (Node node in module.ViewAllNodes())
            {
                if (node.Brand.Text == "FunctionDef")
                {
                    Node functionIdentifier = node.ViewAllNodes().ElementAt(0);
                    if (functionIdentifier.AtomicValue.ToString() == "main")
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        /// <summary>
        /// Indexing of all FunctionDefinitions of this module
        /// </summary>
        /// <param name="module">Module to walk through</param>
        private void IndexFunctionDefinitions(Node module)
        {
            foreach (Node currentNode in module.ViewAllNodes())
            {
                if (currentNode.Brand.Text == "FunctionDef")
                {   //Add functiondefinition to symboltable
                    Node functionIdentifier = currentNode.ViewAllNodes().ElementAt(0);
                    SymbolTable.AddFunctionDefinition(functionIdentifier.AtomicValue.ToString(), currentNode);
                }
            }
        }

        #endregion
    }
}
