package Com.Util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class Xmlutil {
	public static Document getDocument() throws Exception {
		// 1.��������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 2.�õ�dom������
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 3.����xml�ļ����õ������ĵ���document
		Document document = builder.parse("Student.xml");
		return document;
	}

	public static void WritetoXml(Document document)throws TransformerFactoryConfigurationError,TransformerConfigurationException, TransformerException,FileNotFoundException {
		TransformerFactory faTransformerFactory = TransformerFactory.newInstance();
		Transformer transformer = faTransformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream("Student.xml")));
	}
}
