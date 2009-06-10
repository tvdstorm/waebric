/*
 * File			: Strings.java
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
package com.uva.se.wparse.util;

import java.util.Arrays;

/**
 * Several String Manipulation functionality which can separate objects by
 * different delimiter.
 */
public final class Strings {

	/**
	 * Prepends delimiter before each object of code objects
	 * 
	 * @param delimiter
	 *            The delimiter to prepend for each object.
	 * @param objects
	 *            The objects where this function prepends the delimiter.
	 * @return
	 */
	public static String prependEach(String delimiter, Iterable<?> objects) {
		StringBuilder builder = new StringBuilder();
		for (Object object : objects) {
			builder.append(delimiter);
			builder.append(object);
		}
		return builder.toString();
	}

	/**
	 * Joins objects with delimiter as the delimiter.
	 * 
	 * @param builder
	 *            The builder which creates the string
	 * @param delimiter
	 *            The delimiter which is added after the objects
	 * @param objects
	 *            The objects which are divided by the delimiter
	 * @return A StringBuilder with all the objects divided by the delimiter
	 */
	public static StringBuilder join(StringBuilder builder, String delimiter,
			Iterable<?> objects) {

		int itemIndex = 0;
		for (Object object : objects) {
			if (itemIndex++ > 0)
				builder.append(delimiter);
			builder.append(object);
		}
		return builder;
	}

	/**
	 * Joins objects with delimiter as the delimiter.
	 * 
	 * @param delimiter
	 *            The delimiter which is added after the objects
	 * @param objects
	 *            The objects which are divided by the delimiter
	 * @return A string with all the objects divided by the delimiter
	 */
	public static String join(String delimiter, Iterable<?> objects) {
		return join(new StringBuilder(), delimiter, objects).toString();
	}

	/**
	 * Joins objects with delimiter as the delimiter.
	 * 
	 * @param delimiter
	 *            The delimiter which is added after the objects
	 * @param objects
	 *            The objects which are divided by the delimiter
	 * @return A string with all the objects divided by the delimiter
	 */
	public static String join(String delimiter, Object... objects) {
		return join(delimiter, Arrays.asList(objects));
	}

	/**
	 * Joins objects with delimiter as the delimiter.
	 * 
	 * @param builder
	 *            The builder which creates the string
	 * @param delimiter
	 *            The delimiter which is added after the objects
	 * @param objects
	 *            The objects which are divided by the delimiter
	 * @return A StringBuilder with all the objects divided by the delimiter
	 */
	public static StringBuilder join(StringBuilder builder, String delimiter,
			Object... objects) {
		return join(builder, delimiter, Arrays.asList(objects));
	}
}
