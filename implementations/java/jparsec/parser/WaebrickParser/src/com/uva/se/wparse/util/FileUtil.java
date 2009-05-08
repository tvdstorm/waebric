/*
 * File			: FileUtil.java
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
package com.uva.se.wparse.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {

	public static String readFile(File file) throws IOException {
		StringBuilder contents = new StringBuilder();
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = null;

		while ((line = in.readLine()) != null) {
			contents.append(line + "\n");

		}
		in.close();

		
		return contents.toString();
	}

}
