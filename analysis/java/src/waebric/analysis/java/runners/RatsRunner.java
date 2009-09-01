package waebric.analysis.java.runners;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import waebric.java.rats.parser.Waebric;
import xtc.parser.ParseError;
import xtc.parser.Result;

public class RatsRunner implements IParserRunner {

	public String getName() {
		return "rats";
	}

	public String parse(File filename) {
		Waebric p;
		try {
			p = new Waebric(new FileReader(filename), "bla.wae");
			Result r = null;
			try {
				r = p.pModule(0);
				if (r instanceof ParseError) {
					return null;
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
			if (r != null) {
				return r.semanticValue().toString();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

}
