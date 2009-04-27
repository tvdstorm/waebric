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
            // Rule 1:  Module ::= module ModuleIds ModuleBlockOpt
            //
            case 1: {
                setResult(
                    new Module(getLeftIToken(), getRightIToken(),
                               (ModuleIdList)getRhsSym(2),
                               (ModuleBlockList)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 2:  ModuleIds ::= ModuleId . ModuleIds
            //
            case 2: {
                ((ModuleIdList)getRhsSym(3)).add((Name)getRhsSym(1));
                setResult(getRhsSym(3));
          break;
            } 
            //
            // Rule 3:  ModuleIds ::= ModuleId
            //
            case 3: {
                setResult(
                    new ModuleIdList((Name)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 4:  ModuleId ::= Name
            //
            case 4:
                break; 
            //
            // Rule 5:  ModuleBlockOpt ::= $Empty
            //
            case 5: {
                setResult(
                    new ModuleBlockList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 6:  ModuleBlockOpt ::= ModuleBlocks
            //
            case 6:
                break; 
            //
            // Rule 7:  ModuleBlocks ::= ModuleBlock ModuleBlocks
            //
            case 7: {
                ((ModuleBlockList)getRhsSym(2)).add((IModuleBlock)getRhsSym(1));
                setResult(getRhsSym(2));
          break;
            } 
            //
            // Rule 8:  ModuleBlocks ::= ModuleBlock
            //
            case 8: {
                setResult(
                    new ModuleBlockList((IModuleBlock)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 9:  ModuleBlock ::= Function
            //
            case 9:
                break; 
            //
            // Rule 10:  ModuleBlock ::= Site
            //
            case 10:
                break; 
            //
            // Rule 11:  Site ::= site MappingsOpt end
            //
            case 11: {
                setResult(
                    new Site(getLeftIToken(), getRightIToken(),
                             (MappingList)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 12:  MappingsOpt ::= $Empty
            //
            case 12: {
                setResult(
                    new MappingList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 13:  MappingsOpt ::= Mappings
            //
            case 13:
                break; 
            //
            // Rule 14:  Mappings ::= Mapping ; Mappings
            //
            case 14: {
                ((MappingList)getRhsSym(3)).add((Mapping)getRhsSym(1));
                setResult(getRhsSym(3));
          break;
            } 
            //
            // Rule 15:  Mappings ::= Mapping ;
            //
            case 15: {
                setResult(
                    new MappingList((Mapping)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 16:  Mapping ::= Path : Markup
            //
            case 16: {
                setResult(
                    new Mapping(getLeftIToken(), getRightIToken(),
                                (IPath)getRhsSym(1),
                                (Markup)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 17:  Path ::= DirNames FileName
            //
            case 17: {
                setResult(
                    new Path(getLeftIToken(), getRightIToken(),
                             (DirNameList)getRhsSym(1),
                             (FileName)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 18:  Path ::= FileName
            //
            case 18:
                break; 
            //
            // Rule 19:  FileName ::= IDENTIFIER$Name . IDENTIFIER$Extension
            //
            case 19: {
                setResult(
                    new FileName(getLeftIToken(), getRightIToken(),
                                 new AstToken(getRhsIToken(1)),
                                 new AstToken(getRhsIToken(3)))
                );
          break;
            } 
            //
            // Rule 20:  DirNames ::= DirName DirNames
            //
            case 20: {
                ((DirNameList)getRhsSym(2)).add((DirName)getRhsSym(1));
                setResult(getRhsSym(2));
          break;
            } 
            //
            // Rule 21:  DirNames ::= DirName
            //
            case 21: {
                setResult(
                    new DirNameList((DirName)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 22:  DirName ::= IDENTIFIER$Name /
            //
            case 22: {
                setResult(
                    new DirName(getLeftIToken(), getRightIToken(),
                                new AstToken(getRhsIToken(1)))
                );
          break;
            } 
            //
            // Rule 23:  Markup ::= Designator ArgumentsOpt
            //
            case 23: {
                setResult(
                    new Markup(getLeftIToken(), getRightIToken(),
                               (Designator)getRhsSym(1),
                               (ArgumentList)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 24:  MarkupOpt ::= $Empty
            //
            case 24: {
                setResult(
                    new MarkupList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 25:  MarkupOpt ::= Markups
            //
            case 25:
                break; 
            //
            // Rule 26:  Markups ::= Markup Markups
            //
            case 26: {
                ((MarkupList)getRhsSym(2)).add((Markup)getRhsSym(1));
                setResult(getRhsSym(2));
          break;
            } 
            //
            // Rule 27:  Markups ::= Markup
            //
            case 27: {
                setResult(
                    new MarkupList((Markup)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 28:  ArgumentsOpt ::= ( )
            //
            case 28: {
                setResult(
                    new ArgumentList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 29:  ArgumentsOpt ::= ( Arguments )
            //
            case 29: {
                setResult((ArgumentList)getRhsSym(2));
          break;
            } 
            //
            // Rule 30:  Arguments ::= Argument , Arguments
            //
            case 30: {
                ((ArgumentList)getRhsSym(3)).add((IArgument)getRhsSym(1));
                setResult(getRhsSym(3));
          break;
            } 
            //
            // Rule 31:  Arguments ::= Argument
            //
            case 31: {
                setResult(
                    new ArgumentList((IArgument)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 32:  Argument ::= Var = Expression
            //
            case 32: {
                setResult(
                    new Argument(getLeftIToken(), getRightIToken(),
                                 (Var)getRhsSym(1),
                                 (IExpression)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 33:  Argument ::= Expression
            //
            case 33:
                break; 
            //
            // Rule 34:  ExpressionOpt ::= $Empty
            //
            case 34: {
                setResult(
                    new ExpressionList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 35:  ExpressionOpt ::= Expressions
            //
            case 35:
                break; 
            //
            // Rule 36:  Expressions ::= Expression , Expressions
            //
            case 36: {
                ((ExpressionList)getRhsSym(3)).add((IExpression)getRhsSym(1));
                setResult(getRhsSym(3));
          break;
            } 
            //
            // Rule 37:  Expressions ::= Expression
            //
            case 37: {
                setResult(
                    new ExpressionList((IExpression)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 38:  Expression ::= Var
            //
            case 38:
                break; 
            //
            // Rule 39:  Expression ::= ExpressionString
            //
            case 39:
                break; 
            //
            // Rule 40:  Expression ::= ExpressionMember
            //
            case 40:
                break; 
            //
            // Rule 41:  Expression ::= ExpressionCollection
            //
            case 41:
                break; 
            //
            // Rule 42:  Expression ::= ExpressionPair
            //
            case 42:
                break; 
            //
            // Rule 43:  Expression ::= ExpressionConstant
            //
            case 43:
                break; 
            //
            // Rule 44:  ExpressionString ::= StringLiteral$String
            //
            case 44: {
                setResult(
                    new ExpressionString(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 45:  ExpressionConstant ::= IntegerLiteral$IntegerString
            //
            case 45: {
                setResult(
                    new ExpressionConstant(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 46:  ExpressionMember ::= Expression . IDENTIFIER$Member
            //
            case 46: {
                setResult(
                    new ExpressionMember(getLeftIToken(), getRightIToken(),
                                         (IExpression)getRhsSym(1),
                                         new AstToken(getRhsIToken(3)))
                );
          break;
            } 
            //
            // Rule 47:  ExpressionCollection ::= [ ExpressionOpt ]
            //
            case 47: {
                setResult(
                    new ExpressionCollection(getLeftIToken(), getRightIToken(),
                                             (ExpressionList)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 48:  ExpressionPair ::= { KeyValuePairOpt }
            //
            case 48: {
                setResult(
                    new ExpressionPair(getLeftIToken(), getRightIToken(),
                                       (KeyValuePairList)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 49:  KeyValuePairOpt ::= $Empty
            //
            case 49: {
                setResult(
                    new KeyValuePairList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 50:  KeyValuePairOpt ::= KeyValuePairs
            //
            case 50:
                break; 
            //
            // Rule 51:  KeyValuePairs ::= KeyValuePair , KeyValuePairs
            //
            case 51: {
                ((KeyValuePairList)getRhsSym(3)).add((KeyValuePair)getRhsSym(1));
                setResult(getRhsSym(3));
          break;
            } 
            //
            // Rule 52:  KeyValuePairs ::= KeyValuePair
            //
            case 52: {
                setResult(
                    new KeyValuePairList((KeyValuePair)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 53:  KeyValuePair ::= IDENTIFIER$Key : Expression
            //
            case 53: {
                setResult(
                    new KeyValuePair(getLeftIToken(), getRightIToken(),
                                     new AstToken(getRhsIToken(1)),
                                     (IExpression)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 54:  Embedding ::= PreText Embed TextTail
            //
            case 54: {
                setResult(
                    new Embedding(getLeftIToken(), getRightIToken(),
                                  (Embed)getRhsSym(2),
                                  (ITextTail)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 55:  TextTail ::= MidText Embed TextTail
            //
            case 55: {
                setResult(
                    new TextTail0(getLeftIToken(), getRightIToken(),
                                  (Embed)getRhsSym(2),
                                  (ITextTail)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 56:  TextTail ::= PostText
            //
            case 56: {
                setResult(
                    new TextTail1(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 57:  Embed ::= MarkupOpt Expression
            //
            case 57: {
                setResult(
                    new Embed(getLeftIToken(), getRightIToken(),
                              (MarkupList)getRhsSym(1),
                              (IExpression)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 58:  Statement ::= StatementEach
            //
            case 58:
                break; 
            //
            // Rule 59:  Statement ::= StatementLet
            //
            case 59:
                break; 
            //
            // Rule 60:  Statement ::= StatementComment
            //
            case 60:
                break; 
            //
            // Rule 61:  Statement ::= StatementBlock
            //
            case 61:
                break; 
            //
            // Rule 62:  Statement ::= StatementEchoExpression
            //
            case 62:
                break; 
            //
            // Rule 63:  Statement ::= StatementEchoEmbedding
            //
            case 63:
                break; 
            //
            // Rule 64:  Statement ::= StatementCData
            //
            case 64:
                break; 
            //
            // Rule 65:  Statement ::= StatementYield
            //
            case 65:
                break; 
            //
            // Rule 66:  StatementEach ::= each ( Var : Expression ) Statement
            //
            case 66: {
                setResult(
                    new StatementEach(getLeftIToken(), getRightIToken(),
                                      (Var)getRhsSym(3),
                                      (IExpression)getRhsSym(5),
                                      (IStatement)getRhsSym(7))
                );
          break;
            } 
            //
            // Rule 67:  StatementLet ::= let Assignments in StatementOpt end
            //
            case 67: {
                setResult(
                    new StatementLet(getLeftIToken(), getRightIToken(),
                                     (AssignmentList)getRhsSym(2),
                                     (StatementList)getRhsSym(4))
                );
          break;
            } 
            //
            // Rule 68:  StatementBlock ::= { Var }
            //
            case 68: {
                setResult(
                    new StatementBlock(getLeftIToken(), getRightIToken(),
                                       (Var)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 69:  StatementOpt ::= $Empty
            //
            case 69: {
                setResult(
                    new StatementList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 70:  StatementOpt ::= Statements
            //
            case 70:
                break; 
            //
            // Rule 71:  Statements ::= Statement Statements
            //
            case 71: {
                ((StatementList)getRhsSym(2)).add((IStatement)getRhsSym(1));
                setResult(getRhsSym(2));
          break;
            } 
            //
            // Rule 72:  Statements ::= Statement
            //
            case 72: {
                setResult(
                    new StatementList((IStatement)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 73:  StatementComment ::= comment StringLiteral ;
            //
            case 73: {
                setResult(
                    new StatementComment(getLeftIToken(), getRightIToken())
                );
          break;
            } 
            //
            // Rule 74:  StatementEchoExpression ::= echo Expression ;
            //
            case 74: {
                setResult(
                    new StatementEchoExpression(getLeftIToken(), getRightIToken(),
                                                (IExpression)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 75:  StatementEchoEmbedding ::= echo Embedding ;
            //
            case 75: {
                setResult(
                    new StatementEchoEmbedding(getLeftIToken(), getRightIToken(),
                                               (Embedding)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 76:  StatementCData ::= cdata Expression ;
            //
            case 76: {
                setResult(
                    new StatementCData(getLeftIToken(), getRightIToken(),
                                       (IExpression)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 77:  StatementYield ::= yield ;
            //
            case 77: {
                setResult(
                    new StatementYield(getLeftIToken(), getRightIToken())
                );
          break;
            } 
            //
            // Rule 78:  Var ::= IDENTIFIER$Name
            //
            case 78: {
                setResult(
                    new Var(getRhsIToken(1))
                );
          break;
            } 
            //
            // Rule 79:  Assignments ::= Assignment Assignments
            //
            case 79: {
                ((AssignmentList)getRhsSym(2)).add((Assignment)getRhsSym(1));
                setResult(getRhsSym(2));
          break;
            } 
            //
            // Rule 80:  Assignments ::= Assignment
            //
            case 80: {
                setResult(
                    new AssignmentList((Assignment)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 81:  Assignment ::= Var = Expression ;
            //
            case 81: {
                setResult(
                    new Assignment(getLeftIToken(), getRightIToken(),
                                   (Var)getRhsSym(1),
                                   (IExpression)getRhsSym(3))
                );
          break;
            } 
            //
            // Rule 82:  Designator ::= IDENTIFIER$Name AttributeOpt
            //
            case 82: {
                setResult(
                    new Designator(getLeftIToken(), getRightIToken(),
                                   new AstToken(getRhsIToken(1)),
                                   (AttributeList)getRhsSym(2))
                );
          break;
            } 
            //
            // Rule 83:  AttributeOpt ::= $Empty
            //
            case 83: {
                setResult(
                    new AttributeList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 84:  AttributeOpt ::= Attributes
            //
            case 84:
                break; 
            //
            // Rule 85:  Attributes ::= Attribute Attributes
            //
            case 85: {
                ((AttributeList)getRhsSym(2)).add((IAttribute)getRhsSym(1));
                setResult(getRhsSym(2));
          break;
            } 
            //
            // Rule 86:  Attributes ::= Attribute
            //
            case 86: {
                setResult(
                    new AttributeList((IAttribute)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 87:  Attribute ::= # IDENTIFIER$Name
            //
            case 87: {
                setResult(
                    new Attribute0(getLeftIToken(), getRightIToken(),
                                   new AstToken(getRhsIToken(2)))
                );
          break;
            } 
            //
            // Rule 88:  Attribute ::= . IDENTIFIER$Name
            //
            case 88: {
                setResult(
                    new Attribute1(getLeftIToken(), getRightIToken(),
                                   new AstToken(getRhsIToken(2)))
                );
          break;
            } 
            //
            // Rule 89:  Attribute ::= : IDENTIFIER$Name
            //
            case 89: {
                setResult(
                    new Attribute2(getLeftIToken(), getRightIToken(),
                                   new AstToken(getRhsIToken(2)))
                );
          break;
            } 
            //
            // Rule 90:  Function ::= def IDENTIFIER$Name ( ParameterDeclOpt ) Var end
            //
            case 90: {
                setResult(
                    new Function(getLeftIToken(), getRightIToken(),
                                 new AstToken(getRhsIToken(2)),
                                 (ParameterDeclList)getRhsSym(4),
                                 (Var)getRhsSym(6))
                );
          break;
            } 
            //
            // Rule 91:  ParameterDeclOpt ::= $Empty
            //
            case 91: {
                setResult(
                    new ParameterDeclList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
          break;
            } 
            //
            // Rule 92:  ParameterDeclOpt ::= ParameterDecls
            //
            case 92:
                break; 
            //
            // Rule 93:  ParameterDecls ::= ParameterDecl , ParameterDecls
            //
            case 93: {
                ((ParameterDeclList)getRhsSym(3)).add((Name)getRhsSym(1));
                setResult(getRhsSym(3));
          break;
            } 
            //
            // Rule 94:  ParameterDecls ::= ParameterDecl
            //
            case 94: {
                setResult(
                    new ParameterDeclList((Name)getRhsSym(1), false /* not left recursive */)
                );
          break;
            } 
            //
            // Rule 95:  ParameterDecl ::= Name
            //
            case 95:
                break; 
            //
            // Rule 96:  Name ::= IDENTIFIER$Name
            //
            case 96: {
                setResult(
                    new Name(getRhsIToken(1))
                );
          break;
            }
    
            default:
                break;
        }
        return;
    }
}

