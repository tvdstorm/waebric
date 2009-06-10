/*
 * File			: ConversionUtil.java
 * Project		: WaebrickParser2
 * 				: Waebrick Parser, practicum opdracht Software Construction
 * 
 * Author		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * Description	:
 * 
 * 
 * Change history
 * -----------------------------------------------------------
 * Date			Change				 
 * -----------------------------------------------------------
 * 07-05-2009	Initial version.
 * 
 * 
 */
package com.uva.se.wparse.util;

import java.util.ArrayList;
import java.util.List;

import com.uva.se.wparse.model.expression.Expression;
import com.uva.se.wparse.model.expression.ExpressionDotIdentifier;
import com.uva.se.wparse.model.expression.Identifier;
import com.uva.se.wparse.model.expression.NaturalConstant;
import com.uva.se.wparse.model.expression.SymbolConstant;
import com.uva.se.wparse.model.expression.Var;
import com.uva.se.wparse.model.markup.Attribute;
import com.uva.se.wparse.model.markup.Designator;
import com.uva.se.wparse.model.markup.SingleAttribute;
import com.uva.se.wparse.parser.Operator;

public class ConversionUtil {

	
	public static Expression designatorToExpression(Designator designator){
		
		
		if(designator.getAttributes().size() > 0 ){
			Attribute attr = designator.getAttributes().get(0);
			if(attr instanceof SingleAttribute){
				SingleAttribute singleAttr = (SingleAttribute)attr;
				if(singleAttr.getSymbol().equals(Operator.DOT)){
					//found a single attr with a dot. this must be a DotExpression
					//convert single attr to dotexpr
					Identifier identifier = new Identifier( singleAttr.getIdentifier(), "");
					Expression newExpr = null;
					if( singleAttr.getIdentifier().startsWith("'")){
						//symbol
						List<String> partList = new ArrayList<String>();
						partList.add(designator.getIdentifier());
						newExpr = new SymbolConstant(partList);
					}else if( isNatural(designator.getIdentifier())){
						//natural
						newExpr = new NaturalConstant(designator.getIdentifier());
					}else{
						//identifier
						newExpr = new Var(designator.getIdentifier(), "");
					}
					
					return new ExpressionDotIdentifier(newExpr, Operator.DOT, identifier);
					//this.expr = exprDotIdent;
					
				}
			}
		}
		
		//return default Var
		return new Var(designator.getIdentifier(), "");
	}
	
	
	private static boolean isNatural(String value){
		try{
			Integer.parseInt(value);
		}catch(Exception ex){
		    return false;	
		}
		return true;
	}
	
}
