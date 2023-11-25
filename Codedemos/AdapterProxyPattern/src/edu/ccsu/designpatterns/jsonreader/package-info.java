/**
 * This package provides an example of using a Decorator to implement the Adapter pattern to
 * effectively add support for an additional interface to an existing class.
 * 
 * The JSON reader has a different set of methods than the Xml reader, but by using the
 * XmlAdapterDecorator the AppXmlReader interface can be added to the Json reader allowing it to
 * more easily be swapped into places the other was being used. Example of it's use is in:
 * 
 * @see edu.ccsu.designpatterns.xmladapter.Main
 * 
 * 
 * @author Chad Williams
 *
 */
package edu.ccsu.designpatterns.jsonreader;
