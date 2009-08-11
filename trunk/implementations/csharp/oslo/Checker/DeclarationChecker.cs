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

        /// <summary>
        /// Creates DeclarationChecker
        /// </summary>
        /// <param name="exceptionList"></param>
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
                        VisitFuncBindAssignment(currentNode);
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
            //Store assignments into SymbolTable
            Node Assignments = letStatement.ViewAllNodes().ElementAt(0);
            foreach (Node Assignment in Assignments.ViewAllNodes())
            {
                //Create new scope for every assignment
                CreateChildSymbolTable();

                //Visit assignment
                VisitSubNodes(Assignment);
            }

            //Visit statements
            Node Statements = letStatement.ViewAllNodes().ElementAt(1);
            VisitSubNodes(Statements);

            //Restore scoping on end of LetStatement
            foreach (Node Assignment in Assignments.ViewAllNodes())
            {
                MoveToParentSymbolTable();
            }
        }
       
        /// <summary>
        /// Visit EachStatement
        /// </summary>
        /// <param name="eachStatement">EachStatement to visit</param>
        public void VisitEachStatement(Node eachStatement)
        {
            CreateChildSymbolTable();

            //Store variable in eachstatement
            Node identifier = eachStatement.ViewAllNodes().ElementAt(0);
            Node expression = eachStatement.ViewAllNodes().ElementAt(1);
            SymbolTable.AddVariableDefinition(identifier.AtomicValue.ToString(), expression);

            //Place single statement in list to make visiting easier
            NodeGraphBuilder graphBuilder = new NodeGraphBuilder();
            Node statementList = (Node)graphBuilder.DefineNode("StatementList");
            statementList.Add(eachStatement.ViewAllNodes().ElementAt(2));

            //Visit statement
            VisitSubNodes(statementList);
            
            MoveToParentSymbolTable();
        }

        /// <summary>
        /// Visit VarExpression
        /// </summary>
        /// <param name="varExpression">VarExpression to visit</param>
        public void VisitVarExpression(Node varExpression)
        {
            //Check if reference to variable exists
            Node identifier = varExpression.ViewAllNodes().ElementAt(0);
            if(!SymbolTable.ContainsVariable(identifier.AtomicValue.ToString()))
            {   //Undefined variable referenced
                ExceptionList.Add(new UndefinedVariable(identifier.AtomicValue.ToString()));
            }
        }
        
        /// <summary>
        /// Visit MarkupCall
        /// </summary>
        /// <param name="markupCall">MarkupCall to visit</param>
        public void VisitMarkupCall(Node markupCall)
        {
            Node Designator = markupCall.ViewAllNodes().ElementAt(0);
            String identifier = Designator.ViewAllNodes().ElementAt(0).AtomicValue.ToString();

            if (SymbolTable.ContainsFunction(identifier))
            {
                //Get nr of formals
                Node calledFunction = SymbolTable.GetFunctionDefinition(identifier);
                Node formals = calledFunction.ViewAllNodes().ElementAt(1);
                int nrFormals = formals.ViewAllNodes().Count;
               
                //Get nr of arguments
                Node Arguments = markupCall.ViewAllNodes().ElementAt(1);
                int nrArguments = Arguments.ViewAllNodes().Count;

                //Check arity
                if (nrFormals != nrArguments)
                {
                    ExceptionList.Add(new FunctionCallArityIncorrect(identifier));
                }
            }
            else
            {
                //Check if it is XHTML, if not its undefined
                if (!IdentifierIsXHTML(identifier))
                {
                    ExceptionList.Add(new UndefinedFunction(identifier));
                }
            }
        }

        /// <summary>
        /// Visit MarkupTag
        /// </summary>
        /// <param name="markupTag">MarkupTag to visit</param>
        public void VisitMarkupTag(Node markupTag)
        {
            Node Designator = markupTag.ViewAllNodes().ElementAt(0);
            String identifier = Designator.ViewAllNodes().ElementAt(0).AtomicValue.ToString();

            if (SymbolTable.ContainsFunction(identifier))
            {
                //Get nr of formals
                Node calledFunction = SymbolTable.GetFunctionDefinition(identifier);
                Node formals = calledFunction.ViewAllNodes().ElementAt(1);
                int nrFormals = formals.ViewAllNodes().Count;

                //Check arity
                if (nrFormals != 0)
                {
                    ExceptionList.Add(new FunctionCallArityIncorrect(identifier));
                }
            }
            else
            {
                //Check if it is XHTML, if not its undefined
                if (!IdentifierIsXHTML(identifier))
                {
                    ExceptionList.Add(new UndefinedFunction(identifier));
                }
            }
        }

        /// <summary>
        /// Visit VarBindAssignment
        /// </summary>
        /// <param name="varBindAssignment">VarBindAssignment to visit</param>
        public void VisitVarBindAssignment(Node varBindAssignment)
        {
            //Visit Expression
            VisitSubNodes(varBindAssignment);

            //Store variable
            NodeCollection subNodes = varBindAssignment.ViewAllNodes();
            SymbolTable.AddVariableDefinition(subNodes.ElementAt(0).AtomicValue.ToString(), subNodes.ElementAt(1));
        }

        /// <summary>
        /// Visit FuncBindAssignment
        /// </summary>
        /// <param name="funcBindAssignment">FuncBindAssignment to visit</param>
        public void VisitFuncBindAssignment(Node funcBindAssignment)
        {
            //Convert FuncBind in a FunctionDef node
            NodeGraphBuilder graphBuilder = new NodeGraphBuilder();

            //Create functionDef node
            Node functionDef = (Node) graphBuilder.DefineNode("FunctionDef");

            //Add identifier of function
            functionDef.Add(funcBindAssignment.ViewAllNodes().ElementAt(0));

            //Add formals
            functionDef.Add(funcBindAssignment.ViewAllNodes().ElementAt(1));

            //Create StatementList to store the single statement in
            Node statementList = (Node)graphBuilder.DefineNode("StatementList");
            statementList.Add(funcBindAssignment.ViewAllNodes().ElementAt(2));
            functionDef.Add(statementList);

            //Visit this functionDefinition
            VisitFunctionDef(functionDef);
            
            //Add function to SymbolTable
            Node identifier = funcBindAssignment.ViewAllNodes().ElementAt(0);
            SymbolTable.AddFunctionDefinition(identifier.AtomicValue.ToString(), functionDef);
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

        /// <summary>
        /// Checks if an identifier is an XHTML tag
        /// </summary>
        /// <param name="identifier">Identifier to check</param>
        /// <returns>True if identifier is XHTML, otherwhise false</returns>
        private bool IdentifierIsXHTML(String identifier)
        {
            String[] xhtmlTags = Enum.GetNames(typeof(XHTMLTags));
            foreach (String item in xhtmlTags)
            {
                if (item.Equals(identifier.ToUpper()))
                {
                    return true;
                }
            }
            return false;
        }

        #endregion
    }
}
