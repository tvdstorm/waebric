package waebricc.WaebricAst;

public interface ResultVisitor
{
    Object visit(AstToken n);
    Object visit(ModuleList n);
    Object visit(Module n);
    Object visit(ModuleIdList n);
    Object visit(ModuleBlockList n);
    Object visit(Site n);
    Object visit(Import n);
    Object visit(FunctionWithParameters n);
    Object visit(FunctionWithoutParameters n);
    Object visit(ParameterDeclList n);
    Object visit(Name n);
    Object visit(MappingList n);
    Object visit(Mapping n);
    Object visit(Markup n);
    Object visit(MarkupList n);
    Object visit(ArgumentList n);
    Object visit(Argument n);
    Object visit(ExpressionList n);
    Object visit(ExpressionString n);
    Object visit(ExpressionPlus n);
    Object visit(ExpressionConstant n);
    Object visit(ExpressionSymbol n);
    Object visit(ExpressionCollection n);
    Object visit(ExpressionPair n);
    Object visit(KeyValuePairList n);
    Object visit(KeyValuePair n);
    Object visit(Embedding n);
    Object visit(TextTailMidText n);
    Object visit(TextTailPostText n);
    Object visit(Embed n);
    Object visit(StatementIf n);
    Object visit(StatementIfElse n);
    Object visit(StatementIfElseNoShortIf n);
    Object visit(StatementEach n);
    Object visit(StatementEachNoShortIf n);
    Object visit(StatementLet n);
    Object visit(StatementBlock n);
    Object visit(StatementList n);
    Object visit(StatementComment n);
    Object visit(StatementEchoExpression n);
    Object visit(StatementEchoEmbedding n);
    Object visit(StatementCData n);
    Object visit(StatementYield n);
    Object visit(StatementMarkup n);
    Object visit(StatementMarkupWithDesignator n);
    Object visit(StatementMarkupWithExpression n);
    Object visit(StatementMarkupWithEmbedding n);
    Object visit(StatementMarkupStatement n);
    Object visit(StatementMarkupStatementNoShortIf n);
    Object visit(TypeList n);
    Object visit(TypeRecord n);
    Object visit(TypeString n);
    Object visit(PredicateCheckType n);
    Object visit(PredicateNegate n);
    Object visit(PredicateAnd n);
    Object visit(PredicateOr n);
    Object visit(Var n);
    Object visit(AssignmentList n);
    Object visit(AssignmentExpression n);
    Object visit(AssignmentStatement n);
    Object visit(Designator n);
    Object visit(AttributeList n);
    Object visit(AttributeSharp n);
    Object visit(AttributeDot n);
    Object visit(AttributeDollar n);
    Object visit(AttributeColon n);
    Object visit(AttributeWidth n);
    Object visit(AttributeWidthHeight n);

    Object visit(Ast n);
}

