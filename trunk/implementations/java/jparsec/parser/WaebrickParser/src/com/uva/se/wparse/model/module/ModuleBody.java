/*
 * File			: ModuleBody.java
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

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.uva.se.wparse.model.common.ValueObject;
import com.uva.se.wparse.util.Strings;

public final class ModuleBody extends ValueObject {
	
	public static final String OUTPUT_MEMBER_LIST = "member-list";

	private static org.apache.log4j.Logger logger = Logger
			.getLogger(ModuleBody.class);
	private List<Member> members;

	public ModuleBody(List<Member> members) {
		this.members = Collections.unmodifiableList(members);
		if (logger.isDebugEnabled()) {
			logger.debug("Creating " + this.getClass().getSimpleName()
					+ " with values : " + toString());
		}
	}

	@Override
	public String toString() {
		return Strings.join(" ", members);
	}
	
	@Override
	public String toTransformerOutput() {
		String memberList = "";
		for (Member member: members) {
			if (member instanceof ValueObject) {
				outputAddToList(memberList, ((ValueObject)member).toTransformerOutput());
			}
		}
		return OUTPUT_MEMBER_LIST + outputBracedBlock( outputBracedList( memberList ) );
	}
}
