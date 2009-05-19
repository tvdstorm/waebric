package org.waebric.adapter;

import java.util.Stack;

import org.sablecc.grammar.waebric.analysis.DepthFirstAdapter;
//import org.sablecc.grammar.waebric.node.AModule;
//import org.sablecc.grammar.waebric.node.AMultipleModuleId;
//import org.sablecc.grammar.waebric.node.ASingleModuleId;
import org.sablecc.grammar.waebric.node.Node;
import org.sablecc.grammar.waebric.node.Start;

public class TreeWalker extends DepthFirstAdapter {
	
	private StringBuilder sb = new StringBuilder();


	@Override
	public void outStart(Start node) {
		System.out.println(sb.toString());
		super.outStart(node);
	}

//	@Override
//	public void inAModule(AModule node) {
//		super.inAModule(node);
//		
//		sb.append("module(");
//	}
//
//	@Override
//	public void outAModule(AModule node) {
//		super.outAModule(node);
//		
//		sb.append(")");
//	}

//	@Override
//	public void caseASingleModuleId(ASingleModuleId node) {
//		super.caseASingleModuleId(node);
//		
//		sb.append("module-id([\"" + node.toString().trim() + "\"])");
//	}

//	@Override
//	public void caseAMultipleModuleId(AMultipleModuleId node) {
//		// TODO Auto-generated method stub
//		sb.append("module-id([\"" + node.toString().trim() + "\"])");
//	}
	
	
	
	

	
	
	
	
	
}
