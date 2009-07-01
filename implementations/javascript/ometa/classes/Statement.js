/**
 * Statement class
 *
 * @author Nickolas Heirbaut
 */

function IfStatement (predicate, ifStatement){
	this.predicate = predicate;
	this.ifStatement = ifStatement;
}

function IfElseStatement (predicate, ifStatement, elseStatement){
	this.predicate = predicate;
	this.ifStatement = ifStatement;
	this.elseStatement = elseStatement;
}

function EachStatement (identifier, expression, statement){
	this.identifier = identifier;
	this.expression = expression;
	this.statement = statement;
}

function LetStatement (assignments, statements){
	this.assignments = assignments;
	this.statements = statements;
}

function BlockStatement (statements){
	this.statements = statements;
}

function CommentStatement (comment){
	this.comment = comment;
}

function EchoStatement (expression){
	this.expression = expression;
}

function EchoEmbeddingStatement (Embedding){
	this.embedding = embedding;
}

function CDataExpression (expression){
	this.expression = expression;
}

function YieldStatement (expression){

}

function MarkupStatement (markup){
	this.markup = markup;
}

function MarkupExpStatement (markup, expression){
	this.markup = markup;
	this.expression = expression;
}

function MarkupMarkupStatement (markup){
	this.markup = markup;
}

function MarkupStatStatement (markup, statement){
	this.markup = markup;
	this.statement = statement;
}

function MarkupEmbeddingStatement (markup, statement){
	this.markup = markup;
	this.embedding = embedding;
}