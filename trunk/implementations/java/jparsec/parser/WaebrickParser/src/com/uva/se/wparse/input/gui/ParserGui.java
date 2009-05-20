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
import com.uva.se.wparse.parser.ModuleParser;
import com.uva.se.wparse.parser.WeabrickParser;
import com.uva.se.wparse.resource.Resources;
import com.uva.se.wparse.util.FileUtil;

public class ParserGui extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 5812414021280027402L;
	
	//declare and initialize gui elements to null
	private JButton btnOpenFile = null;
	private JFileChooser fileChooser = null;
	private  File sourceFile = null ;
	private JTextField txtFileName = null;
	private JTextArea txtParserOutput = null;
	
	
	private  String sourceData  = "";
	

	public ParserGui() {
		super();
		initGUI();
	}

	private void initGUI() {
		/*the gui uses tablelayout, which uses 2 dimensional array with
		the grid settings */
		double size[][] = { { 10, TableLayout.FILL, 10, 100, 10 },
				{ 20, 20, 20, TableLayout.FILL, 30 } };

		getContentPane().setLayout(new TableLayout(size));

		//hide and dispose the gui when user closes hte gui
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		//create gui elements
		btnOpenFile = new JButton();
		btnOpenFile.setText(Resources.GUI_BUTTON_LOAD.getResource());
		btnOpenFile.addActionListener(new LoadAction());

		txtFileName = new JTextField("", 20);
		txtFileName.setEditable(false);

		txtParserOutput = new JTextArea();
		txtParserOutput.setEditable(false);
		txtParserOutput.setLineWrap(true);
		txtParserOutput.setWrapStyleWord(true);

		//add a scrollpane to the textbox
		JScrollPane scrollArea = new JScrollPane(txtParserOutput);

		//create labels with text information
		JLabel lblFileName = new JLabel("FileName");
		JLabel lblParserOutput = new JLabel("Parser output");

		/*add the gui elements to their correct coordinates, this is done
		  with tablelayout
		  link: http://java.sun.com/products/jfc/tsc/articles/tablelayout/
		*/
		getContentPane().add(lblFileName, "1,0");
		getContentPane().add(txtFileName, "1,1");
		getContentPane().add(btnOpenFile, "3,1");
		getContentPane().add(lblParserOutput, "1,2");
		getContentPane().add(scrollArea, "1,3");

		setTitle(Resources.GUI_TITLE.getResource());
		//set the size of the gui
		pack();
		setSize(700, 300);
	}

	public String getSourceData() {
		return sourceData;
	}
	
	
	/**
	 * Action listener for the load button, this will load the file contents
	 * and pass it to the parser.
	 * 
	 *
	 */
	private class LoadAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			fileChooser = new JFileChooser();
			fileChooser.showOpenDialog(ParserGui.this);

			sourceFile = fileChooser.getSelectedFile();
			
			if (sourceFile != null) {
				txtFileName.setText(sourceFile.toString());
				try {
					sourceData = FileUtil.readFile(sourceFile);
				} catch (IOException exception) {
					// throw new InputException("Error while reading file \"" +
					// sourceFile + "\"" , exception);
					exception.printStackTrace();
					String error = Resources.FILE_ERROR.getResource() + "\n" + exception.getMessage();
					showErrorDialog(error);
				}

				WeabrickParser weabrickParser = new ModuleParser();
				WabrickParseTree parseTree = null;
				try {
					parseTree = weabrickParser.parse(sourceData);
					//done with parsing, now convert the parsetree to correct output.
					txtParserOutput.setText(parseTree.toString());
				} catch (Exception exception) {
					String error = Resources.PARSER_ERROR.getResource() + "\n" + exception.getMessage();
					showErrorDialog(error);

				}
				
			}
		}

	}
	
	private void showErrorDialog(String errorMessage){
		ErrorMessagePanel errorPanel =  new ErrorMessagePanel(errorMessage);
		JOptionPane.showMessageDialog(ParserGui.this, errorPanel, Resources.ERROR_DIALOG_TITLE.getResource(), JOptionPane.ERROR_MESSAGE);
	
	
	}
	

	

}
