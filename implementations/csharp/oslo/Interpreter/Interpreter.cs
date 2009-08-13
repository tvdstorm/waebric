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
                    VisitTextExpression(expression);
                    break;
                case "SymbolExpression":
                    VisitSymbolExpression(expression);
                    break;
                case "VarExpression":
                    VisitVarExpression(expression);
                    break;
                case "NatExpression":
                    VisitNatExpression(expression);
                    break;
                case "CatExpression":
                    VisitCatExpression(expression);
                    break;
                case "FieldExpression":
                    VisitFieldExpression(expression);
                    break;
                case "ListExpression":
                    VisitListExpression(expression);
                    break;
                case "RecordExpression":
                    VisitRecordExpression(expression);
                    break;
            }
        }

        /// <summary>
        /// Interpret TextExpression
        /// </summary>
        /// <param name="textExpression">TextExpression to interpret</param>
        public void VisitTextExpression(Node textExpression)
        {
            Node value = textExpression.ViewAllNodes().ElementAt(0);
            TextValue = value.AtomicValue.ToString();
        }

        /// <summary>
        /// Interpret SymbolExpression
        /// </summary>
        /// <param name="symbolExpression">SymbolExpression to interpret</param>
        public void VisitSymbolExpression(Node symbolExpression)
        {
            Node value = symbolExpression.ViewAllNodes().ElementAt(0);
            TextValue = value.AtomicValue.ToString();
        }

        /// <summary>
        /// Interpret VarExpression
        /// </summary>
        /// <param name="varExpression">VarExpression to interpret</param>
        public void VisitVarExpression(Node varExpression)
        {
            Node varIdentifier = varExpression.ViewAllNodes().ElementAt(0);
            Node expression = SymbolTable.GetVariableDefinition(varIdentifier.AtomicValue.ToString());

            //Check references to parent functions with same identifier
            if (expression == varExpression && SymbolTable.GetParentSymbolTable() != null)
            {
                expression = SymbolTable.GetParentSymbolTable().GetVariableDefinition(varIdentifier.AtomicValue.ToString());
            }

            if (expression != null)
            {   //Get expression value
                VisitExpression(expression);
            }
            else
            {   //Variable doesn't have an allocated expressionvalue
                TextValue = "undef";
            }

        }

        /// <summary>
        /// Interpret NatExpression
        /// </summary>
        /// <param name="natExpression">NatExpression to interpret</param>
        public void VisitNatExpression(Node natExpression)
        {
            Node value = natExpression.ViewAllNodes().ElementAt(0);
            TextValue = value.AtomicValue.ToString();
        }

        /// <summary>
        /// Interpret CatExpression
        /// </summary>
        /// <param name="catExpression">CatExpression to interpret</param>
        public void VisitCatExpression(Node catExpression)
        {
            Node leftExpression = catExpression.ViewAllNodes().ElementAt(0);
            Node rightExpression = catExpression.ViewAllNodes().ElementAt(1);

            //Concatenate expressions
            String catValue = "";
            
            //Visit left
            VisitExpression(leftExpression);
            catValue += TextValue;

            //Visit right
            VisitExpression(rightExpression);
            catValue += TextValue;

            //Store concatenation value
            TextValue = catValue;
        }

        /// <summary>
        /// Interpret FieldExpression
        /// </summary>
        /// <param name="fieldExpression">FieldExpression to interpret</param>
        public void VisitFieldExpression(Node fieldExpression)
        {
            //Retrieve expression
            Node expression = GetExpression(fieldExpression);
            if (expression != null)
            {   //Get expression value
                VisitExpression(expression);
            }
            else
            {   //No expression value found
                TextValue = "undef";
            }
        }

        /// <summary>
        /// Interpret ListExpression
        /// </summary>
        /// <param name="listExpression">ListExpression to interpret</param>
        public void VisitListExpression(Node listExpression)
        {
            //Convert list to textvalue
            String tempList = "[";
            
            //Convert each expression in list
            NodeCollection expressionList = listExpression.ViewAllNodes();
            for (int i = 0; i <= (expressionList.Count - 1); i++)
            {
                Node currentExpression = expressionList.ElementAt(i);

                //Store Text and SymbolExpression between " to recognize , seperator
                if (currentExpression.Brand.Text == "TextExpression" || currentExpression.Brand.Text == "SymbolExpression")
                {
                    tempList += "\"";
                }

                //Store expression value in tempList
                VisitExpression(currentExpression);
                tempList += TextValue;

                if (currentExpression.Brand.Text == "TextExpression" || currentExpression.Brand.Text == "SymbolExpression")
                {
                    tempList += "\"";
                }

                //Add , seperator
                if (i != (expressionList.Count - 1))
                {
                    tempList += ",";
                }
            }

            tempList += "]";
            TextValue = tempList;
        }

        /// <summary>
        /// Interpret RecordExpression
        /// </summary>
        /// <param name="recordExpression">RecordExpression to interpret</param>
        public void VisitRecordExpression(Node recordExpression)
        {
            //Convert record to textvalue
            String tempRecord = "{";
            NodeCollection pairList = recordExpression.ViewAllNodes();
            for (int i = 0; i <= (pairList.Count - 1); i++)
            {
                Node pair = pairList.ElementAt(i);

                //Convert pair
                Node key = pair.ViewAllNodes().ElementAt(0);
                Node value = pair.ViewAllNodes().ElementAt(1);
                tempRecord += key.AtomicValue.ToString() + ":";
                VisitExpression(value);
                tempRecord += TextValue;

                //Add seperator
                if (i != (pairList.Count - 1))
                {
                    tempRecord += ",";
                }
            }

            tempRecord += "}";
            TextValue = tempRecord;
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

        /// <summary>
        /// Interpret IfStatement
        /// </summary>
        /// <param name="ifStatement">IfStatement to interpret</param>
        public void VisitIfStatement(Node ifStatement)
        {
            Node predicate = ifStatement.ViewAllNodes().ElementAt(0);
            Node trueStatement = ifStatement.ViewAllNodes().ElementAt(1);
            if (EvaluatePredicate(predicate))
            {
                VisitStatement(trueStatement);
            }
        }

        /// <summary>
        /// Interpret IfElseStatement
        /// </summary>
        /// <param name="ifElseStatement">IfElseStatement to interpret</param>
        public void VisitIfElseStatement(Node ifElseStatement)
        {
            Node predicate = ifElseStatement.ViewAllNodes().ElementAt(0);
            Node trueStatement = ifElseStatement.ViewAllNodes().ElementAt(1);
            Node falseStatement = ifElseStatement.ViewAllNodes().ElementAt(2);
            if (EvaluatePredicate(predicate))
            {
                VisitStatement(trueStatement);
            }
            else
            {
                VisitStatement(falseStatement);
            }
        }

        /// <summary>
        /// Interpret CommentStatement
        /// </summary>
        /// <param name="commentStatement">CommentStatement to interpret</param>
        public void VisitCommentStatement(Node commentStatement)
        {
            AddElement(new XHTMLElement("comment", Current));
            Node comment = commentStatement.ViewAllNodes().ElementAt(0);
            Current.AddContent(comment.AtomicValue.ToString());
        }

        /// <summary>
        /// Interpret EchoExpressionStatement
        /// </summary>
        /// <param name="echoExpressionStatement">EchoExpressionStatement to interpret</param>
        public void VisitEchoExpressionStatement(Node echoExpressionStatement)
        {
            Node expression = echoExpressionStatement.ViewAllNodes().ElementAt(0);
            VisitExpression(expression);
        }

        public void VisitEchoEmbeddingStatement(Node echoEmbeddingStatement)
        {

        }

        /// <summary>
        /// Interpret CDataStatement
        /// </summary>
        /// <param name="cDataStatement">CDataStatement to interpret</param>
        public void VisitCDataStatement(Node cDataStatement)
        {
            Node expression = cDataStatement.ViewAllNodes().ElementAt(0);
            VisitExpression(expression);
            AddElement(new XHTMLElement("cdata", Current));
            Current.AddContent(TextValue);
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

        /// <summary>
        /// Get scoped SymbolTable of specific function
        /// </summary>
        /// <param name="function">FunctionDefinition</param>
        /// <returns>SymbolTable of specific function</returns>
        private SymbolTable GetSymbolTableOfFunction(Node function)
        {
            if (FunctionSymbolTable.ContainsKey(function))
            {
                return FunctionSymbolTable[function];
            }
            return SymbolTable;
        }

        /// <summary>
        /// Retrieve concrete expression of an fieldexpression
        /// </summary>
        /// <param name="expression">FieldExpression</param>
        /// <returns>Concrete expression</returns>
        private Node GetExpression(Node expression)
        {
            Node expr = expression.ViewAllNodes().ElementAt(0);
            //Get real expression, not reference
            while (expr.Brand.Text == "VarExpression")
            {
                Node identifier = expr.ViewAllNodes().ElementAt(0);
                expr = SymbolTable.GetVariableDefinition(identifier.AtomicValue.ToString());
            }

            //When dealing with RecordExpression, get specific record
            if (expr.Brand.Text == "RecordExpression")
            {
                Node expressionIdentifier = expression.ViewAllNodes().ElementAt(1);
                foreach (Node pair in expr.ViewAllNodes())
                {
                    Node key = pair.ViewAllNodes().ElementAt(0);
                    Node value = pair.ViewAllNodes().ElementAt(1);
                    if (key.AtomicValue.ToString() == expressionIdentifier.AtomicValue.ToString())
                    {
                        return value;
                    }
                }
            }
            return null;
        }

        private bool EvaluatePredicate(Node predicate)
        {
            if (predicate.Brand.Text == "IsAPredicate")
            {   //Evaluate IsAPredicate
                Node expression = predicate.ViewAllNodes().ElementAt(0);
                Node type = predicate.ViewAllNodes().ElementAt(1);

                //Evaluate type
                if (type.AtomicValue.ToString() == "string")
                {
                    return expression.Brand.Text == "TextExpression";
                }
                else if (type.AtomicValue.ToString() == "list")
                {
                    return expression.Brand.Text == "ListExpression";
                }
                else if (type.AtomicValue.ToString() == "record")
                {
                    return expression.Brand.Text == "RecordExpression";
                }
                else
                {
                    return false;
                }
            }
            else if (predicate.Brand.Text == "ExpressionPredicate")
            {   //Evaluate ExpressionPredicate
                Node expression = predicate.ViewAllNodes().ElementAt(0);
                if (expression.Brand.Text == "FieldExpression")
                {   //Check if field exists in record
                    Node expr = GetExpression(expression);
                    return expr != null;
                }
                else if (expression.Brand.Text == "VarExpression")
                {   //Check if variable is defined
                    Node varIdentifier = expression.ViewAllNodes().ElementAt(0);
                    return SymbolTable.ContainsVariable(varIdentifier.AtomicValue.ToString());
                }
                else
                {   //Other expressions are always true, they don't refer to data
                    return true;
                }
            }
            else if (predicate.Brand.Text == "AndPredicate")
            {   //Evaluate AndPredicate
                return EvaluatePredicate(predicate.ViewAllNodes().ElementAt(0)) && EvaluatePredicate(predicate.ViewAllNodes().ElementAt(1));
            }
            else if (predicate.Brand.Text == "OrPredicate")
            {   //Evaluate OrPredicate
                return EvaluatePredicate(predicate.ViewAllNodes().ElementAt(0)) || EvaluatePredicate(predicate.ViewAllNodes().ElementAt(1));
            }
            else if (predicate.Brand.Text == "NotPredicate")
            {   //Evaluate NotPredicate
                return !EvaluatePredicate(predicate.ViewAllNodes().ElementAt(0));
            }
            return false;
        }

        #endregion
    }
}
