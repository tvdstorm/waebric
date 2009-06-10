/*
 * File			: ModuleBody.java
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

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.WaebricParseTreeNode;
import com.uva.se.wparse.util.Strings;

/**
 * The weabric parse tree node of the weabric 'ModuleBody' construction. 
 */
public final class ModuleBody extends WaebricParseTreeNode {
	
	/**
	 * OUTPUT_MEMBER_LIST is used to indicate this construction in the output process.
	 */
	private static final String OUTPUT_MEMBER_LIST = "member-list";

	/**
	 * This variable exposes the logging functionality.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(ModuleBody.class);
	
	/**
	 * All the members of the module. 
	 */
	private List<Member> members;

	/**
	 * Constructs a Weabric 'ModuleBody' parse tree node.
	 * @param members All the members of the module. 
	 */
	public ModuleBody(List<Member> members) {
		this.members = Collections.unmodifiableList(members);
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
		return Strings.join(" ", members);
	}
	
	/**
	 * Transforms the content of this object to the expected output code. 
	 * If necessary this function constructs also the output of the children. 
	 * (It calls the same function <i>toTransformerOutput</i> of the children)
	 */
	@Override
	public String toTransformerOutput() {
		String memberList = "";
		for (Member member: members) {
			outputAddToBlock(memberList, member.toTransformerOutput());
		}
		return OUTPUT_MEMBER_LIST + outputBracedBlock( outputBracedList( memberList ) );
	}
}
