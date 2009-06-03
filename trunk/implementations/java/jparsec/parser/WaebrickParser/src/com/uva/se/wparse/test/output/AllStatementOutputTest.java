package com.uva.se.wparse.test.output;

import junit.framework.TestCase;

public class AllStatementOutputTest extends TestCase {
	
	public static final String OUTPUTTEST_MODULE_OPEN 			= "module(module-id([\"menus\"]),[";
	//assignment
	public static final String OUTPUTTEST_STATEMENT_ASSIGNMENT 	= "";
	//cdata
	public static final String OUTPUTTEST_STATEMENT_CDATA	 	= "";
	//comment
	public static final String OUTPUTTEST_STATEMENT_COMMENT	 	= "";
	//each
	public static final String OUTPUTTEST_STATEMENT_EACH	 	= "";
	//echo
	public static final String OUTPUTTEST_STATEMENT_ECHO	 	= "";
	//if
	public static final String OUTPUTTEST_STATEMENT_IF		 	= "";
	//if else
	public static final String OUTPUTTEST_STATEMENT_IFELSE	 	= "";
	//let in
	public static final String OUTPUTTEST_STATEMENT_LETIN	 	= "";
	//yield
	public static final String OUTPUTTEST_STATEMENT_YIELD	 	= "";	
	public static final String OUTPUTTEST_MODULE_CLOSE = 		"])";
	
	public static final String INPUTTEST_MODULE 				= "module menus";
	//assignment
	public static final String INPUTTEST_STATEMENT_ASSIGNMENT 	= "";
	//cdata
	public static final String INPUTTEST_STATEMENT_CDATA	 	= "def menu(menu) echo menu.title; ul each (kid: menu.kids) item(kid); end";
	//comment
	public static final String INPUTTEST_STATEMENT_COMMENT	 	= "";
	//each
	public static final String INPUTTEST_STATEMENT_EACH		 	= "";
	//echo
	public static final String INPUTTEST_STATEMENT_ECHO		 	= "";
	//if
	public static final String INPUTTEST_STATEMENT_IF		 	= "";
	//if else
	public static final String INPUTTEST_STATEMENT_IFELSE	 	= "";
	//let in
	public static final String INPUTTEST_STATEMENT_LETIN	 	= "";
	//yield
	public static final String INPUTTEST_STATEMENT_YIELD	 	= "";
}
