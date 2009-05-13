package com.uva.se.wparse.resource;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceLoader {
	
	private ResourceBundle messages = null;
	
	private ResourceLoader(){
		String packagePath = getClass().getPackage().getName();
		packagePath = packagePath.replace(".", "/");
		messages = ResourceBundle.getBundle(packagePath + "/messages", Locale.US);
	}
	
	public static ResourceLoader getInstance(){
		return new ResourceLoader();
	}
	
	public String getResource(String key){
		return messages.getString(key);
	}

}
