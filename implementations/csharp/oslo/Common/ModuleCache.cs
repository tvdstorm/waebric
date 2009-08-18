using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;
using System.Text;
using System.IO;
using WaebricCompiler;
using System.Dataflow;

namespace Common
{
    /// <summary>
    /// Class which stores/caches all parsed modules
    /// </summary>
    public class ModuleCache
    {
        #region Private Members

        private static readonly ModuleCache ModuleCacheInstance = new ModuleCache();
        private Hashtable ModuleTable;
        private String DirectoryPath;

        #endregion

        #region Public Methods
        
        /// <summary>
        /// Instance of ModuleCache singleton
        /// </summary>
        public static ModuleCache Instance
        {
            get
            {
                return ModuleCacheInstance;
            }
        }

        public void SetDirectoryPath(String directoryPath)
        {
            DirectoryPath = directoryPath;
        }
        
        /// <summary>
        /// Request an specified module
        /// </summary>
        /// <param name="indentifier">ModuleId of requested module</param>
        /// <returns>Requested module if available</returns>
        public Node RequestModule(String identifier)
        {
            if (ModuleTable.Contains(identifier))
            {   //Module already loaded so return instance of module
                return (Node) ModuleTable[identifier];
            }

            //Let's parse the stream
            WaebricParser.Instance.Parse(GetPath(identifier));

            //Add module to hashtable
            Node requestedModule = WaebricParser.Instance.GetAST();
            if (requestedModule.Brand.Text == "")
            {
                return null;
            }
            ModuleTable.Add(GetModuleIdentifier(requestedModule), requestedModule);

            return requestedModule;
        }

        /// <summary>
        /// Request dependencies of specified modules
        /// </summary>
        /// <param name="module"></param>
        public void RequestDependencies(Node module, List<Node> list)
        {
            //Check if module is already in Table
            if (!ContainsModule(list, GetModuleIdentifier(module)))
            {
                list.Add(module);
                List<String> imports = GetImportsOfModule(module);

                foreach (String importId in imports)
                {
                    if (!ContainsModule(list, importId))
                    {
                        //Get module
                        Node requestedDependency = RequestModule(importId);
                        if (requestedDependency != null)
                        {   //Not null, so add to list
                            //Get dependencies of retrieved module
                            RequestDependencies(requestedDependency, list);
                        }
                    }
                }
            }
        }

        /// <summary>
        /// Get dependencies of module and return a list of founded dependencies
        /// </summary>
        /// <param name="module">Module to get dependencies from</param>
        /// <returns>List of dependencies</returns>
        public List<Node> RequestDependencies(Node module)
        {
            List<Node> moduleList = new List<Node>();
            RequestDependencies(module, moduleList);
            return moduleList;
        }

        /// <summary>
        /// Add an specific module to the modulecache
        /// </summary>
        /// <param name="module"></param>
        public void AddModuleToCache(Node module)
        {
            ModuleTable.Add(GetModuleIdentifier(module), module);
        }

        /// <summary>
        /// Clear the ModuleCache
        /// </summary>
        public void ClearModuleCache()
        {
            ModuleTable.Clear();
        }

        /// <summary>
        /// Check if ModuleCache contains a specified module
        /// </summary>
        /// <param name="moduleString">String representation of ModuleId</param>
        /// <returns>True if module is in Cache, otherwise false</returns>
        public bool ContainsModule(String moduleString)
        {
            return ModuleTable.Contains(moduleString);
        }

        public String GetModuleIdentifier(Node moduleNode)
        {
            if(moduleNode.Brand.Text != "Module")
            {
                new Exception("Module not found");
            }

            //Retrieve ModuleId
            Node moduleId = moduleNode.ViewAllNodes().First();
            Node identifier = moduleId.ViewAllNodes().First();
            return identifier.AtomicValue.ToString();
        }

        /// <summary>
        /// Determine relative path of specified identifier
        /// </summary>
        /// <param name="identifier">Identifier of module</param>
        /// <returns>Path of module</returns>
        public String GetPath(String identifier)
        {
            String[] identifierList = identifier.Split('.');
            String path = DirectoryPath;

            //Create path
            for (int i = 0; i <= (identifierList.Length - 1); i++)
            {
                path += identifierList[i];
                if (i != (identifierList.Length - 1))
                {
                    path += "/";
                }
            }

            //Add extension
            path += ".wae";

            return path;
        }

        #endregion

        #region Private Methods

        /// <summary>
        /// Private constructor for singleton
        /// </summary>
        private ModuleCache()
        {
            ModuleTable = new Hashtable();
        }
        
        /// <summary>
        /// Method to check if list contains specific module
        /// </summary>
        /// <param name="moduleList">List of modules</param>
        /// <param name="identifier">Identifier of module to search</param>
        /// <returns>True if in list, otherwise false</returns>
        private bool ContainsModule(List<Node> moduleList, String identifier)
        {
            foreach (Node module in moduleList)
            {
                if (GetModuleIdentifier(module) == identifier)
                {
                    return true;
                }
            }
            return false;
        }

        /// <summary>
        /// Method to retrieve Imports from moduleNode
        /// </summary>
        /// <param name="moduleNode">Module to retrieve Imports from</param>
        /// <returns>List of Imports</returns>
        private List<String> GetImportsOfModule(Node moduleNode)
        {
            List<String> importList = new List<String>();
            foreach(Node currentNode in moduleNode.ViewAllNodes())
            {
                if (currentNode.Brand.Text == "Import")
                {
                    //Get moduleId
                    String import = "";
                    Node[] ModuleId = currentNode.ViewAllNodes().ToArray();
                    Node[] identifiers = ModuleId[0].ViewAllNodes().ToArray();
                    for (int i = 0; i <= (identifiers.Length - 1); i++)
                    {
                        import += identifiers[i].AtomicValue.ToString();
                        if (i != (identifiers.Length - 1))
                        {
                            import += ".";
                        }
                    }
                    importList.Add(import);
                }
            }
            return importList;
        }

        #endregion

    }
}
