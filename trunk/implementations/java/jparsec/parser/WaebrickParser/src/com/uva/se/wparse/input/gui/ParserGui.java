/*
 * File			: MainParserFrame.java
 * Project		: WaebrickParser
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
package com.uva.se.wparse.input.gui;

import info.clearthought.layout.TableLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.uva.se.wparse.model.common.WabrickParseTree;
import com.uva.se.wparse.output.transformer.OutputTransformer;
import com.uva.se.wparse.parser.ModuleParser;
import com.uva.se.wparse.parser.WeabrickParser;
import com.uva.se.wparse.resource.Resources;
import com.uva.se.wparse.util.FileUtil;

/**
 * The form which displays the graphical user for the input and output of the
 * Parser process.
 */
public class ParserGui extends javax.swing.JFrame {

	/**
	 * Use for serialization purposes in the Java framework.
	 */
	private static final long serialVersionUID = 5812414021280027402L;

	/**
	 * A button for openingen a Weabric file which is parsed.
	 */
	private JButton btnOpenFile = null;

	/**
	 * A filechooser for choosing a file which is parsed.
	 */
	private JFileChooser fileChooser = null;

	/**
	 * The sourcefile which is parsed.
	 */
	private File sourceFile = null;

	/**
	 * The filename of the File which is parsed displayed in
	 */
	private JTextField txtFileName = null;

	/**
	 * The output of the parsing process.
	 */
	private JTextArea txtParserOutput = null;

	/**
	 * The inputdata of the the source file.
	 */
	private String sourceData = "";

	/**
	 * Constructs the parser form.
	 */
	public ParserGui() {
		super();
		initGUI();
	}

	/**
	 * Initialize the parser form. Set all the controls on the form and register
	 * the listeners of the controls.
	 */
	private void initGUI() {
		/*
		 * the gui uses tablelayout, which uses 2 dimensional array with the
		 * grid settings
		 */
		double size[][] = { { 10, TableLayout.FILL, 10, 100, 10 },
				{ 20, 20, 20, TableLayout.FILL, 30 } };

		getContentPane().setLayout(new TableLayout(size));

		// hide and dispose the gui when user closes hte gui
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		// create gui elements
		btnOpenFile = new JButton();
		btnOpenFile.setText(Resources.GUI_BUTTON_LOAD.getResource());
		btnOpenFile.addActionListener(new LoadAction());

		txtFileName = new JTextField("", 20);
		txtFileName.setEditable(false);

		txtParserOutput = new JTextArea();
		txtParserOutput.setEditable(false);
		txtParserOutput.setLineWrap(true);
		txtParserOutput.setWrapStyleWord(true);

		// add a scrollpane to the textbox
		JScrollPane scrollArea = new JScrollPane(txtParserOutput);

		// create labels with text information
		JLabel lblFileName = new JLabel("FileName");
		JLabel lblParserOutput = new JLabel("Parser output");

		/*
		 * add the gui elements to their correct coordinates, this is done with
		 * tablelayout link:
		 * http://java.sun.com/products/jfc/tsc/articles/tablelayout/
		 */
		getContentPane().add(lblFileName, "1,0");
		getContentPane().add(txtFileName, "1,1");
		getContentPane().add(btnOpenFile, "3,1");
		getContentPane().add(lblParserOutput, "1,2");
		getContentPane().add(scrollArea, "1,3");

		setTitle(Resources.GUI_TITLE.getResource());
		// set the size of the gui
		pack();
		setSize(700, 300);
	}

	/**
	 * A accessor for the data of the source file.
	 * 
	 * @return The data of the source file.
	 */
	public String getSourceData() {
		return sourceData;
	}

	/**
	 * Action listener for the load button, this will load the file contents and
	 * pass it to the parser.
	 */
	private class LoadAction implements ActionListener {

		/**
		 * Implements the action which is performed when the user want to parse
		 * the input file.
		 * 
		 * @param ActionEvent
		 *            The eventargs which are passed to this function.
		 */
		public void actionPerformed(ActionEvent e) {
			// Show open file dialog
			fileChooser = new JFileChooser();
			fileChooser.showOpenDialog(ParserGui.this);
			sourceFile = fileChooser.getSelectedFile();

			if (sourceFile != null) {

				// Display file information the frontend.
				txtFileName.setText(sourceFile.toString());
				try {
					sourceData = FileUtil.readFile(sourceFile);
				} catch (IOException exception) {
					exception.printStackTrace();
					String error = Resources.ERROR_FILE.getResource() + "\n"
							+ exception.getMessage();
					showErrorDialog(error);
				}

				// Parse the input.
				WeabrickParser weabrickParser = new ModuleParser();
				WabrickParseTree parseTree = null;
				try {
					parseTree = weabrickParser.parse(sourceData);
					// done with parsing, now convert the parsetree to correct
					// output.
					OutputTransformer outputTransformer = new OutputTransformer();
					String output = outputTransformer.transform(parseTree);
					txtParserOutput.setText(output);
				} catch (Exception exception) {
					exception.printStackTrace();
					String error = Resources.ERROR_PARSER.getResource() + "\n"
							+ exception.getMessage();
					showErrorDialog(error);
				}
			}
		}
	}

	/**
	 * Display an error message dialog when you call this function.
	 * 
	 * @param errorMessage
	 *            The message which is displayed in this the error message.
	 */
	private void showErrorDialog(String errorMessage) {
		ErrorMessagePanel errorPanel = new ErrorMessagePanel(errorMessage);
		JOptionPane.showMessageDialog(ParserGui.this, errorPanel,
				Resources.ERROR_DIALOG_TITLE.getResource(),
				JOptionPane.ERROR_MESSAGE);
	}

}
