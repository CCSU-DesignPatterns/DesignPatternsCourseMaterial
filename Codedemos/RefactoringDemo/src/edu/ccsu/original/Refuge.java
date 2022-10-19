package edu.ccsu.original;


public class Refuge extends Land {
  protected String name;
  private XMLUtil xmlUtil = new XMLUtil();

  public String toXML() {
    String returnXML = xmlUtil.simpleAttributesToXML(this);
    returnXML += xmlUtil.complexAttributesToXML(this);
    returnXML = xmlUtil.classToXML(this, returnXML);
    return returnXML;
  }
}

