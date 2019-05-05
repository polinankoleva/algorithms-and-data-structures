package com.tasks;

import java.util.HashMap;
import java.util.List;

/**
 * Since XML is very verbose, you are given a way of encoding it where each tag
 * gets mapped to a pre-defined integer value.Write code to print the encoded
 * version of an XML element (passed in Element and Attribute objects). Task
 * 16.12 CCI.
 * 
 * @author Polina Koleva
 *
 */
public class XMLEncoding {

}

class XMLElementParent {
	String tag;

	public int getTagMapping(String tag) {
		return TagsMapping.getInstance().mappings.get(tag);
	}
}

class XMLElement extends XMLElementParent {
	List<XMLAttribute> attributes;
	List<XMLElement> children;

	public String encode() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getTagMapping(tag));
		attributes.forEach(a -> {
			sb.append(" " + a.encode());
		});
		// append end
		sb.append(" " + 0);
		children.forEach(child -> {
			sb.append(" " + child.encode());
		});
		sb.append(" " + 0);
		return sb.toString();
	}
}

class XMLAttribute extends XMLElementParent {
	String value;

	public XMLAttribute(String tag, String value) {
		this.tag = tag;
		this.value = value;
	}

	public String encode() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getTagMapping(tag) + " ");
		sb.append(this.value);
		return sb.toString();
	}
}

class TagsMapping {

	private static TagsMapping instance = null;
	public HashMap<String, Integer> mappings;

	public static TagsMapping getInstance(HashMap<String, Integer> mappings) {
		if (instance == null) {
			instance = new TagsMapping();
			instance.mappings = mappings;
			return instance;
		}
		return instance;
	}

	public static TagsMapping getInstance() {
		if (instance == null) {
			System.err.println(
					"No mappings given. Please initialize the object with mappings by invokation of getInstance(Map)");
		}
		return instance;
	}

}