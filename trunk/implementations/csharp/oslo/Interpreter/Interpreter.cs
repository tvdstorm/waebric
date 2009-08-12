using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Common;
using System.Dataflow;

namespace Interpreter
{   
    /// <summary>
    /// Class which interprets AST tree and results in an XHTML tree
    /// </summary>
    public class Interpreter
    {
        #region Private Members

        private SymbolTable SymbolTable;                                        //Table which holds functions and variables
        private XHTMLElement Root;                                              //Root element of XHTMLTree
        private XHTMLElement Current;                                           //Pointer to current element in XHTMLTree
        private Dictionary<Node, SymbolTable> FunctionSymbolTable;              //Stores symboltables per function
        private String TextValue = "";                                          //Buffer used for buffering values
        private Stack<Node> YieldStack;                                         //Stack containing nodes which are referred by a yield

        #endregion

        #region Public Methods

        /// <summary>
        /// Interpret 
        /// </summary>
        /// <param name="symbolTable"></param>
        public Interpreter(SymbolTable symbolTable)
        {
            SymbolTable = symbolTable;
            FunctionSymbolTable = new Dictionary<Node, SymbolTable>();
            YieldStack = new Stack<Node>();
        }

        /// <summary>
        /// Interpret an FunctionDefinition
        /// </summary>
        /// <param name="functionDefinition">FunctionDefinition to interpret</param>
        public void VisitFunctionDefinition(Node functionDefinition)
        {
            //Interpret statements
            Node statementList = functionDefinition.ViewAllNodes().ElementAt(2);
            XHTMLElement temp = Current;
            foreach(Node statement in statementList.ViewAllNodes())
            {
                Current = temp;
                VisitStatement(statement);
            }
        }

        /// <summary>
        /// Interpret Statements
        /// </summary>
        /// <param name="statementList">Statement to interpret</param>
        public void VisitStatement(Node statement)
        {
            //Determine statement type
            switch (statement.Brand.Text)
            {
                case "BlockStatement":
                    VisitBlockStatement(statement);
                    break;
                case "EachStatement":
                    VisitEachStatement(statement);
                    break;
                case "LetStatement":
                    VisitLetStatement(statement);
                    break;
                case "IfStatement":
                    VisitIfStatement(statement);
                    break;
                case "IfElseStatement":
                    VisitIfElseStatement(statement);
                    break;
                case "CommentStatement":
                    VisitCommentStatement(statement);
                    break;
                case "EchoExpressionStatement":
                    VisitEchoExpressionStatement(statement);
                    break;
                case "EchoEmbeddingStatement":
                    VisitEchoEmbeddingStatement(statement);
                    break;
                case "CDataStatement":
                    VisitCDataStatement(statement);
                    break;
                case "YieldStatement":
                    VisitYieldStatement(statement);
                    break;
                //ADD MARKUPS STATEMENTS HERE!!!
            }
        }

        /// <summary>
        /// Interpret expression
        /// </summary>
        /// <param name="expression">Expression to interpret</param>
        public void VisitExpression(Node expression)
        {
            //Determine expression type
            switch (expression.Brand.Text)
            {
                case "TextExpression":
                    break;
                case "SymbolExpression":
                    break;
                case "VarExpression":
                    break;
                case "NatExpression":
                    break;
                case "CatExpression":
                    break;
                case "FieldExpression":
                    break;
            }
        }

        /// <summary>
        /// Interpret attribute
        /// </summary>
        /// <param name="attribute">Attribute to interpret</param>
        public void VisitAttribute(Node attribute)
        {
            //Determine attribute type
            switch (attribute.Brand.Text)
            {
                case "IdAttribute":
                    break;
                case "ClassAttribute":
                    break;
                case "NameAttribute":
                    break;
                case "TypeAttribute":
                    break;
                case "Width_HeightAttribute":
                    break;
                case "WidthAttribute":
                    break;
            }
        }

        /// <summary>
        /// Interpret BlockStatement
        /// </summary>
        /// <param name="blockStatement">BlockStatement to interpret</param>
        public void VisitBlockStatement(Node blockStatement)
        {
            XHTMLElement temp = Current;
            Node statementList = blockStatement.ViewAllNodes().ElementAt(0);
            foreach (Node currentStatement in statementList.ViewAllNodes())
            {
                Current = temp;
                VisitStatement(currentStatement);
            }
        }

        public void VisitEachStatement(Node eachStatement)
        {

        }

        public void VisitLetStatement(Node letStatement)
        {

        }

        public void VisitIfStatement(Node ifStatement)
        {

        }

        public void VisitIfElseStatement(Node ifElseStatement)
        {

        }

        public void VisitCommentStatement(Node commentStatement)
        {
            AddElement(new XHTMLElement("comment", Current));
            Node comment = commentStatement.ViewAllNodes().ElementAt(0);
            Current.AddContent(comment.AtomicValue.ToString());
        }

        public void VisitEchoExpressionStatement(Node echoExpressionStatement)
        {

        }

        public void VisitEchoEmbeddingStatement(Node echoEmbeddingStatement)
        {

        }

        public void VisitCDataStatement(Node cDataStatement)
        {

        }

        public void VisitYieldStatement(Node yieldStatement)
        {

        }

        #endregion

        #region Private Methods

        /// <summary>
        /// Add an XHTMLElement to XHTMLTree
        /// </summary>
        /// <param name="element">Element to add</param>
        private void AddElement(XHTMLElement element)
        {
            //If no root element, new element is root
            if (Root == null)
            {
                Root = element;
                Current = Root;
                return;
            }

            //Add element as child of current element
            Current.AddChild(element);
            //Set current to last added element
            Current = element;
        }

        private Node GetExpression(Node expression)
        {
            return null;
        }

        #endregion
    }
}
