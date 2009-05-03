package waebricc.WaebricAst;

public interface ArgumentVisitor
{
    void visit(AstToken n, Object o);
    void visit(Module n, Object o);
    void visit(ModuleIdList n, Object o);
    void visit(ModuleBlockList n, Object o);
    void visit(Site n, Object o);
    void visit(MappingList n, Object o);
    void visit(Mapping n, Object o);
    void visit(Path n, Object o);
    void visit(FileName n, Object o);
    void visit(DirNameList n, Object o);
    void visit(DirName n, Object o);
    void visit(Markup n, Object o);
    void visit(MarkupList n, Object o);
    void visit(ArgumentList n, Object o);
    void visit(Argument n, Object o);
    void visit(ExpressionList n, Object o);
    void visit(ExpressionString n, Object o);
    void visit(ExpressionConstant n, Object o);
    void visit(ExpressionCollection n, Object o);
    void visit(ExpressionPair n, Object o);
    void visit(KeyValuePairList n, Object o);
    void visit(KeyValuePair n, Object o);
    void visit(Embedding n, Object o);
    void visit(Embed n, Object o);
    void visit(StatementIf n, Object o);
    void visit(StatementIfElse n, Object o);
    void visit(StatementEach n, Object o);
    void visit(StatementLet n, Object o);
    void visit(StatementBlock n, Object o);
    void visit(StatementList n, Object o);
    void visit(StatementComment n, Object o);
    void visit(StatementEchoExpression n, Object o);
    void visit(StatementEchoEmbedding n, Object o);
    void visit(StatementCData n, Object o);
    void visit(StatementYield n, Object o);
    void visit(Predicate n, Object o);
    void visit(Var n, Object o);
    void visit(AssignmentList n, Object o);
    void visit(Assignment n, Object o);
    void visit(Designator n, Object o);
    void visit(AttributeList n, Object o);
    void visit(Attribute n, Object o);
    void visit(Function n, Object o);
    void visit(ParameterDeclList n, Object o);
    void visit(Name n, Object o);
    void visit(TextTail0 n, Object o);
    void visit(TextTail1 n, Object o);
    void visit(Type0 n, Object o);
    void visit(Type1 n, Object o);
    void visit(Type2 n, Object o);

    void visit(Ast n, Object o);
}

