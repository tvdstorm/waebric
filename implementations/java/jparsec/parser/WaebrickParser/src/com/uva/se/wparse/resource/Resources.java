package com.uva.se.wparse.resource;

public enum Resources {
	MAIN_ERROR_NOARGS("main.error.noargs"),
	GUI_BUTTON_LOAD("gui.button.load"),
	
	PARSER_ERROR("parser.error"),
	FILE_ERROR("file.error"),
	
	ERROR_DIALOG_TITLE("error.dialog.title"),
	;

	private String key = null;

	private ResourceLoader resourceLoader = ResourceLoader.getInstance();

	private Resources(final String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return key;
	}

	public String getResource() {
		return resourceLoader.getResource(key);
	}

}
