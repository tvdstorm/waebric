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
import com.uva.se.wparse.model.statement.Statement;

public final class FunctionDef extends ValueObject implements Member {

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(FunctionDef.class);

	private String name;
	private Argument arguments;
	private List<Statement> statements;

	public FunctionDef(String name, Argument arguments, List<Statement> statements) {

		this.name = name;
		this.arguments = arguments;
		this.statements = statements;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return "def " + name + "(" + arguments + ")" + statements + " end";

	}

}
