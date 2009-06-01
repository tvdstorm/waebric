/*
 * Created on Aug 13, 2005
 *
 */
package waebricc;

import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.sampled.Control.Type;

import lpg.runtime.*;
import waebricc.WaebricAst.*;

/**
 * @author Gerry Fisher
 *
 */
public class PrettyPrintVisitor extends AbstractVisitor
{
	
	private PrsStream prsStream;
	
	private int indent;
	
    public void unimplementedVisitor(String s) {
        System.out.println(s);
    }
    
    public PrettyPrintVisitor(PrsStream prsStream)
    {
    	this.prsStream = prsStream;
    	indent = 0;
    }
    
    private void prettyPrint( String s)
    {
    	System.out.println();
    	for(int i = 0; i < indent; i++)
    	{
    		System.out.print("  ");
    	}
    	System.out.print(s);
    }
    
    
    public void visit(AstToken n) 
    {
    	/* do nothing */
    }
    
    

    public void visit(Module n) 
    {
    	indent++;
    	prettyPrint("module ");
    	n.getModuleIds().accept(this);
    	n.getModuleBlockOpt().accept(this);
    	indent--;
    	
    }

//    public void visit(ModuleBlockList n) { unimplementedVisitor("visit(ModuleBlockList)"); n.accept(this); }
    
    
    
    public void visit(Argument n) 
    { 
    	indent++;
    	prettyPrint("Argument");
    	n.getVar().accept(this);
    	n.getExpression().accept(this);
    	indent--;
	}
    
    public void visit(AssignmentExpression n) 
    { 
    	indent++;
    	prettyPrint("Assignment");
    	n.getVar().accept(this);
    	n.getExpression().accept(this);
    	indent--;
	}
    
    public void visit(AssignmentStatement n) 
    { 
    	indent++;
    	prettyPrint("Assignment" + n.getName());
    	n.getStatement().accept(this);
    	indent--;
	}
    
    public void visit(AttributeSharp n) 
    { 
    	indent++;
    	prettyPrint("Attribute " + n.getName());
    	indent--;
	}
    
    public void visit(AttributeDot n) 
    { 
    	indent++;
    	prettyPrint("Attribute " + n.getName());
    	indent--;
	}
    
    public void visit(AttributeDollar n) 
    { 
    	indent++;
    	prettyPrint("Attribute " + n.getName());
    	indent--;
	}
    
    public void visit(AttributeColon n) 
    { 
    	indent++;
    	prettyPrint("Attribute " + n.getName());
    	indent--;
	}
    
    public void visit(AttributeWidth n) 
    { 
    	indent++;
    	prettyPrint("Attribute w:" + n.getWidth());
    	indent--;
	}
    
    public void visit(AttributeWidthHeight n) 
    { 
    	indent++;
    	prettyPrint("Attribute wh:" + n.getWidth() + " w:" + n.getHeight());
    	indent--;
	}
    
    
    
    public void visit(Embedding n) 
    { 
    	indent++;
    	prettyPrint("Embedding " + n.getPreText());
    	n.getEmbed().accept(this);
    	n.getTextTail().accept(this);
    	indent--;
	}
    
    public void visit(Embed n) 
    { 
    	indent++;
    	prettyPrint("Embed");
    	n.getMarkupOpt().accept(this);
    	n.getExpression().accept(this);
    	indent--;
	}
    
    public void visit(ExpressionSymbol n) 
    { 
    	indent++;
    	prettyPrint("ExpressionSymbol " + n.getSymbolString());
    	indent--;
	}
    
    
    
    
    public void visit(FunctionWithParameters n) 
    { 
    	indent++;
    	prettyPrint("function " + n.getName());
    	n.getParameterDeclOpt().accept(this);
    	n.getStatementOpt().accept(this);
    	indent--;
	}
    
    public void visit(FunctionWithoutParameters n) 
    { 
    	indent++;
    	prettyPrint("function1 " + n.getName());
    	n.getStatementOpt().accept(this);
    	indent--;
	}
    
    public void visit(Import n) 
    { 
    	indent++;
    	prettyPrint("import");
    	n.getModuleIds().accept(this);
    	indent--;
	}
    
    
    
    public void visit(Name n) 
    { 
    	indent++;
    	prettyPrint("name " + n.getName());
    	indent--;
	}
    
    public void visit(Site n) 
    { 
    	indent++;
    	prettyPrint("site");
    	n.getMappingsOpt().accept(this);
    	indent--;
    }
    
    public void visit(Mapping n) 
    { 
    	indent++;
    	prettyPrint("mapping " + n.getPath());
    	n.getMarkup().accept(this);
    	indent--;
    }
    
    public void visit(Markup n)
    { 
    	indent++;
    	prettyPrint("markup ");
    	n.getDesignator().accept(this);
    	n.getArgumentsOpt().accept(this);
    	indent--;
    }
    
    public void visit(Designator n)
    { 
    	indent++;
    	prettyPrint("Designator " + n.getName());
    	n.getAttributeOpt().accept(this);
    	indent--;
    }   
    
    public void visit(ExpressionString n)
    { 
    	indent++;
    	prettyPrint(n.getString().toString());
    	indent--;
    }   
       
    public void visit(ExpressionPair n)
    { 
    	indent++;
    	prettyPrint("ExpressionPair");
    	n.getKeyValuePairOpt().accept(this);
    	indent--;
    }  
    
    public void visit(KeyValuePair n)
    { 
    	indent++;
    	prettyPrint("keyvaluepair " + n.getKey());
    	n.getExpression().accept(this);
    	indent--;
    } 
    
//    public void visit(StatementList n)
//    {
//    	indent++;
//    	n.get
//    	//prettyPrint("StatementBlock " + n.getn);
//    	visitChilds(n.getChildren());
//    	indent--;
//    }
    
    public void visit(StatementYield n) 
    {
    	indent++;
    	prettyPrint("Yield statement");
    	indent--;
    }

    public void visit(StatementBlock n)
    {
    	indent++;
    	prettyPrint("{");
    	n.getStatementOpt().accept(this);
    	prettyPrint("}");
    	indent--;
    }
    
    public void visit(StatementCData n)
    {
    	indent++;
    	prettyPrint("CData statement");
    	n.getExpression().accept(this);
    	indent--;
    }
    
    public void visit(StatementEchoExpression n) 
    {
    	indent++;
    	prettyPrint("Statement echo");
    	n.getExpression().accept(this);
    	indent--;
    }
   
    public void visit(StatementIf n)
    {
    	indent++;
    	prettyPrint("If statement ");
    	n.getPredicate().accept(this);
    	n.getStatement().accept(this);	
    	indent--;
    }
    
    public void visit(StatementIfElse n) 
    {
    	indent++;
    	prettyPrint("IfElse statement");
    	n.getPredicate().accept(this);
    	n.getStatement().accept(this);
    	n.getStatementNoShortIf().accept(this);
    	indent--;
    }
    
    public void visit(StatementLet n)
    {
    	indent++;
    	prettyPrint("Let statement ");
    	n.getAssignments().accept(this);
    	n.getStatementOpt().accept(this);
    	indent--;
    }
    
    public void visit(StatementMarkup n)
    {
    	indent++;
    	prettyPrint("StatementMarkup0 ");
    	n.getMarkup().accept(this);
    	indent--;
    
    }   
    
    public void visit(StatementMarkupWithDesignator n)
    {
    	indent++;
    	prettyPrint("StatementMarkup2 ");
    	n.getDesignator().accept(this);
    	n.getArgumentsOpt().accept(this);
    	indent--;
    
    }  
    
    public void visit(StatementMarkupWithExpression n)
    {
    	indent++;
    	prettyPrint("StatementMarkup2 ");
    	n.getMarkups().accept(this);
    	n.getExpression().accept(this);
    	indent--;
    }
    
    public void visit(StatementMarkupWithEmbedding n)
    {
    	indent++;
    	prettyPrint("StatementMarkup3 ");
    	n.getMarkups().accept(this);
    	n.getEmbedding().accept(this);
    	indent--;
    } 
      
    
    public void visit(StatementComment n)
    {
    	indent++;
    	prettyPrint(n.getComment().toString());
    	indent--;
    
    }
    
    public void visit(StatementMarkupStatement n)
    {
    	indent++;
    	prettyPrint("StatementMarkupStatement ");
    	n.getMarkups().accept(this);
    	n.getStatementWithoutMarkup().accept(this);
    	indent--;
    }
    
    
    public void visit(PredicateCheckType n)
    {
    	indent++;
    	prettyPrint("Predicate ");
    	n.getExpression().accept(this);
    	n.getType().accept(this);
    	indent--;
    }

    public void visit(PredicateNegate n)
    {
    	indent++;
    	prettyPrint("Negate ");
    	n.getPredicate().accept(this);
    	indent--;
    }
    
    public void visit(TextTailMidText n)
    {
    	indent++;
    	prettyPrint("TextTail " + n.getMidText() + n.getTextTail());
    	n.getEmbed().accept(this);
    	indent--;
    }
    
    public void visit(TextTailPostText n)
    {
    	indent++;
    	prettyPrint("TextTail " + n.getPostText());
    	indent--;
    }
    
    public void visit(TypeList n)
    {
    	indent++;
    	prettyPrint("Type list " );
    	indent--;
    }

    public void visit(TypeRecord n)
    {
    	indent++;
    	prettyPrint("Type record " );
    	indent--;
    }

    public void visit(TypeString n)
    {
    	indent++;
    	prettyPrint("Type string " );
    	indent--;
    }
    
    public void visit(Var n)
    {
    	indent++;
    	prettyPrint("Var " + n.getName() );
    	indent--;
    }
    

    public void visit(ExpressionConstant n)
    { 
    	indent++;
    	prettyPrint("expressionconstant " + n.getIntegerString());
    	indent--;
    } 
    
    
}
