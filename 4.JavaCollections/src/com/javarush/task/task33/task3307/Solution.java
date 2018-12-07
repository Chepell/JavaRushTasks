package com.javarush.task.task33.task3307;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.io.StringReader;

/* 
Десериализация XML объекта
*/
public class Solution {
	public static void main(String[] args) throws IOException, JAXBException {
		String xmlData = "<cat><name>Murka</name><age>5</age><weight>4</weight></cat>";
		Cat cat = convertFromXmlToNormal(xmlData, Cat.class);
		System.out.println(cat);
	}

	// параметризированнй метод <T> возвращающий Т, и принимающий класс в параметрах
	public static <T> T convertFromXmlToNormal(String xmlData, Class<T> clazz) throws IOException, JAXBException {
		StringReader reader = new StringReader(xmlData); // конвертирую строку в ридер
		JAXBContext context = JAXBContext.newInstance(clazz); // создаю контекст на основе класса
		Unmarshaller unmarshaller = context.createUnmarshaller(); // из контекста создаю десериализатор
		T obj = (T) unmarshaller.unmarshal(reader); // сама десериализация конкретного объекта
		return obj;
	}

	@XmlRootElement
	@XmlType(name = "cat")
	public static class Cat {
		public String name;
		public int age;
		public int weight;

		@Override
		public String toString() {
			return "Cat{" +
					"name='" + name + '\'' +
					", age=" + age +
					", weight=" + weight +
					'}';
		}
	}
}

//В метод convertFromXmlToNormal первым параметром приходит строка, содержащая xml объект.
//Вторым параметром приходит класс, объект которого необходимо вернуть.
//Метод convertFromXmlToNormal должен создать объект из xml-строки и вернуть его.
//
//
//Требования:
//1. В методе convertFromXmlToNormal должен быть создан новый объект типа JAXBContext с помощью
// статического метода JAXBContext.newInstance, в качестве параметра используй целевой класс.
//2. В методе convertFromXmlToNormal должен быть создан новый объект типа Unmarshaller
// с помощью метода createUnmarshaller вызванного на объекте типа JAXBContext.
//3. Метод convertFromXmlToNormal должен корректно преобразовывать входящую xml строку в объект требуемого класса.
//4. Метод convertFromXmlToNormal должен быть статическим.
