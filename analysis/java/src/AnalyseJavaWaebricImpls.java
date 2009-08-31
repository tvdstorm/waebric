import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import waebric.analysis.java.runners.IParserRunner;
import waebric.analysis.java.runners.JParsecRunner;
import waebric.analysis.java.runners.JavaCCRunner;
import waebric.analysis.java.runners.JavaCupRunner;
import waebric.analysis.java.runners.LPGRunner;
import waebric.analysis.java.runners.SableCCRunner;
import aterm.ATerm;
import aterm.pure.PureFactory;


public class AnalyseJavaWaebricImpls {
	private static String TEST_PATH = "/Users/tvdstorm/GLT/build/waebric/test/test";
	private static String TESTS_DAT = "tests.dat";
	private List<String> tests;
	private List<IParserRunner> parsers = new ArrayList<IParserRunner>();
	private Map<String, Map<String, TestResult>> stats = new HashMap<String, Map<String,TestResult>>();
	private String root;
	private PureFactory factory;
	
	public AnalyseJavaWaebricImpls(List<String> tests, String root) {
		this.tests = tests;
		this.root = root;
		this.factory = new PureFactory();
		addParser(new JavaCCRunner());		
		addParser(new JavaCupRunner());
		addParser(new JParsecRunner());
		addParser(new LPGRunner());
		addParser(new SableCCRunner());
	}

	public void addParser(IParserRunner parser) {
		this.parsers.add(parser);
		stats.put(parser.getName(), new HashMap<String,TestResult>());
	}



	public static void main(String args[]) {
		new AnalyseJavaWaebricImpls(tests(TESTS_DAT, TEST_PATH), TEST_PATH).run();
	}
	
	public void run() {
		for (IParserRunner p: parsers) {
			runSuite(p);
		}
		printResults();
	}
	
	public ATerm getExpectedAST(String test) {
		String[] elts = test.split("\\.");
		String astFileName = root + "/output/" + elts[0] + ".ast";
		try {
			return factory.readFromFile(astFileName);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void printResults() {
		List<String> names = new ArrayList<String>(stats.keySet());
		Collections.sort(names);
		System.out.print(String.format("%-16s,", ""));
		for (String name: names) {
			System.out.print(String.format("%-9s", name));
			if (!names.get(names.size() - 1).equals(name)) {
				System.out.print(", ");
			}
		}
		System.out.println();
		for (String filename: tests) {
			System.out.print(String.format("%-16s,", filename));
			//System.out.print(filename + "\t");
			for (String name: names) {
				System.out.print(String.format("%-9s", stats.get(name).get(filename)));
				if (!names.get(names.size() - 1).equals(name)) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}
	
	public void runSuite(IParserRunner parser) {
		for (String filename: tests) {
			//System.err.println("TESTING: " + filename);
			try {
				String result = parser.parse(new File(new File(root), filename));
				if (result != null) {
//					System.err.println("success: ");
//					System.err.println(result);
					try {
						ATerm ast = factory.parse(result);
						if (ast.equals(getExpectedAST(filename))) {
							stats.get(parser.getName()).put(filename, new Success());
						}
						else {
							stats.get(parser.getName()).put(filename, new ASTMismatch());
						}
					}
					catch (aterm.ParseError e) {
						stats.get(parser.getName()).put(filename, new InvalidAST());
					}
				}
				else {
					stats.get(parser.getName()).put(filename, new ParseError());
					//System.err.println("FAILURE");
				}
			}
			catch (Throwable t) {
				stats.get(parser.getName()).put(filename, new Other());
				t.printStackTrace();
			}
		}
	}
	
	
	public static List<String> tests(String tests, String root) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File(new File(root), tests)));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1);
		}
		String line;
		List<String> result = new ArrayList<String>();
		try {
			line = reader.readLine();
			while (line != null) {
				result.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}
	
}
