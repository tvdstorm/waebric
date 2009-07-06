function WaebricSemanticCollector(){
}

/** 
 * Collects all function definitions found in the specified module and its transitive imports
 *
 * @param {Module} The module object
 * @return {Array} An array of function definitions
 */
WaebricSemanticCollector.collectAllFunctions = function(module){
    var localFunctions = WaebricSemanticCollector.collectLocalFunctions(module);
    var importFunctions = WaebricSemanticCollector.collectImportFunctions(module);
    return localFunctions.concat(importFunctions);
}

/**
 * Collects all functions of the current module
 * (not the transitive imports)
 *
 * @param {Object} module
 */
WaebricSemanticCollector.collectLocalFunctions = function(module){
    //Function definitions (standard)
    var functions = new Array();
    functions = functions.concat(module.functionDefinitions);
    
    //Function definitions (function binding)
    //Finds the function bindings in a statement and converts that binding into a normal
    //functiondefinition. Then, the functiondefinition is added to the global function list
    for (var i = 0; i < functions.length; i++) {
        var func = functions[i];
        var statements = func.statements;
        for (var j = 0; j < statements.length; j++) {
            var statement = statements[j];
            if (statement instanceof LetStatement) {
                var assignments = statement.assignments;
                for (var k = 0; k < assignments.length; k++) {
                    var assignment = assignments[k];
                    var newFunctionName = assignment.variable;
                    var newFunctionFormals = assignment.formals;
                    var newFunctionStatements = assignment.statement;
                    var newFunction = new FunctionDefinition(newFunctionName, newFunctionFormals, newFunctionStatements)
                    functions.push(newFunction);
                }
            }
        }
    }
    return functions;
}

/**
 * Collects all functions inside the dependencies of the module
 * (not the current module itself)
 *
 * @param {Module} module
 */
WaebricSemanticCollector.collectImportFunctions = function(module){
    var importsFunctions = new Array();
    for (var j = 0; j < module.dependencies.length; j++) {
        var importFunctions = WaebricSemanticCollector.collectAllFunctions(module.dependencies[j]);
        importsFunctions = importsFunctions.concat(importFunctions);
    }
    return importsFunctions;
}

/** 
 * Collects all function calls found in the specified module and its transitive imports
 *
 * @param {Module} The module object
 * @return {Array} An array of function calls
 */
WaebricSemanticCollector.collectAllFunctionCalls = function(module){
    var localFunctionCalls = WaebricSemanticCollector.collectLocalFunctionCalls(module);
    var importFunctionCalls = WaebricSemanticCollector.collectImportFunctionCalls(module);
    
    return localFunctionCalls.concat(importFunctionCalls);
}

/** 
 * Collects all function calls found in the specified modules
 *
 * @param {Array} An array of modules
 * @return {Array} An array of function calls
 */
WaebricSemanticCollector.collectLocalFunctionCalls = function(module){
	var siteFunctionCalls = WaebricSemanticCollector.collectFunctionCallsMappings(module.site.mappings);
	var funcDefFunctionCalls = WaebricSemanticCollector.collectFunctionCallsFuncDef(module.functionDefinitions);
	return siteFunctionCalls.concat(funcDefFunctionCalls);
}

/**
 *
 * @param {Object} module
 */
WaebricSemanticCollector.collectImportFunctionCalls = function(module){
    var importsFunctionCalls = new Array();
    for (var j = 0; j < module.dependencies.length; j++) {
        var importFunctionCalls = WaebricSemanticCollector.collectAllFunctionCalls(module.dependencies[j]);
        importsFunctionCalls = importsFunctionCalls.concat(importFunctionCalls);
    }
    return importsFunctionCalls;
}

WaebricSemanticCollector.collectFunctionCallsMappings = function(mappings){
    var functionCalls = new Array();
    for (var i = 0; i < mappings.length; i++) {
        var mapping = mappings[i];
        var markup = mapping.markup;
        if (markup instanceof MarkupCall) {
            functionCalls.push(markup);
        }
    }
    return functionCalls;
}

WaebricSemanticCollector.collectFunctionCallsFuncDef = function(functionDefinitions){
	var functionCalls = new Array();
    for (var i = 0; i < functionDefinitions.length; i++) {
        var stmtFunctionCalls = WaebricSemanticCollector.collectFunctionCallsStmts(functionDefinitions[i].statements)
		functionCalls = functionCalls.concat(stmtFunctionCalls);
    }
	return functionCalls;
}

WaebricSemanticCollector.collectFunctionCallsStmts = function(statements){
	var functionCalls = new Array();
	
    for (var i = 0; i < statements.length; i++) {
        var statement = statements[i]
		
        if(statement instanceof IfStatement){
			var ifFunctionCalls = WaebricSemanticCollector.collectFunctionCallsStmts([statement.ifStatement]);
			functionCalls = functionCalls.concat(ifFunctionCalls);
		}
		else if(statement instanceof IfElseStatement){
			var ifFunctionCalls = WaebricSemanticCollector.collectFunctionCallsStmts([statement.ifStatement]);
			var ElseFunctionCalls = collectFunctionCallsStmts([statement.elseStatement]);
			functionCalls = functionCalls.concat(ifFunctionCalls).concat(ElseFunctionCalls);
		}
		else if(statement instanceof EachStatement){
			var eachFunctioncalls = WaebricSemanticCollector.collectFunctionCallsStmts([statement.statement]);
			functionCalls = functionCalls.concat(eachFunctioncalls);
		}
		else if(statement instanceof LetStatement){
			var letFunctionCalls = WaebricSemanticCollector.collectFunctionCallsStmts(statement.statements);
			functionCalls = functionCalls.concat(letFunctionCalls);
		}
		else if(statement instanceof BlockStatement){
			var blockFunctionCalls = WaebricSemanticCollector.collectFunctionCallsStmts(statement.statements);
			functionCalls = functionCalls.concat(blockFunctionCalls);
		}
		else if(statement instanceof MarkupStatement){
			var markupFunctionCalls = WaebricSemanticCollector.collectFunctionCallsMarkups([statement.markup]);
			functionCalls = functionCalls.concat(markupFunctionCalls);
		}
		else if(statement instanceof MarkupMarkupStatement){
			var markupMarkupFunctionCalls = WaebricSemanticCollector.collectFunctionCallsMarkups(statement.markups);
			functionCalls = functionCalls.concat(markupMarkupFunctionCalls);
		}
		else if(statement instanceof MarkupExpressionStatement){
			var markupExprFunctionCalls = WaebricSemanticCollector.collectFunctionCallsMarkups(statement.markups);
			functionCalls = functionCalls.concat(markupExprFunctionCalls);
		}
		else if(statement instanceof MarkupStatementStatement){
			var markupFunctionCalls = WaebricSemanticCollector.collectFunctionCallsMarkups(statement.markups);
			var statementFunctionCalls = WaebricSemanticCollector.collectFunctionCallsStmts([statement.statement]);
			functionCalls = functionCalls.concat(markupFunctionCalls).concat(statementFunctionCalls);
		}
		else if(statement instanceof MarkupEmbeddingStatement){
			var markupFunctionCalls = WaebricSemanticCollector.collectFunctionCallsMarkups(statement.markups);
			var embeddingFunctionCalls = WaebricSemanticCollector.collectFunctionCallsEmbedding(statement.embedding);
			functionCalls = functionCalls.concat(markupFunctionCalls).concat(embeddingFunctionCalls);
		}
		else if(statement instanceof EchoEmbeddingStatement){
			var echoFunctionCalls = WaebricSemanticCollector.collectFunctionCallsEmbedding(statement.embedding);
			functionCalls = functionCalls.concat(echoFunctionCalls);
		}
    }	
	return functionCalls;
}

WaebricSemanticCollector.collectFunctionCallsMarkups = function(markups){
	var functionCalls = new Array();
	for(var i = 0; i < markups.length; i++){
		var markup = markups[i];
		//Standard markup tags (expressions, variables, ...) should be ignored
		var isMarkupCall = markup instanceof MarkupCall;
		if(isMarkupCall){
			//Function calls to XHTML defined tags should also be ignored
			var isXHTMLTag = XHTML.isXHTMLTag(markup.designator.idCon);			
			if (!isXHTMLTag) {
				functionCalls.push(markup);
			}
		}
	}
	return functionCalls;
}

/**
 *
 * @param {Object} module
 */
WaebricSemanticCollector.collectAllVariables = function(module){
    //Collect the variables in the module
    var localVariables = WaebricSemanticCollector.collectLocalVariables(module);
    
    //Collect the variables in the transitive imports
    var importVariables = WaebricSemanticCollector.collectImportVariables(module);
    
    return localVariables.concat(importVariables);
}

WaebricSemanticCollector.collectLocalVariables = function(module){
    return new Array();
}

WaebricSemanticCollector.collectImportVariables = function(module){
    return new Array();
}
