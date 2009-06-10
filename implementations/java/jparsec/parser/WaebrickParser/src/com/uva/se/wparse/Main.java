/*
 * File			: Main.java
 * Project		: WaebrickParser2
 * 				: Waebrick Parser, practicum opdracht Software Construction
 * 
 * Author		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * Description	:
 * 
 * 
 * Change history
 * -----------------------------------------------------------
 * Date			Change				 
 * -----------------------------------------------------------
 * 07-05-2009	Initial version.
 * 
 * 
 */
package com.uva.se.wparse;

import java.io.File;
import java.io.IOException;

import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.uva.se.wparse.exception.ParserException;
import com.uva.se.wparse.input.gui.ParserGui;
import com.uva.se.wparse.model.common.WabrickParseTree;
import com.uva.se.wparse.output.transformer.OutputTransformer;
import com.uva.se.wparse.parser.ModuleParser;
import com.uva.se.wparse.parser.WeabrickParser;
import com.uva.se.wparse.resource.Resources;
import com.uva.se.wparse.util.FileUtil;

/**
 * The main class of the application. You can start the application via this
 * class. The application supports two arguments
 * 
 * -i to start the application in interactive mode with a gui -c <filename> to
 * start the application in commandline mode.
 */
public class Main {

	/**
	 * You can use the log4net log functionality via this variable.
	 */
	private static org.apache.log4j.Logger logger = Logger
			.getLogger(Main.class);

	/**
	 * When you start the application up with the command, you start the
	 * application with the command line.
	 */
	private final static String OPTION_COMMANDLINE = "-c";

	/**
	 * When you start the application up with the command, you start the
	 * application with the graphical user interface.
	 */
	private final static String OPTION_INTERACTIVE = "-i";

	/**
	 * This function starts the application.
	 * 
	 * @param args
	 *            A character which indicates the type of application which is
	 *            started up. You can startup the application with the
	 *            commandline (-c) or with an interactive mode. (-i)
	 */
	public static void main(String[] args) {
		// check if arguments are present
		if (args.length > 0) {
			new Main(args);
		} else {
			// illegal start option provided, handle with error message
			System.out.println(Resources.ERROR_MAIN_NOARGS.getResource());
		}
	}

	/**
	 * The constructor which creates this class with a set of input parameters.
	 * When the application is started in the commandline mode, also the
	 * filename of the inputfile is loaded.
	 * 
	 * @param arguments
	 *            A character which indicates the type of application which is
	 *            started up. You can startup the application with the
	 *            commandline (-c) or with an interactive mode. (-i)
	 */
	public Main(String[] arguments) {

		// check the type of client to start
		if ((arguments.length == 1) && OPTION_INTERACTIVE.equals(arguments[0])) {
			// starting in interactive mode
			if (logger.isDebugEnabled()) {
				logger.debug("Starting in Interactive mode");
			}
			// Start the gui client
			startGuiClient();

		} else if ((arguments.length == 2)
				&& OPTION_COMMANDLINE.equals(arguments[0])) {
			if (logger.isDebugEnabled()) {
				logger.debug("Starting in commandline mode");
			}
			// open the filename provided as second argument
			String fileName = arguments[1];
			// start the commandline client
			startCommandLineClient(fileName);
		} else {
			// illegal start option provided, handle with error msg
			System.out.println("ERROR: Bad combination of arguments");
		}
	}

	/**
	 * Start a Swing GUI
	 */
	private void startGuiClient() {
		// Gui is executed asynchronously on the AWT event dispatching thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ParserGui inst = new ParserGui();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	/**
	 * The commandline client loads the file given as a startup argument.
	 * 
	 * @param fileName
	 *            the file with the weabrick sourcecode to parse.
	 */
	private void startCommandLineClient(String fileName) {
		File file = new File(fileName);
		if (logger.isDebugEnabled()) {
			logger.debug("Loading file: " + file.toString());
		}

		String source = "";
		try {
			if (file.exists()) {
				// read the contents of the file to a string.
				source = FileUtil.readFile(file);
			}
		} catch (IOException ioException) {
			logger.error("ERROR: error while reading file \"" + fileName + "\"", ioException);
			return;
		}

		try {

			// start the parser
			WeabrickParser weabrickParser = new ModuleParser();
			WabrickParseTree parseTree = weabrickParser.parse(source);

			// done with parsing, now convert the parsetree to correct
			// output.
			OutputTransformer outputTransformer = new OutputTransformer();
			String output = outputTransformer.transform(parseTree);
			System.out.println(output);
			if (logger.isDebugEnabled()) {
				logger.debug("Parser result: " + output);
			}
		} catch (ParserException e) {
			// exception occured, display error message and then exit.
			logger.error("ERROR: error while processing file \"" + fileName
			+ "\"", e);
		}
	}

}
