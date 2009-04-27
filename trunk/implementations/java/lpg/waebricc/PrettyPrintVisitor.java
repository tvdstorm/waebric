/*
 * Created on Aug 13, 2005
 *
 */
package waebricc;

import java.util.ArrayList;
import java.util.Iterator;

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
    
    private void visitChilds(ArrayList<Ast> children)
    {
    	Iterator<Ast> it = null;
    	it = children.iterator();
    	while(it.hasNext())
    	{
    		it.next().accept(this);
    	}
    	
    }
    
    
    public void visit(AstToken n) 
    {
    	/* do nothing */
    }

    public void visit(Module n) 
    {
    	indent++;
    	prettyPrint("module ");
    	
    	visitChilds(n.getChildren());
//    	n.getModuleIds().accept(this);
//    	n.getChildren().
//    	n.getModuleBlockOpt().accept(this);
    	indent--;
    	
    }

//    public void visit(ModuleBlockList n) { unimplementedVisitor("visit(ModuleBlockList)"); n.accept(this); }

    public void visit(Function n) 
    { 
    	indent++;
    	prettyPrint("function " + n.getName());
    	n.getParameterDeclOpt().accept(this);
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
    	visitChilds(n.getChildren());
    	indent--;
    }
    
    public void visit(Mapping n) 
    { 
    	indent++;
    	prettyPrint("mapping");
    	visitChilds(n.getChildren());
    	indent--;
    }
    
    public void visit(Path n)
    { 
    	indent++;
    	prettyPrint("path ");
    	visitChilds(n.getChildren());
    	indent--;
    }
    
    public void visit(FileName n) 
    { 
    	indent++;
    	prettyPrint("filename " + n.getName() + "." + n.getExtension());
    	indent--;
    }
    
    public void visit(DirName n)
    { 
    	indent++;
    	prettyPrint("dirname " + n.getName());
    	indent--;
    }
    
    public void visit(Markup n)
    { 
    	indent++;
    	prettyPrint("markup ");
    	visitChilds(n.getChildren());
    	indent--;
    }
    
    public void visit(Designator n)
    { 
    	indent++;
    	prettyPrint("designator " + n.getName());
    	visitChilds(n.getChildren());
    	indent--;
    }   
    
    public void visit(ExpressionString n)
    { 
    	indent++;
    	prettyPrint("expressionstring " + n.getString());
    	indent--;
    }   
       
    public void visit(ExpressionPair n)
    { 
    	indent++;
    	prettyPrint("expressionpair");
    	visitChilds(n.getChildren());
    	indent--;
    }  
    
    public void visit(KeyValuePair n)
    { 
    	indent++;
    	prettyPrint("keyvaluepair " + n.getKey());
    	visitChilds(n.getChildren());
    	indent--;
    } 
    
    public void visit(ExpressionConstant n)
    { 
    	indent++;
    	prettyPrint("expressionconstant " + n.getIntegerString());
    	indent--;
    } 
    
    
}
