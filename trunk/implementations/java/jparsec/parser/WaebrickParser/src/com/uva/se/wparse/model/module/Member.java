/*
 * File			: Member.java
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

import com.uva.se.wparse.model.common.TransformerOutput;

/**
 * This member interface indicates that it is an Member. In Weabric it can be 
 * a FunctionDef or a ModuleDef.
 */
public interface Member extends TransformerOutput {}