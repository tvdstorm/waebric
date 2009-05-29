/*
 * File			: BlockStatement.java
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

package com.uva.se.wparse.model.statement;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.util.Strings;

public final class Block extends ValueObject implements Statement {
	
	public static final String OUTPUT_BLOCK = "block";

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(Block.class);

	private List<Statement> statements;

	public Block(List<Statement> statements) {
		this.statements = Collections.unmodifiableList(statements);
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return "{" + Strings.join(" ", statements) + "}";
	}
	
	@Override
	public String toTransformerOutput() {
		String statementBlock = "";
		for (Statement statement: statements){
			if (statement instanceof ValueObject){
				statementBlock = outputAddToBlock(statementBlock, ((ValueObject)statement).toTransformerOutput());
			}			
		}		
		return OUTPUT_BLOCK + outputBracedBlock( outputBracedList( statementBlock ) );
	}
}
