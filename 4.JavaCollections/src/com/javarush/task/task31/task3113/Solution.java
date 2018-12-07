package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        // использую try-with-resources
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Path path = Paths.get(reader.readLine()); // читаю путь директории из консоли
            if (!Files.isDirectory(path)) System.out.printf("%s - не папка", path); // проверяю если прочитана не папка

            Visitor visitor = new Visitor(); // создаю объект класса обхода
            Files.walkFileTree(path, visitor); // вызываю метод обхода

            System.out.printf("Всего папок - %d%n", visitor.getTotalDirs() - 1); // -1, без учета текущей папки
            System.out.printf("Всего файлов - %d%n", visitor.getTotalFiles());
            System.out.printf("Общий размер - %d%n", visitor.getTotalSize());
        }
    }
}

// реализация класса обхода пути
class Visitor extends SimpleFileVisitor<Path> {
    private int totalDirs = 0;
    private int totalFiles = 0;
    private int totalSize = 0;

    int getTotalDirs() {
        return totalDirs;
    }

    int getTotalFiles() {
        return totalFiles;
    }

    int getTotalSize() {
        return totalSize;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        totalDirs++;
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        totalFiles++;
        totalSize += Files.size(file);
        return CONTINUE;
    }
}