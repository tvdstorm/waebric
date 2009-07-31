package waebric.java.rats.parser.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class TestDemos extends RatsTesting {
	private final static String DEMO_DIR = "src/waebric/java/rats/parser/test/demos";
	private final static String MENUS = DEMO_DIR + "/menus.wae";
	private final static String SWFOBJECT = DEMO_DIR + "/swfobject.wae";
	private final static String LAYOUT = DEMO_DIR + "/layout.wae";
	
	@Before
	public void setup() {
		setLogging(true);
	}
	
	private String load(String fileName) {
		BufferedReader reader = null;
		StringBuilder builder = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			
			while (line != null) {
				builder.append(line + "\n");
				line = reader.readLine();
			}
		} 
		catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} 
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return builder.toString();
	}
	
	@Test
	public void testMenus() {
		testModule(load(MENUS));
	}

	@Test
	public void testLayout() {
		testModule(load(LAYOUT));
	}

	@Test
	public void testSWFObject() {
		testModule(load(SWFOBJECT));
	}

}
