package edu.ccsu.designpatterns.jsonreader;

import java.io.IOException;
import edu.ccsu.designpatterns.xmladapter.AppXmlException;

/**
 * Interface for application's JSON reader
 * 
 * @author Chad Williams
 *
 */
public interface AppJSONReader {
  /**
   * Specify the property to get the value
   * 
   * @param tag Tag value to return
   * @return Value between this tag in the XML
   */
  public String getName(String name);

  /**
   * Parses and loads the Xml document to allow the tags to be read
   * 
   * @param fileName File name to read
   * @throws AppXmlException An exception occurred trying to read the Xml document
   * 
   * @author Chad Williams
   * @throws IOException
   *
   */
  public void loadJSONDocument(String fileName) throws IOException;
}
