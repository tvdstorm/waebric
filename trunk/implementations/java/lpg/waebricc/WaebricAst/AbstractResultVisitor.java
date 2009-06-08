package waebricc.WaebricAst;

public abstract class AbstractResultVisitor implements ResultVisitor, ResultArgumentVisitor
{
    public abstract Object unimplementedVisitor(String s);

    public Object visit(AstToken n) { return unimplementedVisitor("visit(AstToken)"); }
    public Object visit(AstToken n, Object o) { return  unimplementedVisitor("visit(AstToken, Object)"); }

    public Object visit(ModuleList n) { return unimplementedVisitor("visit(ModuleList)"); }
    public Object visit(ModuleList n, Object o) { return  unimplementedVisitor("visit(ModuleList, Object)"); }

    public Object visit(Module n) { return unimplementedVisitor("visit(Module)"); }
    public Object visit(Module n, Object o) { return  unimplementedVisitor("visit(Module, Object)"); }

    public Object visit(ModuleIdList n) { return unimplementedVisitor("visit(ModuleIdList)"); }
    public Object visit(ModuleIdList n, Object o) { return  unimplementedVisitor("visit(ModuleIdList, Object)"); }

    public Object visit(ModuleBlockList n) { return unimplementedVisitor("visit(ModuleBlockList)"); }
    public Object visit(ModuleBlockList n, Object o) { return  unimplementedVisitor("visit(ModuleBlockList, Object)"); }

    public Object visit(Site n) { return unimplementedVisitor("visit(Site)"); }
    public Object visit(Site n, Object o) { return  unimplementedVisitor("visit(Site, Object)"); }

    public Object visit(Import n) { return unimplementedVisitor("visit(Import)"); }
    public Object visit(Import n, Object o) { return  unimplementedVisitor("visit(Import, Object)"); }

    public Object visit(FunctionWithParameters n) { return unimplementedVisitor("visit(FunctionWithParameters)"); }
    public Object visit(FunctionWithParameters n, Object o) { return  unimplementedVisitor("visit(FunctionWithParameters, Object)"); }

    public Object visit(FunctionWithoutParameters n) { return unimplementedVisitor("visit(FunctionWithoutParameters)"); }
    public Object visit(FunctionWithoutParameters n, Object o) { return  unimplementedVisitor("visit(FunctionWithoutParameters, Object)"); }

    public Object visit(ParameterDeclList n) { return unimplementedVisitor("visit(ParameterDeclList)"); }
    public Object visit(ParameterDeclList n, Object o) { return  unimplementedVisitor("visit(ParameterDeclList, Object)"); }

    public Object visit(Name n) { return unimplementedVisitor("visit(Name)"); }
    public Object visit(Name n, Object o) { return  unimplementedVisitor("visit(Name, Object)"); }

    public Object visit(MappingList n) { return unimplementedVisitor("visit(MappingList)"); }
    public Object visit(MappingList n, Object o) { return  unimplementedVisitor("visit(MappingList, Object)"); }

    public Object visit(Mapping n) { return unimplementedVisitor("visit(Mapping)"); }
    public Object visit(Mapping n, Object o) { return  unimplementedVisitor("visit(Mapping, Object)"); }

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

    public Object visit(ExpressionPlus n) { return unimplementedVisitor("visit(ExpressionPlus)"); }
    public Object visit(ExpressionPlus n, Object o) { return  unimplementedVisitor("visit(ExpressionPlus, Object)"); }

    public Object visit(ExpressionConstant n) { return unimplementedVisitor("visit(ExpressionConstant)"); }
    public Object visit(ExpressionConstant n, Object o) { return  unimplementedVisitor("visit(ExpressionConstant, Object)"); }

    public Object visit(ExpressionSymbol n) { return unimplementedVisitor("visit(ExpressionSymbol)"); }
    public Object visit(ExpressionSymbol n, Object o) { return  unimplementedVisitor("visit(ExpressionSymbol, Object)"); }

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

    public Object visit(TextTailMidText n) { return unimplementedVisitor("visit(TextTailMidText)"); }
    public Object visit(TextTailMidText n, Object o) { return  unimplementedVisitor("visit(TextTailMidText, Object)"); }

    public Object visit(TextTailPostText n) { return unimplementedVisitor("visit(TextTailPostText)"); }
    public Object visit(TextTailPostText n, Object o) { return  unimplementedVisitor("visit(TextTailPostText, Object)"); }

    public Object visit(Embed n) { return unimplementedVisitor("visit(Embed)"); }
    public Object visit(Embed n, Object o) { return  unimplementedVisitor("visit(Embed, Object)"); }

    public Object visit(StatementIf n) { return unimplementedVisitor("visit(StatementIf)"); }
    public Object visit(StatementIf n, Object o) { return  unimplementedVisitor("visit(StatementIf, Object)"); }

    public Object visit(StatementIfElse n) { return unimplementedVisitor("visit(StatementIfElse)"); }
    public Object visit(StatementIfElse n, Object o) { return  unimplementedVisitor("visit(StatementIfElse, Object)"); }

    public Object visit(StatementIfElseNoShortIf n) { return unimplementedVisitor("visit(StatementIfElseNoShortIf)"); }
    public Object visit(StatementIfElseNoShortIf n, Object o) { return  unimplementedVisitor("visit(StatementIfElseNoShortIf, Object)"); }

    public Object visit(StatementEach n) { return unimplementedVisitor("visit(StatementEach)"); }
    public Object visit(StatementEach n, Object o) { return  unimplementedVisitor("visit(StatementEach, Object)"); }

    public Object visit(StatementEachNoShortIf n) { return unimplementedVisitor("visit(StatementEachNoShortIf)"); }
    public Object visit(StatementEachNoShortIf n, Object o) { return  unimplementedVisitor("visit(StatementEachNoShortIf, Object)"); }

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

    public Object visit(StatementMarkup n) { return unimplementedVisitor("visit(StatementMarkup)"); }
    public Object visit(StatementMarkup n, Object o) { return  unimplementedVisitor("visit(StatementMarkup, Object)"); }

    public Object visit(StatementMarkupWithDesignator n) { return unimplementedVisitor("visit(StatementMarkupWithDesignator)"); }
    public Object visit(StatementMarkupWithDesignator n, Object o) { return  unimplementedVisitor("visit(StatementMarkupWithDesignator, Object)"); }

    public Object visit(StatementMarkupWithExpression n) { return unimplementedVisitor("visit(StatementMarkupWithExpression)"); }
    public Object visit(StatementMarkupWithExpression n, Object o) { return  unimplementedVisitor("visit(StatementMarkupWithExpression, Object)"); }

    public Object visit(StatementMarkupWithEmbedding n) { return unimplementedVisitor("visit(StatementMarkupWithEmbedding)"); }
    public Object visit(StatementMarkupWithEmbedding n, Object o) { return  unimplementedVisitor("visit(StatementMarkupWithEmbedding, Object)"); }

    public Object visit(StatementMarkupStatement n) { return unimplementedVisitor("visit(StatementMarkupStatement)"); }
    public Object visit(StatementMarkupStatement n, Object o) { return  unimplementedVisitor("visit(StatementMarkupStatement, Object)"); }

    public Object visit(StatementMarkupStatementNoShortIf n) { return unimplementedVisitor("visit(StatementMarkupStatementNoShortIf)"); }
    public Object visit(StatementMarkupStatementNoShortIf n, Object o) { return  unimplementedVisitor("visit(StatementMarkupStatementNoShortIf, Object)"); }

    public Object visit(TypeList n) { return unimplementedVisitor("visit(TypeList)"); }
    public Object visit(TypeList n, Object o) { return  unimplementedVisitor("visit(TypeList, Object)"); }

    public Object visit(TypeRecord n) { return unimplementedVisitor("visit(TypeRecord)"); }
    public Object visit(TypeRecord n, Object o) { return  unimplementedVisitor("visit(TypeRecord, Object)"); }

    public Object visit(TypeString n) { return unimplementedVisitor("visit(TypeString)"); }
    public Object visit(TypeString n, Object o) { return  unimplementedVisitor("visit(TypeString, Object)"); }

    public Object visit(PredicateCheckType n) { return unimplementedVisitor("visit(PredicateCheckType)"); }
    public Object visit(PredicateCheckType n, Object o) { return  unimplementedVisitor("visit(PredicateCheckType, Object)"); }

    public Object visit(PredicateNegate n) { return unimplementedVisitor("visit(PredicateNegate)"); }
    public Object visit(PredicateNegate n, Object o) { return  unimplementedVisitor("visit(PredicateNegate, Object)"); }

    public Object visit(PredicateAnd n) { return unimplementedVisitor("visit(PredicateAnd)"); }
    public Object visit(PredicateAnd n, Object o) { return  unimplementedVisitor("visit(PredicateAnd, Object)"); }

    public Object visit(PredicateOr n) { return unimplementedVisitor("visit(PredicateOr)"); }
    public Object visit(PredicateOr n, Object o) { return  unimplementedVisitor("visit(PredicateOr, Object)"); }

    public Object visit(Var n) { return unimplementedVisitor("visit(Var)"); }
    public Object visit(Var n, Object o) { return  unimplementedVisitor("visit(Var, Object)"); }

    public Object visit(AssignmentList n) { return unimplementedVisitor("visit(AssignmentList)"); }
    public Object visit(AssignmentList n, Object o) { return  unimplementedVisitor("visit(AssignmentList, Object)"); }

    public Object visit(AssignmentExpression n) { return unimplementedVisitor("visit(AssignmentExpression)"); }
    public Object visit(AssignmentExpression n, Object o) { return  unimplementedVisitor("visit(AssignmentExpression, Object)"); }

    public Object visit(AssignmentStatement n) { return unimplementedVisitor("visit(AssignmentStatement)"); }
    public Object visit(AssignmentStatement n, Object o) { return  unimplementedVisitor("visit(AssignmentStatement, Object)"); }

    public Object visit(Designator n) { return unimplementedVisitor("visit(Designator)"); }
    public Object visit(Designator n, Object o) { return  unimplementedVisitor("visit(Designator, Object)"); }

    public Object visit(AttributeList n) { return unimplementedVisitor("visit(AttributeList)"); }
    public Object visit(AttributeList n, Object o) { return  unimplementedVisitor("visit(AttributeList, Object)"); }

    public Object visit(AttributeSharp n) { return unimplementedVisitor("visit(AttributeSharp)"); }
    public Object visit(AttributeSharp n, Object o) { return  unimplementedVisitor("visit(AttributeSharp, Object)"); }

    public Object visit(AttributeDot n) { return unimplementedVisitor("visit(AttributeDot)"); }
    public Object visit(AttributeDot n, Object o) { return  unimplementedVisitor("visit(AttributeDot, Object)"); }

    public Object visit(AttributeDollar n) { return unimplementedVisitor("visit(AttributeDollar)"); }
    public Object visit(AttributeDollar n, Object o) { return  unimplementedVisitor("visit(AttributeDollar, Object)"); }

    public Object visit(AttributeColon n) { return unimplementedVisitor("visit(AttributeColon)"); }
    public Object visit(AttributeColon n, Object o) { return  unimplementedVisitor("visit(AttributeColon, Object)"); }

    public Object visit(AttributeWidth n) { return unimplementedVisitor("visit(AttributeWidth)"); }
    public Object visit(AttributeWidth n, Object o) { return  unimplementedVisitor("visit(AttributeWidth, Object)"); }

    public Object visit(AttributeWidthHeight n) { return unimplementedVisitor("visit(AttributeWidthHeight)"); }
    public Object visit(AttributeWidthHeight n, Object o) { return  unimplementedVisitor("visit(AttributeWidthHeight, Object)"); }


    public Object visit(Ast n)
    {
        if (n instanceof AstToken) return visit((AstToken) n);
        else if (n instanceof ModuleList) return visit((ModuleList) n);
        else if (n instanceof Module) return visit((Module) n);
        else if (n instanceof ModuleIdList) return visit((ModuleIdList) n);
        else if (n instanceof ModuleBlockList) return visit((ModuleBlockList) n);
        else if (n instanceof Site) return visit((Site) n);
        else if (n instanceof Import) return visit((Import) n);
        else if (n instanceof FunctionWithParameters) return visit((FunctionWithParameters) n);
        else if (n instanceof FunctionWithoutParameters) return visit((FunctionWithoutParameters) n);
        else if (n instanceof ParameterDeclList) return visit((ParameterDeclList) n);
        else if (n instanceof Name) return visit((Name) n);
        else if (n instanceof MappingList) return visit((MappingList) n);
        else if (n instanceof Mapping) return visit((Mapping) n);
        else if (n instanceof Markup) return visit((Markup) n);
        else if (n instanceof MarkupList) return visit((MarkupList) n);
        else if (n instanceof ArgumentList) return visit((ArgumentList) n);
        else if (n instanceof Argument) return visit((Argument) n);
        else if (n instanceof ExpressionList) return visit((ExpressionList) n);
        else if (n instanceof ExpressionString) return visit((ExpressionString) n);
        else if (n instanceof ExpressionPlus) return visit((ExpressionPlus) n);
        else if (n instanceof ExpressionConstant) return visit((ExpressionConstant) n);
        else if (n instanceof ExpressionSymbol) return visit((ExpressionSymbol) n);
        else if (n instanceof ExpressionCollection) return visit((ExpressionCollection) n);
        else if (n instanceof ExpressionPair) return visit((ExpressionPair) n);
        else if (n instanceof KeyValuePairList) return visit((KeyValuePairList) n);
        else if (n instanceof KeyValuePair) return visit((KeyValuePair) n);
        else if (n instanceof Embedding) return visit((Embedding) n);
        else if (n instanceof TextTailMidText) return visit((TextTailMidText) n);
        else if (n instanceof TextTailPostText) return visit((TextTailPostText) n);
        else if (n instanceof Embed) return visit((Embed) n);
        else if (n instanceof StatementIf) return visit((StatementIf) n);
        else if (n instanceof StatementIfElse) return visit((StatementIfElse) n);
        else if (n instanceof StatementIfElseNoShortIf) return visit((StatementIfElseNoShortIf) n);
        else if (n instanceof StatementEach) return visit((StatementEach) n);
        else if (n instanceof StatementEachNoShortIf) return visit((StatementEachNoShortIf) n);
        else if (n instanceof StatementLet) return visit((StatementLet) n);
        else if (n instanceof StatementBlock) return visit((StatementBlock) n);
        else if (n instanceof StatementList) return visit((StatementList) n);
        else if (n instanceof StatementComment) return visit((StatementComment) n);
        else if (n instanceof StatementEchoExpression) return visit((StatementEchoExpression) n);
        else if (n instanceof StatementEchoEmbedding) return visit((StatementEchoEmbedding) n);
        else if (n instanceof StatementCData) return visit((StatementCData) n);
        else if (n instanceof StatementYield) return visit((StatementYield) n);
        else if (n instanceof StatementMarkup) return visit((StatementMarkup) n);
        else if (n instanceof StatementMarkupWithDesignator) return visit((StatementMarkupWithDesignator) n);
        else if (n instanceof StatementMarkupWithExpression) return visit((StatementMarkupWithExpression) n);
        else if (n instanceof StatementMarkupWithEmbedding) return visit((StatementMarkupWithEmbedding) n);
        else if (n instanceof StatementMarkupStatement) return visit((StatementMarkupStatement) n);
        else if (n instanceof StatementMarkupStatementNoShortIf) return visit((StatementMarkupStatementNoShortIf) n);
        else if (n instanceof TypeList) return visit((TypeList) n);
        else if (n instanceof TypeRecord) return visit((TypeRecord) n);
        else if (n instanceof TypeString) return visit((TypeString) n);
        else if (n instanceof PredicateCheckType) return visit((PredicateCheckType) n);
        else if (n instanceof PredicateNegate) return visit((PredicateNegate) n);
        else if (n instanceof PredicateAnd) return visit((PredicateAnd) n);
        else if (n instanceof PredicateOr) return visit((PredicateOr) n);
        else if (n instanceof Var) return visit((Var) n);
        else if (n instanceof AssignmentList) return visit((AssignmentList) n);
        else if (n instanceof AssignmentExpression) return visit((AssignmentExpression) n);
        else if (n instanceof AssignmentStatement) return visit((AssignmentStatement) n);
        else if (n instanceof Designator) return visit((Designator) n);
        else if (n instanceof AttributeList) return visit((AttributeList) n);
        else if (n instanceof AttributeSharp) return visit((AttributeSharp) n);
        else if (n instanceof AttributeDot) return visit((AttributeDot) n);
        else if (n instanceof AttributeDollar) return visit((AttributeDollar) n);
        else if (n instanceof AttributeColon) return visit((AttributeColon) n);
        else if (n instanceof AttributeWidth) return visit((AttributeWidth) n);
        else if (n instanceof AttributeWidthHeight) return visit((AttributeWidthHeight) n);
        throw new UnsupportedOperationException("visit(" + n.getClass().toString() + ")");
    }
    public Object visit(Ast n, Object o)
    {
        if (n instanceof AstToken) return visit((AstToken) n, o);
        else if (n instanceof ModuleList) return visit((ModuleList) n, o);
        else if (n instanceof Module) return visit((Module) n, o);
        else if (n instanceof ModuleIdList) return visit((ModuleIdList) n, o);
        else if (n instanceof ModuleBlockList) return visit((ModuleBlockList) n, o);
        else if (n instanceof Site) return visit((Site) n, o);
        else if (n instanceof Import) return visit((Import) n, o);
        else if (n instanceof FunctionWithParameters) return visit((FunctionWithParameters) n, o);
        else if (n instanceof FunctionWithoutParameters) return visit((FunctionWithoutParameters) n, o);
        else if (n instanceof ParameterDeclList) return visit((ParameterDeclList) n, o);
        else if (n instanceof Name) return visit((Name) n, o);
        else if (n instanceof MappingList) return visit((MappingList) n, o);
        else if (n instanceof Mapping) return visit((Mapping) n, o);
        else if (n instanceof Markup) return visit((Markup) n, o);
        else if (n instanceof MarkupList) return visit((MarkupList) n, o);
        else if (n instanceof ArgumentList) return visit((ArgumentList) n, o);
        else if (n instanceof Argument) return visit((Argument) n, o);
        else if (n instanceof ExpressionList) return visit((ExpressionList) n, o);
        else if (n instanceof ExpressionString) return visit((ExpressionString) n, o);
        else if (n instanceof ExpressionPlus) return visit((ExpressionPlus) n, o);
        else if (n instanceof ExpressionConstant) return visit((ExpressionConstant) n, o);
        else if (n instanceof ExpressionSymbol) return visit((ExpressionSymbol) n, o);
        else if (n instanceof ExpressionCollection) return visit((ExpressionCollection) n, o);
        else if (n instanceof ExpressionPair) return visit((ExpressionPair) n, o);
        else if (n instanceof KeyValuePairList) return visit((KeyValuePairList) n, o);
        else if (n instanceof KeyValuePair) return visit((KeyValuePair) n, o);
        else if (n instanceof Embedding) return visit((Embedding) n, o);
        else if (n instanceof TextTailMidText) return visit((TextTailMidText) n, o);
        else if (n instanceof TextTailPostText) return visit((TextTailPostText) n, o);
        else if (n instanceof Embed) return visit((Embed) n, o);
        else if (n instanceof StatementIf) return visit((StatementIf) n, o);
        else if (n instanceof StatementIfElse) return visit((StatementIfElse) n, o);
        else if (n instanceof StatementIfElseNoShortIf) return visit((StatementIfElseNoShortIf) n, o);
        else if (n instanceof StatementEach) return visit((StatementEach) n, o);
        else if (n instanceof StatementEachNoShortIf) return visit((StatementEachNoShortIf) n, o);
        else if (n instanceof StatementLet) return visit((StatementLet) n, o);
        else if (n instanceof StatementBlock) return visit((StatementBlock) n, o);
        else if (n instanceof StatementList) return visit((StatementList) n, o);
        else if (n instanceof StatementComment) return visit((StatementComment) n, o);
        else if (n instanceof StatementEchoExpression) return visit((StatementEchoExpression) n, o);
        else if (n instanceof StatementEchoEmbedding) return visit((StatementEchoEmbedding) n, o);
        else if (n instanceof StatementCData) return visit((StatementCData) n, o);
        else if (n instanceof StatementYield) return visit((StatementYield) n, o);
        else if (n instanceof StatementMarkup) return visit((StatementMarkup) n, o);
        else if (n instanceof StatementMarkupWithDesignator) return visit((StatementMarkupWithDesignator) n, o);
        else if (n instanceof StatementMarkupWithExpression) return visit((StatementMarkupWithExpression) n, o);
        else if (n instanceof StatementMarkupWithEmbedding) return visit((StatementMarkupWithEmbedding) n, o);
        else if (n instanceof StatementMarkupStatement) return visit((StatementMarkupStatement) n, o);
        else if (n instanceof StatementMarkupStatementNoShortIf) return visit((StatementMarkupStatementNoShortIf) n, o);
        else if (n instanceof TypeList) return visit((TypeList) n, o);
        else if (n instanceof TypeRecord) return visit((TypeRecord) n, o);
        else if (n instanceof TypeString) return visit((TypeString) n, o);
        else if (n instanceof PredicateCheckType) return visit((PredicateCheckType) n, o);
        else if (n instanceof PredicateNegate) return visit((PredicateNegate) n, o);
        else if (n instanceof PredicateAnd) return visit((PredicateAnd) n, o);
        else if (n instanceof PredicateOr) return visit((PredicateOr) n, o);
        else if (n instanceof Var) return visit((Var) n, o);
        else if (n instanceof AssignmentList) return visit((AssignmentList) n, o);
        else if (n instanceof AssignmentExpression) return visit((AssignmentExpression) n, o);
        else if (n instanceof AssignmentStatement) return visit((AssignmentStatement) n, o);
        else if (n instanceof Designator) return visit((Designator) n, o);
        else if (n instanceof AttributeList) return visit((AttributeList) n, o);
        else if (n instanceof AttributeSharp) return visit((AttributeSharp) n, o);
        else if (n instanceof AttributeDot) return visit((AttributeDot) n, o);
        else if (n instanceof AttributeDollar) return visit((AttributeDollar) n, o);
        else if (n instanceof AttributeColon) return visit((AttributeColon) n, o);
        else if (n instanceof AttributeWidth) return visit((AttributeWidth) n, o);
        else if (n instanceof AttributeWidthHeight) return visit((AttributeWidthHeight) n, o);
        throw new UnsupportedOperationException("visit(" + n.getClass().toString() + ")");
    }
}

