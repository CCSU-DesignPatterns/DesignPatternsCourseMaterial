package edu.ccsu.designpatterns.xmladapter;

import edu.ccsu.designpatterns.jsonreader.AppJSONReaderImpl;
import edu.ccsu.designpatterns.jsonreader.XmlAdapterDecorator;

/**
 * Simple demo of how our app can now interfact with an interface completely independent of what
 * third party library is being used for the call.
 * 
 * @author Chad Williams
 *
 */
public class Main {

  /**
   * Demonstrates reading properties file with two different parsers adapted to the same interface
   * 
   * @param args No arguments are needed.
   */
  public static void main(String[] args) {
    try {
      String xmlDoc = "demo.xml";
      AppXmlReader reader = new DocumentBuilderXmlAdapter();
      reader.loadXmlDocument(xmlDoc);
      System.out.println("AppName: " + reader.readTag("AppName"));
      System.out.println("AppAuthor: " + reader.readTag("AppAuthor"));
      System.out.println("AppCreationDate: " + reader.readTag("AppCreationDate"));

      // Now with SAX parser without changing the way we interact with the underlying library
      reader = new SaxParserXmlAdapter();
      reader.loadXmlDocument(xmlDoc);
      System.out.println("AppName: " + reader.readTag("AppName"));
      System.out.println("AppAuthor: " + reader.readTag("AppAuthor"));
      System.out.println("AppCreationDate: " + reader.readTag("AppCreationDate"));

      // Now load JSON file, but use decorator adapter so same code still works
      reader = new XmlAdapterDecorator(new AppJSONReaderImpl());
      reader.loadXmlDocument("demo.json");
      System.out.println("AppName: " + reader.readTag("AppName"));
      System.out.println("AppAuthor: " + reader.readTag("AppAuthor"));
      System.out.println("AppCreationDate: " + reader.readTag("AppCreationDate"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
