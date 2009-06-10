/*
 * File			: ResourceLoader.java
 * Project		: WaebrickParser2
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
package com.uva.se.wparse.resource;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class can load different resources out of a Java resouce file. 
 */
public class ResourceLoader {

	/**
	 * All the different messages which are stored in the resource.
	 */
	private ResourceBundle messages = null;

	/**
	 * The loader of the resource.
	 */
	private static ResourceLoader resourceLoader = null;

	/**
	 * Constructs the resource loaded. 
	 */
	private ResourceLoader() {
		String packagePath = getClass().getPackage().getName();
		packagePath = packagePath.replace(".", "/");
		messages = ResourceBundle.getBundle(packagePath + "/messages",
				Locale.US);
	}

	/**
	 * Get singleton instance of ResourceLoader
	 * 
	 * @return instance of ResourceLoader
	 */
	public static ResourceLoader getInstance() {
		if (resourceLoader == null) {
			resourceLoader = new ResourceLoader();
		}
		return resourceLoader;
	}

	/**
	 * Get the value for a specific key from the messages file
	 * 
	 * @param key
	 *            for which to get the value
	 * @return the value of the key
	 */
	public String getResource(String key) {
		return messages.getString(key);
	}

}
