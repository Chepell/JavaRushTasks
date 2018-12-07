package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуй логику записи в файл и чтения из файла для карты properties.


Требования:
1. Метод fillInPropertiesMap должен считывать данные с консоли.
2. Метод fillInPropertiesMap должен создавать FileInputStream, передавая считанную строку в качестве параметра.
3. Метод fillInPropertiesMap должен вызывать метод load передавая только что созданный FileInputStream в качестве параметра.
4. Метод save должен сохранять карту properties в полученный в качестве параметра объект типа OutputStream.
5. Метод load должен восстанавливать состояние карты properties из полученного в качестве параметра объекта типа InputStream.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        InputStream inputStream = new FileInputStream(fileName);

        load(inputStream);

        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        // создаю объект свойств
        Properties propertiesToFile = new Properties();
        // добавляю в объект свойств сразу все пары параметров
        propertiesToFile.putAll(properties);
        // методом store() сохраняю данные во внешний поток
        propertiesToFile.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        // создаю объект свойств
        Properties prop = new Properties();
        // загружаю свойства из файлового потока
        prop.load(inputStream);
        // помещаю пары из объекта свойств в map
        prop.forEach((k, v) -> properties.put((String) k, (String) v));
    }

    public static void main(String[] args) throws Exception {

        // создаю объект класса
        Solution solution = new Solution();
        // вызываю метод заполнения мэпа из файла
        solution.fillInPropertiesMap();
        // вывожу мэп на экран
        properties.forEach((k, v) -> System.out.println(k + ":" + v));

        OutputStream outputStream = new FileOutputStream("prop2.properties");
        solution.save(outputStream);
        outputStream.close();


    }
}
