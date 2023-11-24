package edu.ccsu.designpatterns.xmladapter;

/**
 * Interface the application wants to use for reading the XML properties that is independent of
 * whatever 3rd party library we use for the actual reading of the file.
 * 
 */
public interface AppXmlReader {
  /**
   * Specify the property to get the value
   * 
   * @param tag Tag value to return
   * @return Value between this tag in the XML
   */
  public String readTag(String tag);

  /**
   * Parses and loads the Xml document to allow the tags to be read
   * 
   * @param fileName File name to read
   * @throws AppXmlException An exception occurred trying to read the Xml document
   * 
   * @author Chad Williams
   *
   */
  public void loadXmlDocument(String fileName) throws AppXmlException;
}
