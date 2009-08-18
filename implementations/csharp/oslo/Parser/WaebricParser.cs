using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.M.Grammar;
using Microsoft.M;
using System.Dataflow;
using System.IO;
using System.Reflection;

namespace WaebricCompiler
{
    /// <summary>
    /// Class which calls the Oslo Parser and performs parser tasks
    /// This class is a singleton to make parser perform better
    /// </summary>
    public class WaebricParser
    {
        #region Private Members

        private static readonly WaebricParser WaebricParserInstance = new WaebricParser();
        private MImage Grammar;
        private DynamicParser Parser;
        private Node Root;

        #endregion

        #region Public Methods

        /// <summary>
        /// Instance of WaebricParser singleton
        /// </summary>
        public static WaebricParser Instance
        {
            get
            {
                return WaebricParserInstance;
            }
        }

        /// <summary>
        /// Parse waebric file which is specified
        /// </summary>
        /// <param name="filename">Path to Waebricfile which should be parsed</param>
        public void Parse(String filename)
        {
            try
            {
                Root = null; //Dereference old tree
                Root = (Node)Parser.Parse(filename, ErrorReporter.Standard);
            }
            catch
            {   //Error so no AST
                Root = null;
            }
        }

        /// <summary>
        /// Retrieves AST if there's one
        /// </summary>
        /// <returns>Root element of AST</returns>
        public Node GetAST()
        {
            return Root;
        }

        #endregion

        #region Private Members

        private WaebricParser()
        {
            //Load grammar and initialize parser and graphbuilder
            String grammarPath = Path.GetDirectoryName(Assembly.GetAssembly(typeof(WaebricParser)).CodeBase);
            grammarPath += "\\Waebric.mx";
            grammarPath = grammarPath.Substring(6);
            Grammar = new MImage(grammarPath);
            Parser = Grammar.ParserFactories["Waebric.Waebric"].Create();
            Parser.GraphBuilder = new NodeGraphBuilder();
        }

        #endregion
    }
}
