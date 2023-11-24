package edu.ccsu.designpatterns.xmladapter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Adapts a SAX Parser approach to reading the XML file.
 * 
 * @author Chad Williams
 *
 */
public class SaxParserXmlAdapter implements AppXmlReader {
  private Map<String, String> elementValueMap = new HashMap();

  public SaxParserXmlAdapter() {

  }

  @Override
  public String readTag(String tag) {
    return elementValueMap.get(tag);
  }

  @Override
  public void loadXmlDocument(String fileName) throws AppXmlException {
    try {
      SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
      SAXParser saxParser = saxParserFactory.newSAXParser();
      saxParser.parse(new File(fileName), new AppXmlSAXHandler());
    } catch (Exception e) {
      throw new AppXmlException("JavaXml load error occured", e);
    }
  }

  private class AppXmlSAXHandler extends DefaultHandler {
    private static final String ROOT_NAME = "MyAppProperties";
    private String curTag = null;
    private String currentContent = null;

    public void startElement(String uri, String localName, String qName, Attributes atts)
        throws SAXException {
      if (!qName.equals(ROOT_NAME)) {
        curTag = qName;
      }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
      currentContent = (new String(ch)).substring(start, start + length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
      if (!qName.equals(ROOT_NAME)) {
        curTag = qName;
        elementValueMap.put(curTag, currentContent);
      }
    }
  }
}
