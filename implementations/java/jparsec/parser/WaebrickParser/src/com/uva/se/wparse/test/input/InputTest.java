package com.uva.se.wparse.test.input;

import java.io.File;
import java.net.URL;

import junit.framework.TestCase;

import com.uva.se.wparse.Main;
import com.uva.se.wparse.input.gui.ParserGui;

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
		//Main.main(new String[]{"-i" });
		ParserGui gui = new ParserGui();
		assertNotNull(gui);
	}
}
