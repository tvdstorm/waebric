/*
 * File			: Mapping.java
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
package com.uva.se.wparse.model.module;

import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.expression.Identifier;
import com.uva.se.wparse.model.markup.Markup;
import com.uva.se.wparse.util.Strings;

/**
 * The weabric parse tree node of the weabric 'Mapping' construction.
 */
public class Mapping extends WaebricParseTreeNode {

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(Mapping.class);

	/**
	 * The path of a mapping.
	 */
	private List<Identifier> path = null;

	/**
	 * The file of a mapping.
	 */
	private Identifier file = null;

	/**
	 * The extension of a mapping.
	 */
	private String extention = "";

	/**
	 * The markup of a mapping.
	 */
	private Markup markup = null;

	/**
	 * Constructs a Weabric 'Mapping' parse tree node.
	 * 
	 * @param path
	 *            The path of a mapping.
	 * @param extention
	 *            The extension of a mapping.
	 * @param markup
	 *            The markup of a mapping.
	 */
	public Mapping(List<Identifier> path, String extention, Markup markup) {
		this.file = path.remove(path.size() - 1);
		this.path = path;
		this.extention = extention;
		this.markup = markup;
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	/**
	 * Presents this object as a string representation.
	 */
	@Override
	public String toString() {
		return Strings.join("/", path) + "/" + file + "." + extention + ":"
				+ markup;
	}

	/**
	 * OUTPUT_MAPPING_PATH is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_MAPPING_PATH = "path";

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {

		String filename = file + "." + extention;
		String pathname = Strings.join("/", path);
		String fullfilename = outputQuote(filename);
		if (!pathname.isEmpty()) {
			fullfilename = OUTPUT_MAPPING_PATH
					+ outputBracedBlock(outputQuote(pathname) + ","
							+ fullfilename);
		}

		return fullfilename + OUTPUT_BLOCK_SEPARATOR
				+ markup.toTransformerOutput();
	}
}
