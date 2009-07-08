/**************************************************************************** 
 * Specifies a Statement used in FunctionDefinition
 * 
 * @author Nickolas Heirbaut 
 ****************************************************************************/

/**
 * If Statement Class
 * 
 * "if" "(" Predicate ")" Statement NoElseMayFollow -> Statement ("if")
 * 
 * @param {Object} predicate
 * @param {Object} ifStatement
 */
function IfStatement(predicate, ifStatement){
	this.predicate = predicate;
	this.ifStatement = ifStatement;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * IfElse Statement Class
 * 
 * "if" "(" Predicate ")" Statement "else" Statement -> Statement ("if-els")
 * 
 * @param {Object} predicate
 * @param {Object} ifStatement
 * @param {Object} elseStatement
 */
function IfElseStatement(predicate, ifStatement, elseStatement){
	this.predicate = predicate;
	this.ifStatement = ifStatement;
	this.elseStatement = elseStatement;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Each Statement Class
 * 
 * "each" "(" IdCon ":" Expression ")" Statement -> Statement ("each")
 * 
 * @param {Object} identifier
 * @param {Object} expression
 * @param {Object} statement
 */
function EachStatement(identifier, expression, statement){
	this.identifier = identifier;
	this.expression = expression;
	this.statement = statement;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Let Statement Class
 * 
 * "let" Assignment+ "in" Statement* "end" -> Statement ("let")
 * 
 * @param {Array} Array of assignments
 * @param {Array} Array of statements
 */
function LetStatement(assignments, statements){
	this.assignments = assignments;
	this.statements = statements;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Block Statement Class
 * 
 * CB Statement* CB -> Statement ("block")
 * 
 * @param {Array} Array of statements
 */
function BlockStatement(statements){
	this.statements = statements;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Comment Statement Class
 * 
 * "comment" StrCon ";" -> Statement ("comment")
 * 
 * @param {Object} comment
 */
function CommentStatement(comment){
	this.comment = comment;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Echo Statement Class
 * 
 * "echo" Expression ";" -> Statement ("echo")
 * 
 * @param {Object} expression
 */
function EchoStatement(expression){
	this.expression = expression;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Echo Embedding Statement Class
 * 
 * "echo" Embedding ";" -> Statement ("echo-embedding")
 * 
 * @param {Object} embedding
 */
function EchoEmbeddingStatement(embedding){
	this.embedding = embedding;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * CData Statement Class
 * 
 * "cdata" Expression ";" -> Statement ("cdata")
 * 
 * @param {Object} expression
 */
function CDataExpression(expression){
	this.expression = expression;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Yield Statement Class
 * 
 * "yield" ";" -> Statement ("yield") 
 */
function YieldStatement(){

}

/**
 * Markup Statement Class
 * 
 * Markup ";" -> Statement ("markup")
 * 
 * @param {Object} markup
 */
function MarkupStatement (markup){
	this.markup = markup;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Markup Expression Statement Class
 * 
 * Markup+ Expression ";" -> Statement ("markup-exp")
 * 
 * @param {Object} markup
 * @param {Object} expression
 */
function MarkupExpressionStatement (markups, expression){
	this.markups = markups;
	this.expression = expression;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Markup Markup Statement Class
 * 
 * Markup+ Markup -> Statement ("markup-markup")
 * 
 * @param {Object} markup
 */
function MarkupMarkupStatement (markups){
	this.markups = markups;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Markup Statement Statement Class
 * 
 * Markup+ Statement -> Statement ("markup-stat")
 * 
 * @param {Object} markup
 * @param {Object} statement
 */
function MarkupStatementStatement (markups, statement){
	this.markups = markups;
	this.statement = statement;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}

/**
 * Markup Embedding Statement Class
 * 
 * Markup+ Embedding ";" -> Statement ("markup-embedding")
 * 
 * @param {Object} markup
 * @param {Object} embedding
 */
function MarkupEmbeddingStatement (markups, embedding){
	this.markups = markups;
	this.embedding = embedding;
	
	//Visitor pattern
	this.accept = function(visitorObject, env){
		visitorObject.visit(this, env);
	}
}