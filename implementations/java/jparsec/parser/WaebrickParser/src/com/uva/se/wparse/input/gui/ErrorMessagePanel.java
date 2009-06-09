package com.uva.se.wparse.input.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Display an error in a panel.
 */
public class ErrorMessagePanel extends JPanel {

	/**
	 * Used for serialization purposes in the Java framework.
	 */
	private static final long serialVersionUID = 6505744285671769458L;

	/**
	 * A scrollpane for scrolling the message which is displayed.
	 */
	JScrollPane messageScrollPane = new JScrollPane();

	/**
	 * Displays the error message
	 */
	JTextArea messageTextArea = new JTextArea();

	/**
	 * The message which is displayed in this anel.
	 */
	String message;

	/**
	 * Constructs an error message panel, based in the messages which is passed
	 * into this constructor.
	 * 
	 * @param message
	 *            The message to display in this panel.
	 */
	public ErrorMessagePanel(String message) {
		this.message = message;

		initGui();
	}

	/**
	 * You can't create an ErrorMessagePanel without passing a message into the
	 * ErrorMessagePanel.
	 */
	@SuppressWarnings("unused")
	private ErrorMessagePanel() {
	}

	/**
	 * Initialize the graphical user interface, place the controls on the form
	 * and order the controls.
	 */
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

	/**
	 * A setter for the error message.
	 * 
	 * @param text
	 *            the error message which is shown in this function.
	 */
	public void setText(String text) {
		// TODO Rename this function.
		this.message = text;
	}
}
