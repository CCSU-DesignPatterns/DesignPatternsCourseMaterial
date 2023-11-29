package edu.ccsu.designpatterns.jsonreader;

import edu.ccsu.designpatterns.xmladapter.AppXmlException;
import edu.ccsu.designpatterns.xmladapter.AppXmlReader;

/**
 * A Class Adapter approach, this class extends the class adapting it to also being able to support
 * an AppXmlReader interface
 * 
 * @author Chad Williams
 *
 */
public class XmlClassAdapter extends AppJSONReaderImpl implements AppXmlReader {


  @Override
  public String readTag(String tag) {
    return getName(tag);
  }

  @Override
  public void loadXmlDocument(String fileName) throws AppXmlException {
    throw new RuntimeException("Xml Load not supported currently");

  }

}
