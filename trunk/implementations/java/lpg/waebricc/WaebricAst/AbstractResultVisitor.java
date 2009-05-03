package waebricc.WaebricAst;

public abstract class AbstractResultVisitor implements ResultVisitor, ResultArgumentVisitor
{
    public abstract Object unimplementedVisitor(String s);

    public Object visit(AstToken n) { return unimplementedVisitor("visit(AstToken)"); }
    public Object visit(AstToken n, Object o) { return  unimplementedVisitor("visit(AstToken, Object)"); }

    public Object visit(Module n) { return unimplementedVisitor("visit(Module)"); }
    public Object visit(Module n, Object o) { return  unimplementedVisitor("visit(Module, Object)"); }

    public Object visit(ModuleIdList n) { return unimplementedVisitor("visit(ModuleIdList)"); }
    public Object visit(ModuleIdList n, Object o) { return  unimplementedVisitor("visit(ModuleIdList, Object)"); }

    public Object visit(ModuleBlockList n) { return unimplementedVisitor("visit(ModuleBlockList)"); }
    public Object visit(ModuleBlockList n, Object o) { return  unimplementedVisitor("visit(ModuleBlockList, Object)"); }

    public Object visit(Site n) { return unimplementedVisitor("visit(Site)"); }
    public Object visit(Site n, Object o) { return  unimplementedVisitor("visit(Site, Object)"); }

    public Object visit(MappingList n) { return unimplementedVisitor("visit(MappingList)"); }
    public Object visit(MappingList n, Object o) { return  unimplementedVisitor("visit(MappingList, Object)"); }

    public Object visit(Mapping n) { return unimplementedVisitor("visit(Mapping)"); }
    public Object visit(Mapping n, Object o) { return  unimplementedVisitor("visit(Mapping, Object)"); }

    public Object visit(Path n) { return unimplementedVisitor("visit(Path)"); }
    public Object visit(Path n, Object o) { return  unimplementedVisitor("visit(Path, Object)"); }

    public Object visit(FileName n) { return unimplementedVisitor("visit(FileName)"); }
    public Object visit(FileName n, Object o) { return  unimplementedVisitor("visit(FileName, Object)"); }

    public Object visit(DirNameList n) { return unimplementedVisitor("visit(DirNameList)"); }
    public Object visit(DirNameList n, Object o) { return  unimplementedVisitor("visit(DirNameList, Object)"); }

    public Object visit(DirName n) { return unimplementedVisitor("visit(DirName)"); }
    public Object visit(DirName n, Object o) { return  unimplementedVisitor("visit(DirName, Object)"); }

    public Object visit(Markup n) { return unimplementedVisitor("visit(Markup)"); }
    public Object visit(Markup n, Object o) { return  unimplementedVisitor("visit(Markup, Object)"); }

    public Object visit(MarkupList n) { return unimplementedVisitor("visit(MarkupList)"); }
    public Object visit(MarkupList n, Object o) { return  unimplementedVisitor("visit(MarkupList, Object)"); }

    public Object visit(ArgumentList n) { return unimplementedVisitor("visit(ArgumentList)"); }
    public Object visit(ArgumentList n, Object o) { return  unimplementedVisitor("visit(ArgumentList, Object)"); }

    public Object visit(Argument n) { return unimplementedVisitor("visit(Argument)"); }
    public Object visit(Argument n, Object o) { return  unimplementedVisitor("visit(Argument, Object)"); }

    public Object visit(ExpressionList n) { return unimplementedVisitor("visit(ExpressionList)"); }
    public Object visit(ExpressionList n, Object o) { return  unimplementedVisitor("visit(ExpressionList, Object)"); }

    public Object visit(ExpressionString n) { return unimplementedVisitor("visit(ExpressionString)"); }
    public Object visit(ExpressionString n, Object o) { return  unimplementedVisitor("visit(ExpressionString, Object)"); }

    public Object visit(ExpressionConstant n) { return unimplementedVisitor("visit(ExpressionConstant)"); }
    public Object visit(ExpressionConstant n, Object o) { return  unimplementedVisitor("visit(ExpressionConstant, Object)"); }

    public Object visit(ExpressionCollection n) { return unimplementedVisitor("visit(ExpressionCollection)"); }
    public Object visit(ExpressionCollection n, Object o) { return  unimplementedVisitor("visit(ExpressionCollection, Object)"); }

    public Object visit(ExpressionPair n) { return unimplementedVisitor("visit(ExpressionPair)"); }
    public Object visit(ExpressionPair n, Object o) { return  unimplementedVisitor("visit(ExpressionPair, Object)"); }

    public Object visit(KeyValuePairList n) { return unimplementedVisitor("visit(KeyValuePairList)"); }
    public Object visit(KeyValuePairList n, Object o) { return  unimplementedVisitor("visit(KeyValuePairList, Object)"); }

    public Object visit(KeyValuePair n) { return unimplementedVisitor("visit(KeyValuePair)"); }
    public Object visit(KeyValuePair n, Object o) { return  unimplementedVisitor("visit(KeyValuePair, Object)"); }

    public Object visit(Embedding n) { return unimplementedVisitor("visit(Embedding)"); }
    public Object visit(Embedding n, Object o) { return  unimplementedVisitor("visit(Embedding, Object)"); }

    public Object visit(Embed n) { return unimplementedVisitor("visit(Embed)"); }
    public Object visit(Embed n, Object o) { return  unimplementedVisitor("visit(Embed, Object)"); }

    public Object visit(StatementIf n) { return unimplementedVisitor("visit(StatementIf)"); }
    public Object visit(StatementIf n, Object o) { return  unimplementedVisitor("visit(StatementIf, Object)"); }

    public Object visit(StatementIfElse n) { return unimplementedVisitor("visit(StatementIfElse)"); }
    public Object visit(StatementIfElse n, Object o) { return  unimplementedVisitor("visit(StatementIfElse, Object)"); }

    public Object visit(StatementEach n) { return unimplementedVisitor("visit(StatementEach)"); }
    public Object visit(StatementEach n, Object o) { return  unimplementedVisitor("visit(StatementEach, Object)"); }

    public Object visit(StatementLet n) { return unimplementedVisitor("visit(StatementLet)"); }
    public Object visit(StatementLet n, Object o) { return  unimplementedVisitor("visit(StatementLet, Object)"); }

    public Object visit(StatementBlock n) { return unimplementedVisitor("visit(StatementBlock)"); }
    public Object visit(StatementBlock n, Object o) { return  unimplementedVisitor("visit(StatementBlock, Object)"); }

    public Object visit(StatementList n) { return unimplementedVisitor("visit(StatementList)"); }
    public Object visit(StatementList n, Object o) { return  unimplementedVisitor("visit(StatementList, Object)"); }

    public Object visit(StatementComment n) { return unimplementedVisitor("visit(StatementComment)"); }
    public Object visit(StatementComment n, Object o) { return  unimplementedVisitor("visit(StatementComment, Object)"); }

    public Object visit(StatementEchoExpression n) { return unimplementedVisitor("visit(StatementEchoExpression)"); }
    public Object visit(StatementEchoExpression n, Object o) { return  unimplementedVisitor("visit(StatementEchoExpression, Object)"); }

    public Object visit(StatementEchoEmbedding n) { return unimplementedVisitor("visit(StatementEchoEmbedding)"); }
    public Object visit(StatementEchoEmbedding n, Object o) { return  unimplementedVisitor("visit(StatementEchoEmbedding, Object)"); }

    public Object visit(StatementCData n) { return unimplementedVisitor("visit(StatementCData)"); }
    public Object visit(StatementCData n, Object o) { return  unimplementedVisitor("visit(StatementCData, Object)"); }

    public Object visit(StatementYield n) { return unimplementedVisitor("visit(StatementYield)"); }
    public Object visit(StatementYield n, Object o) { return  unimplementedVisitor("visit(StatementYield, Object)"); }

    public Object visit(Predicate n) { return unimplementedVisitor("visit(Predicate)"); }
    public Object visit(Predicate n, Object o) { return  unimplementedVisitor("visit(Predicate, Object)"); }

    public Object visit(Var n) { return unimplementedVisitor("visit(Var)"); }
    public Object visit(Var n, Object o) { return  unimplementedVisitor("visit(Var, Object)"); }

    public Object visit(AssignmentList n) { return unimplementedVisitor("visit(AssignmentList)"); }
    public Object visit(AssignmentList n, Object o) { return  unimplementedVisitor("visit(AssignmentList, Object)"); }

    public Object visit(Assignment n) { return unimplementedVisitor("visit(Assignment)"); }
    public Object visit(Assignment n, Object o) { return  unimplementedVisitor("visit(Assignment, Object)"); }

    public Object visit(Designator n) { return unimplementedVisitor("visit(Designator)"); }
    public Object visit(Designator n, Object o) { return  unimplementedVisitor("visit(Designator, Object)"); }

    public Object visit(AttributeList n) { return unimplementedVisitor("visit(AttributeList)"); }
    public Object visit(AttributeList n, Object o) { return  unimplementedVisitor("visit(AttributeList, Object)"); }

    public Object visit(Attribute n) { return unimplementedVisitor("visit(Attribute)"); }
    public Object visit(Attribute n, Object o) { return  unimplementedVisitor("visit(Attribute, Object)"); }

    public Object visit(Function n) { return unimplementedVisitor("visit(Function)"); }
    public Object visit(Function n, Object o) { return  unimplementedVisitor("visit(Function, Object)"); }

    public Object visit(ParameterDeclList n) { return unimplementedVisitor("visit(ParameterDeclList)"); }
    public Object visit(ParameterDeclList n, Object o) { return  unimplementedVisitor("visit(ParameterDeclList, Object)"); }

    public Object visit(Name n) { return unimplementedVisitor("visit(Name)"); }
    public Object visit(Name n, Object o) { return  unimplementedVisitor("visit(Name, Object)"); }

    public Object visit(TextTail0 n) { return unimplementedVisitor("visit(TextTail0)"); }
    public Object visit(TextTail0 n, Object o) { return  unimplementedVisitor("visit(TextTail0, Object)"); }

    public Object visit(TextTail1 n) { return unimplementedVisitor("visit(TextTail1)"); }
    public Object visit(TextTail1 n, Object o) { return  unimplementedVisitor("visit(TextTail1, Object)"); }

    public Object visit(Type0 n) { return unimplementedVisitor("visit(Type0)"); }
    public Object visit(Type0 n, Object o) { return  unimplementedVisitor("visit(Type0, Object)"); }

    public Object visit(Type1 n) { return unimplementedVisitor("visit(Type1)"); }
    public Object visit(Type1 n, Object o) { return  unimplementedVisitor("visit(Type1, Object)"); }

    public Object visit(Type2 n) { return unimplementedVisitor("visit(Type2)"); }
    public Object visit(Type2 n, Object o) { return  unimplementedVisitor("visit(Type2, Object)"); }


    public Object visit(Ast n)
    {
        if (n instanceof AstToken) return visit((AstToken) n);
        else if (n instanceof Module) return visit((Module) n);
        else if (n instanceof ModuleIdList) return visit((ModuleIdList) n);
        else if (n instanceof ModuleBlockList) return visit((ModuleBlockList) n);
        else if (n instanceof Site) return visit((Site) n);
        else if (n instanceof MappingList) return visit((MappingList) n);
        else if (n instanceof Mapping) return visit((Mapping) n);
        else if (n instanceof Path) return visit((Path) n);
        else if (n instanceof FileName) return visit((FileName) n);
        else if (n instanceof DirNameList) return visit((DirNameList) n);
        else if (n instanceof DirName) return visit((DirName) n);
        else if (n instanceof Markup) return visit((Markup) n);
        else if (n instanceof MarkupList) return visit((MarkupList) n);
        else if (n instanceof ArgumentList) return visit((ArgumentList) n);
        else if (n instanceof Argument) return visit((Argument) n);
        else if (n instanceof ExpressionList) return visit((ExpressionList) n);
        else if (n instanceof ExpressionString) return visit((ExpressionString) n);
        else if (n instanceof ExpressionConstant) return visit((ExpressionConstant) n);
        else if (n instanceof ExpressionCollection) return visit((ExpressionCollection) n);
        else if (n instanceof ExpressionPair) return visit((ExpressionPair) n);
        else if (n instanceof KeyValuePairList) return visit((KeyValuePairList) n);
        else if (n instanceof KeyValuePair) return visit((KeyValuePair) n);
        else if (n instanceof Embedding) return visit((Embedding) n);
        else if (n instanceof Embed) return visit((Embed) n);
        else if (n instanceof StatementIf) return visit((StatementIf) n);
        else if (n instanceof StatementIfElse) return visit((StatementIfElse) n);
        else if (n instanceof StatementEach) return visit((StatementEach) n);
        else if (n instanceof StatementLet) return visit((StatementLet) n);
        else if (n instanceof StatementBlock) return visit((StatementBlock) n);
        else if (n instanceof StatementList) return visit((StatementList) n);
        else if (n instanceof StatementComment) return visit((StatementComment) n);
        else if (n instanceof StatementEchoExpression) return visit((StatementEchoExpression) n);
        else if (n instanceof StatementEchoEmbedding) return visit((StatementEchoEmbedding) n);
        else if (n instanceof StatementCData) return visit((StatementCData) n);
        else if (n instanceof StatementYield) return visit((StatementYield) n);
        else if (n instanceof Predicate) return visit((Predicate) n);
        else if (n instanceof Var) return visit((Var) n);
        else if (n instanceof AssignmentList) return visit((AssignmentList) n);
        else if (n instanceof Assignment) return visit((Assignment) n);
        else if (n instanceof Designator) return visit((Designator) n);
        else if (n instanceof AttributeList) return visit((AttributeList) n);
        else if (n instanceof Attribute) return visit((Attribute) n);
        else if (n instanceof Function) return visit((Function) n);
        else if (n instanceof ParameterDeclList) return visit((ParameterDeclList) n);
        else if (n instanceof Name) return visit((Name) n);
        else if (n instanceof TextTail0) return visit((TextTail0) n);
        else if (n instanceof TextTail1) return visit((TextTail1) n);
        else if (n instanceof Type0) return visit((Type0) n);
        else if (n instanceof Type1) return visit((Type1) n);
        else if (n instanceof Type2) return visit((Type2) n);
        throw new UnsupportedOperationException("visit(" + n.getClass().toString() + ")");
    }
    public Object visit(Ast n, Object o)
    {
        if (n instanceof AstToken) return visit((AstToken) n, o);
        else if (n instanceof Module) return visit((Module) n, o);
        else if (n instanceof ModuleIdList) return visit((ModuleIdList) n, o);
        else if (n instanceof ModuleBlockList) return visit((ModuleBlockList) n, o);
        else if (n instanceof Site) return visit((Site) n, o);
        else if (n instanceof MappingList) return visit((MappingList) n, o);
        else if (n instanceof Mapping) return visit((Mapping) n, o);
        else if (n instanceof Path) return visit((Path) n, o);
        else if (n instanceof FileName) return visit((FileName) n, o);
        else if (n instanceof DirNameList) return visit((DirNameList) n, o);
        else if (n instanceof DirName) return visit((DirName) n, o);
        else if (n instanceof Markup) return visit((Markup) n, o);
        else if (n instanceof MarkupList) return visit((MarkupList) n, o);
        else if (n instanceof ArgumentList) return visit((ArgumentList) n, o);
        else if (n instanceof Argument) return visit((Argument) n, o);
        else if (n instanceof ExpressionList) return visit((ExpressionList) n, o);
        else if (n instanceof ExpressionString) return visit((ExpressionString) n, o);
        else if (n instanceof ExpressionConstant) return visit((ExpressionConstant) n, o);
        else if (n instanceof ExpressionCollection) return visit((ExpressionCollection) n, o);
        else if (n instanceof ExpressionPair) return visit((ExpressionPair) n, o);
        else if (n instanceof KeyValuePairList) return visit((KeyValuePairList) n, o);
        else if (n instanceof KeyValuePair) return visit((KeyValuePair) n, o);
        else if (n instanceof Embedding) return visit((Embedding) n, o);
        else if (n instanceof Embed) return visit((Embed) n, o);
        else if (n instanceof StatementIf) return visit((StatementIf) n, o);
        else if (n instanceof StatementIfElse) return visit((StatementIfElse) n, o);
        else if (n instanceof StatementEach) return visit((StatementEach) n, o);
        else if (n instanceof StatementLet) return visit((StatementLet) n, o);
        else if (n instanceof StatementBlock) return visit((StatementBlock) n, o);
        else if (n instanceof StatementList) return visit((StatementList) n, o);
        else if (n instanceof StatementComment) return visit((StatementComment) n, o);
        else if (n instanceof StatementEchoExpression) return visit((StatementEchoExpression) n, o);
        else if (n instanceof StatementEchoEmbedding) return visit((StatementEchoEmbedding) n, o);
        else if (n instanceof StatementCData) return visit((StatementCData) n, o);
        else if (n instanceof StatementYield) return visit((StatementYield) n, o);
        else if (n instanceof Predicate) return visit((Predicate) n, o);
        else if (n instanceof Var) return visit((Var) n, o);
        else if (n instanceof AssignmentList) return visit((AssignmentList) n, o);
        else if (n instanceof Assignment) return visit((Assignment) n, o);
        else if (n instanceof Designator) return visit((Designator) n, o);
        else if (n instanceof AttributeList) return visit((AttributeList) n, o);
        else if (n instanceof Attribute) return visit((Attribute) n, o);
        else if (n instanceof Function) return visit((Function) n, o);
        else if (n instanceof ParameterDeclList) return visit((ParameterDeclList) n, o);
        else if (n instanceof Name) return visit((Name) n, o);
        else if (n instanceof TextTail0) return visit((TextTail0) n, o);
        else if (n instanceof TextTail1) return visit((TextTail1) n, o);
        else if (n instanceof Type0) return visit((Type0) n, o);
        else if (n instanceof Type1) return visit((Type1) n, o);
        else if (n instanceof Type2) return visit((Type2) n, o);
        throw new UnsupportedOperationException("visit(" + n.getClass().toString() + ")");
    }
}

