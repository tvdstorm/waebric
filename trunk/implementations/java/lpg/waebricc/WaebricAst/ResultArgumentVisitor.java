package waebricc.WaebricAst;

public interface ResultArgumentVisitor
{
    Object visit(AstToken n, Object o);
    Object visit(Module n, Object o);
    Object visit(ModuleIdList n, Object o);
    Object visit(ModuleBlockList n, Object o);
    Object visit(Site n, Object o);
    Object visit(MappingList n, Object o);
    Object visit(Mapping n, Object o);
    Object visit(Path n, Object o);
    Object visit(FileName n, Object o);
    Object visit(DirNameList n, Object o);
    Object visit(DirName n, Object o);
    Object visit(Markup n, Object o);
    Object visit(MarkupList n, Object o);
    Object visit(ArgumentList n, Object o);
    Object visit(Argument n, Object o);
    Object visit(ExpressionList n, Object o);
    Object visit(ExpressionString n, Object o);
    Object visit(ExpressionConstant n, Object o);
    Object visit(ExpressionCollection n, Object o);
    Object visit(ExpressionPair n, Object o);
    Object visit(KeyValuePairList n, Object o);
    Object visit(KeyValuePair n, Object o);
    Object visit(Embedding n, Object o);
    Object visit(Embed n, Object o);
    Object visit(StatementIf n, Object o);
    Object visit(StatementIfElse n, Object o);
    Object visit(StatementEach n, Object o);
    Object visit(StatementLet n, Object o);
    Object visit(StatementBlock n, Object o);
    Object visit(StatementList n, Object o);
    Object visit(StatementComment n, Object o);
    Object visit(StatementEchoExpression n, Object o);
    Object visit(StatementEchoEmbedding n, Object o);
    Object visit(StatementCData n, Object o);
    Object visit(StatementYield n, Object o);
    Object visit(Predicate n, Object o);
    Object visit(Var n, Object o);
    Object visit(AssignmentList n, Object o);
    Object visit(Assignment n, Object o);
    Object visit(Designator n, Object o);
    Object visit(AttributeList n, Object o);
    Object visit(Attribute n, Object o);
    Object visit(Function n, Object o);
    Object visit(ParameterDeclList n, Object o);
    Object visit(Name n, Object o);
    Object visit(TextTail0 n, Object o);
    Object visit(TextTail1 n, Object o);
    Object visit(Type0 n, Object o);
    Object visit(Type1 n, Object o);
    Object visit(Type2 n, Object o);

    Object visit(Ast n, Object o);
}

