package com.java.jdbc.common;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XMLHelper {
	public static JdbcConnParam GetConnParam() throws Exception {
		JdbcConnParam result = new JdbcConnParam();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse("src/com/java/jdbc/common/sqlcon.xml");
		
		result.setDbtype(((Element)(doc.getElementsByTagName("type").item(0))).getTextContent());
		result.setHost(((Element)(doc.getElementsByTagName("host").item(0))).getTextContent());
		result.setPort(((Element)(doc.getElementsByTagName("port").item(0))).getTextContent());
		result.setDbname(((Element)(doc.getElementsByTagName("dbname").item(0))).getTextContent());
		result.setUsername(((Element)(doc.getElementsByTagName("username").item(0))).getTextContent());
		result.setPassword(((Element)(doc.getElementsByTagName("password").item(0))).getTextContent());
		
		return result;
	}
}
