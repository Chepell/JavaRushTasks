package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Path path = Paths.get(root);
        List<String> resultList = new ArrayList<>();
        Files.walkFileTree(path, new Visitor(resultList)); // метод проходит по всему дереву переданного пути
        return resultList;
    }

    public static void main(String[] args) throws IOException {
        List<String> fileTree = getFileTree("E:\\Документы\\cloud\\Dropbox\\JavaRush\\JavaRushTasks\\testDir");
        fileTree.forEach(System.out::println);
    }

    // класс переопределения метода visitFile
    public static class Visitor extends SimpleFileVisitor<Path> {
        private List<String> list;

        public Visitor(List<String> list) {
            this.list = list;
        }
        // переопределение метода обхода папок вглубь
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE; // просто переход на следующую папку
        }
        // переопределение метода обхода файлов
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            list.add(file.toAbsolutePath().toString()); // абс.путь файла в виде строки добавляю в список
            return FileVisitResult.CONTINUE; // и перехожу на следующий файл
        }
    }
}