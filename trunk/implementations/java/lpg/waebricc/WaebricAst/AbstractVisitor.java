package waebricc.WaebricAst;

public abstract class AbstractVisitor implements Visitor, ArgumentVisitor
{
    public abstract void unimplementedVisitor(String s);

    public void visit(AstToken n) { unimplementedVisitor("visit(AstToken)"); }
    public void visit(AstToken n, Object o) { unimplementedVisitor("visit(AstToken, Object)"); }

    public void visit(Module n) { unimplementedVisitor("visit(Module)"); }
    public void visit(Module n, Object o) { unimplementedVisitor("visit(Module, Object)"); }

    public void visit(ModuleIdList n) { unimplementedVisitor("visit(ModuleIdList)"); }
    public void visit(ModuleIdList n, Object o) { unimplementedVisitor("visit(ModuleIdList, Object)"); }

    public void visit(ModuleBlockList n) { unimplementedVisitor("visit(ModuleBlockList)"); }
    public void visit(ModuleBlockList n, Object o) { unimplementedVisitor("visit(ModuleBlockList, Object)"); }

    public void visit(Site n) { unimplementedVisitor("visit(Site)"); }
    public void visit(Site n, Object o) { unimplementedVisitor("visit(Site, Object)"); }

    public void visit(MappingList n) { unimplementedVisitor("visit(MappingList)"); }
    public void visit(MappingList n, Object o) { unimplementedVisitor("visit(MappingList, Object)"); }

    public void visit(Mapping n) { unimplementedVisitor("visit(Mapping)"); }
    public void visit(Mapping n, Object o) { unimplementedVisitor("visit(Mapping, Object)"); }

    public void visit(Path n) { unimplementedVisitor("visit(Path)"); }
    public void visit(Path n, Object o) { unimplementedVisitor("visit(Path, Object)"); }

    public void visit(FileName n) { unimplementedVisitor("visit(FileName)"); }
    public void visit(FileName n, Object o) { unimplementedVisitor("visit(FileName, Object)"); }

    public void visit(DirNameList n) { unimplementedVisitor("visit(DirNameList)"); }
    public void visit(DirNameList n, Object o) { unimplementedVisitor("visit(DirNameList, Object)"); }

    public void visit(DirName n) { unimplementedVisitor("visit(DirName)"); }
    public void visit(DirName n, Object o) { unimplementedVisitor("visit(DirName, Object)"); }

    public void visit(Markup n) { unimplementedVisitor("visit(Markup)"); }
    public void visit(Markup n, Object o) { unimplementedVisitor("visit(Markup, Object)"); }

    public void visit(MarkupList n) { unimplementedVisitor("visit(MarkupList)"); }
    public void visit(MarkupList n, Object o) { unimplementedVisitor("visit(MarkupList, Object)"); }

    public void visit(ArgumentList n) { unimplementedVisitor("visit(ArgumentList)"); }
    public void visit(ArgumentList n, Object o) { unimplementedVisitor("visit(ArgumentList, Object)"); }

    public void visit(Argument n) { unimplementedVisitor("visit(Argument)"); }
    public void visit(Argument n, Object o) { unimplementedVisitor("visit(Argument, Object)"); }

    public void visit(ExpressionList n) { unimplementedVisitor("visit(ExpressionList)"); }
    public void visit(ExpressionList n, Object o) { unimplementedVisitor("visit(ExpressionList, Object)"); }

    public void visit(ExpressionString n) { unimplementedVisitor("visit(ExpressionString)"); }
    public void visit(ExpressionString n, Object o) { unimplementedVisitor("visit(ExpressionString, Object)"); }

    public void visit(ExpressionConstant n) { unimplementedVisitor("visit(ExpressionConstant)"); }
    public void visit(ExpressionConstant n, Object o) { unimplementedVisitor("visit(ExpressionConstant, Object)"); }

    public void visit(ExpressionMember n) { unimplementedVisitor("visit(ExpressionMember)"); }
    public void visit(ExpressionMember n, Object o) { unimplementedVisitor("visit(ExpressionMember, Object)"); }

    public void visit(ExpressionCollection n) { unimplementedVisitor("visit(ExpressionCollection)"); }
    public void visit(ExpressionCollection n, Object o) { unimplementedVisitor("visit(ExpressionCollection, Object)"); }

    public void visit(ExpressionPair n) { unimplementedVisitor("visit(ExpressionPair)"); }
    public void visit(ExpressionPair n, Object o) { unimplementedVisitor("visit(ExpressionPair, Object)"); }

    public void visit(KeyValuePairList n) { unimplementedVisitor("visit(KeyValuePairList)"); }
    public void visit(KeyValuePairList n, Object o) { unimplementedVisitor("visit(KeyValuePairList, Object)"); }

    public void visit(KeyValuePair n) { unimplementedVisitor("visit(KeyValuePair)"); }
    public void visit(KeyValuePair n, Object o) { unimplementedVisitor("visit(KeyValuePair, Object)"); }

    public void visit(Embedding n) { unimplementedVisitor("visit(Embedding)"); }
    public void visit(Embedding n, Object o) { unimplementedVisitor("visit(Embedding, Object)"); }

    public void visit(Embed n) { unimplementedVisitor("visit(Embed)"); }
    public void visit(Embed n, Object o) { unimplementedVisitor("visit(Embed, Object)"); }

    public void visit(StatementEach n) { unimplementedVisitor("visit(StatementEach)"); }
    public void visit(StatementEach n, Object o) { unimplementedVisitor("visit(StatementEach, Object)"); }

    public void visit(StatementLet n) { unimplementedVisitor("visit(StatementLet)"); }
    public void visit(StatementLet n, Object o) { unimplementedVisitor("visit(StatementLet, Object)"); }

    public void visit(StatementBlock n) { unimplementedVisitor("visit(StatementBlock)"); }
    public void visit(StatementBlock n, Object o) { unimplementedVisitor("visit(StatementBlock, Object)"); }

    public void visit(StatementList n) { unimplementedVisitor("visit(StatementList)"); }
    public void visit(StatementList n, Object o) { unimplementedVisitor("visit(StatementList, Object)"); }

    public void visit(StatementComment n) { unimplementedVisitor("visit(StatementComment)"); }
    public void visit(StatementComment n, Object o) { unimplementedVisitor("visit(StatementComment, Object)"); }

    public void visit(StatementEchoExpression n) { unimplementedVisitor("visit(StatementEchoExpression)"); }
    public void visit(StatementEchoExpression n, Object o) { unimplementedVisitor("visit(StatementEchoExpression, Object)"); }

    public void visit(StatementEchoEmbedding n) { unimplementedVisitor("visit(StatementEchoEmbedding)"); }
    public void visit(StatementEchoEmbedding n, Object o) { unimplementedVisitor("visit(StatementEchoEmbedding, Object)"); }

    public void visit(StatementCData n) { unimplementedVisitor("visit(StatementCData)"); }
    public void visit(StatementCData n, Object o) { unimplementedVisitor("visit(StatementCData, Object)"); }

    public void visit(StatementYield n) { unimplementedVisitor("visit(StatementYield)"); }
    public void visit(StatementYield n, Object o) { unimplementedVisitor("visit(StatementYield, Object)"); }

    public void visit(Var n) { unimplementedVisitor("visit(Var)"); }
    public void visit(Var n, Object o) { unimplementedVisitor("visit(Var, Object)"); }

    public void visit(AssignmentList n) { unimplementedVisitor("visit(AssignmentList)"); }
    public void visit(AssignmentList n, Object o) { unimplementedVisitor("visit(AssignmentList, Object)"); }

    public void visit(Assignment n) { unimplementedVisitor("visit(Assignment)"); }
    public void visit(Assignment n, Object o) { unimplementedVisitor("visit(Assignment, Object)"); }

    public void visit(Designator n) { unimplementedVisitor("visit(Designator)"); }
    public void visit(Designator n, Object o) { unimplementedVisitor("visit(Designator, Object)"); }

    public void visit(AttributeList n) { unimplementedVisitor("visit(AttributeList)"); }
    public void visit(AttributeList n, Object o) { unimplementedVisitor("visit(AttributeList, Object)"); }

    public void visit(Function n) { unimplementedVisitor("visit(Function)"); }
    public void visit(Function n, Object o) { unimplementedVisitor("visit(Function, Object)"); }

    public void visit(ParameterDeclList n) { unimplementedVisitor("visit(ParameterDeclList)"); }
    public void visit(ParameterDeclList n, Object o) { unimplementedVisitor("visit(ParameterDeclList, Object)"); }

    public void visit(Name n) { unimplementedVisitor("visit(Name)"); }
    public void visit(Name n, Object o) { unimplementedVisitor("visit(Name, Object)"); }

    public void visit(TextTail0 n) { unimplementedVisitor("visit(TextTail0)"); }
    public void visit(TextTail0 n, Object o) { unimplementedVisitor("visit(TextTail0, Object)"); }

    public void visit(TextTail1 n) { unimplementedVisitor("visit(TextTail1)"); }
    public void visit(TextTail1 n, Object o) { unimplementedVisitor("visit(TextTail1, Object)"); }

    public void visit(Attribute0 n) { unimplementedVisitor("visit(Attribute0)"); }
    public void visit(Attribute0 n, Object o) { unimplementedVisitor("visit(Attribute0, Object)"); }

    public void visit(Attribute1 n) { unimplementedVisitor("visit(Attribute1)"); }
    public void visit(Attribute1 n, Object o) { unimplementedVisitor("visit(Attribute1, Object)"); }

    public void visit(Attribute2 n) { unimplementedVisitor("visit(Attribute2)"); }
    public void visit(Attribute2 n, Object o) { unimplementedVisitor("visit(Attribute2, Object)"); }


    public void visit(Ast n)
    {
        if (n instanceof AstToken) visit((AstToken) n);
        else if (n instanceof Module) visit((Module) n);
        else if (n instanceof ModuleIdList) visit((ModuleIdList) n);
        else if (n instanceof ModuleBlockList) visit((ModuleBlockList) n);
        else if (n instanceof Site) visit((Site) n);
        else if (n instanceof MappingList) visit((MappingList) n);
        else if (n instanceof Mapping) visit((Mapping) n);
        else if (n instanceof Path) visit((Path) n);
        else if (n instanceof FileName) visit((FileName) n);
        else if (n instanceof DirNameList) visit((DirNameList) n);
        else if (n instanceof DirName) visit((DirName) n);
        else if (n instanceof Markup) visit((Markup) n);
        else if (n instanceof MarkupList) visit((MarkupList) n);
        else if (n instanceof ArgumentList) visit((ArgumentList) n);
        else if (n instanceof Argument) visit((Argument) n);
        else if (n instanceof ExpressionList) visit((ExpressionList) n);
        else if (n instanceof ExpressionString) visit((ExpressionString) n);
        else if (n instanceof ExpressionConstant) visit((ExpressionConstant) n);
        else if (n instanceof ExpressionMember) visit((ExpressionMember) n);
        else if (n instanceof ExpressionCollection) visit((ExpressionCollection) n);
        else if (n instanceof ExpressionPair) visit((ExpressionPair) n);
        else if (n instanceof KeyValuePairList) visit((KeyValuePairList) n);
        else if (n instanceof KeyValuePair) visit((KeyValuePair) n);
        else if (n instanceof Embedding) visit((Embedding) n);
        else if (n instanceof Embed) visit((Embed) n);
        else if (n instanceof StatementEach) visit((StatementEach) n);
        else if (n instanceof StatementLet) visit((StatementLet) n);
        else if (n instanceof StatementBlock) visit((StatementBlock) n);
        else if (n instanceof StatementList) visit((StatementList) n);
        else if (n instanceof StatementComment) visit((StatementComment) n);
        else if (n instanceof StatementEchoExpression) visit((StatementEchoExpression) n);
        else if (n instanceof StatementEchoEmbedding) visit((StatementEchoEmbedding) n);
        else if (n instanceof StatementCData) visit((StatementCData) n);
        else if (n instanceof StatementYield) visit((StatementYield) n);
        else if (n instanceof Var) visit((Var) n);
        else if (n instanceof AssignmentList) visit((AssignmentList) n);
        else if (n instanceof Assignment) visit((Assignment) n);
        else if (n instanceof Designator) visit((Designator) n);
        else if (n instanceof AttributeList) visit((AttributeList) n);
        else if (n instanceof Function) visit((Function) n);
        else if (n instanceof ParameterDeclList) visit((ParameterDeclList) n);
        else if (n instanceof Name) visit((Name) n);
        else if (n instanceof TextTail0) visit((TextTail0) n);
        else if (n instanceof TextTail1) visit((TextTail1) n);
        else if (n instanceof Attribute0) visit((Attribute0) n);
        else if (n instanceof Attribute1) visit((Attribute1) n);
        else if (n instanceof Attribute2) visit((Attribute2) n);
        throw new UnsupportedOperationException("visit(" + n.getClass().toString() + ")");
    }
    public void visit(Ast n, Object o)
    {
        if (n instanceof AstToken) visit((AstToken) n, o);
        else if (n instanceof Module) visit((Module) n, o);
        else if (n instanceof ModuleIdList) visit((ModuleIdList) n, o);
        else if (n instanceof ModuleBlockList) visit((ModuleBlockList) n, o);
        else if (n instanceof Site) visit((Site) n, o);
        else if (n instanceof MappingList) visit((MappingList) n, o);
        else if (n instanceof Mapping) visit((Mapping) n, o);
        else if (n instanceof Path) visit((Path) n, o);
        else if (n instanceof FileName) visit((FileName) n, o);
        else if (n instanceof DirNameList) visit((DirNameList) n, o);
        else if (n instanceof DirName) visit((DirName) n, o);
        else if (n instanceof Markup) visit((Markup) n, o);
        else if (n instanceof MarkupList) visit((MarkupList) n, o);
        else if (n instanceof ArgumentList) visit((ArgumentList) n, o);
        else if (n instanceof Argument) visit((Argument) n, o);
        else if (n instanceof ExpressionList) visit((ExpressionList) n, o);
        else if (n instanceof ExpressionString) visit((ExpressionString) n, o);
        else if (n instanceof ExpressionConstant) visit((ExpressionConstant) n, o);
        else if (n instanceof ExpressionMember) visit((ExpressionMember) n, o);
        else if (n instanceof ExpressionCollection) visit((ExpressionCollection) n, o);
        else if (n instanceof ExpressionPair) visit((ExpressionPair) n, o);
        else if (n instanceof KeyValuePairList) visit((KeyValuePairList) n, o);
        else if (n instanceof KeyValuePair) visit((KeyValuePair) n, o);
        else if (n instanceof Embedding) visit((Embedding) n, o);
        else if (n instanceof Embed) visit((Embed) n, o);
        else if (n instanceof StatementEach) visit((StatementEach) n, o);
        else if (n instanceof StatementLet) visit((StatementLet) n, o);
        else if (n instanceof StatementBlock) visit((StatementBlock) n, o);
        else if (n instanceof StatementList) visit((StatementList) n, o);
        else if (n instanceof StatementComment) visit((StatementComment) n, o);
        else if (n instanceof StatementEchoExpression) visit((StatementEchoExpression) n, o);
        else if (n instanceof StatementEchoEmbedding) visit((StatementEchoEmbedding) n, o);
        else if (n instanceof StatementCData) visit((StatementCData) n, o);
        else if (n instanceof StatementYield) visit((StatementYield) n, o);
        else if (n instanceof Var) visit((Var) n, o);
        else if (n instanceof AssignmentList) visit((AssignmentList) n, o);
        else if (n instanceof Assignment) visit((Assignment) n, o);
        else if (n instanceof Designator) visit((Designator) n, o);
        else if (n instanceof AttributeList) visit((AttributeList) n, o);
        else if (n instanceof Function) visit((Function) n, o);
        else if (n instanceof ParameterDeclList) visit((ParameterDeclList) n, o);
        else if (n instanceof Name) visit((Name) n, o);
        else if (n instanceof TextTail0) visit((TextTail0) n, o);
        else if (n instanceof TextTail1) visit((TextTail1) n, o);
        else if (n instanceof Attribute0) visit((Attribute0) n, o);
        else if (n instanceof Attribute1) visit((Attribute1) n, o);
        else if (n instanceof Attribute2) visit((Attribute2) n, o);
        throw new UnsupportedOperationException("visit(" + n.getClass().toString() + ")");
    }
}

