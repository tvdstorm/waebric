/*
 * File			: CommentStatement.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
 * 
 */
package com.uva.se.wparse.model.statement;


public class CommentStatement implements Statement {

	
	private String comment;

	public CommentStatement(String comment) {
		this.comment = comment;
		System.out.println("debug -- inside " + this.getClass().getSimpleName() + " constructor");
	}

	@Override
	public String toString() {
		return comment;
	}
	
	
}
