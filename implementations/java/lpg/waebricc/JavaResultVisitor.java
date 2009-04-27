/*
 * Created on Aug 13, 2005
 *
 */
package waebricc;

import waebricc.WaebricAst.*;

/**
 * @author Gerry Fisher
 *
 */
public class JavaResultVisitor extends AbstractVisitor
{
    public void unimplementedVisitor(String s) {
        System.out.println(s);
    }

    public void visit(AstToken n) 
    { 
    	System.out.print(n.getIToken().toString());
    }



    
}
