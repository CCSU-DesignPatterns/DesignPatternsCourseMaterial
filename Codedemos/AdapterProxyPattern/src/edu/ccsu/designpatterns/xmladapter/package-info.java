/**
 * This package contains an example of the adapter pattern. The AppXmlReader and AppXmlException
 * represent the interface the application wants to use for interacting with the XML document for
 * the application. There are then two classes that adapt two different XML document reading
 * libraries so that from the application's perspective it is oblivious as to another library being
 * used not to mention which library is being used as.
 * 
 * The DocumentBuilderXMLAdapter provides an example of adapting the DOM DocumentBuilder parser to
 * the application's interface and the SaxParserXMLAdapter provides an example of adapting a
 * SAXParser to the same applicaiton interface so my application is not at all dependent on the
 * actual 3rd party library used.
 * 
 * @author Chad Williams
 *
 */
package edu.ccsu.designpatterns.xmladapter;
