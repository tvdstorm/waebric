function WaebricInterpreterVisitor(env){
	
	/**
	 * Returns a module visitor
	 */
	this.getModuleVisitor = function(env, dom){
		return new ModuleVisitor(env, dom);
	}
	
	/**
	 * Visitor for Module
	 *
	 */
	function ModuleVisitor(env, dom){	
		this.env = env;
		this.dom = dom;	
		this.visit = function(module){
			/*//Assign name to environment for exception logging
			if (this.env.name == '') {
				this.env.name = module.moduleId.identifier;
			}			
			
			//Visit dependencies
			//Should be done before the current module is visited			
			for (var i = 0; i < module.dependencies.length; i++) {
				var dependency = module.dependencies[i];
				dependency.accept(new DependencyVisitor(this.env, this.dom));
			}*/
			
			//Store Function Definitions
			//Should be done before the FunctionDefinitionVisitor is called
			for (var i = 0; i < module.functionDefinitions.length; i++) {
				var functionDefinition = module.functionDefinitions[i];
				if (!this.env.containsFunction(functionDefinition.functionName)) {
					this.env.addFunction(functionDefinition);
				} else {
					this.env.addException(new DuplicateDefinitionException(functionDefinition));
				}
			}
			
			var mainFunction = this.env.getLocalFunction('main');
			if(mainFunction != null){				
				this.dom.createXHTMLRoot();
				mainFunction.accept(new FunctionDefinitionVisitor(this.env, this.dom));
			}
			
			/*//Visit Function Definitions{
			for (var i = 0; i < module.functionDefinitions.length; i++) {
				var functionDefinition = module.functionDefinitions[i];
				functionDefinition.accept(new FunctionDefinitionVisitor(this.env, this.dom));
			}
			//Visit Mappings
			for (var i = 0; i < module.site.mappings.length; i++) {
				var mapping = module.site.mappings[i];
				mapping.markup.accept(new MarkupVisitor(this.env, this.dom));
			}*/
		}
	}	
	
	/**
	 * Visitor for dependencies (imports)
	 */
	function DependencyVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(module){
			//Visit only unprocessed dependencies
			var dependency = module.dependencies[i];
			var dependencyName = dependency.moduleId.identifier;
			var existingDependency = this.env.getDependency(dependencyName);
			
			//If dependency is not processed before, visit it
			if (existingDependency == null) {
				var new_env = this.env.addDependency('module');
				new_env.name = dependency.moduleId.identifier;
				dependency.accept(new ModuleVisitor(new_env));
			}    //If dependency was processed before, add existing dependecy to
			//current environment but do not visit it again.
			else {
				this.env.addExistingDependency(existingDependency);
			}
		}
	}
	
	/**
	 * Visitor for FunctionDefinition
	 *
	 */
	function FunctionDefinitionVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(functionDefinition){
			//Add Arguments of function to new environment	
			var new_env;
			if (!functionDefinition.isFunctionBinding) {
				new_env = this.env.addEnvironment('func-def');
			}else{
				new_env = this.env.addEnvironment('func-bind')
			}
			
			for (var i = 0; i < functionDefinition.formals.length; i++){
				//Get variable name from arguments 				
				var variableName = functionDefinition.formals[i];
				
				//Retrieve variable value from parent environment (markup call)
				//The value of the first function argument equals the first argument
				//in the function call (markup call)
				var variableValue;
				if (this.env.variables.length > i) {
					 variableValue = this.env.variables[i].value;
				}else{
					variableValue = 'undef';
				}
				
				//Save variable
				new_env.addVariable(variableName, variableValue);
			}
			
			//VisitStatements
			for (var i = 0; i < functionDefinition.statements.length; i++) {
				print('visit statements')
				var statement = functionDefinition.statements[i];
				statement.accept(new StatementVisitor(new_env, this.dom));
			}
		}
	}
	
	/**
	 * Visitor for Statement
	 */
	function StatementVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(statement){
			if (statement instanceof IfStatement) {
				statement.accept(new IfStatementVisitor(this.env, this.dom));
			} else if (statement instanceof IfElseStatement) {
				statement.accept(new IfElseStatementVisitor(this.env, this.dom));
			} else if (statement instanceof EachStatement) {
				statement.accept(new EachStatementVisitor(this.env, this.dom));
			} else if (statement instanceof LetStatement) {
				statement.accept(new LetStatementVisitor(this.env, this.dom));
			} else if (statement instanceof BlockStatement) {
				statement.accept(new BlockStatementVisitor(this.env, this.dom));
			} else if (statement instanceof CommentStatement) {
				//No action required
			} else if (statement instanceof EchoStatement) {
				statement.accept(new EchoStatementVisitor(this.env, this.dom));
			} else if (statement instanceof EchoEmbeddingStatement) {
				statement.accept(new EchoEmbeddingVisitor(this.env, this.dom));
			} else if (statement instanceof CDataExpression) {
				statement.accept(new CDataExpressionVisitor(this.env, this.dom));
			} else if (statement instanceof YieldStatement) {
				//No action required
			} else if (statement instanceof MarkupStatement) {
				statement.accept(new MarkupStatementVisitor(this.env, this.dom));
			} else if (statement instanceof MarkupMarkupStatement) {
				statement.accept(new MarkupMarkupStatementVisitor(this.env, this.dom));
			} else if (statement instanceof MarkupEmbeddingStatement) {
				statement.accept(new MarkupEmbeddingStatementVisitor(this.env, this.dom));
			} else if (statement instanceof MarkupStatementStatement) {
				statement.accept(new MarkupStatementStatementVisitor(this.env, this.dom));
			} else if (statement instanceof MarkupExpressionStatement) {
				statement.accept(new MarkupExpressionStatementVisitor(this.env, this.dom));
			} else { //Statement is not recognizederror.");
			}
			
		}
	}
	
	function isValidExpression(expression, env){
		if(expression instanceof FieldExpression){
			return isValidFieldExpression(expression, env);
		}else if(expression instanceof CatExpression){
			return isValidCatExpression(expression, env)
		}else{
			return true;
		}
	}
	
	function isValidFieldExpression(expression, env){
		return getFieldExpressionRootData(expression, env) != null;
	}
	
	function isValidCatExpression(expression, env){
		var isValidLeftExpression = isValidExpression(expression.expressionLeft, env);
		var isValidRightExpression = isValidExpression(expression.expressionRight, env);
		return isValidLeftExpression && isValidRightExpression;
	}
	
	function getExpressionValue(expression, env){
		if (expression instanceof FieldExpression) {
			return getFieldExpressionValue(expression, env);
		}else if(expression instanceof VarExpression){
			return env.getVariable(expression).value;
		}else{
			return expression;
		}
	}
	
	function getFieldExpressionValue(expression, env){
		//Store fields in array
		var fields = new Array();
		var expr = expression;
		while(expr instanceof FieldExpression){
			fields.push(expr.field);
			expr = expr.expression;
		}
		fields = fields.reverse();
		
		//Get root variable value
		var data = getFieldExpressionRootValue(expression, env);
		if (data == null) {
			return null;
		}
		
		//Get data by fields in array
		for(var i = 0; i < fields.length; i++){
			var field = fields[i];
			data = data.getValue(field);	
			if(data == null){
				return data;
			}
		}
		return data;
	}
	
	function getFieldExpressionRootValue(expression, env){
		var root = expression;
		while (root instanceof FieldExpression) {
			root = root.expression;
		}
		
		//Accept variables or record expressions as value
		if(root instanceof VarExpression){		
			return env.getVariable(root).value;
		}else if (root instanceof RecordExpression) {
			return root;
		}else {
			return null;
		}
	}
	
			
	/**
	 * Visitor IfStatement
	 */
	function IfStatementVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(ifStmt){	
			if (isValidExpression(ifStmt.predicate, this.env)) {
				ifStmt.ifStatement.accept(new StatementVisitor(this.env, this.dom))
			}
		}
	}
		
	/**
	 * Visitor IfElseStatement
	 */
	function IfElseStatementVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(ifElseStmt){			
			if (isValidExpression(ifElseStmt.predicate, this.env)) {
				ifElseStmt.ifStatement.accept(new StatementVisitor(this.env, this.dom));
			}else{
				ifElseStmt.elseStatement.accept(new StatementVisitor(this.env, this.dom));
			}			
		}
	}
	
	/**
	 * Visitor Each Statement
	 */
	function EachStatementVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(eachStmt){
			//Add new environment because the scope of the variable declaration (identifier)
			// is limited to the statement inside the each statement.
			var new_env = this.env.addEnvironment('each-stmt');
			
			//Add variable to new environment of each statement
			new_env.addVariable(eachStmt.identifier);
			
			//Get expression value
			var expressionValue = getExpressionValue(eachStmt.expression, this.env);
			
			//Expression value should be an array
			var lastElement = this.dom.lastElement;
			if(expressionValue instanceof ListExpression){				
				//Loop all records and output statement
				for(var i = 0; i < expressionValue.list.length; i++){					
					var listValue = expressionValue.list[i];			
					//Save variable to environment
					new_env.addVariable(eachStmt.identifier, listValue);	
					//Visit statement				
					eachStmt.statement.accept(new StatementVisitor(new_env, this.dom));
					//Set last element back to original (otherwise nesting)
					this.dom.lastElement = lastElement;
				}				
			}
		}
	}
	
	
	
	/**
	 * Visitor Let Statement
	 */
	function LetStatementVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(letStmt){
			//Assignments and statements in a let statement require a new environment under
			//the current environment since the scope of the assignments (function/variable declaration)
			// is limited to the statements inside the let statement
			var new_env = this.env.addEnvironment('let-stmt');
			
			//Visit Assignments (converts to function definition)
			for (var i = 0; i < letStmt.assignments.length; i++) {
				var assignment = letStmt.assignments[i];
				assignment.accept(new AssignmentVisitor(new_env, this.dom));
			}
			
			//Visit Statements
			var lastElement = this.dom.lastElement;
			for (var j = 0; j < letStmt.statements.length; j++) {
				var statement = letStmt.statements[j];
				statement.accept(new StatementVisitor(new_env, this.dom));
				this.dom.lastElement = lastElement; //Prevent nested nodes
			}
		}
	}

	/**
	 * Visitor Block Statement
	 */
	function BlockStatementVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(blockStmt){
			//Visit statements
			for (var i = 0; i < blockStmt.statements.length; i++) {
				var statement = blockStmt.statements[i];
				statement.accept(new StatementVisitor(this.env, this.dom));
			}
		}
	}

	/**
	 * Visitor Echo Statement
	 */
	function EchoStatementVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(echoStmt){
			//Visit Expression	
			echoStmt.expression.accept(new ExpressionVisitor(this.env, this.dom));
		}
	}
	
	/**
	 * Visitor for Echo Embedding
	 */
	function EchoEmbeddingVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(echoEmbeddingStmt){
			//Visit Embedding
			echoEmbeddingStmt.embedding.accept(new EmbeddingVisitor(this.env, this.dom));
		}
	}

	/**
	 * Visitor for CData
	 */
	function CDataExpressionVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(cdataExpr){
			//Visit Expression
			cdataExpr.expression.accept(new ExpressionVisitor(this.env, this.dom));
		}
	}
	
	/**
	 * Visitor Markup Statement
	 */
	function MarkupStatementVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(markupStmt){
			//Visit Markup
			markupStmt.markup.accept(new MarkupVisitor(this.env, this.dom));
		}
	}
	
	/**
	 * Visitor MarkupMarkup Statement
	 */
	function MarkupMarkupStatementVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(markupMarkupStmt){
			//Visit Markups
			for (var i = 0; i < markupMarkupStmt.markups.length; i++) {
				var markup = markupMarkupStmt.markups[i];
				markup.accept(new MarkupVisitor(this.env, this.dom));
			}
		}
	}
	
	/**
	 * Visitor MarkupEmbedding Statement
	 */
	function MarkupEmbeddingStatementVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(markupEmbeddingStmt){
			//Visit Markups
			for (var i = 0; i < markupEmbeddingStmt.markups.length; i++) {
				var markup = markupEmbeddingStmt.markups[i];
				markup.accept(new MarkupVisitor(this.env, this.dom));
			}
			
			//Visit Embedding
			markupEmbeddingStmt.embedding.accept(new EmbeddingVisitor(this.env, this.dom));
		}
	}
	
	/**
	 * Visitor MarkupStatement Statement
	 */
	function MarkupStatementStatementVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(markupStmtStmt){
			//Visit Markups
			for (var i = 0; i < markupStmtStmt.markups.length; i++) {
				var markup = markupStmtStmt.markups[i];
				markup.accept(new MarkupVisitor(this.env, this.dom));
			}
			
			//Visit Statement
			markupStmtStmt.statement.accept(new StatementVisitor(this.env, this.dom));
		}
	}
		
	/**
	 * Visitor MarkupExpression Statement
	 */
	function MarkupExpressionStatementVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(markupExprStmt){
			//Visit Markups
			for (var i = 0; i < markupExprStmt.markups.length; i++) {
				var markup = markupExprStmt.markups[i];
				markup.accept(new MarkupVisitor(this.env, this.dom));
			}
			
			//Visit Expression
			markupExprStmt.expression.accept(new ExpressionVisitor(this.env, this.dom));
			
			//Print out HTML from expression
			var text = this.dom.document.createTextNode(this.dom.lastValue);
			this.dom.lastElement.appendChild(text);
		}
	}
	
	/**
	 * Visitor Expression
	 */
	function ExpressionVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(expression){
			if (expression instanceof VarExpression) {
				expression.accept(new VarExpressionVisitor(this.env, this.dom));
			} else if (expression instanceof SymbolExpression) {
				expression.accept(new SymbolExpressionVisitor(this.env, this.dom));	
			} else if (expression instanceof NatExpression) {
				expression.accept(new NatExpressionVisitor(this.env, this.dom));
			} else if (expression instanceof TextExpression) {
				expression.accept(new TextExpressionVisitor(this.env, this.dom));
			} else if (expression instanceof FieldExpression) {
				expression.accept(new FieldExpressionVisitor(this.env, this.dom));
			} else if (expression instanceof CatExpression) {
				expression.accept(new CatExpressionVisitor(this.env, this.dom));
			} else if (expression instanceof ListExpression) {
				expression.accept(new ListExpressionVisitor(this.env, this.dom));
			} else if (expression instanceof RecordExpression) {
				expression.accept(new RecordExpressionVisitor(this.env, this.dom));
			} else { //Expression is not recognized
				print("Unrecognized Expression found. Parser should have thrown an error.");
			}
		}
	}	
		
	/**
	 * Visitor Variable Expression
	 */
	function VarExpressionVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(variable){
			var _var = this.env.getVariable(variable);	
			if (_var != null) {
				this.dom.lastValue = _var.value;
			}else{
				this.env.addException(new UndefinedVariableException(variable, this.env));
				this.dom.lastValue = 'undef';				
			}
		}
	}
	
	/**
	 * Visitor Symbol Expression
	 */
	function SymbolExpressionVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(symbol){
			//Save value temporary
			this.dom.lastValue = symbol;
		}
	}
	
	/**
	 * Visitor Variable Expression
	 */
	function NatExpressionVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(natural){
			//Save value temporary
			this.dom.lastValue = natural;
		}
	}
	
	/**
	 * Visitor Text Expression
	 */
	function TextExpressionVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(text){
			//Save value temporary
			this.dom.lastValue = text;
		}
	}
	
	
	/**
	 * Visitor Field Expression
	 */
	function FieldExpressionVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(fieldExpr){
			//Visit Expression
			fieldExpr.expression.accept(new ExpressionVisitor(this.env, this.dom));
		}
	}	
			
	/**
	 * Visitor Category Expression
	 */
	function CatExpressionVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(catExpr){
			//Visit Expression Left
			catExpr.expressionLeft.accept(new ExpressionVisitor(this.env, this.dom));
			
			//Visit Expression Right
			catExpr.expressionRight.accept(new ExpressionVisitor(this.env, this.dom));
		}
	}	
	
	/**
	 * Visitor List Expression
	 */
	function ListExpressionVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(listExpr){
			//Visit Expressions
			for (var i = 0; i < listExpr.list.length; i++) {
				var expression = listExpr.list[i];
				expression.accept(new ExpressionVisitor(this.env, this.dom));
			}
		}
	}
	
	/**
	 * Visitor Record Expression
	 */
	function RecordExpressionVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(recordExpr){
			//Visit KeyValuePairs
			for (var i = 0; i < recordExpr.records.length; i++) {
				var keyValuePair = recordExpr.records[i];
				keyValuePair.accept(new KeyValueVisitor(this.env, this.dom));
			}
		}
	}
		
	/**
	 * Visitor Predicate
	 */
	function PredicateVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(predicate){
			if (predicate instanceof NotPredicate) {
				predicate.predicate.accept(new PredicateVisitor(this.env, this.dom));
			} else if (predicate instanceof AndPredicate) {
				predicate.predicateLeft.accept(new PredicateVisitor(this.env, this.dom));
				predicate.predicateRight.accept(new PredicateVisitor(this.env, this.dom));
			} else if (predicate instanceof OrPredicate) {
				predicate.predicateLeft.accept(new PredicateVisitor(this.env, this.dom));
				predicate.predicateRight.accept(new PredicateVisitor(this.env, this.dom));
			} else if (predicate instanceof IsAPredicate) {
				predicate.expression.accept(new ExpressionVisitor(this.env, this.dom));
			} else { //Predicate is not recognized
				predicate.accept(new ExpressionVisitor(this.env, this.dom)); //Predicate is an Expression
			}
		}
	}
		
	/**
	 * Visitor for Embedding
	 */
	function EmbeddingVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(embedding){
			//Visit Embed
			embedding.embed.accept(new EmbedVisitor(this.env, this.dom));
			
			//Visit Tail
			embedding.tail.accept(new TextTailVisitor(this.env, this.dom));
		}
	}
	
	/**
	 * Visitor Embed
	 */
	function EmbedVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(embed){
			if (embed instanceof ExpressionEmbedding) {
				embed.accept(new ExpressionEmbeddingVisitor(this.env, this.dom));
			} else if (embed instanceof MarkupEmbedding) {
				embed.accept(new MarkupEmbeddingVisitor(this.env, this.dom));
			} else { //Embed is not recognized
				print("Unrecognized Embed found. Parser should have thrown an error.");
			}
		}
	}

	/**
	 * Visitor for TextTail
	 */
	function TextTailVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(textTail){
			if (textTail instanceof MidTextTail) {
				textTail.accept(new MidTextTailVisitor(this.env, this.dom));
			} else if (textTail instanceof PostTextTail) {
				//No action required
			} else { //TextTail is not recognized
				print("Unrecognized TextTail found. Parser should have thrown an error.");
			}
		}
	}
	
	/**
	 * Visitor for Mid Text Tail
	 */
	function MidTextTailVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(midTextTail){
			//Visit Embed
			midTextTail.embed.accept(new EmbedVisitor(this.env, this.dom));
			
			//Visit Tail
			midTextTail.tail.accept(new TextTailVisitor(this.env, this.dom));
		}
	}
			
	/**
	 * Visitor ExpressionEmbedding
	 */
	function ExpressionEmbeddingVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(exprEmbed){
			//Visit Markups	
			for (var i = 0; i < exprEmbed.markups.length; i++) {
				var markup = exprEmbed.markups[i];
				markup.accept(new MarkupVisitor(this.env, this.dom));
			}
			
			//Visit expression
			exprEmbed.expression.accept(new ExpressionVisitor(this.env, this.dom));
		}
	}
	
	/**
	 * Visitor MarkupEmbedding
	 */
	function MarkupEmbeddingVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(markupEmbed){
			//Visit Markups
			for (var i = 0; i < markupEmbed.markups.length; i++) {
				var markup = markupEmbed.markups[i];
				markup.accept(new MarkupVisitor(this.env, this.dom));
			}
		}
	}
			
	/**
	 * Visitor Assignment
	 */
	function AssignmentVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(assignment){
			if (assignment instanceof VariableBinding) {
				assignment.accept(new VariableBindingVisitor(this.env, this.dom));
			} else if (assignment instanceof FunctionBinding) {
				assignment.accept(new FunctionBindingVisitor(this.env, this.dom));
			} else { //Assignment is not recognized
				print("Unrecognized Assignment found. Parser should have thrown an error.");
			}
		}
	}

	/**
	 * Visitor Variablebinding
	 */
	function VariableBindingVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(varbind){
			//Add variable to current environment (let statement)
			this.env.addVariable(varbind.variable);
			
			//Visit expression
			varbind.expression.accept(new ExpressionVisitor(this.env, this.dom));
		}
	}
	
	/**
	 * Visitor Functionbinding
	 */
	function FunctionBindingVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(funcbind){
			//Convert function binding into function definition
			var newFunctionName = funcbind.variable;
			var newFunctionFormals = funcbind.formals;
			var newFunctionStatements = [funcbind.statement];
			var newFunction = new FunctionDefinition(newFunctionName, newFunctionFormals, newFunctionStatements, true);
			
			//Add function to current environment (let statement)
			//(not done by FunctionDefinitionVisitor)
			//if (!this.env.containsLocalFunction(newFunctionName)) {
			//	print('add function ' + newFunctionName + ' to ' + this.env.type)
				this.env.addFunction(newFunction);
			//} else {
			//	this.env.addException(new DuplicateDefinitionException(newFunction, this.env));
			//}
		}
	}

	/**
	 * Visitor Markup
	 */
	function MarkupVisitor(env, dom){
		this.env = env
		this.dom = dom;
		this.visit = function(markup){
			if (markup instanceof MarkupCall) {
				var new_env = this.env.addEnvironment('markup-call')
				//Check if function already exists in current environment (incl dependecies)
				var functionDefinition = this.env.getLocalFunction(markup.designator.idCon);
				if (functionDefinition != null) {
					//Check if number of the arguments equals
					if (functionDefinition.formals.length != markup.arguments.length) {
						//If arguments do not equal and the designator tag is not part
						//of XHTML, then it must be a function call with incorrect arguments.
						if (!XHTML.isXHTMLTag(markup.designator.idCon)) {
							new_env.addException(new IncorrectArgumentsException(markup, new_env));
						}
					}
					//Store variables
					for(var i = 0; i < markup.arguments.length; i++){
						print('store var : ' + markup.arguments[i]);
						var variableValue = getExpressionValue(markup.arguments[i], this.env);								
						new_env.addVariable('arg' + i, variableValue);
					}
					
					//Visit function definition
					functionDefinition.accept(new FunctionDefinitionVisitor(new_env, this.dom));
					
					//Visit arguments/formals
					for (var i = 0; i < markup.arguments.length; i++) {
						var argument = markup.arguments[i];
						argument.accept(new ArgumentVisitor(new_env, this.dom));
					}					
				} else if (!XHTML.isXHTMLTag(markup.designator.idCon)) {
					//If function does not exists and the designator tag is not part of
					//XHTML, then it must be an undefined function						
					this.env.addException(new UndefinedFunctionException(markup, this.env))
				} else {//XHTML tag
					//Add tag/element to document	
					var element = this.dom.document.createElement(markup.designator.idCon);				
					this.dom.lastElement.appendChild(element);
					this.dom.lastElement = element;
					
					//Visit arguments/formals
					for (var i = 0; i < markup.arguments.length; i++) {
						var argument = markup.arguments[i];
						argument.accept(new ArgumentVisitor(new_env, this.dom));
					}
				}
			} else { //Markup is MarkupTag Expression	
				//Add tag/element to document	
				var element = this.dom.document.createElement(markup.idCon);				
				this.dom.lastElement.appendChild(element);
				this.dom.lastElement = element;
				
				//Visit arguments of tag/element
				for(var i = 0; i < markup.attributes.length; i++){
					var attribute = markup.attributes[i];
					attribute.accept(new AttributeVisitor(this.env, this.dom));
				}
			}
		}
	}
	
	/**
	 * Visitor Attributes
	 */
	function AttributeVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(attribute){
			if(attribute instanceof IdAttribute){
				attribute.accept(new IdAttributeVisitor(this.env, this.dom));
			}else if(attribute instanceof ClassAttribute){
				attribute.accept(new ClassAttributeVisitor(this.env, this.dom));
			}else if(attribute instanceof NameAttribute){
				attribute.accept(new NameAttributeVisitor(this.env, this.dom));
			}else if(attribute instanceof TypeAttribute){
				attribute.accept(new TypeAttributeVisitor(this.env, this.dom));
			}else if(attribute instanceof WidthHeightAttribute){
				attribute.accept(new WidthHeightAttributeVisitor(this.env, this.dom));
			}else if(attribute instanceof WidthAttribute){
				attribute.accept(new WidthAttributeVisitor(this.env, this.dom));
			}
		}
	}
	
	/**
	 * Visitor ID Attribute
	 */
	function IdAttributeVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(attribute){
			this.dom.lastElement.setAttribute('id', attribute.id);
		}
	}
	
	/**
	 * Visitor Class Attribute
	 */
	function ClassAttributeVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(attribute){
			this.dom.lastElement.setAttribute('class', attribute.className);
		}
	}
	
	/**
	 * Visitor Name Attribute
	 */
	function NameAttributeVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(attribute){
			this.dom.lastElement.setAttribute('name', attribute.name);
		}
	}
	
	/**
	 * Visitor Type Attribute
	 */
	function TypeAttributeVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(attribute){
			this.dom.lastElement.setAttribute('type', attribute.type);
		}
	}
	
	/**
	 * Visitor Width Height Attribute
	 */
	function WidthHeightAttributeVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(attribute){
			this.dom.lastElement.setAttribute('width', attribute.width);
			this.dom.lastElement.setAttribute('height', attribute.height);
		}
	}
	
	/**
	 * Visitor Width Attribute
	 */
	function WidthAttributeVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(attribute){
			this.dom.lastElement.setAttribute('width', attribute.width);
		}
	}
	
	
	/**
	 * Visitor Argument
	 */
	function ArgumentVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(argument){
			if (argument instanceof Argument) { 
				argument.accept(new ArgumentExpressionVisitor(this.env, this.dom));
			} else { //Argument is expression
				argument.accept(new ExpressionVisitor(this.env, this.dom));
			}
		}
	}
	
	/**
	 * Visitor Argument Expression
	 */
	function ArgumentExpressionVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(argument){
			//Visit Expression
			argument.expression.accept(new ExpressionVisitor(this.env, this.dom));
			
			//Add attribute to last element
			this.dom.lastElement.setAttribute(argument.variable, this.dom.lastValue);
		}
	}
	
	/**
	 * Visitor KeyValue
	 */
	function KeyValueVisitor(env, dom){
		this.env = env;
		this.dom = dom;
		this.visit = function(keyValueExpr){
			//Visit Expression value
			keyValueExpr.value.accept(new ExpressionVisitor(this.env, this.dom));
		}
	}
}