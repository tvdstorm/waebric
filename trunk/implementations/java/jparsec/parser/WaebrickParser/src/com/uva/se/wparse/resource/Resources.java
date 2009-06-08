/*
 * File			: Resources.java
 * Project		: WaebrickParser
 * 				: Waebrick Parser, practicum opdracht Software Construction
 * 
 * Author		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * Description	: Enum which contains elements for all the items items of the messages properties file.
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
package com.uva.se.wparse.resource;

public enum Resources {
	
	GUI_BUTTON_LOAD("gui.button.load"),
	GUI_TITLE("gui.title"),
	
	
	ERROR_PARSER("error.parser"),
	ERROR_FILE("error.file"),
	ERROR_MAIN_NOARGS("error.main.noargs"),
	ERROR_DIALOG_TITLE("error.dialog.title"),
	;

	private String key = null;

	private ResourceLoader resourceLoader = ResourceLoader.getInstance();

	/**
	 * Resources can only be defined by this enum itself 
	 * @param key the value of the key
	 */
	private Resources(final String key) {
		this.key = key;
	}

	/**
	 * Get the name of the enum as String
	 */
	@Override
	public String toString() {
		return key;
	}

	/**
	 * Get the value of the enum
	 * @return value actual value of the message this enum links to
	 */
	public String getResource() {
		return resourceLoader.getResource(key);
	}

}