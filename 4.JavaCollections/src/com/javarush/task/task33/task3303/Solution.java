package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/
public class Solution {
	// метод параметризован <T> и возвращает объект типа Т
	public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		T t = mapper.readValue(new File(fileName), clazz);
		return t;
	}

	public static void main(String[] args) {

	}
}