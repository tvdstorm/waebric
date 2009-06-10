/*
 * File			: EchoEmbedding.java
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
package com.uva.se.wparse.model.statement;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.embedding.Embedding;

/**
 * The weabric parse tree node of the weabric 'echo embedding' construction. It
 * is an implementation of a statement.
 */
public class EchoEmbedding extends WaebricParseTreeNode implements Statement {

	/**
	 * OUTPUT_ECHO is used to indicate this option in the output process.
	 */
	private static final String OUTPUT_ECHO = "echo-embedding";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(EchoEmbedding.class);

	/**
	 * The embedded code.
	 */
	private Embedding embedding;

	/**
	 * Constructs a Weabric 'Each' parse tree node.
	 * 
	 * @param embedding
	 *            The embedded code.
	 */
	public EchoEmbedding(Embedding embedding) {
		this.embedding = embedding;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	/**
	 * Presents this object as a string representation
	 */
	@Override
	public String toString() {
		return embedding.toString();
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		return OUTPUT_ECHO + outputBracedBlock(embedding.toTransformerOutput());
	}

}
