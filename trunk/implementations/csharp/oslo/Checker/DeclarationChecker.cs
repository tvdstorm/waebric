using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Dataflow;
using Common;
using Checker.Exceptions;

namespace Checker
{
    /// <summary>
    /// Class which checks declarations
    /// </summary>
    public class DeclarationChecker
    {
        #region Private Members

        private List<Exception> ExceptionList;
        private SymbolTable SymbolTable;

        #endregion

        #region Public Methods

        public DeclarationChecker(List<Exception> exceptionList)
        {
            ExceptionList = exceptionList;
            SymbolTable = new SymbolTable();
        }

        /// <summary>
        /// Checks a module and their dependency's for declarations
        /// </summary>
        /// <param name="module">Module to check</param>
        public void VisitModule(Node module)
        {
            //Get dependency's for this module
            List<Node> dependencyList = ModuleCache.Instance.RequestDependencies(module);

            //Store all functiondefintions in SymbolTable
            foreach (Node dependency in dependencyList)
            {
                StoreFunctionDefinitionsOfModule(dependency);
            }

            //Check all defintions
            foreach (Node dependency in dependencyList)
            {
                VisitSubNodes(dependency);
            }
        }

        public void VisitSubNodes(Node node)
        {
            NodeCollection subNodes = node.ViewAllNodes();
            foreach (Node currentNode in subNodes)
            {
                //Check which node this is and perform action
                switch (currentNode.Brand.Text)
                {
                    case "FunctionDef":
                        VisitFunctionDef(currentNode);
                        break;
                    case "StatementList":
                        VisitSubNodes(currentNode);
                        break;
                    case "EachStatement":
                        VisitEachStatement(currentNode);
                        break;
                    case "LetStatement":
                        VisitLetStatement(currentNode);
                        break;
                    case "VarExpression":
                        VisitVarExpression(currentNode);
                        break;
                    case "MarkupCall":
                        VisitMarkupCall(currentNode);
                        break;
                    case "MarkupTag":
                        VisitMarkupTag(currentNode);
                        break;
                    case "VarBindAssignment":
                        VisitVarBindAssignment(currentNode);
                        break;
                    case "FuncBindAssignment":
                        Visit
                        break;
                    default:
                        //If non of above types are matched, visit subnodes of current node
                        VisitSubNodes(currentNode);
                        break;
                }
            }
        }

        /// <summary>
        /// Visits an FunctionDef node
        /// </summary>
        /// <param name="functionDef">FunctionDefinition to visit</param>
        public void VisitFunctionDef(Node functionDef)
        {
            CreateChildSymbolTable();

            //Check Formals (always second element of functiondef)
            Node Formals = functionDef.ViewAllNodes().ElementAt(1);
            foreach (Node formal in Formals.ViewAllNodes())
            {
                //Store variable, but without expression
                SymbolTable.AddVariableDefinition(formal.AtomicValue.ToString(), null);
            }
            
            //Check statements. StatementList is always at second position
            Node statementList = functionDef.ViewAllNodes().ElementAt(2);
            VisitSubNodes(statementList);

            MoveToParentSymbolTable();
        }

        /// <summary>
        /// Visit LetStatement
        /// </summary>
        /// <param name="letStatement">LetStatement to visit</param>
        public void VisitLetStatement(Node letStatement)
        {

        }

        /// <summary>
        /// Visit EachStatement
        /// </summary>
        /// <param name="eachStatement">EachStatement to visit</param>
        public void VisitEachStatement(Node eachStatement)
        {

        }

        /// <summary>
        /// Visit VarExpression
        /// </summary>
        /// <param name="varExpression">VarExpression to visit</param>
        public void VisitVarExpression(Node varExpression)
        {

        }
        
        /// <summary>
        /// Visit MarkupCall
        /// </summary>
        /// <param name="markupCall">MarkupCall to visit</param>
        public void VisitMarkupCall(Node markupCall)
        {

        }

        /// <summary>
        /// Visit MarkupTag
        /// </summary>
        /// <param name="markupTag">MarkupTag to visit</param>
        public void VisitMarkupTag(Node markupTag)
        {

        }

        /// <summary>
        /// Visit VarBindAssignment
        /// </summary>
        /// <param name="varBindAssignment">VarBindAssignment to visit</param>
        public void VisitVarBindAssignment(Node varBindAssignment)
        {

        }

        /// <summary>
        /// Visit FuncBindAssignment
        /// </summary>
        /// <param name="funcBindAssignment">FuncBindAssignment to visit</param>
        public void VisitFuncBindAssignment(Node funcBindAssignment)
        {

        }

        #endregion

        #region Private Methods

        /// <summary>
        /// Method which creates a new child SymbolTable with current SymbolTable as parent
        /// </summary>
        private void CreateChildSymbolTable()
        {
            SymbolTable = new SymbolTable(SymbolTable);
        }

        /// <summary>
        /// Method which moves the current SymbolTable to his parent
        /// </summary>
        private void MoveToParentSymbolTable()
        {
            SymbolTable = SymbolTable.GetParentSymbolTable();
        }

        /// <summary>
        /// Store all functiondefinitions in SymbolTable and perform already declared check
        /// </summary>
        /// <param name="module">Module to store functionsdefs of</param>
        private void StoreFunctionDefinitionsOfModule(Node module)
        {
            //Walk through all ModuleElements
            foreach (Node currentNode in module.ViewAllNodes())
            {
                if (currentNode.Brand.Text == "FunctionDef")
                {   //Verify if function is not already defined
                    Node functionId = currentNode.ViewAllNodes().First();

                    if (SymbolTable.ContainsFunction(functionId.AtomicValue.ToString()))
                    {
                        ExceptionList.Add(new FunctionAlreadyDefined(functionId.AtomicValue.ToString())); 
                    }
                    else
                    {
                        SymbolTable.AddFunctionDefinition(functionId.AtomicValue.ToString(), currentNode);
                    }                   
                }
            }
        }

        #endregion
    }
}
