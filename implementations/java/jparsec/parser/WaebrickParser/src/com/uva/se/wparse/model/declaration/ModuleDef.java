/*
 * File			: ModuleDef.java
 * Project		: WaebrickParser
 * 				: Practicum opdracht Software Construction
 * 
 * Authors		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * 
 * Description	:
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
