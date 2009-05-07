/*
 * File			: AssignmentArgument2.java
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

import java.util.List;

import com.uva.se.wparse.model.markup.Argument;
import com.uva.se.wparse.util.Strings;

public class AssignmentArgument2 implements Argument {

	private String var = "";
	private String data = "";
	
	
	//public AssignmentArgument2(String var, Object test1, List<String> data, Object test2) {
	public AssignmentArgument2(String var, List<String> data) {
		super();
		this.var = var;
		//for(List<String> part : data){
		//	this.data = this.data + Strings.join("", part);
		//}
		this.data = Strings.join("", data);
		System.out.println("data ==" + this.data);
	}


	@Override
	public String toString() {
		return var + " = " + data;
	}
	
	
	
}
