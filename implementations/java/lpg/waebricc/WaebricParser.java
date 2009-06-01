package waebricc;

import waebricc.WaebricAst.*;
import lpg.runtime.*;

public class WaebricParser extends PrsStream implements RuleAction
{
    private static ParseTable prs = new WaebricParserprs();
    private DeterministicParser dtParser;

    public DeterministicParser getParser() { return dtParser; }
    private void setResult(Object object) { dtParser.setSym1(object); }
    public Object getRhsSym(int i) { return dtParser.getSym(i); }

    public int getRhsTokenIndex(int i) { return dtParser.getToken(i); }
    public IToken getRhsIToken(int i) { return super.getIToken(getRhsTokenIndex(i)); }
    
    public int getRhsFirstTokenIndex(int i) { return dtParser.getFirstToken(i); }
    public IToken getRhsFirstIToken(int i) { return super.getIToken(getRhsFirstTokenIndex(i)); }

    public int getRhsLastTokenIndex(int i) { return dtParser.getLastToken(i); }
    public IToken getRhsLastIToken(int i) { return super.getIToken(getRhsLastTokenIndex(i)); }

    public int getLeftSpan() { return dtParser.getFirstToken(); }
    public IToken getLeftIToken()  { return super.getIToken(getLeftSpan()); }

    public int getRightSpan() { return dtParser.getLastToken(); }
    public IToken getRightIToken() { return super.getIToken(getRightSpan()); }

    public int getRhsErrorTokenIndex(int i)
    {
        int index = dtParser.getToken(i);
        IToken err = super.getIToken(index);
        return (err instanceof ErrorToken ? index : 0);
    }
    public ErrorToken getRhsErrorIToken(int i)
    {
        int index = dtParser.getToken(i);
        IToken err = super.getIToken(index);
        return (ErrorToken) (err instanceof ErrorToken ? err : null);
    }

    public WaebricParser(LexStream lexStream)
    {
        super(lexStream);

        try
        {
            super.remapTerminalSymbols(orderedTerminalSymbols(), WaebricParserprs.EOFT_SYMBOL);
        }
        catch(NullExportedSymbolsException e) {
        }
        catch(NullTerminalSymbolsException e) {
        }
        catch(UnimplementedTerminalsException e)
        {
            java.util.ArrayList unimplemented_symbols = e.getSymbols();
            System.out.println("The Lexer will not scan the following token(s):");
            for (int i = 0; i < unimplemented_symbols.size(); i++)
            {
                Integer id = (Integer) unimplemented_symbols.get(i);
                System.out.println("    " + WaebricParsersym.orderedTerminalSymbols[id.intValue()]);               
            }
            System.out.println();                        
        }
        catch(UndefinedEofSymbolException e)
        {
            throw new Error(new UndefinedEofSymbolException
                                ("The Lexer does not implement the Eof symbol " +
                                 WaebricParsersym.orderedTerminalSymbols[WaebricParserprs.EOFT_SYMBOL]));
        } 
    }

    public String[] orderedTerminalSymbols() { return WaebricParsersym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return WaebricParsersym.orderedTerminalSymbols[kind]; }            
    public int getEOFTokenKind() { return WaebricParserprs.EOFT_SYMBOL; }
    public PrsStream getParseStream() { return (PrsStream) this; }

    public Ast parser()
    {
        return parser(null, 0);
    }
        
    public Ast parser(Monitor monitor)
    {
        return parser(monitor, 0);
    }
        
    public Ast parser(int error_repair_count)
    {
        return parser(null, error_repair_count);
    }
        
    public Ast parser(Monitor monitor, int error_repair_count)
    {
        try
        {
            dtParser = new DeterministicParser(monitor, (TokenStream)this, prs, (RuleAction)this);
        }
        catch (NotDeterministicParseTableException e)
        {
            throw new Error(new NotDeterministicParseTableException
                                ("Regenerate WaebricParserprs.java with -NOBACKTRACK option"));
        }
        catch (BadParseSymFileException e)
        {
            throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- WaebricParsersym.java. Regenerate WaebricParserprs.java"));
        }

        try
        {
            return (Ast) dtParser.parse();
        }
        catch (BadParseException e)
        {
            reset(e.error_token); // point to error token

            DiagnoseParser diagnoseParser = new DiagnoseParser(this, prs);
            diagnoseParser.diagnose(e.error_token);
        }

        return null;
    }


    public void ruleAction(int ruleNumber)
    {
        switch (ruleNumber)
        {
 
            //
            // Rule 1:  Modules ::= $Empty
            //
            case 1: {
                setResult(
                    new ModuleList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 2:  Modules ::= Modules Module
            //
            case 2: {
                ((ModuleList)getRhsSym(1)).add((Module)getRhsSym(2));
          break;
            } 
            //
            // Rule 3:  Module ::= module ModuleIds ModuleBlockOpt
            //
            case 3: {
                setResult(
                    new Module(getLeftIToken(), getRightIToken(),
                               (ModuleIdList)getRhsSym(2),
                               (ModuleBlockList)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 4:  ModuleIds ::= ModuleId . ModuleIds
            //
            case 4: {
                ((ModuleIdList)getRhsSym(3)).add((Name)getRhsSym(1));
                setResult(getRhsSym(3));
          break;
            } 
            //
            // Rule 5:  ModuleIds ::= ModuleId
            //
            case 5: {
                setResult(
                    new ModuleIdList((Name)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 6:  ModuleId ::= Name
            //
            case 6:
                break; 
            //
            // Rule 7:  ModuleBlockOpt ::= $Empty
            //
            case 7: {
                setResult(
                    new ModuleBlockList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 8:  ModuleBlockOpt ::= ModuleBlocks
            //
            case 8:
                break; 
            //
            // Rule 9:  ModuleBlocks ::= ModuleBlock ModuleBlocks
            //
            case 9: {
                ((ModuleBlockList)getRhsSym(2)).add((IModuleBlock)getRhsSym(1));
                setResult(getRhsSym(2));
          break;
            } 
            //
            // Rule 10:  ModuleBlocks ::= ModuleBlock
            //
            case 10: {
                setResult(
                    new ModuleBlockList((IModuleBlock)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 11:  ModuleBlock ::= Function
            //
            case 11:
                break; 
            //
            // Rule 12:  ModuleBlock ::= Site
            //
            case 12:
                break; 
            //
            // Rule 13:  ModuleBlock ::= Import
            //
            case 13:
                break; 
            //
            // Rule 14:  Site ::= site MappingsOpt end
            //
            case 14: {
                setResult(
                    new Site(getLeftIToken(), getRightIToken(),
                             (MappingList)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 15:  Import ::= import ModuleIds
            //
            case 15: {
                setResult(
                    new Import(getLeftIToken(), getRightIToken(),
                               (ModuleIdList)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 16:  Function ::= def IDENTIFIER$Name ParameterDeclOpt StatementOpt end
            //
            case 16: {
                setResult(
                    new FunctionWithParameters(getLeftIToken(), getRightIToken(),
                                               new AstToken(getRhsIToken(2)),
                                               (ParameterDeclList)getRhsSym(3),
                                               (StatementList)getRhsSym(4))
                );
          break;
            } 
            //
            // Rule 17:  Function ::= def IDENTIFIER$Name StatementOpt end
            //
            case 17: {
                setResult(
                    new FunctionWithoutParameters(getLeftIToken(), getRightIToken(),
                                                  new AstToken(getRhsIToken(2)),
                                                  (StatementList)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 18:  ParameterDeclOpt ::= ( )
            //
            case 18: {
                setResult(
                    new ParameterDeclList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 19:  ParameterDeclOpt ::= ( ParameterDecls )
            //
            case 19: {
                setResult((ParameterDeclList)getRhsSym(2));
          break;
            } 
            //
            // Rule 20:  ParameterDecls ::= ParameterDecl , ParameterDecls
            //
            case 20: {
                ((ParameterDeclList)getRhsSym(3)).add((Name)getRhsSym(1));
                setResult(getRhsSym(3));
          break;
            } 
            //
            // Rule 21:  ParameterDecls ::= ParameterDecl
            //
            case 21: {
                setResult(
                    new ParameterDeclList((Name)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 22:  ParameterDecl ::= Name
            //
            case 22:
                break; 
            //
            // Rule 23:  Name ::= IDENTIFIER$Name
            //
            case 23: {
                setResult(
                    new Name(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 24:  MappingsOpt ::= $Empty
            //
            case 24: {
                setResult(
                    new MappingList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 25:  MappingsOpt ::= Mappings
            //
            case 25:
                break; 
            //
            // Rule 26:  Mappings ::= Mapping ; Mappings
            //
            case 26: {
                ((MappingList)getRhsSym(3)).add((Mapping)getRhsSym(1));
                setResult(getRhsSym(3));
          break;
            } 
            //
            // Rule 27:  Mappings ::= Mapping
            //
            case 27: {
                setResult(
                    new MappingList((Mapping)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 28:  Mapping ::= Path$Path : Markup
            //
            case 28: {
                setResult(
                    new Mapping(getLeftIToken(), getRightIToken(),
                                new AstToken(getRhsIToken(1)),
                                (IMarkup)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 29:  Markup ::= Designator
            //
            case 29:
                break; 
            //
            // Rule 30:  Markup ::= Designator ArgumentsOpt
            //
            case 30: {
                setResult(
                    new Markup(getLeftIToken(), getRightIToken(),
                               (Designator)getRhsSym(1),
                               (ArgumentList)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 31:  MarkupOpt ::= $Empty
            //
            case 31: {
                setResult(
                    new MarkupList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 32:  MarkupOpt ::= Markups
            //
            case 32:
                break; 
            //
            // Rule 33:  Markups ::= Markups Markup
            //
            case 33: {
                ((MarkupList)getRhsSym(1)).add((IMarkup)getRhsSym(2));
          break;
            } 
            //
            // Rule 34:  Markups ::= Markup
            //
            case 34: {
                setResult(
                    new MarkupList((IMarkup)getRhsSym(1), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 35:  ArgumentsOpt ::= ( )
            //
            case 35: {
                setResult(
                    new ArgumentList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 36:  ArgumentsOpt ::= ( Arguments )
            //
            case 36: {
                setResult((ArgumentList)getRhsSym(2));
          break;
            } 
            //
            // Rule 37:  Arguments ::= Argument , Arguments
            //
            case 37: {
                ((ArgumentList)getRhsSym(3)).add((IArgument)getRhsSym(1));
                setResult(getRhsSym(3));
          break;
            } 
            //
            // Rule 38:  Arguments ::= Argument
            //
            case 38: {
                setResult(
                    new ArgumentList((IArgument)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 39:  Argument ::= Var = Expression
            //
            case 39: {
                setResult(
                    new Argument(getLeftIToken(), getRightIToken(),
                                 (Var)getRhsSym(1),
                                 (IExpression)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 40:  Argument ::= Expression
            //
            case 40:
                break; 
            //
            // Rule 41:  ExpressionOpt ::= $Empty
            //
            case 41: {
                setResult(
                    new ExpressionList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 42:  ExpressionOpt ::= Expressions
            //
            case 42:
                break; 
            //
            // Rule 43:  Expressions ::= Expression , Expressions
            //
            case 43: {
                ((ExpressionList)getRhsSym(3)).add((IExpression)getRhsSym(1));
                setResult(getRhsSym(3));
          break;
            } 
            //
            // Rule 44:  Expressions ::= Expression
            //
            case 44: {
                setResult(
                    new ExpressionList((IExpression)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 45:  Expression ::= Var
            //
            case 45:
                break; 
            //
            // Rule 46:  Expression ::= ExpressionString
            //
            case 46:
                break; 
            //
            // Rule 47:  Expression ::= ExpressionCollection
            //
            case 47:
                break; 
            //
            // Rule 48:  Expression ::= ExpressionPair
            //
            case 48:
                break; 
            //
            // Rule 49:  Expression ::= ExpressionConstant
            //
            case 49:
                break; 
            //
            // Rule 50:  Expression ::= ExpressionSymbol
            //
            case 50:
                break; 
            //
            // Rule 51:  Expression ::= ExpressionPlus
            //
            case 51:
                break; 
            //
            // Rule 52:  ExpressionNoPlus ::= Var
            //
            case 52:
                break; 
            //
            // Rule 53:  ExpressionNoPlus ::= ExpressionString
            //
            case 53:
                break; 
            //
            // Rule 54:  ExpressionNoPlus ::= ExpressionCollection
            //
            case 54:
                break; 
            //
            // Rule 55:  ExpressionNoPlus ::= ExpressionPair
            //
            case 55:
                break; 
            //
            // Rule 56:  ExpressionNoPlus ::= ExpressionConstant
            //
            case 56:
                break; 
            //
            // Rule 57:  ExpressionNoPlus ::= ExpressionSymbol
            //
            case 57:
                break; 
            //
            // Rule 58:  ExpressionString ::= StringLiteral$String
            //
            case 58: {
                setResult(
                    new ExpressionString(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 59:  ExpressionPlus ::= ExpressionNoPlus + Expression
            //
            case 59: {
                setResult(
                    new ExpressionPlus(getLeftIToken(), getRightIToken(),
                                       (IExpressionNoPlus)getRhsSym(1),
                                       (IExpression)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 60:  ExpressionConstant ::= IntegerLiteral$IntegerString
            //
            case 60: {
                setResult(
                    new ExpressionConstant(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 61:  ExpressionSymbol ::= SymbolLiteral$SymbolString
            //
            case 61: {
                setResult(
                    new ExpressionSymbol(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 62:  ExpressionCollection ::= [ ExpressionOpt ]
            //
            case 62: {
                setResult(
                    new ExpressionCollection(getLeftIToken(), getRightIToken(),
                                             (ExpressionList)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 63:  ExpressionPair ::= { KeyValuePairOpt }
            //
            case 63: {
                setResult(
                    new ExpressionPair(getLeftIToken(), getRightIToken(),
                                       (KeyValuePairList)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 64:  KeyValuePairOpt ::= $Empty
            //
            case 64: {
                setResult(
                    new KeyValuePairList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 65:  KeyValuePairOpt ::= KeyValuePairs
            //
            case 65:
                break; 
            //
            // Rule 66:  KeyValuePairs ::= KeyValuePair , KeyValuePairs
            //
            case 66: {
                ((KeyValuePairList)getRhsSym(3)).add((KeyValuePair)getRhsSym(1));
                setResult(getRhsSym(3));
          break;
            } 
            //
            // Rule 67:  KeyValuePairs ::= KeyValuePair
            //
            case 67: {
                setResult(
                    new KeyValuePairList((KeyValuePair)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 68:  KeyValuePair ::= IDENTIFIER$Key : Expression
            //
            case 68: {
                setResult(
                    new KeyValuePair(getLeftIToken(), getRightIToken(),
                                     new AstToken(getRhsIToken(1)),
                                     (IExpression)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 69:  Embedding ::= PreText$PreText Embed TextTail
            //
            case 69: {
                setResult(
                    new Embedding(getLeftIToken(), getRightIToken(),
                                  new AstToken(getRhsIToken(1)),
                                  (Embed)getRhsSym(2),
                                  (ITextTail)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 70:  TextTail ::= MidText$MidText Embed TextTail
            //
            case 70: {
                setResult(
                    new TextTailMidText(getLeftIToken(), getRightIToken(),
                                        new AstToken(getRhsIToken(1)),
                                        (Embed)getRhsSym(2),
                                        (ITextTail)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 71:  TextTail ::= PostText$PostText
            //
            case 71: {
                setResult(
                    new TextTailPostText(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 72:  Embed ::= MarkupOpt Expression
            //
            case 72: {
                setResult(
                    new Embed(getLeftIToken(), getRightIToken(),
                              (MarkupList)getRhsSym(1),
                              (IExpression)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 73:  StatementWithoutSubstatement ::= StatementBlock
            //
            case 73:
                break; 
            //
            // Rule 74:  StatementWithoutSubstatement ::= StatementCData
            //
            case 74:
                break; 
            //
            // Rule 75:  StatementWithoutSubstatement ::= StatementYield
            //
            case 75:
                break; 
            //
            // Rule 76:  StatementWithoutSubstatement ::= StatementComment
            //
            case 76:
                break; 
            //
            // Rule 77:  StatementWithoutSubstatement ::= StatementMarkup
            //
            case 77:
                break; 
            //
            // Rule 78:  StatementWithoutSubstatement ::= StatementEchoExpression
            //
            case 78:
                break; 
            //
            // Rule 79:  StatementWithoutSubstatement ::= StatementEchoEmbedding
            //
            case 79:
                break; 
            //
            // Rule 80:  StatementWithoutSubstatement ::= StatementLet
            //
            case 80:
                break; 
            //
            // Rule 81:  StatementWithoutSubAndMarkup ::= StatementBlock
            //
            case 81:
                break; 
            //
            // Rule 82:  StatementWithoutSubAndMarkup ::= StatementCData
            //
            case 82:
                break; 
            //
            // Rule 83:  StatementWithoutSubAndMarkup ::= StatementYield
            //
            case 83:
                break; 
            //
            // Rule 84:  StatementWithoutSubAndMarkup ::= StatementComment
            //
            case 84:
                break; 
            //
            // Rule 85:  StatementWithoutSubAndMarkup ::= StatementEchoExpression
            //
            case 85:
                break; 
            //
            // Rule 86:  StatementWithoutSubAndMarkup ::= StatementEchoEmbedding
            //
            case 86:
                break; 
            //
            // Rule 87:  StatementWithoutSubAndMarkup ::= StatementLet
            //
            case 87:
                break; 
            //
            // Rule 88:  Statement ::= StatementWithoutSubstatement
            //
            case 88:
                break; 
            //
            // Rule 89:  Statement ::= StatementIf
            //
            case 89:
                break; 
            //
            // Rule 90:  Statement ::= StatementIfElse
            //
            case 90:
                break; 
            //
            // Rule 91:  Statement ::= StatementEach
            //
            case 91:
                break; 
            //
            // Rule 92:  Statement ::= StatementMarkupStatement
            //
            case 92:
                break; 
            //
            // Rule 93:  StatementNoShortIf ::= StatementWithoutSubstatement
            //
            case 93:
                break; 
            //
            // Rule 94:  StatementNoShortIf ::= StatementIfElseNoShortIf
            //
            case 94:
                break; 
            //
            // Rule 95:  StatementNoShortIf ::= StatementEachNoShortIf
            //
            case 95:
                break; 
            //
            // Rule 96:  StatementNoShortIf ::= StatementMarkupStatementNoShortIf
            //
            case 96:
                break; 
            //
            // Rule 97:  StatementWithoutMarkup ::= StatementWithoutSubAndMarkup
            //
            case 97:
                break; 
            //
            // Rule 98:  StatementWithoutMarkup ::= StatementIf
            //
            case 98:
                break; 
            //
            // Rule 99:  StatementWithoutMarkup ::= StatementIfElse
            //
            case 99:
                break; 
            //
            // Rule 100:  StatementWithoutMarkup ::= StatementEach
            //
            case 100:
                break; 
            //
            // Rule 101:  StatementWithoutMarkupNoShortIf ::= StatementWithoutSubAndMarkup
            //
            case 101:
                break; 
            //
            // Rule 102:  StatementWithoutMarkupNoShortIf ::= StatementIfElseNoShortIf
            //
            case 102:
                break; 
            //
            // Rule 103:  StatementWithoutMarkupNoShortIf ::= StatementEachNoShortIf
            //
            case 103:
                break; 
            //
            // Rule 104:  StatementIf ::= if ( Predicate ) Statement
            //
            case 104: {
                setResult(
                    new StatementIf(getLeftIToken(), getRightIToken(),
                                    (IPredicate)getRhsSym(3),
                                    (IStatement)getRhsSym(5))
                );
          break;
            } 
            //
            // Rule 105:  StatementIfElse ::= if ( Predicate ) StatementNoShortIf else Statement
            //
            case 105: {
                setResult(
                    new StatementIfElse(getLeftIToken(), getRightIToken(),
                                        (IPredicate)getRhsSym(3),
                                        (IStatementNoShortIf)getRhsSym(5),
                                        (IStatement)getRhsSym(7))
                );
          break;
            } 
            //
            // Rule 106:  StatementIfElseNoShortIf ::= if ( Predicate ) StatementNoShortIf else StatementNoShortIf
            //
            case 106: {
                setResult(
                    new StatementIfElseNoShortIf(getLeftIToken(), getRightIToken(),
                                                 (IPredicate)getRhsSym(3),
                                                 (IStatementNoShortIf)getRhsSym(5),
                                                 (IStatementNoShortIf)getRhsSym(7))
                );
          break;
            } 
            //
            // Rule 107:  StatementEach ::= each ( Var : Expression ) Statement
            //
            case 107: {
                setResult(
                    new StatementEach(getLeftIToken(), getRightIToken(),
                                      (Var)getRhsSym(3),
                                      (IExpression)getRhsSym(5),
                                      (IStatement)getRhsSym(7))
                );
          break;
            } 
            //
            // Rule 108:  StatementEachNoShortIf ::= each ( Var : Expression ) StatementNoShortIf
            //
            case 108: {
                setResult(
                    new StatementEachNoShortIf(getLeftIToken(), getRightIToken(),
                                               (Var)getRhsSym(3),
                                               (IExpression)getRhsSym(5),
                                               (IStatementNoShortIf)getRhsSym(7))
                );
          break;
            } 
            //
            // Rule 109:  StatementLet ::= let Assignments in StatementOpt end
            //
            case 109: {
                setResult(
                    new StatementLet(getLeftIToken(), getRightIToken(),
                                     (AssignmentList)getRhsSym(2),
                                     (StatementList)getRhsSym(4))
                );
          break;
            } 
            //
            // Rule 110:  StatementBlock ::= { StatementOpt }
            //
            case 110: {
                setResult(
                    new StatementBlock(getLeftIToken(), getRightIToken(),
                                       (StatementList)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 111:  StatementOpt ::= $Empty
            //
            case 111: {
                setResult(
                    new StatementList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 112:  StatementOpt ::= Statements
            //
            case 112:
                break; 
            //
            // Rule 113:  Statements ::= Statements Statement
            //
            case 113: {
                ((StatementList)getRhsSym(1)).add((IStatement)getRhsSym(2));
          break;
            } 
            //
            // Rule 114:  Statements ::= Statement
            //
            case 114: {
                setResult(
                    new StatementList((IStatement)getRhsSym(1), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 115:  StatementComment ::= comment CommentLiteral$Comment ;
            //
            case 115: {
                setResult(
                    new StatementComment(getLeftIToken(), getRightIToken(),
                                         new AstToken(getRhsIToken(2)))
                );
          break;
            } 
            //
            // Rule 116:  StatementEchoExpression ::= echo Expression ;
            //
            case 116: {
                setResult(
                    new StatementEchoExpression(getLeftIToken(), getRightIToken(),
                                                (IExpression)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 117:  StatementEchoEmbedding ::= echo Embedding ;
            //
            case 117: {
                setResult(
                    new StatementEchoEmbedding(getLeftIToken(), getRightIToken(),
                                               (Embedding)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 118:  StatementCData ::= cdata Expression ;
            //
            case 118: {
                setResult(
                    new StatementCData(getLeftIToken(), getRightIToken(),
                                       (IExpression)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 119:  StatementYield ::= yield ;
            //
            case 119: {
                setResult(
                    new StatementYield(getLeftIToken(), getRightIToken())
                );
          break;
            } 
            //
            // Rule 120:  StatementMarkup ::= Markup ;
            //
            case 120: {
                setResult(
                    new StatementMarkup(getLeftIToken(), getRightIToken(),
                                        (IMarkup)getRhsSym(1))
                );
          break;
            } 
            //
            // Rule 121:  StatementMarkup ::= Markups Designator ArgumentsOpt ;
            //
            case 121: {
                setResult(
                    new StatementMarkupWithDesignator(getLeftIToken(), getRightIToken(),
                                                      (MarkupList)getRhsSym(1),
                                                      (Designator)getRhsSym(2),
                                                      (ArgumentList)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 122:  StatementMarkup ::= Markups Expression ;
            //
            case 122: {
                setResult(
                    new StatementMarkupWithExpression(getLeftIToken(), getRightIToken(),
                                                      (MarkupList)getRhsSym(1),
                                                      (IExpression)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 123:  StatementMarkup ::= Markups Embedding ;
            //
            case 123: {
                setResult(
                    new StatementMarkupWithEmbedding(getLeftIToken(), getRightIToken(),
                                                     (MarkupList)getRhsSym(1),
                                                     (Embedding)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 124:  StatementMarkupStatement ::= Markups StatementWithoutMarkup
            //
            case 124: {
                setResult(
                    new StatementMarkupStatement(getLeftIToken(), getRightIToken(),
                                                 (MarkupList)getRhsSym(1),
                                                 (IStatementWithoutMarkup)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 125:  StatementMarkupStatementNoShortIf ::= Markups StatementWithoutMarkupNoShortIf
            //
            case 125: {
                setResult(
                    new StatementMarkupStatementNoShortIf(getLeftIToken(), getRightIToken(),
                                                          (MarkupList)getRhsSym(1),
                                                          (IStatementWithoutMarkupNoShortIf)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 126:  Type ::= list
            //
            case 126: {
                setResult(
                    new TypeList(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 127:  Type ::= record
            //
            case 127: {
                setResult(
                    new TypeRecord(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 128:  Type ::= string
            //
            case 128: {
                setResult(
                    new TypeString(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 129:  Predicate ::= Expression
            //
            case 129: {
                setResult(
                    new PredicateCheckType(getLeftIToken(), getRightIToken(),
                                           (IExpression)getRhsSym(1),
                                           (IType)null)
                );
          break;
            } 
            //
            // Rule 130:  Predicate ::= Expression . Type
            //
            case 130: {
                setResult(
                    new PredicateCheckType(getLeftIToken(), getRightIToken(),
                                           (IExpression)getRhsSym(1),
                                           (IType)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 131:  Predicate ::= ! Predicate
            //
            case 131: {
                setResult(
                    new PredicateNegate(getLeftIToken(), getRightIToken(),
                                        (IPredicate)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 132:  Predicate ::= ( Predicate ) AND_AND$AndPredicate ( Predicate )
            //
            case 132: {
                setResult(
                    new PredicateAnd(getLeftIToken(), getRightIToken(),
                                     (IPredicate)getRhsSym(2),
                                     new AstToken(getRhsIToken(4)),
                                     (IPredicate)getRhsSym(6))
                );
          break;
            } 
            //
            // Rule 133:  Predicate ::= ( Predicate ) OR_OR$OrPredicate ( Predicate )
            //
            case 133: {
                setResult(
                    new PredicateOr(getLeftIToken(), getRightIToken(),
                                    (IPredicate)getRhsSym(2),
                                    new AstToken(getRhsIToken(4)),
                                    (IPredicate)getRhsSym(6))
                );
          break;
            } 
            //
            // Rule 134:  Var ::= IDENTIFIER$Name
            //
            case 134: {
                setResult(
                    new Var(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 135:  Assignments ::= Assignments Assignment
            //
            case 135: {
                ((AssignmentList)getRhsSym(1)).add((IAssignment)getRhsSym(2));
          break;
            } 
            //
            // Rule 136:  Assignments ::= Assignment
            //
            case 136: {
                setResult(
                    new AssignmentList((IAssignment)getRhsSym(1), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 137:  Assignment ::= Var = Expression ;
            //
            case 137: {
                setResult(
                    new AssignmentExpression(getLeftIToken(), getRightIToken(),
                                             (Var)getRhsSym(1),
                                             (IExpression)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 138:  Assignment ::= IDENTIFIER$Name ParameterDeclOpt = Statement
            //
            case 138: {
                setResult(
                    new AssignmentStatement(getLeftIToken(), getRightIToken(),
                                            new AstToken(getRhsIToken(1)),
                                            (ParameterDeclList)getRhsSym(2),
                                            (IStatement)getRhsSym(4))
                );
          break;
            } 
            //
            // Rule 139:  Designator ::= IDENTIFIER$Name AttributeOpt
            //
            case 139: {
                setResult(
                    new Designator(getLeftIToken(), getRightIToken(),
                                   new AstToken(getRhsIToken(1)),
                                   (AttributeList)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 140:  AttributeOpt ::= $Empty
            //
            case 140: {
                setResult(
                    new AttributeList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 141:  AttributeOpt ::= Attributes
            //
            case 141:
                break; 
            //
            // Rule 142:  Attributes ::= Attribute Attributes
            //
            case 142: {
                ((AttributeList)getRhsSym(2)).add((IAttribute)getRhsSym(1));
                setResult(getRhsSym(2));
          break;
            } 
            //
            // Rule 143:  Attributes ::= Attribute
            //
            case 143: {
                setResult(
                    new AttributeList((IAttribute)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 144:  Attribute ::= # IDENTIFIER$Name
            //
            case 144: {
                setResult(
                    new AttributeSharp(getLeftIToken(), getRightIToken(),
                                       new AstToken(getRhsIToken(2)))
                );
          break;
            } 
            //
            // Rule 145:  Attribute ::= . IDENTIFIER$Name
            //
            case 145: {
                setResult(
                    new AttributeDot(getLeftIToken(), getRightIToken(),
                                     new AstToken(getRhsIToken(2)))
                );
          break;
            } 
            //
            // Rule 146:  Attribute ::= $ IDENTIFIER$Name
            //
            case 146: {
                setResult(
                    new AttributeDollar(getLeftIToken(), getRightIToken(),
                                        new AstToken(getRhsIToken(2)))
                );
          break;
            } 
            //
            // Rule 147:  Attribute ::= : IDENTIFIER$Name
            //
            case 147: {
                setResult(
                    new AttributeColon(getLeftIToken(), getRightIToken(),
                                       new AstToken(getRhsIToken(2)))
                );
          break;
            } 
            //
            // Rule 148:  Attribute ::= @ IntegerLiteral$Width
            //
            case 148: {
                setResult(
                    new AttributeWidth(getLeftIToken(), getRightIToken(),
                                       new AstToken(getRhsIToken(2)))
                );
          break;
            } 
            //
            // Rule 149:  Attribute ::= @ IntegerLiteral$Width % IntegerLiteral$Height
            //
            case 149: {
                setResult(
                    new AttributeWidthHeight(getLeftIToken(), getRightIToken(),
                                             new AstToken(getRhsIToken(2)),
                                             new AstToken(getRhsIToken(4)))
                );
          break;
            }
    
            default:
                break;
        }
        return;
    }
}

