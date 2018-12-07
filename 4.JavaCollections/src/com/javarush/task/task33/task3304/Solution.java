package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
	public static void main(String[] args) throws IOException {
		Second s = (Second) convertOneToAnother(new First(), Second.class);
		First f = (First) convertOneToAnother(new Second(), First.class);
	}

	public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
		StringWriter writer = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(writer, one); // сериализую объект в поток строки
		// вытаскиваю имена классов
		String oneClassName = one.getClass()
								 .getSimpleName()
								 .toLowerCase();
		String resClassName = resultClassObject.getSimpleName()
											   .toLowerCase();
		// сериализованный объект конвертирую в строку и ищу имя для замены
		String replaceStr = writer.toString()
								  .replaceFirst(oneClassName, resClassName);
		StringReader reader = new StringReader(replaceStr);
		return mapper.readValue(reader, resultClassObject);
	}

	//	@JsonAutoDetect
	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
	@JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
	public static class First {
		public int i;
		public String name;
	}

	//	@JsonAutoDetect
	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
	@JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
	public static class Second {
		public int i;
		public String name;
	}
}