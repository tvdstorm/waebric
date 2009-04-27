package waebricc.WaebricAst;

public interface Visitor
{
    void visit(AstToken n);
    void visit(Module n);
    void visit(ModuleIdList n);
    void visit(ModuleBlockList n);
    void visit(Site n);
    void visit(MappingList n);
    void visit(Mapping n);
    void visit(Path n);
    void visit(FileName n);
    void visit(DirNameList n);
    void visit(DirName n);
    void visit(Markup n);
    void visit(MarkupList n);
    void visit(ArgumentList n);
    void visit(Argument n);
    void visit(ExpressionList n);
    void visit(ExpressionString n);
    void visit(ExpressionConstant n);
    void visit(ExpressionMember n);
    void visit(ExpressionCollection n);
    void visit(ExpressionPair n);
    void visit(KeyValuePairList n);
    void visit(KeyValuePair n);
    void visit(Embedding n);
    void visit(Embed n);
    void visit(StatementEach n);
    void visit(StatementLet n);
    void visit(StatementBlock n);
    void visit(StatementList n);
    void visit(StatementComment n);
    void visit(StatementEchoExpression n);
    void visit(StatementEchoEmbedding n);
    void visit(StatementCData n);
    void visit(StatementYield n);
    void visit(Var n);
    void visit(AssignmentList n);
    void visit(Assignment n);
    void visit(Designator n);
    void visit(AttributeList n);
    void visit(Function n);
    void visit(ParameterDeclList n);
    void visit(Name n);
    void visit(TextTail0 n);
    void visit(TextTail1 n);
    void visit(Attribute0 n);
    void visit(Attribute1 n);
    void visit(Attribute2 n);

    void visit(Ast n);
}

