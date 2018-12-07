package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Path path = Paths.get(fileName);
        Properties properties = new Properties();

        try {
            properties.loadFromXML(Files.newInputStream(path));
        } catch (InvalidPropertiesFormatException e) {
            try {
                properties.load(Files.newBufferedReader(path));
            } catch (IOException ignored) {
            }
        } catch (IOException ignored) {
        }

        return properties;
//        Properties properties = new Properties();
//        Path path = Paths.get(fileName);
//
//        if (Files.notExists(path)) {
//            return properties;
//        }
//
//        if (fileName.endsWith(".xml")) {
//            try {
//                properties.loadFromXML(Files.newInputStream(path));
//            } catch (IOException e) {
//                return null;
//            }
//        } else if (Files.isDirectory(path)) {
//            return null;
//        } else {
//            try {
//                properties.load(Files.newBufferedReader(path));
//            } catch (IOException e) {
//                return null;
//            }
//        }
//        return properties;
    }
}