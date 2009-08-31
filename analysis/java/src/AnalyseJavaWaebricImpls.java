import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import waebric.analysis.java.runners.IParserRunner;
import waebric.analysis.java.runners.JParsecRunner;
import waebric.analysis.java.runners.JavaCCRunner;
import waebric.analysis.java.runners.JavaCupRunner;
import waebric.analysis.java.runners.LPGRunner;
import waebric.analysis.java.runners.SableCCRunner;


public class AnalyseJavaWaebricImpls {
	private static String TEST_PATH = "/Users/tvdstorm/GLT/build/waebric/test/test";
	private static String TESTS_DAT = "tests.dat";
	private List<String> tests;
	private List<IParserRunner> parsers = new ArrayList<IParserRunner>();
	private Map<String, Map<String, Boolean>> stats = new HashMap<String, Map<String,Boolean>>();
	private String root;
	
	public AnalyseJavaWaebricImpls(List<String> tests, String root) {
		this.tests = tests;
		this.root = root;
		addParser(new JavaCCRunner());		
		addParser(new JavaCupRunner());
		addParser(new JParsecRunner());
		addParser(new LPGRunner());
		addParser(new SableCCRunner());
	}

	public void addParser(IParserRunner parser) {
		this.parsers.add(parser);
		stats.put(parser.getName(), new HashMap<String,Boolean>());
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
	
	public void printResults() {
		Set<String> names = stats.keySet();
		System.out.print("\t\t");
		for (String name: names) {
			System.out.print(name + "\t");
		}
		System.out.println();
		for (String filename: tests) {
			System.out.print(filename + "\t");
			for (String name: names) {
				System.out.print(stats.get(name).get(filename) + "\t\t");
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
					stats.get(parser.getName()).put(filename, true);
				}
				else {
					stats.get(parser.getName()).put(filename, false);
					//System.err.println("FAILURE");
				}
			}
			catch (Throwable t) {
				t.printStackTrace();
				System.err.println("FAILURE");
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
