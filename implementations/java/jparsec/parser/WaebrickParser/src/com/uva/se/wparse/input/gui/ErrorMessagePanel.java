package com.uva.se.wparse.input.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ErrorMessagePanel extends JPanel {

	private static final long serialVersionUID = 6505744285671769458L;
	
	JScrollPane messageScrollPane = new JScrollPane();
	JTextArea messageTextArea = new JTextArea();
	String message;

	public ErrorMessagePanel(String message) {
		this.message = message;

		initGui();

	}

	
	@SuppressWarnings("unused")
	private ErrorMessagePanel() {
	}

	void initGui() {
		this.setLayout(new BorderLayout());
		messageTextArea.setEnabled(true);
		messageTextArea.setEditable(false);
		messageTextArea.setLineWrap(true);
		messageTextArea.setText(message);
		this.add(messageScrollPane, BorderLayout.CENTER);
		messageScrollPane.getViewport().add(messageTextArea, null);
		messageScrollPane.setPreferredSize(new Dimension(350, 150));
		
		
	}

	public void setText(String text) {
		this.message = text;
	}
}
