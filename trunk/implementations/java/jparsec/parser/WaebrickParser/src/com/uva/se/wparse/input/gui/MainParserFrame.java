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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.uva.se.wparse.model.declaration.ModuleDef;
import com.uva.se.wparse.parser.DeclarationParser;
import com.uva.se.wparse.util.FileUtil;

public class MainParserFrame extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 5812414021280027402L;
	private JButton btnOpenFile;
	private JFileChooser fileChooser;
	
	private  File sourceFile ;

	JTextField txtFileName;
	JTextArea txtParserOutput;
	

	private  String sourceData  = "";
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainParserFrame inst = new MainParserFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public MainParserFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
	
		 double size[][] =
         {{10,TableLayout.FILL , 10, 100,10},
          {20, 20, 20, TableLayout.FILL, 30}};

		 getContentPane().setLayout (new TableLayout(size));

     
     
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		
		
		btnOpenFile = new JButton();
		btnOpenFile.setText("Load");
		btnOpenFile.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(MainParserFrame.this);
				
				 sourceFile = fileChooser.getSelectedFile();
				// String sourceData  = "";
				 if(sourceFile != null){
					 try {
						 sourceData  = FileUtil.readFile(sourceFile);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					DeclarationParser dp = new DeclarationParser();
					ModuleDef md = dp.parse(sourceData);
					txtParserOutput.setText(md.toString());	
				 }
			}
			
		});
		
	
		txtFileName = new JTextField("", 20);
		txtFileName.setEditable(false);

		txtParserOutput = new JTextArea();
		txtParserOutput.setEditable(false);
	
		JScrollPane scrollArea = new JScrollPane(txtParserOutput);
		
		JLabel lblFileName = new JLabel("FileName");
		JLabel lblParserOutput = new JLabel("Parser output");
		
		getContentPane().add(lblFileName, "1,0");
		getContentPane().add(txtFileName, "1,1");
		getContentPane().add(btnOpenFile, "3,1");
		getContentPane().add(lblParserOutput, "1,2");
		getContentPane().add(scrollArea, "1,3");
		
		pack();
		setSize(600, 300);

	}

	public String getSourceData() {
		return sourceData;
	}
	

}
