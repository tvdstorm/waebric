using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Dataflow;

namespace Common
{
    /// <summary>
    /// Class which holds an hashtable with function and variable definitions
    /// </summary>
    public class SymbolTable : ICloneable
    {
        #region Private Members

        private SymbolTable ParentSymbolTable;
        private Dictionary<String, Node> FunctionDefinitions;
        private Dictionary<String, Node> VariableDefinitions;

        #endregion

        #region Public Methods

        /// <summary>
        /// Create empty SymbolTable
        /// </summary>
        public SymbolTable()
        {
            ParentSymbolTable = null;
            FunctionDefinitions = new Dictionary<string, Node>();
            VariableDefinitions = new Dictionary<string, Node>();
        }

        /// <summary>
        /// Create empty SymbolTable with reference to parent
        /// </summary>
        /// <param name="parentSymbolTable">Parent SymbolTable</param>
        public SymbolTable(SymbolTable parentSymbolTable)
        {
            ParentSymbolTable = parentSymbolTable;
            FunctionDefinitions = new Dictionary<string, Node>();
            VariableDefinitions = new Dictionary<string, Node>();
        }
        /// <summary>
        /// Add FunctionDefinition to SymbolTable
        /// </summary>
        /// <param name="functionDefinition">FunctionDefinition to add</param>
        public void AddFunctionDefinition(String functionIdentifier, Node functionDefinition)
        {
            FunctionDefinitions.Add(functionIdentifier, functionDefinition);
        }

        /// <summary>
        /// Retrieve list of FunctionDefinitions
        /// </summary>
        /// <returns>FunctionDefinitionList</returns>
        public List<Node> GetFunctionDefinitions()
        {
            return FunctionDefinitions.Values.ToList();
        }

        /// <summary>
        /// Get FunctionDefinition
        /// </summary>
        /// <param name="identifier">Identifier of FunctionDefinition</param>
        /// <returns>FunctionDefinition</returns>
        public Node GetFunctionDefinition(String identifier)
        {
            if (FunctionDefinitions.ContainsKey(identifier))
            {
                return FunctionDefinitions[identifier];
            }
            if (ParentSymbolTable != null)
            {
                return ParentSymbolTable.GetFunctionDefinition(identifier);
            }
            return null;
        }

        /// <summary>
        /// Retrieve list of names of FunctionDefinitions
        /// </summary>
        /// <returns>FunctionDefinitionNames</returns>
        public List<String> GetFunctionDefinitionNames()
        {
            return FunctionDefinitions.Keys.ToList();
        }

        /// <summary>
        /// Add VariableDefinition to SymbolTable
        /// </summary>
        /// <param name="variableDefinition">VariableDefinition to add</param>
        public void AddVariableDefinition(String identifier, Node value)
        {
            VariableDefinitions.Add(identifier, value);
        }

        /// <summary>
        /// Get value of specified variable
        /// </summary>
        /// <param name="identifier">Identifier of variable</param>
        /// <returns>Expression of variable</returns>
        public Node GetVariableDefinition(String identifier)
        {
            if (VariableDefinitions.ContainsKey(identifier))
            {
                return VariableDefinitions[identifier];
            }
            if (ParentSymbolTable != null)
            {
                return ParentSymbolTable.GetVariableDefinition(identifier);
            }
            return null;
        }

        /// <summary>
        /// Retrieve list of VariableNames
        /// </summary>
        /// <returns>VariableNameList</returns>
        public List<String> GetVariableNames()
        {
            return VariableDefinitions.Keys.ToList();
        }

        /// <summary>
        /// Check if an specified variable is already in SymbolTable
        /// </summary>
        /// <param name="identifier">Identifier of variable</param>
        /// <returns>True if in SymbolTable, otherwise false</returns>
        public bool ContainsVariable(String identifier)
        {
            if (ParentSymbolTable != null)
            {
                return VariableDefinitions.ContainsKey(identifier) || ParentSymbolTable.ContainsVariable(identifier);
            }
            else
            {
                return VariableDefinitions.ContainsKey(identifier);
            }
        }

        /// <summary>
        /// Check if an specified function is already in SymbolTable
        /// </summary>
        /// <param name="identifier">Identifier of Function</param>
        /// <returns>True if in SymbolTable, otherwise false</returns>
        public bool ContainsFunction(String identifier)
        {
            if (ParentSymbolTable != null)
            {
                return FunctionDefinitions.ContainsKey(identifier) || ParentSymbolTable.ContainsFunction(identifier);
            }
            else
            {
                return FunctionDefinitions.ContainsKey(identifier);
            }
        }

        /// <summary>
        /// Retrieve parent SymbolTable
        /// </summary>
        /// <returns>SymbolTable which is parent of current SymbolTable</returns>
        public SymbolTable GetParentSymbolTable()
        {
            return ParentSymbolTable;
        }

        public Object Clone()
        {
            SymbolTable clonedSymbolTable = new SymbolTable(GetParentSymbolTable());
            //Copy functions
            foreach (KeyValuePair<String, Node> def in FunctionDefinitions)
            {
                clonedSymbolTable.AddFunctionDefinition(def.Key, def.Value);
            }

            //Copy variables
            foreach (KeyValuePair<String, Node> pair in VariableDefinitions)
            {
                clonedSymbolTable.AddVariableDefinition(pair.Key, pair.Value);
            }

            return clonedSymbolTable;
        }

        #endregion
    }
}
