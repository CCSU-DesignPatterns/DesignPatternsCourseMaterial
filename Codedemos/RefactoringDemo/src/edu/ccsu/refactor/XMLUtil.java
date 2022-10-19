package edu.ccsu.refactor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Dummy class does something with passed class to create XML
 * 
 * @author Chad Williams
 */
public class XMLUtil {
	private Set<Field> fields = new HashSet<>();
	
	private XMLUtil(XMLEnabled passedObject) {
		Class<?> curClass = passedObject.getClass();
		while (curClass != Object.class) {
			fields.addAll(Arrays.asList(curClass.getDeclaredFields()));
			curClass = curClass.getSuperclass();
		}
	}
	
	public static String createXML(XMLEnabled passedObject) {
		XMLUtil util = new XMLUtil(passedObject);
		String returnXML = util.simpleAttributesToXML(passedObject);
		returnXML += util.complexAttributesToXML(passedObject);
		returnXML = util.classToXML(passedObject, returnXML);
		return returnXML;
	}

	private String simpleAttributesToXML(XMLEnabled passedObject) {
		StringBuffer buffer = new StringBuffer("<SIMPLE_ATTRIBUTES>");
		for (Field curField : fields) {
			if (curField.getType().getPackageName().equals("java.lang")){
				buffer.append("<FIELD>"+curField.getName()+"</FIELD>");
			}
		}
		buffer.append("</SIMPLE_ATTRIBUTES>");
		return buffer.toString();
	}

	private String complexAttributesToXML(XMLEnabled passedObject) {
		StringBuffer buffer = new StringBuffer("<COMPLEX_ATTRIBUTES>");
		for (Field curField : fields) {
			if (!curField.getType().getPackageName().equals("java.lang")){
				buffer.append("<FIELD>"+curField.getName()+"</FIELD>");
			}
		}
		buffer.append("</COMPLEX_ATTRIBUTES>");
		return buffer.toString();
	}

	private String classToXML(XMLEnabled passedObject, String baseXML) {
		StringBuffer buffer = new StringBuffer("<CLASS>");
		buffer.append("<NAME>"+passedObject.getClass().getName()+"</NAME>");
		buffer.append(baseXML);
		buffer.append("</CLASS>");
		return buffer.toString();
	}
}
