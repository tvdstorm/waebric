function ModuleVisitor(){
	this.visit = function(module, env){ 
		//Visit dependencies
		//Should be done before the current module is visited
		//Otherwise, functioncalls from the current module to dependencies
		// would not be recognized since they wouldn't be visited
		for(var i = 0; i < module.dependencies.length; i++){
			var dependency = module.dependencies[i];
			dependency.accept(new ModuleVisitor(), env);
		}
		
		//Store Function Definitions
		//Should be done before the FunctionDefinitionVisitor is called
		//If not done, a function in a Waebric program would then be declared before
		//a functioncall, which is not wanted
		for(var i = 0; i < module.functionDefinitions.length; i++){
			var functionDefinition = module.functionDefinitions[i];
			if (!env.containsFunction(functionDefinition.functionName)) {
				env.addFunction(functionDefinition);
			}else{
				env.addException(new DuplicateDefinitionException(functionDefinition));
			}
		}
		
		//Visit all Function Definitions
		for(var i = 0; i < module.functionDefinitions.length; i++){
			var functionDefinition = module.functionDefinitions[i];
			functionDefinition.accept(new FunctionDefinitionVisitor(), env);
		}		
		
		//Visit all Mappings
		for(var i = 0; i < module.site.mappings.length; i++){
			var mapping = module.site.mappings[i];
			mapping.markup.accept(new MarkupVisitor(), env);
		}		
	}
}

function FunctionDefinitionVisitor(){
	this.visit = function(functionDefinition, env){		
		//Function definition itself is already stored in the ModuleVisitor
		//Add arguments of function to new environment		
		var new_env = env.addEnvironment();		
		for (var i = 0; i < functionDefinition.formals.length; i++) {
			var formal = functionDefinition.formals[i];
			new_env.addVariable(formal);
		}
		
		//Visit internal statements of function definitions with new 
		//environment
		for(var i = 0; i < functionDefinition.statements.length; i++){
			var statement = functionDefinition.statements[i];
			statement.accept(new StatementVisitor(), new_env);
		}
	}
}

function StatementVisitor(){
	this.visit = function(statement, env){
		if(statement instanceof IfStatement){
			statement.accept(new IfStatementVisitor(), env);
		}
		else if(statement instanceof IfElseStatement){
			statement.accept(new IfElseStatementVisitor(), env);
		}
		else if(statement instanceof EachStatement){
			statement.accept(new EachStatementVisitor(), env);
		}
		else if(statement instanceof LetStatement){
			statement.accept(new LetStatementVisitor(), env);
		}
		else if(statement instanceof BlockStatement){
			statement.accept(new BlockStatementVisitor(), env);
		}
		else if(statement instanceof EchoStatement){
			statement.accept(new EchoStatementVisitor(), env)
		}
		else if(statement instanceof EchoEmbeddingStatement){
			statement.accept(new EchoEmbeddingVisitor(), env)
		}
		else if(statement instanceof CDataExpression){
			statement.accept(new CDataExpressionVisitor(), env)
		}
		else if(statement instanceof MarkupStatement){
			statement.accept(new MarkupStatementVisitor(), env);			
		}
		else if(statement instanceof MarkupMarkupStatement){
			statement.accept(new MarkupMarkupStatementVisitor(), env)
		}
		else if(statement instanceof MarkupEmbeddingStatement){
			statement.accept(new MarkupEmbeddingStatementVisitor(), env)
		}
		else if(statement instanceof MarkupStatementStatement){
			statement.accept(new MarkupStatementStatementVisitor(), env)
		}
		else if(statement instanceof MarkupExpressionStatement){
			statement.accept(new MarkupExpressionStatementVisitor(), env)
		}		
		else{
			print("function not yet implented: " + statement)
			for(obj in statement){
				print(obj);
			}
		}
		
	}
}

function CDataExpressionVisitor(){
	this.visit = function(cdataExpr, env){
		cdataExpr.expression.accept(new ExpressionVisitor(), env);
	}
}

function EchoEmbeddingVisitor(){
	this.visit = function(echoEmbeddingStmt, env){
		echoEmbeddingStmt.embedding.accept(new EmbeddingVisitor(), env);
	}
}

function EmbeddingVisitor(){
	this.visit = function(embedding, env){
		embedding.embed.accept(new EmbedVisitor(), env);
		if(embedding.tail instanceof MidTextTail){
			embedding.tail.accept(new MidTextTail(), env);
		}		
	}
}

function MidTextTailVisitor(){
	this.visit = function(midTextTail, env){
		midTextTail.embed.accept(new EmbedVisitor(), env);
		if (midTextTail.tail instanceof MidTextTail) {
			midTextTail.tail.accept(new MidTextTail(), env);
		}
	}
}

function EmbedVisitor(){
	this.visit = function(embed, env){
		if(embed instanceof ExpressionEmbedding){
			embed.accept(new ExpressionEmbeddingVisitor(), env);			
		}else if(embed instanceof MarkupEmbedding){			
			embed.accept(new MarkupEmbeddingVisitor(), env);
		}
	}
}

function ExpressionEmbeddingVisitor(){
	this.visit = function(exprEmbed, env){		
		for(var i = 0; i < exprEmbed.markups.length; i++){
			var markup = exprEmbed.markups[i];
			markup.accept(new MarkupVisitor(), env);
		}
		exprEmbed.expression.accept(new ExpressionVisitor(), env);
	}
}

function MarkupEmbeddingVisitor(){
	this.visit = function(markupEmbed, env){
		for(var i = 0; i < markupEmbed.markups.length; i++){
			var markup = markupEmbed.markups[i];
			markup.accept(new MarkupVisitor(), env);
		}
	}
}



function EchoStatementVisitor(){
	this.visit = function(echoStmt, env){		
		echoStmt.expression.accept(new ExpressionVisitor(), env);	
	}
}


function BlockStatementVisitor(){
	this.visit = function(blockStmt, env){		
		for(var i = 0; i < blockStmt.statements.length; i++){			
			var statement = blockStmt.statements[i];
			statement.accept(new StatementVisitor(), env);
		}	
	}
}

function LetStatementVisitor(){
	this.visit = function(letStmt, env){
		var new_env = env.addEnvironment();
		
		for(var i = 0; i < letStmt.assignments.length; i++){
			var assignment = letStmt.assignments[i];
			assignment.accept(new AssignmentVisitor(), new_env);
		}
		for(var j = 0; j < letStmt.statements.length; j++){
			var statement = letStmt.statements[j];
			statement.accept(new StatementVisitor(), new_env);
		}		
	}
}

function AssignmentVisitor(){
	this.visit = function(assignment, env){		
		if(assignment instanceof VariableBinding){
			assignment.accept(new VariableBindingVisitor(), env);
		}else if(assignment instanceof FunctionBinding){
			assignment.accept(new FunctionBindingVisitor(), env);
		}		
	}
}

function VariableBindingVisitor(){
	this.visit = function(varbind, env){
		env.addVariable(varbind.variable);
		varbind.expression.accept(new ExpressionVisitor(), env);
	}
}

function FunctionBindingVisitor(){
	this.visit = function(funcbind, env){
		//Convert function binding into function definition
		var newFunctionName = funcbind.variable;
        var newFunctionFormals = funcbind.formals;
        var newFunctionStatements = [funcbind.statement];
        var newFunction = new FunctionDefinition(newFunctionName, newFunctionFormals, newFunctionStatements);
		
		//The FunctionDefinitionVisitor does not save the function itself
		saveFunctionDefinition(newFunction, env);
		newFunction.accept(new FunctionDefinitionVisitor(), env);
		
	}
}

function IfStatementVisitor(){
	this.visit = function(ifStmt, env){
		ifStmt.predicate.accept(new PredicateVisitor(), env);
		ifStmt.ifStatement.accept(new StatementVisitor(), env);
	}
} 

function IfElseStatementVisitor(){
	this.visit = function(ifElseStmt, env){
		ifElseStmt.predicate.accept(new PredicateVisitor(), env);
		ifElseStmt.ifStatement.accept(new StatementVisitor(), env);
		ifElseStmt.elseStatement.accept(new StatementVisitor(), env);
	}
} 


function PredicateVisitor(){
	this.visit = function(predicate, env){
		if(predicate instanceof NotPredicate){
			predicate.predicate.accept(new PredicateVisitor(), env);
		}else if(predicate instanceof AndPredicate){
			predicate.predicateLeft.accept(new PredicateVisitor(), env);
			predicate.predicateRight.accept(new PredicateVisitor(), env);
		}else if(predicate instanceof OrPredicate){
			predicate.predicateLeft.accept(new PredicateVisitor(), env);
			predicate.predicateRight.accept(new PredicateVisitor(), env);
		}else if(predicate instanceof isAPredicate){
			predicate.expression.accept(new ExpressionVisitor(), env);
		}else{
			//Predicate is an Expression
			predicate.accept(new ExpressionVisitor(), env);
		}
	}
} 

function MarkupStatementVisitor(){
	this.visit = function(markupStmt, env){
		markupStmt.markup.accept(new MarkupVisitor(), env);
	}
}

function MarkupMarkupStatementVisitor(){
	this.visit = function(markupMarkupStmt, env){
		for(var i = 0; i < markupMarkupStmt.markups.length; i++){
			var markup = markupMarkupStmt.markups[i];
			markup.accept(new MarkupVisitor(), env);
		}		
	}
}

function MarkupStatementStatementVisitor(){
	this.visit = function(markupStmtStmt, env){
		for(var i = 0; i < markupStmtStmt.markups.length; i++){
			var markup = markupStmtStmt.markups[i];
			markup.accept(new MarkupVisitor(), env);
		}	
		markupStmtStmt.statement.accept(new StatementVisitor(), env);	
	}
}

function MarkupEmbeddingStatementVisitor(){
	this.visit = function(markupEmbeddingStmt, env){
		for(var i = 0; i < markupEmbeddingStmt.markups.length; i++){
			var markup = markupEmbeddingStmt.markups[i];
			markup.accept(new MarkupVisitor(), env);
		}	
		markupEmbeddingStmt.embedding.accept(new EmbeddingVisitor(), env);	
	}
}

function MarkupExpressionStatementVisitor(){
	this.visit = function(markupExprStmt, env){
		for(var i = 0; i < markupExprStmt.markups.length; i++){
			var markup = markupExprStmt.markups[i];
			markup.accept(new MarkupVisitor(), env);
		}	
		markupExprStmt.expression.accept(new ExpressionVisitor(), env);
	}
}

function EachStatementVisitor(){
	this.visit = function(eachStmt, env){
		var new_env = env.addEnvironment();
		new_env.addVariable(eachStmt.identifier);
		eachStmt.expression.accept(new ExpressionVisitor(), new_env);
		eachStmt.statement.accept(new StatementVisitor(), new_env);
	}
}


function ExpressionVisitor(){
	this.visit = function(expression, env){
		if(expression instanceof VarExpression){
			expression.accept(new VarExpressionVisitor(), env);
		}else if(expression instanceof FieldExpression){
			expression.expression.accept(new VarExpressionVisitor(), env);
		}else if(expression instanceof ListExpression){
			expression.accept(new ListExpressionVisitor(), env)
		}else if(expression instanceof RecordExpression){
			expression.accept(new RecordExpressionVisitor(), env);
		}
	}
}

function ListExpressionVisitor(){
	this.visit = function(listExpr, env){
		for(var i = 0; i < listExpr.list.length; i++){			
			listExpr.list[i].accept(new ExpressionVisitor(), env);
		}
	}
}

function RecordExpressionVisitor(){
	this.visit = function(recordExpr, env){
		for(var i = 0; i < recordExpr.record.length; i++){			
			recordExpr.record[i].accept(new KeyValueVisitor(), env);
		}
	}
}

function KeyValueVisitor(){
	this.visit = function(keyValueExpr, env){
		keyValueExpr.value.accept(new ExpressionVisitor(), env);
	}
}

function MarkupVisitor(){
	this.visit = function(markup, env){ 
		if(markup instanceof MarkupCall){	
			//Check function name
			var functionDefinition = env.getFunction(markup.designator.idCon);
			if(functionDefinition != null){
				//Check arguments length
				if(functionDefinition.formals.length != markup.arguments.length){
					env.addException(new IncorrectArgumentsException(markup));
				}						
				//Check variable reference in formals
				processFormals(markup, env);
			}else if(XHTML.isXHTMLTag(markup.designator.idCon)){
				//Check variable reference in formals
				for(var i = 0; i < markup.arguments.length; i++){									
					var argument = markup.arguments[i];
					argument.accept(new ArgumentVisitor(), env);
				}
			}else{
				env.addException(new UndefinedFunctionException(markup))
			}
		}
	}
}



function VarExpressionVisitor(){
	this.visit = function(variable, env){
		if(env.getVariable(variable) == null){
			env.addException(new UndefinedVariableException(variable));
		}
	}
}

function ArgumentVisitor(){
	this.visit = function(argument, env){
		if (argument instanceof Argument) {
			argument.expression.accept(new ExpressionVisitor(), env);
		}else{
			argument.accept(new ExpressionVisitor(), env);
		}
	}
}


function ArgumentExpression(){
	this.visit = function(argument, env){
		argument.variable.visit(new VarExpressionVisitor(), env);
		argument.expression.visit(new ExpressionVisitor(), env);
	}
}
function processFormals(markup, env){
	for(var i = 0; i < markup.arguments.length; i++){									
		var argument = markup.arguments[i];
		if (argument instanceof VarExpression) {
			argument.accept(new VarExpressionVisitor(), env);
		}
	}
}

