package edu.ccsu.designpatterns.bridge.implementation;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlRepositoryImpl extends FileBasedRepositoryImpl {

  public XmlRepositoryImpl(String repositoryName, List<String> itemMetaData) {
    super(repositoryName, itemMetaData);
  }

  @Override
  public void persist() throws RepoPersistException {
    Document document;
    try {
      document = repositoryToXmlDocument();
      String xmlDocumentString = toString(document);
      writeToFile(xmlDocumentString);
    } catch (Exception e) {
      System.err.println("Error writing repository (" + getFileName() + ")");
      e.printStackTrace();
      throw new RepoPersistException("Error writing repository (" + getFileName() + ")", e);
    }
  }

  private Document repositoryToXmlDocument() throws ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    builder = factory.newDocumentBuilder();
    Document document = builder.newDocument();
    Element root = (Element) document.createElement("REPOSITORY");
    root.setAttribute("repositoryName", repositoryName);
    document.appendChild(root);
    Set<Map.Entry<String, List<String>>> recordEntries = records.entrySet();
    // Convert each record to a XML record
    for (Map.Entry<String, List<String>> entry : recordEntries) {
      Element curElement = (Element) document.createElement("RECORD");
      Element idElement = (Element) document.createElement(itemMetaData.get(0));
      idElement.setTextContent(entry.getKey());
      curElement.appendChild(idElement);
      for (int index = 1; index < itemMetaData.size(); index++) {
        Element curValueElement = (Element) document.createElement(itemMetaData.get(index));
        curValueElement.setTextContent(entry.getValue().get(index - 1));
        curElement.appendChild(curValueElement);
      }
      root.appendChild(curElement);
    }
    return document;
  }

  @Override
  public void load() throws RepoLoadException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    try {
      builder = factory.newDocumentBuilder();
      Document xmlDocument = builder.parse(new File(super.getFileName()));
      NodeList recordNodes = xmlDocument.getElementsByTagName("RECORD");
      for (int i = 0; i < recordNodes.getLength(); i++) {
        Node curRecord = recordNodes.item(i);
        NodeList valueNodes = curRecord.getChildNodes();
        // Read record
        String id = "";
        List<String> values = new ArrayList<String>();
        for (int valueIndex = 0; valueIndex < valueNodes.getLength(); valueIndex++) {
          String value = valueNodes.item(valueIndex).getFirstChild().getNodeValue();
          if (valueIndex == 0) {
            id = value;
          } else {
            values.add(value);
          }
        }
        addRecord(id, values);
      }
    } catch (Exception e) {
      System.err.println("Error reading from repository (" + getFileName() + ")");
      e.printStackTrace();
      throw new RepoLoadException("Error reading from repository (" + getFileName() + ")", e);
    }
  }

  public String toString() {
    Document xmlDocument;
    String xmlString = "";
    try {
      xmlDocument = repositoryToXmlDocument();
      xmlString = toString(xmlDocument);
    } catch (Exception e) {
      System.err.println("Error creating repo XML: " + e.getMessage());
      e.printStackTrace();
    }
    return xmlString;
  }

  private String toString(Document xmlDocument) throws TransformerException {
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer;
    String xmlString = "";
    transformer = tf.newTransformer();
    StringWriter writer = new StringWriter();
    transformer.transform(new DOMSource(xmlDocument), new StreamResult(writer));
    xmlString = writer.getBuffer().toString();
    return xmlString;
  }

  @Override
  protected String getFileFormatExtension() {
    return ".xml";
  }

}
