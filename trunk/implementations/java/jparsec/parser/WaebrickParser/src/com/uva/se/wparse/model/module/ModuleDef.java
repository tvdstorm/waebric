/*
 * File			: ModuleDef.java
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

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.model.common.WabrickParseTree;

/**
 * The weabric parse tree node of the weabric 'ModuleDef' construction.
 */
public final class ModuleDef extends WaebricParseTreeNode implements
		WabrickParseTree {

	/**
	 * OUTPUT_MODULE is used to indicate this construction in the output
	 * process.
	 */
	private static final String OUTPUT_MODULE = "module";

	/**
	 * OUTPUT_MODULE_ID is used to indicate this construction in the output
	 * process.
	 */
	private static final String OUTPUT_MODULE_ID = "module-id";

	/**
	 * OUTPUT_IMPORT is used to indicate this construction in the output
	 * process.
	 */
	private static final String OUTPUT_IMPORT = "import";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(ModuleDef.class);

	/**
	 * The body of the module.
	 */
	private ArrayList<ModuleBody> body;

	/**
	 * The name of the module.
	 */
	private QualifiedName name;

	/**
	 * The imports of the module.
	 */
	private ArrayList<QualifiedName> imports;

	/**
	 * Constructs a Weabric 'ModuleDef' parse tree node.
	 * 
	 * @param name
	 *            The name of the module.
	 * @param imports
	 *            The imports of the module.
	 * @param body
	 *            The body of the module.
	 */
	public ModuleDef(QualifiedName name, ArrayList<QualifiedName> imports,
			ArrayList<ModuleBody> body) {
		this.body = body;
		this.name = name;
		this.imports = imports;
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
		return "module " + name + " \n" + imports + body.toString();
	}

	/**
	 * The ModuleDef is the base class of the tree, therefore it implements
	 * WabrickParseTree, which constructs the output of the parsetree.
	 */
	// @Override
	public String getTransformerOutput() {
		return toTransformerOutput();
	}

	/**
	 * Transforms the content of this object to the expected output code. If
	 * necessary this function constructs also the output of the children. (It
	 * calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String moduleId = OUTPUT_MODULE_ID
				+ outputBracedBlock(outputBracedList(name.toTransformerOutput()));

		String importList = "";
		if (!imports.isEmpty()) {
			for (QualifiedName importItem : imports) {
				importList = outputAddToBlock(importList, OUTPUT_IMPORT
						+ outputBracedBlock(OUTPUT_MODULE_ID
								+ outputBracedBlock(outputBracedList(importItem
										.toTransformerOutput()))));
			}
		}

		String moduleElements = outputBracedList(outputAddToBlock(importList,
				blockToTransformerOutput(body)), true);

		return OUTPUT_MODULE
				+ outputBracedBlock(outputAddToBlock(moduleId, moduleElements));
	}
}
