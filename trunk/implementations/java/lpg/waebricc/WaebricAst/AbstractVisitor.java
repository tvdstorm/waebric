package waebricc.WaebricAst;

public abstract class AbstractVisitor implements Visitor, ArgumentVisitor
{
    public abstract void unimplementedVisitor(String s);

    public void visit(AstToken n) { unimplementedVisitor("visit(AstToken)"); }
    public void visit(AstToken n, Object o) { unimplementedVisitor("visit(AstToken, Object)"); }

    public void visit(ModuleList n) { unimplementedVisitor("visit(ModuleList)"); }
    public void visit(ModuleList n, Object o) { unimplementedVisitor("visit(ModuleList, Object)"); }

    public void visit(Module n) { unimplementedVisitor("visit(Module)"); }
    public void visit(Module n, Object o) { unimplementedVisitor("visit(Module, Object)"); }

    public void visit(ModuleIdList n) { unimplementedVisitor("visit(ModuleIdList)"); }
    public void visit(ModuleIdList n, Object o) { unimplementedVisitor("visit(ModuleIdList, Object)"); }

    public void visit(ModuleBlockList n) { unimplementedVisitor("visit(ModuleBlockList)"); }
    public void visit(ModuleBlockList n, Object o) { unimplementedVisitor("visit(ModuleBlockList, Object)"); }

    public void visit(Site n) { unimplementedVisitor("visit(Site)"); }
    public void visit(Site n, Object o) { unimplementedVisitor("visit(Site, Object)"); }

    public void visit(Import n) { unimplementedVisitor("visit(Import)"); }
    public void visit(Import n, Object o) { unimplementedVisitor("visit(Import, Object)"); }

    public void visit(FunctionWithParameters n) { unimplementedVisitor("visit(FunctionWithParameters)"); }
    public void visit(FunctionWithParameters n, Object o) { unimplementedVisitor("visit(FunctionWithParameters, Object)"); }

    public void visit(FunctionWithoutParameters n) { unimplementedVisitor("visit(FunctionWithoutParameters)"); }
    public void visit(FunctionWithoutParameters n, Object o) { unimplementedVisitor("visit(FunctionWithoutParameters, Object)"); }

    public void visit(ParameterDeclList n) { unimplementedVisitor("visit(ParameterDeclList)"); }
    public void visit(ParameterDeclList n, Object o) { unimplementedVisitor("visit(ParameterDeclList, Object)"); }

    public void visit(Name n) { unimplementedVisitor("visit(Name)"); }
    public void visit(Name n, Object o) { unimplementedVisitor("visit(Name, Object)"); }

    public void visit(MappingList n) { unimplementedVisitor("visit(MappingList)"); }
    public void visit(MappingList n, Object o) { unimplementedVisitor("visit(MappingList, Object)"); }

    public void visit(Mapping n) { unimplementedVisitor("visit(Mapping)"); }
    public void visit(Mapping n, Object o) { unimplementedVisitor("visit(Mapping, Object)"); }

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

    public void visit(ExpressionPlus n) { unimplementedVisitor("visit(ExpressionPlus)"); }
    public void visit(ExpressionPlus n, Object o) { unimplementedVisitor("visit(ExpressionPlus, Object)"); }

    public void visit(ExpressionConstant n) { unimplementedVisitor("visit(ExpressionConstant)"); }
    public void visit(ExpressionConstant n, Object o) { unimplementedVisitor("visit(ExpressionConstant, Object)"); }

    public void visit(ExpressionSymbol n) { unimplementedVisitor("visit(ExpressionSymbol)"); }
    public void visit(ExpressionSymbol n, Object o) { unimplementedVisitor("visit(ExpressionSymbol, Object)"); }

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

    public void visit(TextTailMidText n) { unimplementedVisitor("visit(TextTailMidText)"); }
    public void visit(TextTailMidText n, Object o) { unimplementedVisitor("visit(TextTailMidText, Object)"); }

    public void visit(TextTailPostText n) { unimplementedVisitor("visit(TextTailPostText)"); }
    public void visit(TextTailPostText n, Object o) { unimplementedVisitor("visit(TextTailPostText, Object)"); }

    public void visit(Embed n) { unimplementedVisitor("visit(Embed)"); }
    public void visit(Embed n, Object o) { unimplementedVisitor("visit(Embed, Object)"); }

    public void visit(StatementIf n) { unimplementedVisitor("visit(StatementIf)"); }
    public void visit(StatementIf n, Object o) { unimplementedVisitor("visit(StatementIf, Object)"); }

    public void visit(StatementIfElse n) { unimplementedVisitor("visit(StatementIfElse)"); }
    public void visit(StatementIfElse n, Object o) { unimplementedVisitor("visit(StatementIfElse, Object)"); }

    public void visit(StatementIfElseNoShortIf n) { unimplementedVisitor("visit(StatementIfElseNoShortIf)"); }
    public void visit(StatementIfElseNoShortIf n, Object o) { unimplementedVisitor("visit(StatementIfElseNoShortIf, Object)"); }

    public void visit(StatementEach n) { unimplementedVisitor("visit(StatementEach)"); }
    public void visit(StatementEach n, Object o) { unimplementedVisitor("visit(StatementEach, Object)"); }

    public void visit(StatementEachNoShortIf n) { unimplementedVisitor("visit(StatementEachNoShortIf)"); }
    public void visit(StatementEachNoShortIf n, Object o) { unimplementedVisitor("visit(StatementEachNoShortIf, Object)"); }

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

    public void visit(StatementMarkup n) { unimplementedVisitor("visit(StatementMarkup)"); }
    public void visit(StatementMarkup n, Object o) { unimplementedVisitor("visit(StatementMarkup, Object)"); }

    public void visit(StatementMarkupWithDesignator n) { unimplementedVisitor("visit(StatementMarkupWithDesignator)"); }
    public void visit(StatementMarkupWithDesignator n, Object o) { unimplementedVisitor("visit(StatementMarkupWithDesignator, Object)"); }

    public void visit(StatementMarkupWithExpression n) { unimplementedVisitor("visit(StatementMarkupWithExpression)"); }
    public void visit(StatementMarkupWithExpression n, Object o) { unimplementedVisitor("visit(StatementMarkupWithExpression, Object)"); }

    public void visit(StatementMarkupWithEmbedding n) { unimplementedVisitor("visit(StatementMarkupWithEmbedding)"); }
    public void visit(StatementMarkupWithEmbedding n, Object o) { unimplementedVisitor("visit(StatementMarkupWithEmbedding, Object)"); }

    public void visit(StatementMarkupStatement n) { unimplementedVisitor("visit(StatementMarkupStatement)"); }
    public void visit(StatementMarkupStatement n, Object o) { unimplementedVisitor("visit(StatementMarkupStatement, Object)"); }

    public void visit(StatementMarkupStatementNoShortIf n) { unimplementedVisitor("visit(StatementMarkupStatementNoShortIf)"); }
    public void visit(StatementMarkupStatementNoShortIf n, Object o) { unimplementedVisitor("visit(StatementMarkupStatementNoShortIf, Object)"); }

    public void visit(TypeList n) { unimplementedVisitor("visit(TypeList)"); }
    public void visit(TypeList n, Object o) { unimplementedVisitor("visit(TypeList, Object)"); }

    public void visit(TypeRecord n) { unimplementedVisitor("visit(TypeRecord)"); }
    public void visit(TypeRecord n, Object o) { unimplementedVisitor("visit(TypeRecord, Object)"); }

    public void visit(TypeString n) { unimplementedVisitor("visit(TypeString)"); }
    public void visit(TypeString n, Object o) { unimplementedVisitor("visit(TypeString, Object)"); }

    public void visit(PredicateCheckType n) { unimplementedVisitor("visit(PredicateCheckType)"); }
    public void visit(PredicateCheckType n, Object o) { unimplementedVisitor("visit(PredicateCheckType, Object)"); }

    public void visit(PredicateNegate n) { unimplementedVisitor("visit(PredicateNegate)"); }
    public void visit(PredicateNegate n, Object o) { unimplementedVisitor("visit(PredicateNegate, Object)"); }

    public void visit(PredicateAnd n) { unimplementedVisitor("visit(PredicateAnd)"); }
    public void visit(PredicateAnd n, Object o) { unimplementedVisitor("visit(PredicateAnd, Object)"); }

    public void visit(PredicateOr n) { unimplementedVisitor("visit(PredicateOr)"); }
    public void visit(PredicateOr n, Object o) { unimplementedVisitor("visit(PredicateOr, Object)"); }

    public void visit(Var n) { unimplementedVisitor("visit(Var)"); }
    public void visit(Var n, Object o) { unimplementedVisitor("visit(Var, Object)"); }

    public void visit(AssignmentList n) { unimplementedVisitor("visit(AssignmentList)"); }
    public void visit(AssignmentList n, Object o) { unimplementedVisitor("visit(AssignmentList, Object)"); }

    public void visit(AssignmentExpression n) { unimplementedVisitor("visit(AssignmentExpression)"); }
    public void visit(AssignmentExpression n, Object o) { unimplementedVisitor("visit(AssignmentExpression, Object)"); }

    public void visit(AssignmentStatement n) { unimplementedVisitor("visit(AssignmentStatement)"); }
    public void visit(AssignmentStatement n, Object o) { unimplementedVisitor("visit(AssignmentStatement, Object)"); }

    public void visit(Designator n) { unimplementedVisitor("visit(Designator)"); }
    public void visit(Designator n, Object o) { unimplementedVisitor("visit(Designator, Object)"); }

    public void visit(AttributeList n) { unimplementedVisitor("visit(AttributeList)"); }
    public void visit(AttributeList n, Object o) { unimplementedVisitor("visit(AttributeList, Object)"); }

    public void visit(AttributeSharp n) { unimplementedVisitor("visit(AttributeSharp)"); }
    public void visit(AttributeSharp n, Object o) { unimplementedVisitor("visit(AttributeSharp, Object)"); }

    public void visit(AttributeDot n) { unimplementedVisitor("visit(AttributeDot)"); }
    public void visit(AttributeDot n, Object o) { unimplementedVisitor("visit(AttributeDot, Object)"); }

    public void visit(AttributeDollar n) { unimplementedVisitor("visit(AttributeDollar)"); }
    public void visit(AttributeDollar n, Object o) { unimplementedVisitor("visit(AttributeDollar, Object)"); }

    public void visit(AttributeColon n) { unimplementedVisitor("visit(AttributeColon)"); }
    public void visit(AttributeColon n, Object o) { unimplementedVisitor("visit(AttributeColon, Object)"); }

    public void visit(AttributeWidth n) { unimplementedVisitor("visit(AttributeWidth)"); }
    public void visit(AttributeWidth n, Object o) { unimplementedVisitor("visit(AttributeWidth, Object)"); }

    public void visit(AttributeWidthHeight n) { unimplementedVisitor("visit(AttributeWidthHeight)"); }
    public void visit(AttributeWidthHeight n, Object o) { unimplementedVisitor("visit(AttributeWidthHeight, Object)"); }


    public void visit(Ast n)
    {
        if (n instanceof AstToken) visit((AstToken) n);
        else if (n instanceof ModuleList) visit((ModuleList) n);
        else if (n instanceof Module) visit((Module) n);
        else if (n instanceof ModuleIdList) visit((ModuleIdList) n);
        else if (n instanceof ModuleBlockList) visit((ModuleBlockList) n);
        else if (n instanceof Site) visit((Site) n);
        else if (n instanceof Import) visit((Import) n);
        else if (n instanceof FunctionWithParameters) visit((FunctionWithParameters) n);
        else if (n instanceof FunctionWithoutParameters) visit((FunctionWithoutParameters) n);
        else if (n instanceof ParameterDeclList) visit((ParameterDeclList) n);
        else if (n instanceof Name) visit((Name) n);
        else if (n instanceof MappingList) visit((MappingList) n);
        else if (n instanceof Mapping) visit((Mapping) n);
        else if (n instanceof Markup) visit((Markup) n);
        else if (n instanceof MarkupList) visit((MarkupList) n);
        else if (n instanceof ArgumentList) visit((ArgumentList) n);
        else if (n instanceof Argument) visit((Argument) n);
        else if (n instanceof ExpressionList) visit((ExpressionList) n);
        else if (n instanceof ExpressionString) visit((ExpressionString) n);
        else if (n instanceof ExpressionPlus) visit((ExpressionPlus) n);
        else if (n instanceof ExpressionConstant) visit((ExpressionConstant) n);
        else if (n instanceof ExpressionSymbol) visit((ExpressionSymbol) n);
        else if (n instanceof ExpressionCollection) visit((ExpressionCollection) n);
        else if (n instanceof ExpressionPair) visit((ExpressionPair) n);
        else if (n instanceof KeyValuePairList) visit((KeyValuePairList) n);
        else if (n instanceof KeyValuePair) visit((KeyValuePair) n);
        else if (n instanceof Embedding) visit((Embedding) n);
        else if (n instanceof TextTailMidText) visit((TextTailMidText) n);
        else if (n instanceof TextTailPostText) visit((TextTailPostText) n);
        else if (n instanceof Embed) visit((Embed) n);
        else if (n instanceof StatementIf) visit((StatementIf) n);
        else if (n instanceof StatementIfElse) visit((StatementIfElse) n);
        else if (n instanceof StatementIfElseNoShortIf) visit((StatementIfElseNoShortIf) n);
        else if (n instanceof StatementEach) visit((StatementEach) n);
        else if (n instanceof StatementEachNoShortIf) visit((StatementEachNoShortIf) n);
        else if (n instanceof StatementLet) visit((StatementLet) n);
        else if (n instanceof StatementBlock) visit((StatementBlock) n);
        else if (n instanceof StatementList) visit((StatementList) n);
        else if (n instanceof StatementComment) visit((StatementComment) n);
        else if (n instanceof StatementEchoExpression) visit((StatementEchoExpression) n);
        else if (n instanceof StatementEchoEmbedding) visit((StatementEchoEmbedding) n);
        else if (n instanceof StatementCData) visit((StatementCData) n);
        else if (n instanceof StatementYield) visit((StatementYield) n);
        else if (n instanceof StatementMarkup) visit((StatementMarkup) n);
        else if (n instanceof StatementMarkupWithDesignator) visit((StatementMarkupWithDesignator) n);
        else if (n instanceof StatementMarkupWithExpression) visit((StatementMarkupWithExpression) n);
        else if (n instanceof StatementMarkupWithEmbedding) visit((StatementMarkupWithEmbedding) n);
        else if (n instanceof StatementMarkupStatement) visit((StatementMarkupStatement) n);
        else if (n instanceof StatementMarkupStatementNoShortIf) visit((StatementMarkupStatementNoShortIf) n);
        else if (n instanceof TypeList) visit((TypeList) n);
        else if (n instanceof TypeRecord) visit((TypeRecord) n);
        else if (n instanceof TypeString) visit((TypeString) n);
        else if (n instanceof PredicateCheckType) visit((PredicateCheckType) n);
        else if (n instanceof PredicateNegate) visit((PredicateNegate) n);
        else if (n instanceof PredicateAnd) visit((PredicateAnd) n);
        else if (n instanceof PredicateOr) visit((PredicateOr) n);
        else if (n instanceof Var) visit((Var) n);
        else if (n instanceof AssignmentList) visit((AssignmentList) n);
        else if (n instanceof AssignmentExpression) visit((AssignmentExpression) n);
        else if (n instanceof AssignmentStatement) visit((AssignmentStatement) n);
        else if (n instanceof Designator) visit((Designator) n);
        else if (n instanceof AttributeList) visit((AttributeList) n);
        else if (n instanceof AttributeSharp) visit((AttributeSharp) n);
        else if (n instanceof AttributeDot) visit((AttributeDot) n);
        else if (n instanceof AttributeDollar) visit((AttributeDollar) n);
        else if (n instanceof AttributeColon) visit((AttributeColon) n);
        else if (n instanceof AttributeWidth) visit((AttributeWidth) n);
        else if (n instanceof AttributeWidthHeight) visit((AttributeWidthHeight) n);
        throw new UnsupportedOperationException("visit(" + n.getClass().toString() + ")");
    }
    public void visit(Ast n, Object o)
    {
        if (n instanceof AstToken) visit((AstToken) n, o);
        else if (n instanceof ModuleList) visit((ModuleList) n, o);
        else if (n instanceof Module) visit((Module) n, o);
        else if (n instanceof ModuleIdList) visit((ModuleIdList) n, o);
        else if (n instanceof ModuleBlockList) visit((ModuleBlockList) n, o);
        else if (n instanceof Site) visit((Site) n, o);
        else if (n instanceof Import) visit((Import) n, o);
        else if (n instanceof FunctionWithParameters) visit((FunctionWithParameters) n, o);
        else if (n instanceof FunctionWithoutParameters) visit((FunctionWithoutParameters) n, o);
        else if (n instanceof ParameterDeclList) visit((ParameterDeclList) n, o);
        else if (n instanceof Name) visit((Name) n, o);
        else if (n instanceof MappingList) visit((MappingList) n, o);
        else if (n instanceof Mapping) visit((Mapping) n, o);
        else if (n instanceof Markup) visit((Markup) n, o);
        else if (n instanceof MarkupList) visit((MarkupList) n, o);
        else if (n instanceof ArgumentList) visit((ArgumentList) n, o);
        else if (n instanceof Argument) visit((Argument) n, o);
        else if (n instanceof ExpressionList) visit((ExpressionList) n, o);
        else if (n instanceof ExpressionString) visit((ExpressionString) n, o);
        else if (n instanceof ExpressionPlus) visit((ExpressionPlus) n, o);
        else if (n instanceof ExpressionConstant) visit((ExpressionConstant) n, o);
        else if (n instanceof ExpressionSymbol) visit((ExpressionSymbol) n, o);
        else if (n instanceof ExpressionCollection) visit((ExpressionCollection) n, o);
        else if (n instanceof ExpressionPair) visit((ExpressionPair) n, o);
        else if (n instanceof KeyValuePairList) visit((KeyValuePairList) n, o);
        else if (n instanceof KeyValuePair) visit((KeyValuePair) n, o);
        else if (n instanceof Embedding) visit((Embedding) n, o);
        else if (n instanceof TextTailMidText) visit((TextTailMidText) n, o);
        else if (n instanceof TextTailPostText) visit((TextTailPostText) n, o);
        else if (n instanceof Embed) visit((Embed) n, o);
        else if (n instanceof StatementIf) visit((StatementIf) n, o);
        else if (n instanceof StatementIfElse) visit((StatementIfElse) n, o);
        else if (n instanceof StatementIfElseNoShortIf) visit((StatementIfElseNoShortIf) n, o);
        else if (n instanceof StatementEach) visit((StatementEach) n, o);
        else if (n instanceof StatementEachNoShortIf) visit((StatementEachNoShortIf) n, o);
        else if (n instanceof StatementLet) visit((StatementLet) n, o);
        else if (n instanceof StatementBlock) visit((StatementBlock) n, o);
        else if (n instanceof StatementList) visit((StatementList) n, o);
        else if (n instanceof StatementComment) visit((StatementComment) n, o);
        else if (n instanceof StatementEchoExpression) visit((StatementEchoExpression) n, o);
        else if (n instanceof StatementEchoEmbedding) visit((StatementEchoEmbedding) n, o);
        else if (n instanceof StatementCData) visit((StatementCData) n, o);
        else if (n instanceof StatementYield) visit((StatementYield) n, o);
        else if (n instanceof StatementMarkup) visit((StatementMarkup) n, o);
        else if (n instanceof StatementMarkupWithDesignator) visit((StatementMarkupWithDesignator) n, o);
        else if (n instanceof StatementMarkupWithExpression) visit((StatementMarkupWithExpression) n, o);
        else if (n instanceof StatementMarkupWithEmbedding) visit((StatementMarkupWithEmbedding) n, o);
        else if (n instanceof StatementMarkupStatement) visit((StatementMarkupStatement) n, o);
        else if (n instanceof StatementMarkupStatementNoShortIf) visit((StatementMarkupStatementNoShortIf) n, o);
        else if (n instanceof TypeList) visit((TypeList) n, o);
        else if (n instanceof TypeRecord) visit((TypeRecord) n, o);
        else if (n instanceof TypeString) visit((TypeString) n, o);
        else if (n instanceof PredicateCheckType) visit((PredicateCheckType) n, o);
        else if (n instanceof PredicateNegate) visit((PredicateNegate) n, o);
        else if (n instanceof PredicateAnd) visit((PredicateAnd) n, o);
        else if (n instanceof PredicateOr) visit((PredicateOr) n, o);
        else if (n instanceof Var) visit((Var) n, o);
        else if (n instanceof AssignmentList) visit((AssignmentList) n, o);
        else if (n instanceof AssignmentExpression) visit((AssignmentExpression) n, o);
        else if (n instanceof AssignmentStatement) visit((AssignmentStatement) n, o);
        else if (n instanceof Designator) visit((Designator) n, o);
        else if (n instanceof AttributeList) visit((AttributeList) n, o);
        else if (n instanceof AttributeSharp) visit((AttributeSharp) n, o);
        else if (n instanceof AttributeDot) visit((AttributeDot) n, o);
        else if (n instanceof AttributeDollar) visit((AttributeDollar) n, o);
        else if (n instanceof AttributeColon) visit((AttributeColon) n, o);
        else if (n instanceof AttributeWidth) visit((AttributeWidth) n, o);
        else if (n instanceof AttributeWidthHeight) visit((AttributeWidthHeight) n, o);
        throw new UnsupportedOperationException("visit(" + n.getClass().toString() + ")");
    }
}

