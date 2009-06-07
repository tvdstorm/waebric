/*
 * File			: SingleAttribute.java
 * Project		: WaebrickParser
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
package com.uva.se.wparse.model.markup;

import org.apache.log4j.Logger;
import org.codehaus.jparsec.Token;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.parser.Operator;

public class SingleAttribute extends WaebricParseTreeNode implements Attribute  {
	
	public static final String OUTPUT_ATRIBUTE_ID 		= "id";
	public static final String OUTPUT_ATRIBUTE_CLASS 	= "class";
	public static final String OUTPUT_ATRIBUTE_NAME		= "name";
	public static final String OUTPUT_ATRIBUTE_TYPE 	= "type";
	public static final String OUTPUT_ATRIBUTE_HEIGHT 	= "height";
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(SingleAttribute.class);

	private Operator symbol;
	private String identifier;
	
	public SingleAttribute(Token symbolToken, String identifier) {
		this.symbol = getSymbol(symbolToken.toString());
		this.identifier = identifier;
		 if (logger.isDebugEnabled()) {
				logger.debug("Creating " + this.getClass().getSimpleName()
						+ " with values : " + toString());
			}
	}
	
	
	public Operator getSymbol() {
		return symbol;
	}


	public String getIdentifier() {
		return identifier;
	}


	public Operator getSymbol(String symbol) {
		if(Operator.POUND.toString().equals(symbol)){
			return Operator.POUND;
		}else if(Operator.DOT.toString().equals(symbol)){
			return Operator.DOT;
		}if(Operator.DOLLAR.toString().equals(symbol)){
			return Operator.DOLLAR;
		}if(Operator.COLON.toString().equals(symbol)){
			return Operator.COLON;
		}

		//default, return null
		return null;
	}

	@Override
	public String toString() {
		return symbol + identifier;
	}
	
	@Override
	public String toTransformerOutput() {		
		String Result = outputQuote( identifier );
		
		switch (symbol) {
		case POUND:
			Result = OUTPUT_ATRIBUTE_ID + outputBracedBlock(Result);
			break;
		case DOT:
			Result = OUTPUT_ATRIBUTE_CLASS + outputBracedBlock(Result);
			break;
		case DOLLAR:
			Result = OUTPUT_ATRIBUTE_NAME + outputBracedBlock(Result);
			break;
		case COLON:
			Result = OUTPUT_ATRIBUTE_TYPE + outputBracedBlock(Result);
			break;
		case AT:
			Result = OUTPUT_ATRIBUTE_HEIGHT + outputBracedBlock(Result);
			break;
		}	
		
		return Result;
	}
	
}
