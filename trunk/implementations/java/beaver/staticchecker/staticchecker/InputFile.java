package staticchecker;

import java.io.*;

/**
 *
 * <p>Title: InputFile</p>
 * <p>Description: Extension of FileReader. Contains operations on an input file.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: University of Amsterdam</p>
 * @author Aart van den Dolder
 * @version 1.0
 */
class InputFile extends FileReader {

  private String fileName;
  private String fileContent;

  /**
   * Constructor
   * @param fileName the name of the input file
   * @throws IOException if the input file cannot be read
   */
  public InputFile(String name) throws IOException {
    super(name);
    this.fileName = name;
    setFileContent();
  }

  /**
   * Sets the fileContent attribute.
   * The text of the file is converted to a String value.
   */
  private void setFileContent() {
    final String NEWLINE = "\n";

    try {
      StringBuffer buffer = new StringBuffer();

      BufferedReader reader = new BufferedReader(this);
      String line = reader.readLine();

      while (line != null) {
        buffer.append(line);
        buffer.append(NEWLINE);
        line = reader.readLine();
      }

      fileContent = buffer.toString();
    }
    catch(IOException exception) {
      System.out.println("IOException: " + exception);
    }

  }

  /**
   * Gets the fileContent attribute
   * @return the fileContent attribute
   */
  public String getFileContent() {
    return fileContent;
  }

  /**
   * Converts the text of a file to a list of String values (lines).
   * @param inputFile the name of the input file
   * @return a list with text lines
   */
  public static StringList textFileToList(String textFile) {
    final char NEWLINE = '\n';

    StringList fileTextList = new StringList();

    try {
      InputFile fileHandle = new InputFile(textFile);
      String fileContentString = fileHandle.getFileContent();

      StringBuffer textLine = new StringBuffer();
      for (int index = 0; index < fileContentString.length(); index++) {
        if (fileContentString.charAt(index) != NEWLINE)
          textLine = textLine.append(fileContentString.charAt(index));
        else
          if (textLine.length() > 0) {
            fileTextList.add(textLine.toString());
            textLine = new StringBuffer();
          }
      }
    }
    catch(IOException exception) {
      System.out.println("IOException: " + exception);
    }

    return fileTextList;
  }

  /**
   * Makes a backup of this input file and replaces the content of this InputFile
   * by the given new content.
   * @param newContent the new content of this InputFile
   */
  public void replaceContent(String newContent) {
    final String TILDE = "~";

    try {
      File backupFile = new File(fileName + TILDE);
      FileWriter backup = new FileWriter(backupFile);
      backup.write(fileContent);
      backup.close();

      File changedFile = new File(fileName);
      FileWriter changed = new FileWriter(changedFile);
      changed.write(newContent);
      changed.close();
    }
    catch(IOException exception) {
      System.out.println("IOException: " + exception);
    }
  }

}