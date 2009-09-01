package waebric.analysis.java;
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

import waebric.analysis.java.runners.BeaverRunner;
import waebric.analysis.java.runners.IParserRunner;
import waebric.analysis.java.runners.JParsecRunner;
import waebric.analysis.java.runners.JavaCCRunner;
import waebric.analysis.java.runners.JavaCupRunner;
import waebric.analysis.java.runners.LPGRunner;
import waebric.analysis.java.runners.RatsRunner;
import waebric.analysis.java.runners.SableCCRunner;
import aterm.ATerm;
import aterm.pure.PureFactory;


public class AnalyseJavaWaebricImpls {
	private static String TEST_PATH = "/Users/tvdstorm/GLT/build/waebric/test/test";
	private static String TESTS_DAT = "tests.dat";
	private List<String> tests;
	private List<IParserRunner> parsers = new ArrayList<IParserRunner>();
	private Map<String, Map<String, TestResult>> stats = new HashMap<String, Map<String,TestResult>>();
	private Map<String, Integer> numOfInvalids = new HashMap<String, Integer>(); // not an ATerm
	private Map<String, Integer> numOfSuccess = new HashMap<String, Integer>(); 
	private Map<String, Integer> numOfMismatch = new HashMap<String, Integer>(); // different ATerm
	private Map<String, Integer> numOfOther = new HashMap<String, Integer>(); 
	private Map<String, Integer> numOfParseError= new HashMap<String, Integer>(); // unexpected parse error
	private Map<String, Integer> numOfNoError = new HashMap<String, Integer>(); // no error, but expected one
	
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
		addParser(new RatsRunner());
		addParser(new BeaverRunner());
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
	
	public String getExpectedASTSource(String test) {
		String[] elts = test.split("\\.");
		String astFileName = root + "/output/" + elts[0] + ".ast";
		String src = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(astFileName)));
			String line = reader.readLine();
			while (line != null) {
				src += line;
				line = reader.readLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
//			throw new RuntimeException(e);
		}
		return src;
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
		System.out.println(String.format("%-12s   %10s %10s %10s %10s %10s %10s", "", "success", "error", "mismatch", "invalid", "no-error", "other"));
		for (String name: names) {
			System.out.print(String.format("%-12s : ", name));
			System.out.print(String.format("%10d ", numOfSuccess.get(name))); 
			System.out.print(String.format("%10d ", numOfParseError.get(name))); 
			System.out.print(String.format("%10d ", numOfMismatch.get(name))); 
			System.out.print(String.format("%10d ", numOfInvalids.get(name))); 
			System.out.print(String.format("%10d ", numOfNoError.get(name)));
			System.out.print(String.format("%10d", numOfOther.get(name))); 
			System.out.println();
		}
		
	}
	
	public void inc(Map<String,Integer> map, String name) {
		if (!map.containsKey(name)) {
			map.put(name, 0);
		}
		map.put(name, map.get(name) + 1);
	}
	
	public void runSuite(IParserRunner parser) {
		for (String filename: tests) {
			System.out.println("TESTING: " + filename);
			String name = parser.getName();
			try {
				String result = parser.parse(new File(new File(root), filename));
				String expected = getExpectedASTSource(filename);
				if (result != null) {
					if (expected.equals("")) {
						stats.get(name).put(filename, new NoParseError());
						inc(numOfNoError, name);
						continue;
					}
					try {
						ATerm ast = factory.parse(result);
						if (ast.equals(factory.parse(expected))) {
							stats.get(name).put(filename, new Success());
							inc(numOfSuccess, name);
						}
						else {
							stats.get(name).put(filename, new ASTMismatch());
							inc(numOfMismatch, name);
						}
					}
					catch (aterm.ParseError e) {
						inc(numOfInvalids, name);
						stats.get(name).put(filename, new InvalidAST());
					}
				}
				else {
					if (expected.equals("")) {
						inc(numOfSuccess, name);
						stats.get(name).put(filename, new Success());
					}
					else {
						inc(numOfParseError, name);
						stats.get(name).put(filename, new ParseError());
					}
				}
			}
			catch (Throwable t) {
				inc(numOfOther, name);
				stats.get(name).put(filename, new Other());
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
