package waebric.java.rats.util;

import java.io.IOException;
import java.io.StringReader;

import waebric.java.rats.parser.Waebric;
import xtc.parser.Result;

public class TestWaebricParser {
	public static void main(String[] args) throws IOException {
		Waebric p = new Waebric(new StringReader("module vla def main if (a) echo \"abcd\"; end"), "bla.wae");
		Result r = p.pModule(0);
		System.out.println(r.semanticValue());
	}
}
