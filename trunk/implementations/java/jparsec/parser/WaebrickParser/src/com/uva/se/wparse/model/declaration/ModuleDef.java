/*
 * File			: ModuleDef.java
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
package com.uva.se.wparse.model.declaration;

import java.util.ArrayList;

import com.uva.se.wparse.model.common.ValueObject;

public final class ModuleDef extends ValueObject {
	private ArrayList<ModuleBody> body;
	private QualifiedName name;
	private ArrayList<QualifiedName> imports;

	public ModuleDef(QualifiedName name, ArrayList<QualifiedName> imports,
			ArrayList<ModuleBody> body) {
		this.body = body;
		this.name = name;
		this.imports = imports;
		System.out.println("debug -- inside " + this.getClass().getName()
				+ " constructor");
	}

	@Override
	public String toString() {
		return "module " + name + " \n" + imports + body.toString();
	}
}
