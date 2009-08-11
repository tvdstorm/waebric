using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Dataflow;
using Common;
using System.IO;
using Checker.Exceptions;

namespace Checker
{
    /// <summary>
    /// ModuleChecker which checks all module references
    /// </summary>
    public class ModuleChecker
    {
        #region Private Members

        List<Exception> ExceptionList;
        
        #endregion

        #region Public Methods

        public ModuleChecker(List<Exception> exceptionList)
        {
            ExceptionList = exceptionList;
        }

        public void CheckModule(Node module)
        {
            Node[] moduleNodes = module.ViewAllNodes().ToArray();

            //Check ModuleId (always first element)
            CheckModuleId(moduleNodes[0]);

            //Get dependencies and check their existence
            List<Node> DependencyList = ModuleCache.Instance.RequestDependencies(module);
            foreach (Node moduleDependency in DependencyList)
            {
                List<Node> imports = GetImports(moduleDependency);
                foreach (Node import in imports)
                {   //Check imports of dependency's
                    CheckModuleId(import);
                    ModuleCache.Instance.RequestModule(GetModuleIdentifier(import));
                }
            }       
        }

        public void CheckModuleId(Node ModuleId)
        {
            //Break up moduleId in array
            Node[] moduleId = ModuleId.ViewAllNodes().ToArray();

            //Collect ModuleId elements
            string moduleIdentifier = "";
            for (int i = 0; i <= (moduleId.Length - 1); i++)
            {
                moduleIdentifier += moduleId[i].AtomicValue;
                if (i != (moduleId.Length - 1))
                {
                    moduleIdentifier += ".";
                }
            }

            //Get path and determine if path exists
            String path = ModuleCache.Instance.GetPath(moduleIdentifier);
            if (!File.Exists(path))
            {
                ExceptionList.Add(new NonExistingModule(moduleIdentifier));
            }
        }

        #endregion

        #region Private Methods

        /// <summary>
        /// Method to retrieve Imports from moduleNode
        /// </summary>
        /// <param name="moduleNode">Module to retrieve Imports from</param>
        /// <returns>List of Imports</returns>
        private List<Node> GetImports(Node moduleNode)
        {
            List<Node> importList = new List<Node>();
            foreach (Node currentNode in moduleNode.ViewAllNodes())
            {
                if (currentNode.Brand.Text == "Import")
                {
                    //Get moduleId
                    Node ModuleId = currentNode.ViewAllNodes().First();
                    importList.Add(ModuleId);
                }
            }
            return importList;
        }

        private String GetModuleIdentifier(Node moduleId)
        {
            Node[] idList = moduleId.ViewAllNodes().ToArray();
            String identifier = "";
            for (int i = 0; i <= (idList.Length - 1); i++)
            {
                identifier += idList[i];
                if (i != (idList.Length - 1))
                {
                    identifier += ".";
                }
            }
            return identifier;
        }

        #endregion
    }

}
