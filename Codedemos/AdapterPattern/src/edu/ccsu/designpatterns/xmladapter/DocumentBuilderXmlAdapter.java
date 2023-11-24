package edu.ccsu.designpatterns.xmladapter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Adapts a XML DocumentBuilder approach to reading the XML file.
 * 
 * @author Chad Williams
 *
 */
public class DocumentBuilderXmlAdapter implements AppXmlReader {
  private Document document = null;

  public DocumentBuilderXmlAdapter() {

  }

  @Override
  public String readTag(String tag) {
    if (document == null) {
      throw new RuntimeException("No document has been loaded");
    } else {
      NodeList nodeList = document.getElementsByTagName(tag);
      Node firstNode = nodeList.item(0);
      return firstNode.getTextContent();
    }
  }

  @Override
  public void loadXmlDocument(String fileName) throws AppXmlException {
    try {
      DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
      document = docBuilder.parse(fileName);
    } catch (Exception e) {
      throw new AppXmlException("JavaXml load error occured", e);
    }
  }
}
