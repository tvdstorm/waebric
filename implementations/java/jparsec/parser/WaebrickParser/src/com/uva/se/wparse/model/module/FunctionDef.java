/*
 * File			: MethodDef.java
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
package com.uva.se.wparse.model.module;

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.model.markup.Formals;
import com.uva.se.wparse.model.statement.Statement;

public final class FunctionDef extends ValueObject implements Member {
	
	public static final String OUTPUT_FUNCTION	= "def";
	public static final String OUTPUT_ARGUMENTS	= "argument";
	public static final String OUTPUT_FORMALS   = "formals";
	

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(FunctionDef.class);

	private String name = "";
	private Formals formals = null;
	private List<Statement> statements = null;

	public FunctionDef(String name, Formals formals, List<Statement> statements) {

		this.name = name.trim();
		this.formals = formals;
		this.statements = statements;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}
	
	

	public String getName() {
		return name;
	}



	public Argument getFormals() {
		return formals;
	}



	public List<Statement> getStatements() {
		return statements;
	}



	@Override
	public String toString() {
		String result = "def " + name + "(";
		if(formals != null){
			result = result + formals;
		}
		result = result +  ")";
		if(statements != null){
			 result = result + statements;
		}
		 
		result = result + " end";
		return result;
	}
	
	@Override
	public String toTransformerOutput() {
		String NameElement = outputQuote( name );
		String ArgumentsElement = OUTPUT_LIST_EMPTY;
		if (formals instanceof ValueObject ) {
			String ArgumentTransformerOutput = ((ValueObject) formals).toTransformerOutput();
			ArgumentsElement = ArgumentTransformerOutput;
		}
		if (ArgumentsElement != OUTPUT_LIST_EMPTY) {
			ArgumentsElement = OUTPUT_FORMALS + outputBracedBlock( outputBracedList( ArgumentsElement ) );
		}
		
		String StatementsElement = OUTPUT_LIST_EMPTY;
		for (Statement statement: statements) {
			if (statement instanceof ValueObject) {
				StatementsElement = outputAddToList(StatementsElement, ((ValueObject)statement).toTransformerOutput());
			}
		}
		StatementsElement = outputBracedList(StatementsElement);
		
		return OUTPUT_FUNCTION + outputBracedBlock(NameElement + OUTPUT_BLOCK_SEPARATOR + ArgumentsElement + OUTPUT_BLOCK_SEPARATOR + StatementsElement );
	}

}
