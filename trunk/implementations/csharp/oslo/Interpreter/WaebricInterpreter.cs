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

                //Write XHTML output
                XHTMLStreamWriter writer = new XHTMLStreamWriter(Console.Out, XHTMLStreamWriter.DocType.TRANSITIONAL, interpreter.GetTree());
                writer.WriteStream();
            }
            
            //Interpret all sites
            foreach (Node dependency in dependencyList)
            {
                List<Node> sites = GetSitesOfModule(dependency);
                foreach (Node site in sites)
                {
                    foreach (Node mapping in site.ViewAllNodes())
                    {
                        //Get markup
                        Node markup = mapping.ViewAllNodes().ElementAt(1);
                        Node pathNode = mapping.ViewAllNodes().ElementAt(0);
                        String path = pathNode.AtomicValue.ToString();
                        
                        //Remove ./ or / from path string
                        path = path.TrimStart('.', '/');

                        
                        Interpreter interpreter = new Interpreter(SymbolTable);
                        interpreter.VisitMarkup(markup);

                        //Write XHTML output
                        Writer =  CreateOutputStream(path);

                        XHTMLStreamWriter writer = new XHTMLStreamWriter(Writer, XHTMLStreamWriter.DocType.TRANSITIONAL, interpreter.GetTree());
                        writer.WriteStream();
                    }
                }
            }
        }

        #endregion

        #region Private Methods

        /// <summary>
        /// Method which opens an streamwriter on specified path and creates directory's if needed
        /// </summary>
        /// <returns>StreamWriter</returns>
        private StreamWriter CreateOutputStream(String path)
        {
            int directoryIndex = path.LastIndexOf("/");

            if (directoryIndex != -1)
            {   //Directory's found, so create them
                System.IO.Directory.CreateDirectory(path.Substring(0, directoryIndex));
            }

            //Create file and return StreamWriter which writes to new file
            FileStream stream = File.Create(path);
            return new StreamWriter(stream);
        }
        
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

        /// <summary>
        /// Get sites of module
        /// </summary>
        /// <param name="module">Module to get sites from</param>
        /// <returns>List of site nodes</returns>
        private List<Node> GetSitesOfModule(Node module)
        {
            List<Node> siteList = new List<Node>();

            foreach (Node currentNode in module.ViewAllNodes())
            {
                if (currentNode.Brand.Text == "Site")
                {
                    siteList.Add(currentNode);
                }
            }

            return siteList;
        }

        #endregion
    }
}
