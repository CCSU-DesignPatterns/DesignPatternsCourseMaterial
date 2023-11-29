package edu.ccsu.designpatterns.jsonreader;

import java.io.IOException;
import edu.ccsu.designpatterns.xmladapter.AppXmlException;
import edu.ccsu.designpatterns.xmladapter.AppXmlReader;

/**
 * An Object Adapter implemented using a Decorator approach, this class decorates a AppJSONReader by
 * adapting it to also being able to support an AppXmlReader interface
 * 
 * @author Chad Williams
 *
 */
public class XmlAdapterDecorator implements AppJSONReader, AppXmlReader {
  private AppJSONReader decoratedReader;

  public XmlAdapterDecorator(AppJSONReader jsonReader) {
    this.decoratedReader = jsonReader;
  }

  @Override
  public String readTag(String tag) {
    return getName(tag);
  }

  @Override
  public void loadXmlDocument(String fileName) throws AppXmlException {
    try {
      decoratedReader.loadJSONDocument(fileName);
    } catch (IOException ie) {
      throw new AppXmlException("Error loading JSON", ie);
    }
  }

  @Override
  public String getName(String name) {
    return decoratedReader.getName(name);
  }

  @Override
  public void loadJSONDocument(String fileName) throws IOException {
    decoratedReader.loadJSONDocument(fileName);
  }

  public static void main(String[] args) {
    try {
      AppJSONReader jsonReader = new AppJSONReaderImpl();
      jsonReader.loadJSONDocument("demo.json");
      System.out.println("AppName: " + jsonReader.getName("AppName"));
      System.out.println("AppAuthor: " + jsonReader.getName("AppAuthor"));
      System.out.println("AppCreationDate: " + jsonReader.getName("AppCreationDate"));

      // Doesn't actually read XML files, but provides interface to JSON as if XML
      AppXmlReader xmlReader = new XmlAdapterDecorator(jsonReader);
      System.out.println("AppName: " + xmlReader.readTag("AppName"));
      System.out.println("AppAuthor: " + xmlReader.readTag("AppAuthor"));
      System.out.println("AppCreationDate: " + xmlReader.readTag("AppCreationDate"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
