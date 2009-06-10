/*
 * File			: InputTest.java
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
package com.uva.se.wparse.test.input;

import java.io.File;
import java.net.URL;

import junit.framework.TestCase;

import com.uva.se.wparse.Main;
import com.uva.se.wparse.input.gui.ParserGui;

/**
 * Test the input part of the frontend: the console and the interactive mode. 
 * 
 * The functions aren't documented. There are two reasons for not documenting 
 * this tests: 
 * - There are some time limits;
 * - The tests are working always in the same manner, so the default pattern is 
 *   documented above. 
 */
public class InputTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	
	public void testConsoleMode(){
		URL url = Main.class.getResource("../wae/lava.wae");
		File file = new File(url.getFile()); 
		String fileName = file.toString().replace("/bin/com/uva/se", "/src/com/uva/se");
		fileName = fileName.replace("%20", " ");
		Main.main(new String[]{"-c", fileName });
	}
	
	public void testInteractiveMode(){
		ParserGui gui = new ParserGui();
		assertNotNull(gui);
	}
}
