package staticchecker;

import java.io.*;

/**
 *
 * <p>Title: WaebricSystem</p>
 * <p>Description: The WaebricSystem contains all necessary environment items.
 * The location of the Waebric source files, the value of the Waebric file extension and
 * the location of the file with all HTML elements are specified in a text file "config.txt".</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: University of Amsterdam</p>
 * @author Aart van den Dolder
 * @version 1.0
 */
class WaebricSystem {

  private String waebricDir = new String();
  private String waebricFileExtension = new String();
  private String htmlElementsFile = new String();
  private String pathSeparator = new String();

  private StringList moduleList = new StringList();
  private StringList htmlElementList = new StringList();
  private StringList configList = new StringList();

  /**
   * Constructor
   */
  public WaebricSystem() {

    try {
      setConfig();
      setModuleList();
      setHtmlElementList();
    }
    catch(IOException exception) {
      System.out.println("IOException: " + exception);
    }

  }

  /**
   * Determines the value of a config item from a list of configuration file lines
   * @param configList the list with configuration file lines
   * @param identifier the requested item
   * @param defaultValue the value if the item is not specified in the configuration file
   * @return the value of the requested item
   */
  private static String configItem (StringList configList, String identifier, String defaultValue) {
    final char EQ = '=';

    String item = "";

    for (int index = 0; index < configList.size(); index++) {
      String line = configList.getStringValue(index);

      if (line.indexOf(identifier) >= 0) {
        item = line.substring(line.indexOf(identifier) + identifier.length());
        item = line.substring(line.indexOf(EQ) + 1);
        item = item.trim();
      }
    }
    if (item.length() == 0) {
      item = defaultValue;
    }
    return item;
  }

  /**
   * Sets the configuration items and default values.
   * @throws IOException if the configuration file cannot be read.
   */
  private void setConfig() throws IOException {
    final String DOT = ".";
    final String UNIX_PATH_SEPARATOR = "/";
    final String WINDOWS_PATH_SEPARATOR = "\\";

    String defaultDir = System.getProperty("user.dir");
    String defaultExtension = "wae";
    String defaultHtmlFileName = "html-elements.txt";

    int unixPathSeparatorIndex = defaultDir.indexOf(UNIX_PATH_SEPARATOR);
    int windowsPathSeparatorIndex = defaultDir.indexOf(WINDOWS_PATH_SEPARATOR);
    if (unixPathSeparatorIndex >= 0) {
      pathSeparator = UNIX_PATH_SEPARATOR;
    }
    if (windowsPathSeparatorIndex >= 0) {
      pathSeparator = WINDOWS_PATH_SEPARATOR;
    }

    StringList configList = InputFile.textFileToList("staticchecker/config.txt");

    waebricDir = configItem(configList,"waebric_dir",defaultDir);

    waebricFileExtension = configItem(configList,"waebric_extension",defaultExtension);
    if (waebricFileExtension.indexOf(DOT) != 0) {
      waebricFileExtension = DOT + waebricFileExtension;
    }

    htmlElementsFile = configItem(configList,"html_elements_file",defaultDir+pathSeparator+defaultHtmlFileName);

  }

  /**
   * Sets the moduleList attribute.
   * Reads the names of all Waebric files (without extension) in the Waebric file directory
   */
  private void setModuleList() {
    File file = new File(waebricDir);
    File[] files = file.listFiles();
    for (int fileInList = 0; fileInList < files.length; fileInList++) {
      String filename = files[fileInList].getName();
      int startExtension = filename.indexOf(waebricFileExtension);
      if (startExtension > 0) {
        String modulename = filename.substring(0, startExtension);
        moduleList.add(modulename);
      }
    }
  }

  /**
   * Sets the htmlElementList attribute.
   * Reads the content of the file with all HTML elements.
   */
  private void setHtmlElementList() {
    htmlElementList = InputFile.textFileToList(htmlElementsFile);
  }

  /**
   * Gets the moduleList attribute.
   * @return the moduleList attribute.
   */
  public StringList getModuleList() {
    return moduleList;
  }

  /**
   * Gets the htmlElementList attribute.
   * @return the htmlElementList attribute.
   */
  public StringList getHtmlElements() {
    return htmlElementList;
  }

  /**
   * Gets the waebricDir attribute.
   * @return the waebricDir attribute.
   */
  public String getWaebricDir() {
    return waebricDir;
  }

  /**
   * Gets the waebricFileExtension attribute.
   * @return the waebricFileExtension attribute.
   */
  public String getWaebricFileExtension() {
    return waebricFileExtension;
  }

  /**
   * Gets the pathSeparator attribute.
   * @return the pathSeparator attribute.
   */
  public String getPathSeparator() {
    return pathSeparator;
  }
}
