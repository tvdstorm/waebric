package waebricc.WaebricAst;

public interface ResultVisitor
{
    Object visit(AstToken n);
    Object visit(Module n);
    Object visit(ModuleIdList n);
    Object visit(ModuleBlockList n);
    Object visit(Site n);
    Object visit(MappingList n);
    Object visit(Mapping n);
    Object visit(Path n);
    Object visit(FileName n);
    Object visit(DirNameList n);
    Object visit(DirName n);
    Object visit(Markup n);
    Object visit(MarkupList n);
    Object visit(ArgumentList n);
    Object visit(Argument n);
    Object visit(ExpressionList n);
    Object visit(ExpressionString n);
    Object visit(ExpressionConstant n);
    Object visit(ExpressionMember n);
    Object visit(ExpressionCollection n);
    Object visit(ExpressionPair n);
    Object visit(KeyValuePairList n);
    Object visit(KeyValuePair n);
    Object visit(Embedding n);
    Object visit(Embed n);
    Object visit(StatementEach n);
    Object visit(StatementLet n);
    Object visit(StatementBlock n);
    Object visit(StatementList n);
    Object visit(StatementComment n);
    Object visit(StatementEchoExpression n);
    Object visit(StatementEchoEmbedding n);
    Object visit(StatementCData n);
    Object visit(StatementYield n);
    Object visit(Var n);
    Object visit(AssignmentList n);
    Object visit(Assignment n);
    Object visit(Designator n);
    Object visit(AttributeList n);
    Object visit(Function n);
    Object visit(ParameterDeclList n);
    Object visit(Name n);
    Object visit(TextTail0 n);
    Object visit(TextTail1 n);
    Object visit(Attribute0 n);
    Object visit(Attribute1 n);
    Object visit(Attribute2 n);

    Object visit(Ast n);
}

