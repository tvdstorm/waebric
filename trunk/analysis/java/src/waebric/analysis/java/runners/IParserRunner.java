package waebric.analysis.java.runners;

import java.io.File;

public interface IParserRunner {
	String parse(File filename);
	String getName();
	
}
