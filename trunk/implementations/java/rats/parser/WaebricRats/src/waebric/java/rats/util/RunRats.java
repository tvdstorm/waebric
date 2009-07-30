package waebric.java.rats.util;

import xtc.parser.Rats;

public class RunRats {
	public static final String SRC_ROOT = "src";
	public static final String PACKAGE_DIR = "waebric/java/rats/parser";
	public static final String WAEBRIC_GRAMMAR = SRC_ROOT + "/" + PACKAGE_DIR + "/Waebric.rats";
	public static final String OUTPUT_DIR = SRC_ROOT + "/" + PACKAGE_DIR;
	public static final String[] RATS_ARGS = {//"-verbose", 
		"-in", SRC_ROOT, 
		"-out", OUTPUT_DIR,
//		"-ast",
		WAEBRIC_GRAMMAR};
//	public static final String[] RATS_ARGS = {WAEBRIC_GRAMMAR};
	
	public static void main(String[] args) {
		Rats rats = new Rats();
		rats.run(RATS_ARGS);
	}

}
