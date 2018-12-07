package com.javarush.task.task33.task3309;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/*
Комментарий внутри xml
*/
public class Solution {
	public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException, TransformerException, IOException, SAXException {
//		StringWriter writer = new StringWriter();
//
//		JAXBContext jc = JAXBContext.newInstance(obj.getClass());
//		String fullComment = "<!--" + comment + "-->";
//
//		Marshaller marshaller = jc.createMarshaller();
//		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//		marshaller.marshal(obj, writer);
//		String string = writer.toString();
//		String[] split = string.split("\n");
//		List<String> lines = new ArrayList<>();
//
//		for (int i = 0; i < split.length; i++) {
//			String line = split[i];
//			if (line.contains("<" + tagName + ">")) {
//				lines.add(fullComment);
//				lines.add(line);
//			} else {
//				lines.add(line);
//			}
//		}
//
//		StringBuilder builder = new StringBuilder();
//		for (int i = 0; i < lines.size(); i++) {
//			builder.append(lines.get(i));
//			if (i < lines.size() - 1) builder.append(System.lineSeparator());
//		}
//		return builder.toString();

		StringWriter writer = new StringWriter();

		JAXBContext jc = JAXBContext.newInstance(obj.getClass());
		String fullComment = "<!--" + comment + "-->";
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(obj, writer);

		// create a new DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// use the factory to create a documentbuilder
		DocumentBuilder builder = factory.newDocumentBuilder();

		// create a new document from input source
		InputSource is = new InputSource(new StringReader(writer.toString()));
		Document doc = builder.parse(is);

		NodeList ourTags = doc.getElementsByTagName(tagName);
		for (int i = 0; i < ourTags.getLength(); i++) {
//			System.out.println(ourTags.item(i).s);
		}


		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		//initialize StreamResult with File object to save to file
		StreamResult result = new StreamResult(new StringWriter());
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);

		String xmlString = result.getWriter().toString();
		return xmlString;
	}

	public static void main(String[] args) throws JAXBException, IOException, SAXException, ParserConfigurationException, TransformerException {
		Animal rich = new Animal("Rich", 8);
		String s = toXmlWithComment(rich, "name", "Fuck this shit!");
		System.out.println(s);

	}

	@XmlType(name = "animal")
	@XmlRootElement
	public static class Animal {
		String name;
		int age;

		public Animal() {
		}

		public Animal(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@XmlElement
		public String getName() {
			return name;
		}

		@XmlElement
		public int getAge() {
			return age;
		}
	}

}


//Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
//В строке перед каждым тегом tagName должен быть вставлен комментарий comment.
//Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.
//
//Пример вызова:
//toXmlWithComment(firstSecondObject, "second", "it's a comment")
//
//Пример результата:
//<?xml version="1.0" encoding="UTF-8" standalone="no"?>
//<first>
//<!--it's a comment-->
//<second>some string</second>
//<!--it's a comment-->
//<second>some string</second>
//<!--it's a comment-->
//<second><![CDATA[need CDATA because of < and >]]></second>
//<!--it's a comment-->
//<second/>
//</first>
//
//
//Требования:
//1. Метод toXmlWithComment должен быть статическим.
//2. Метод toXmlWithComment должен быть публичным.
//3. Если во входящем xml отсутствует искомый тег, то добавлять комментарии не нужно.
//4. Количество комментариев вставленных в xml должно быть равно количеству тегов tagName.
//5. Метод toXmlWithComment должен возвращать xml в виде строки преобразованной в соответствии с условием задачи.
