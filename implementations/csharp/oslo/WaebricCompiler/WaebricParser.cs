using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.M.Grammar;
using Microsoft.M;
using System.Dataflow;

namespace WaebricCompiler
{
    /// <summary>
    /// Class which calls the Oslo Parser and performs parser tasks
    /// </summary>
    public class WaebricParser
    {
        #region Private Members

        private MImage Grammar;
        private DynamicParser Parser;
        private Node Root;

        #endregion

        #region Public Methods

        public WaebricParser(String filename)
        {
            //Read grammar and create NodeGraphBuilder
            Grammar = new MImage("Waebric.mx");
            Parser = Grammar.ParserFactories["Waebric.Waebric"].Create();
            Parser.GraphBuilder = new NodeGraphBuilder();

            //Open sourcefile and parse it
            Root = (Node)Parser.Parse(filename, ErrorReporter.Standard);
        }

        /// <summary>
        /// Retrieves AST
        /// </summary>
        /// <returns>Root element of AST</returns>
        public Node GetAST()
        {
            return Root;
        }

        #endregion
    }
}
