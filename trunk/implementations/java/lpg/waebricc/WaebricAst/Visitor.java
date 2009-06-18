package waebricc.WaebricAst;

public interface Visitor
{
    void visit(AstToken n);
    void visit(ModuleList n);
    void visit(Module n);
    void visit(ModuleIdList n);
    void visit(ModuleBlockList n);
    void visit(Site n);
    void visit(Import n);
    void visit(FunctionWithParameters n);
    void visit(FunctionWithoutParameters n);
    void visit(ParameterDeclList n);
    void visit(Name n);
    void visit(MappingList n);
    void visit(Mapping n);
    void visit(Markup n);
    void visit(MarkupList n);
    void visit(ArgumentList n);
    void visit(Argument n);
    void visit(ExpressionList n);
    void visit(ExpressionString n);
    void visit(ExpressionPlus n);
    void visit(ExpressionConstant n);
    void visit(ExpressionSymbol n);
    void visit(ExpressionCollection n);
    void visit(ExpressionPair n);
    void visit(KeyValuePairList n);
    void visit(KeyValuePair n);
    void visit(Embedding n);
    void visit(TextTailMidText n);
    void visit(TextTailPostText n);
    void visit(Embed n);
    void visit(StatementIf n);
    void visit(StatementIfElse n);
    void visit(StatementIfElseNoShortIf n);
    void visit(StatementEach n);
    void visit(StatementEachNoShortIf n);
    void visit(StatementLet n);
    void visit(StatementBlock n);
    void visit(StatementList n);
    void visit(StatementComment n);
    void visit(StatementEchoExpression n);
    void visit(StatementEchoEmbedding n);
    void visit(StatementCData n);
    void visit(StatementYield n);
    void visit(StatementMarkup n);
    void visit(StatementMarkupWithDesignator n);
    void visit(StatementMarkupWithExpression n);
    void visit(StatementMarkupWithEmbedding n);
    void visit(StatementMarkupStatement n);
    void visit(StatementMarkupStatementNoShortIf n);
    void visit(TypeList n);
    void visit(TypeRecord n);
    void visit(TypeString n);
    void visit(PredicateCheckType n);
    void visit(PredicateNegate n);
    void visit(PredicateAnd n);
    void visit(PredicateOr n);
    void visit(Var n);
    void visit(AssignmentList n);
    void visit(AssignmentExpression n);
    void visit(AssignmentStatement n);
    void visit(Designator n);
    void visit(AttributeList n);
    void visit(AttributeSharp n);
    void visit(AttributeDot n);
    void visit(AttributeDollar n);
    void visit(AttributeColon n);
    void visit(AttributeWidth n);
    void visit(AttributeWidthHeight n);

    void visit(Ast n);
}
