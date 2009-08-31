package waebric.analysis.java.runners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.uva.se.wparse.exception.ParserException;
import com.uva.se.wparse.model.common.WabrickParseTree;
import com.uva.se.wparse.output.transformer.OutputTransformer;
import com.uva.se.wparse.parser.ModuleParser;
import com.uva.se.wparse.parser.WeabrickParser;

public class JParsecRunner implements IParserRunner {

	public String getName() {
		return "jparsec";
	}

	public String parse(File filename) {
		WeabrickParser weabrickParser = new ModuleParser();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			return null;
		}
		String source = "";
		try {
			String line = reader.readLine();
			while (line != null) {
				source += "\n" + line;
				line = reader.readLine();
			}
		} catch (IOException e) {
			return null;
		}
		WabrickParseTree parseTree;
		try {
			parseTree = weabrickParser.parse(source);
		} catch (ParserException e) {
			return null;
		}
		OutputTransformer outputTransformer = new OutputTransformer();
		String output = outputTransformer.transform(parseTree);
		return output;
	}

}
