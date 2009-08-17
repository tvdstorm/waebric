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
                case "MarkupStatement":
                    VisitMarkupStatement(statement);
                    break;
                case "MarkupsStatement":
                    VisitMarkupsStatement(statement);
                    break;
                case "MarkupStatStatement":
                    VisitMarkupStatStatement(statement);
                    break;
                case "MarkupEmbeddingStatement":
                    VisitMarkupEmbeddingStatement(statement);
                    break;
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
            if (value.AtomicValue != null)
            {
                TextValue = value.AtomicValue.ToString();
            }
            else
            {
                TextValue = "";
            }
        }

        /// <summary>
        /// Interpret SymbolExpression
        /// </summary>
        /// <param name="symbolExpression">SymbolExpression to interpret</param>
        public void VisitSymbolExpression(Node symbolExpression)
        {
            Node value = symbolExpression.ViewAllNodes().ElementAt(0);
            if (value.AtomicValue != null)
            {
                TextValue = value.AtomicValue.ToString();
            }
            else
            {
                TextValue = "";
            }
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
            if (value.AtomicValue != null)
            {
                TextValue = value.AtomicValue.ToString();
            }
            else
            {
                TextValue = "";
            }
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
                    VisitIdAttribute(attribute);
                    break;
                case "ClassAttribute":
                    VisitClassAttribute(attribute);
                    break;
                case "NameAttribute":
                    VisitNameAttribute(attribute);
                    break;
                case "TypeAttribute":
                    VisitTypeAttribute(attribute);
                    break;
                case "WidthHeightAttribute":
                    VisitWidthHeightAttribute(attribute);
                    break;
                case "WidthAttribute":
                    VisitWidthAttribute(attribute);
                    break;
            }
        }

        /// <summary>
        /// Interpret IdAttribute
        /// </summary>
        /// <param name="idAttribute">IdAttribute to interpret</param>
        public void VisitIdAttribute(Node idAttribute)
        {   //Add id attribute
            Node id = idAttribute.ViewAllNodes().ElementAt(0);
            Current.AddAttribute("id", id.AtomicValue.ToString());
        }

        /// <summary>
        /// Interpret ClassAttribute
        /// </summary>
        /// <param name="classAttribute">ClassAttribute to interpret</param>
        public void VisitClassAttribute(Node classAttribute)
        {   //Add class attribute
            Node classId = classAttribute.ViewAllNodes().ElementAt(0);
            Current.AddAttribute("class", classId.AtomicValue.ToString());
        }

        /// <summary>
        /// Interpret NameAttribute
        /// </summary>
        /// <param name="nameAttribute">NameAttribute to interpret</param>
        public void VisitNameAttribute(Node nameAttribute)
        {   //Add name attribute
            Node name = nameAttribute.ViewAllNodes().ElementAt(0);
            Current.AddAttribute("name", name.AtomicValue.ToString());
        }

        /// <summary>
        /// Interpret TypeAttribute
        /// </summary>
        /// <param name="typeAttribute">TypeAttribute to interpret</param>
        public void VisitTypeAttribute(Node typeAttribute)
        {   //Add TypeAttribute
            Node type = typeAttribute.ViewAllNodes().ElementAt(0);
            Current.AddAttribute("type", type.AtomicValue.ToString());
        }

        /// <summary>
        /// Interpret WidthHeightAttribute
        /// </summary>
        /// <param name="widthHeightAttribute">WidthHeightAttribute to interpret</param>
        public void VisitWidthHeightAttribute(Node widthHeightAttribute)
        {   //Add WidthHeightAttribute
            Node width = widthHeightAttribute.ViewAllNodes().ElementAt(0);
            Node height = widthHeightAttribute.ViewAllNodes().ElementAt(1);
            Current.AddAttribute("width", width.AtomicValue.ToString());
            Current.AddAttribute("height", height.AtomicValue.ToString());
        }

        /// <summary>
        /// Interpret WidthAttribute
        /// </summary>
        /// <param name="widthAttribute">WidthAttribute to interpret</param>
        public void VisitWidthAttribute(Node widthAttribute)
        {   //Add WidthAttribute
            Node width = widthAttribute.ViewAllNodes().ElementAt(0);
            Current.AddAttribute("width", width.AtomicValue.ToString());
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

        /// <summary>
        /// Interpret EachStatement
        /// </summary>
        /// <param name="eachStatement">EachStatement to interpret</param>
        public void VisitEachStatement(Node eachStatement)
        {
            Node expression = eachStatement.ViewAllNodes().ElementAt(1);
            Node varId = eachStatement.ViewAllNodes().ElementAt(0);
            Node statement = eachStatement.ViewAllNodes().ElementAt(2);
            if (expression.Brand.Text == "ListExpression")
            {
                //Walk through list expression
                XHTMLElement temp = Current;
                foreach (Node expr in expression.ViewAllNodes())
                {
                    Current = temp;

                    //New scope
                    SymbolTable = new SymbolTable(SymbolTable);

                    //Fill variable and then interpret statement in current context
                    SymbolTable.AddVariableDefinition(varId.AtomicValue.ToString(), expr);
                    VisitStatement(statement);

                    //Go to parent scope
                    SymbolTable = SymbolTable.GetParentSymbolTable();
                }
            }
            else if(expression.Brand.Text == "FieldExpression")
            {   //Get expression in referenced record
                Node expr = GetExpression(expression);

                //Create new EachStatement with new expression
                NodeGraphBuilder nodeBuilder = new NodeGraphBuilder();

                Node newEachStatement = (Node) nodeBuilder.DefineNode("EachStatement");
                newEachStatement.Add(varId);
                newEachStatement.Add(expr);
                newEachStatement.Add(statement);
                VisitEachStatement(newEachStatement);
            }
            else if(expression.Brand.Text == "VarExpression")
            {   //Get expression in referenced record
                Node expr = SymbolTable.GetVariableDefinition(varId.AtomicValue.ToString());

                //Create new EachStatement with new expression
                NodeGraphBuilder nodeBuilder = new NodeGraphBuilder();

                Node newEachStatement = (Node)nodeBuilder.DefineNode("EachStatement");
                newEachStatement.Add(varId);
                newEachStatement.Add(expr);
                newEachStatement.Add(statement);
                VisitEachStatement(newEachStatement);
            }
        }

        /// <summary>
        /// Interpret LetStatement
        /// </summary>
        /// <param name="letStatement">LetStatement to interpret</param>
        public void VisitLetStatement(Node letStatement)
        {
            //Store assignments into SymbolTable
            Node Assignments = letStatement.ViewAllNodes().ElementAt(0);
            foreach (Node Assignment in Assignments.ViewAllNodes())
            {
                //Create new scope for every assignment
                SymbolTable = new SymbolTable(SymbolTable);
                VisitAssignment(Assignment);
            }

            //Interpret statements
            Node Statements = letStatement.ViewAllNodes().ElementAt(1);
            foreach (Node statement in Statements.ViewAllNodes())
            {
                VisitStatement(statement);
            }

            //Restore scoping on end of LetStatement
            foreach (Node Assignment in Assignments.ViewAllNodes())
            {
                SymbolTable = SymbolTable.GetParentSymbolTable();
            }
        }

        /// <summary>
        /// Interpret Assignment
        /// </summary>
        /// <param name="assignment">Assignment to interpret</param>
        public void VisitAssignment(Node assignment)
        {   
            //Detect assignment type
            switch (assignment.Brand.Text)
            {
                case "VarBindAssignment":
                    VisitVarBindAssignment(assignment);
                    break;
                case "FuncBindAssignment":
                    VisitFuncBindAssignment(assignment);
                    break;
            }
        }
        
        /// <summary>
        /// Interpret VarBindAssignment
        /// </summary>
        /// <param name="varBindAssignment">VarBindAssignment to interpret</param>
        public void VisitVarBindAssignment(Node varBindAssignment)
        {
            Node varIdentifier = varBindAssignment.ViewAllNodes().ElementAt(0);
            Node expression = varBindAssignment.ViewAllNodes().ElementAt(1);
            SymbolTable.AddVariableDefinition(varIdentifier.AtomicValue.ToString(), expression);
        }

        /// <summary>
        /// Interpret FuncBindAssignment
        /// </summary>
        /// <param name="funcBindAssignment">FuncBindAssignment to interpret</param>
        public void VisitFuncBindAssignment(Node funcBindAssignment)
        {
            //Convert FuncBind in a FunctionDef node
            NodeGraphBuilder graphBuilder = new NodeGraphBuilder();

            //Create functionDef node
            Node functionDef = (Node)graphBuilder.DefineNode("FunctionDef");

            //Add identifier of function
            functionDef.Add(funcBindAssignment.ViewAllNodes().ElementAt(0));

            //Add formals
            functionDef.Add(funcBindAssignment.ViewAllNodes().ElementAt(1));

            //Create StatementList to store the single statement in
            Node statementList = (Node)graphBuilder.DefineNode("StatementList");
            statementList.Add(funcBindAssignment.ViewAllNodes().ElementAt(2));
            functionDef.Add(statementList);

            Node identifier = funcBindAssignment.ViewAllNodes().ElementAt(0);

            //Create new SymbolTable for function
            FunctionSymbolTable.Add(functionDef, (SymbolTable)SymbolTable.Clone());

            //Add function to SymbolTable
            SymbolTable.AddFunctionDefinition(identifier.AtomicValue.ToString(), functionDef);
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
                Node statement = trueStatement.ViewAllNodes().ElementAt(0);
                VisitStatement(statement);
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
                Node statement = trueStatement.ViewAllNodes().ElementAt(0);
                VisitStatement(statement);
            }
            else
            {
                Node statement = falseStatement.ViewAllNodes().ElementAt(0);
                VisitStatement(statement);
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

            //Add just an tag to current as parent
            XHTMLElement echoElement = new XHTMLElement(TextValue, Current);
            echoElement.SetTagState(false);

            Current.AddChild(echoElement);
        }

        /// <summary>
        /// Interpret EchoEmbeddingStatement
        /// </summary>
        /// <param name="echoEmbeddingStatement">EchoEmbeddingStatement to interpret</param>
        public void VisitEchoEmbeddingStatement(Node echoEmbeddingStatement)
        {
            Node embedding = echoEmbeddingStatement.ViewAllNodes().ElementAt(0);
            VisitEmbedding(embedding);
        }

        /// <summary>
        /// Interpret Embedding
        /// </summary>
        /// <param name="embedding">Embedding to interpret</param>
        public void VisitEmbedding(Node embedding)
        {
            Node preText = embedding.ViewAllNodes().ElementAt(0);
            Node preTextValue = preText.ViewAllNodes().ElementAt(0);
            Node embed = embedding.ViewAllNodes().ElementAt(1);
            Node textTail = embedding.ViewAllNodes().ElementAt(2);

            //Add content of pretext
            String preTextString = "";
            if (preTextValue.AtomicValue != null)
            {
                preTextString = preTextValue.AtomicValue.ToString();
            }
            XHTMLElement element = new XHTMLElement(preTextString, Current);
            element.SetTagState(false);
            Current.AddChild(element);

            //Interpret Embed and TextTail
            VisitEmbed(embed);
            VisitTextTail(textTail);
        }

        /// <summary>
        /// Interpret Embed
        /// </summary>
        /// <param name="embed">Embed to interpret</param>
        public void VisitEmbed(Node embed)
        {
            //Convert to MarkupsStatement
            NodeGraphBuilder nodeBuilder = new NodeGraphBuilder();

            Node markupsStatement = (Node)nodeBuilder.DefineNode("MarkupsStatement");
            
            //Check if there's an MarkupList, otherwise add empty markuplist
            Node markupList = embed.ViewAllNodes().ElementAt(0);
            if (markupList.Brand.Text == "")
            {   //Empty list, so create an new empty MarkupList node
                markupList = (Node)nodeBuilder.DefineNode("MarkupList");
            }

            markupsStatement.Add(markupList);
            markupsStatement.Add(embed.ViewAllNodes().ElementAt(1));
            
            //Interpret markupsStatement
            VisitMarkupsStatement(markupsStatement);
        }

        /// <summary>
        /// Interpret TextTail
        /// </summary>
        /// <param name="textTail">TextTail to interpret</param>
        public void VisitTextTail(Node textTail)
        {
            //Determine type of texttail
            if (textTail.Brand.Text == "MidTextTail")
            {
                Node midText = textTail.ViewAllNodes().ElementAt(0);
                Node midTextValue = midText.ViewAllNodes().ElementAt(0);

                //Check if there's an midText string and interpret it
                String midTextString = "";
                if(midTextValue.AtomicValue != null)
                {
                    midTextString = midTextValue.AtomicValue.ToString();
                }
                XHTMLElement element = new XHTMLElement(midTextString, Current);
                element.SetTagState(false);
                Current.AddChild(element);

                //Interpret embed
                XHTMLElement temp = Current;
                Node embed = textTail.ViewAllNodes().ElementAt(1);
                VisitEmbed(embed);
                Current = temp;

                //Interpret texttail
                Node tail = textTail.ViewAllNodes().ElementAt(2);
                VisitTextTail(tail);
            }
            else if (textTail.Brand.Text == "PostTextTail")
            {
                Node postText = textTail.ViewAllNodes().ElementAt(0);
                Node postTextValue = postText.ViewAllNodes().ElementAt(0);

                //Check if there's an postText string and interpret it
                String postTextString = "";
                if (postTextValue.AtomicValue != null)
                {
                    postTextString = postTextValue.AtomicValue.ToString();
                }

                XHTMLElement element = new XHTMLElement(postTextString, Current);
                element.SetTagState(false);
                Current.AddChild(element);
            }
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

        /// <summary>
        /// Interpret YieldStatement
        /// </summary>
        /// <param name="yieldStatement">YieldStatement to interpret</param>
        public void VisitYieldStatement(Node yieldStatement)
        {
            if (YieldStack.Count == 0)
            {
                return;
            }

            //Pop from YieldStack and lets interpet it
            Node node = YieldStack.Pop();

            if (node != null)
            {
                //Let's copy yieldstack, because there are possible yields in the yield. 
                Stack<Node> tempYieldStack = new Stack<Node>();
                List<Node> yieldList = YieldStack.ToList();
                foreach (Node yieldNode in yieldList)
                {
                    tempYieldStack.Push(yieldNode);
                }

                //Lets interpret it
                VisitYieldNode(node);

                //Add some content when node is an expression or embedding
                if (IsExpression(node) || node.Brand.Text == "Embedding")
                {
                    //TODO, MAYBE TEMP ELEMENT IS NEEDED!!!
                    XHTMLElement element = new XHTMLElement(TextValue, Current);
                    element.SetTagState(false);
                    Current.AddChild(element);
                }

                //Restore YieldStack in original shape before interpreting
                YieldStack = tempYieldStack;
            }
        }

        /// <summary>
        /// Special method to visit nodes which are on YieldStack
        /// </summary>
        /// <param name="node">Node to visit</param>
        public void VisitYieldNode(Node node)
        {
            switch (node.Brand.Text)
            {
                case "BlockStatement":
                    VisitBlockStatement(node);
                    break;
                case "EachStatement":
                    VisitEachStatement(node);
                    break;
                case "LetStatement":
                    VisitLetStatement(node);
                    break;
                case "IfStatement":
                    VisitIfStatement(node);
                    break;
                case "IfElseStatement":
                    VisitIfElseStatement(node);
                    break;
                case "CommentStatement":
                    VisitCommentStatement(node);
                    break;
                case "EchoExpressionStatement":
                    VisitEchoExpressionStatement(node);
                    break;
                case "EchoEmbeddingStatement":
                    VisitEchoEmbeddingStatement(node);
                    break;
                case "CDataStatement":
                    VisitCDataStatement(node);
                    break;
                case "YieldStatement":
                    VisitYieldStatement(node);
                    break;
                case "MarkupStatement":
                    VisitMarkupStatement(node);
                    break;
                case "MarkupsStatement":
                    VisitMarkupsStatement(node);
                    break;
                case "MarkupStatStatement":
                    VisitMarkupStatStatement(node);
                    break;
                case "MarkupEmbeddingStatement":
                    VisitMarkupEmbeddingStatement(node);
                    break;
                case "TextExpression":
                    VisitTextExpression(node);
                    break;
                case "SymbolExpression":
                    VisitSymbolExpression(node);
                    break;
                case "VarExpression":
                    VisitVarExpression(node);
                    break;
                case "NatExpression":
                    VisitNatExpression(node);
                    break;
                case "CatExpression":
                    VisitCatExpression(node);
                    break;
                case "FieldExpression":
                    VisitFieldExpression(node);
                    break;
                case "ListExpression":
                    VisitListExpression(node);
                    break;
                case "RecordExpression":
                    VisitRecordExpression(node);
                    break;
            }
        }

        /// <summary>
        /// Interpret MarkupStatement
        /// </summary>
        /// <param name="markupStatement">MarkupStatement interpret</param>
        public void VisitMarkupStatement(Node markupStatement)
        {
            Node markup = markupStatement.ViewAllNodes().ElementAt(0);

            //Determine if markup is a call
            if (IsCall(markup))
            {
                Node designator = markup.ViewAllNodes().ElementAt(0);
                Node functionIdentifier = designator.ViewAllNodes().ElementAt(0);
                if (NodeContainsYield(SymbolTable.GetFunctionDefinition(functionIdentifier.AtomicValue.ToString())))
                {   //Store null element, nothing to yield
                    YieldStack.Push(null);
                }
            }

            //Interpret markup
            VisitMarkup(markup);
        }

        /// <summary>
        /// Interpret MarkupsStatement
        /// </summary>
        /// <param name="markupsStatement">MarkupsStatement to interpret</param>
        public void VisitMarkupsStatement(Node markupsStatement)
        {
            //Handle MarkupList first
            Node markupList = markupsStatement.ViewAllNodes().ElementAt(0);
            NodeCollection markups = markupList.ViewAllNodes();
            for (int i = 0; i <= (markups.Count - 1); i++)
            {
                Node currentMarkup = markups.ElementAt(i);
                Node currentDesignator = currentMarkup.ViewAllNodes().ElementAt(0);

                if (IsCall(currentMarkup))
                {   //Check is called function contains, yield
                    Node functionIdentifier = currentDesignator.ViewAllNodes().ElementAt(0);
                    if(NodeContainsYield(SymbolTable.GetFunctionDefinition(functionIdentifier.AtomicValue.ToString())))
                    {   //Construct new MarkupsStatement to push on yieldstack
                        NodeGraphBuilder nodeBuilder = new NodeGraphBuilder();
                        
                        //Construct new markupList with remaining nodes
                        Node newMarkupList = (Node)nodeBuilder.DefineNode("MarkupList");
                        for (int j = i + 1; j <= (markups.Count - 1); j++)
                        {
                            newMarkupList.Add(markups.ElementAt(j));
                        }

                        //Create new statement and fill it with childnodes
                        Node newMarkupsStatement = (Node)nodeBuilder.DefineNode("MarkupsStatement");
                        newMarkupsStatement.Add(newMarkupList);
                        newMarkupsStatement.Add(markupsStatement.ViewAllNodes().ElementAt(1));
                        
                        //Push node to yieldstack
                        YieldStack.Push(newMarkupsStatement);
                    }

                    //Interpret markup
                    VisitMarkup(currentMarkup);
                    return;
                }
                else
                {   //Interpret Tag
                    VisitMarkup(currentMarkup);
                }
            }


            Node unknownElement = markupsStatement.ViewAllNodes().ElementAt(1);
            if (IsExpression(unknownElement))
            {   //Interpret expression
                VisitExpression(unknownElement);

                XHTMLElement element = new XHTMLElement(TextValue, Current);
                element.SetTagState(false);
                Current.AddChild(element);
            }
            else
            {   //Interpret markup
                VisitMarkup(unknownElement);
            }
        }

        /// <summary>
        /// Interpret MarkupStatStatement
        /// </summary>
        /// <param name="markupStatStatement">MarkupStatStatement to interpret</param>
        public void VisitMarkupStatStatement(Node markupStatStatement)
        {
            Node markupList = markupStatStatement.ViewAllNodes().ElementAt(0);
            NodeCollection markups = markupList.ViewAllNodes();
            for (int i = 0; i <= (markups.Count - 1); i++)
            {
                Node currentMarkup = markups.ElementAt(i);
                Node currentDesignator = currentMarkup.ViewAllNodes().ElementAt(0);

                if (IsCall(currentMarkup))
                {   //Check is called function contains, yield
                    Node functionIdentifier = currentDesignator.ViewAllNodes().ElementAt(0);
                    if (NodeContainsYield(SymbolTable.GetFunctionDefinition(functionIdentifier.AtomicValue.ToString())))
                    {   //Construct new MarkupStatStatement to push on yieldstack
                        NodeGraphBuilder nodeBuilder = new NodeGraphBuilder();

                        //Construct new markupList with remaining nodes
                        Node newMarkupList = (Node)nodeBuilder.DefineNode("MarkupList");
                        for (int j = i + 1; j <= (markups.Count - 1); j++)
                        {
                            newMarkupList.Add(markups.ElementAt(j));
                        }

                        //Create new statement and fill it with childnodes
                        Node newMarkupStatStatement = (Node)nodeBuilder.DefineNode("MarkupStatStatement");
                        newMarkupStatStatement.Add(newMarkupList);
                        newMarkupStatStatement.Add(markupStatStatement.ViewAllNodes().ElementAt(1));

                        //Push node to yieldstack
                        YieldStack.Push(newMarkupStatStatement);
                    }

                    //Interpret markup
                    VisitMarkup(currentMarkup);
                    return;
                }
                else
                {   //Interpret Tag
                    VisitMarkup(currentMarkup);
                }
            }

            //Interpret statement
            VisitStatement(markupStatStatement.ViewAllNodes().ElementAt(1));
        }

        /// <summary>
        /// Interpret MarkupEmbeddingStatement
        /// </summary>
        /// <param name="markupEmbeddingStatement">MarkupEmbeddingStatement to interpret</param>
        public void VisitMarkupEmbeddingStatement(Node markupEmbeddingStatement)
        {
            Node markupList = markupEmbeddingStatement.ViewAllNodes().ElementAt(0);
            NodeCollection markups = markupList.ViewAllNodes();
            for (int i = 0; i <= (markups.Count - 1); i++)
            {
                Node currentMarkup = markups.ElementAt(i);
                Node currentDesignator = currentMarkup.ViewAllNodes().ElementAt(0);

                if (IsCall(currentMarkup))
                {   //Check is called function contains, yield
                    Node functionIdentifier = currentDesignator.ViewAllNodes().ElementAt(0);
                    if (NodeContainsYield(SymbolTable.GetFunctionDefinition(functionIdentifier.AtomicValue.ToString())))
                    {   //Construct new MarkupEmbeddingStatement to push on yieldstack
                        NodeGraphBuilder nodeBuilder = new NodeGraphBuilder();

                        //Construct new markupList with remaining nodes
                        Node newMarkupList = (Node)nodeBuilder.DefineNode("MarkupList");
                        for (int j = i + 1; j <= (markups.Count - 1); j++)
                        {
                            newMarkupList.Add(markups.ElementAt(j));
                        }

                        //Create new statement and fill it with childnodes
                        Node newMarkupEmbeddingStatement = (Node)nodeBuilder.DefineNode("MarkupEmbeddingStatement");
                        newMarkupEmbeddingStatement.Add(newMarkupList);
                        newMarkupEmbeddingStatement.Add(markupEmbeddingStatement.ViewAllNodes().ElementAt(1));

                        //Push node to yieldstack
                        YieldStack.Push(newMarkupEmbeddingStatement);
                    }

                    //Interpret markup
                    VisitMarkup(currentMarkup);
                    return;
                }
                else
                {   //Interpret Tag
                    VisitMarkup(currentMarkup);
                }
            }

            //Interpret statement
            VisitEmbedding(markupEmbeddingStatement.ViewAllNodes().ElementAt(1));
        }

        /// <summary>
        /// Interpret Markup
        /// </summary>
        /// <param name="markup">Markup to interpret</param>
        public void VisitMarkup(Node markup)
        {
            Node designator = markup.ViewAllNodes().ElementAt(0);
            Node tag = designator.ViewAllNodes().ElementAt(0);
            if (IsCall(markup))
            {   //Handle function call
                Node functionDefinition = SymbolTable.GetFunctionDefinition(tag.AtomicValue.ToString());

                //Create SymbolTable for function call
                SymbolTable tempSymbolTable = SymbolTable;
                SymbolTable = new SymbolTable(GetSymbolTableOfFunction(functionDefinition));

                //Interpret arguments of function call
                if (markup.ViewAllNodes().Count == 2)
                {
                    Node arguments = markup.ViewAllNodes().ElementAt(1);
                    Node formals = functionDefinition.ViewAllNodes().ElementAt(1);
                    int parameterNr = 0;
                    foreach (Node argument in arguments.ViewAllNodes())
                    {
                        //Store arguments in SymbolTable
                        if (argument.Brand.Text == "ExpressionArgument")
                        {
                            Node parameter = formals.ViewAllNodes().ElementAt(parameterNr);
                            SymbolTable.AddVariableDefinition(parameter.AtomicValue.ToString(), argument.ViewAllNodes().ElementAt(0));
                            parameterNr++;
                        }
                    }
                }

                //Visit function definition
                VisitFunctionDefinition(functionDefinition);

                //Restore scope
                SymbolTable = tempSymbolTable;
        
            }
            else
            {   //Handle tag
                
                //Write tag with attributes
                AddElement(new XHTMLElement(tag.AtomicValue.ToString(), Current));

                //Visit attributes
                Node attributes = designator.ViewAllNodes().ElementAt(1);
                foreach (Node attribute in attributes.ViewAllNodes())
                {
                    VisitAttribute(attribute);
                }

                //Interpret arguments also as attributes if they exist
                if(markup.ViewAllNodes().Count == 2)
                {
                    String attributeValue = "";
                    Node arguments = markup.ViewAllNodes().ElementAt(1);
                    foreach (Node argument in arguments.ViewAllNodes())
                    {
                        if (argument.Brand.Text == "AttrArgument")
                        {
                            //Interpret expression to retrieve value
                            Node expression = argument.ViewAllNodes().ElementAt(1);
                            VisitExpression(expression);

                            //Store attribute
                            Node attrId = argument.ViewAllNodes().ElementAt(0);
                            Current.AddAttribute(attrId.AtomicValue.ToString(), TextValue);
                        }
                        else if (argument.Brand.Text == "ExpressionArgument")
                        {
                            //Interpret expression
                            Node expression = argument.ViewAllNodes().ElementAt(0);
                            VisitExpression(expression);
                            if (TextValue == "undef")
                            {
                                TextValue = "UNDEFINED";
                            }
                            //Store value
                            if (!(attributeValue == "") && !(TextValue != ""))
                            {
                                attributeValue += " ";
                            }
                            attributeValue += TextValue;
                        }
                    }

                    if (attributeValue != "")
                    {
                        Current.AddAttribute("value", attributeValue);
                    }
                }
            }
        }

        /// <summary>
        /// Get XHTML tree
        /// </summary>
        /// <returns>Root element of tree</returns>
        public XHTMLElement GetTree()
        {
            return Root;
        }

        #endregion

        #region Private Methods

        /// <summary>
        /// Determines if an specific node is an expression
        /// </summary>
        /// <param name="node">Node to check</param>
        /// <returns>IsExpression</returns>
        private bool IsExpression(Node node)
        {
            switch (node.Brand.Text)
            {
                case "TextExpression":
                    return true;
                case "VarExpression":
                    return true;
                case "SymbolExpression":
                    return true;
                case "NatExpression":
                    return true;
                case "FieldExpression":
                    return true;
                case "CatExpression":
                    return true;
                case "ListExpression":
                    return true;
                case "RecordExpression":
                    return true;
                default:
                    return false;
            }
        }

        /// <summary>
        /// Determine if markup is a call
        /// </summary>
        /// <param name="markup">Markup to check</param>
        /// <returns>IsCall</returns>
        private bool IsCall(Node markup)
        {
            Node designator = markup.ViewAllNodes().ElementAt(0);
            Node identifier = designator.ViewAllNodes().ElementAt(0);
            return SymbolTable.ContainsFunction(identifier.AtomicValue.ToString());
        }

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

        /// <summary>
        /// Check if an node contains an yield
        /// </summary>
        /// <param name="node">Node to check</param>
        /// <returns>True if node contains yield, otherwise false</returns>
        private bool NodeContainsYield(Node node)
        {
            if (node.Brand.Text == "YieldStatement")
            {   //Node itself is an yield
                return true;
            }
            else
            {   //Check subnodes
                foreach (Node subNode in node.ViewAllNodes())
                {
                    if (NodeContainsYield(subNode))
                    {
                        return true;
                    }
                }
                //No Yields found
                return false;
            }
        }

        #endregion
    }
}
