/*
 * File			: Main.java
 * Project		: WaebrickParser
 * 				: Waebrick Parser, practicum opdracht Software Construction
 * 
 * Author		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * Description	: This is the main class of the application.
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

import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.uva.se.wparse.input.gui.ParserGui;
import com.uva.se.wparse.model.common.WabrickParseTree;
import com.uva.se.wparse.parser.ModuleParser;
import com.uva.se.wparse.parser.WeabrickParser;
import com.uva.se.wparse.resource.Resources;
import com.uva.se.wparse.util.FileUtil;

	
/**
 * 
 * The application supports two arguments
 * 
 * -i to start the application in interactive mode with a gui
 * -c <filename> to start the application in commandline mode.
 *
 */
public class Main {

	private static org.apache.log4j.Logger logger = Logger.getLogger(Main.class);

	private final static String OPTION_COMMANDLINE	= "-c";
	private final static String OPTION_INTERACTIVE	= "-i";
	

	public Main(String[] arguments) {
		
		// check the type of client to start
		if ( (arguments.length == 1) && OPTION_INTERACTIVE.equals(arguments[0])) {
			// starting in interactive mode
			if (logger.isDebugEnabled()) {
				logger.debug("Starting in Interactive mode");
			}
			// Start the gui client
			startGuiClient();

		} else if ( (arguments.length == 2) && OPTION_COMMANDLINE.equals(arguments[0])) {
			if (logger.isDebugEnabled()) {
				logger.debug("Starting in commandline mode");
			}
			// open the filename provided as second argument
			String fileName = arguments[1];
			//start the commandline client
			startCommandLineClient(fileName);
		} else {
			// illegal start option provided, handle with error msg
			System.out.println("ERROR: Bad combination of arguments");
		}
	}
	
	public static void main(String[] args) {
		// check if arguments are present
		if (args.length > 0) {
			new Main(args);
		} else {
			// illegal start option provided, handle with error msg
			//System.out.println("ERROR: not arguments given");
			System.out.println(Resources.ERROR_MAIN_NOARGS.getResource() );
			// TODO: print help info
		}

	}
	
	/**
	 * Start a Swing GUI.
	 * 
	 */
	private void startGuiClient(){
		//Gui is executed asynchronously on the AWT event dispatching thread
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
	 * @param fileName the file with the weabrick sourcecode to parse.
	 */
	private void startCommandLineClient(String fileName){
		File file = new File(fileName);
		if(logger.isDebugEnabled()){
			logger.debug("Loading file: " + file.toString());
		}
		try {
			//check if the file exists
			if(file.exists()){
				//read the contents of the file to a string.
				String source = FileUtil.readFile(file);
				//start the parser
				WeabrickParser weabrickParser = new ModuleParser();
				WabrickParseTree parseTree = weabrickParser.parse(source);
				//done with parsing, now convert the parsetree to correct output.
				
				//TODO:Miguel, start hier de output generator
				
				if(logger.isDebugEnabled()){
					logger.debug("Parser result: " + parseTree.toString());
				}
			}
		} catch (Exception e) {
			//exception occured, display error message and then exit.
			logger.error("ERROR: error while processing file \"" + fileName + "\"", e);
		}
	}
	

	
}
