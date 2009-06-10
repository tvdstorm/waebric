/*
 * File			: FileUtil.java
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * A utility class with methods which can be used in the case of file access.
 * 
 * State: refactored, not reviewed.  
 */
public class FileUtil {

	/**
	 * This token can be used for a new line in a file. 
	 */
	private static final String NEWLINETOKEN = "\n";
	
	/**
	 * Reads the specified <i>file</i> and returns the contents of that 
	 * file. 
	 * 
	 * @param The file to be read 
	 * @return The file contents of the specified file
	 * 
	 * @throws IOException occurs when the file cannot be read 
	 */
	public static String readFile(File file) throws IOException {
		
		assert (file != null) : "readFile.file is null";
		
		StringBuilder contents = new StringBuilder();
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		
		String line = null;
		while ((line = fileReader.readLine()) != null) {
			contents.append(line + NEWLINETOKEN);
		}
		fileReader.close();

		return contents.toString();
	}
}
