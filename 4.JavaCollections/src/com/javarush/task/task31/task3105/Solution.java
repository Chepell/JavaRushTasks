package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zipFileName = args[1];
        Path pathFile = Paths.get(fileName);
        Path pathZip = Paths.get(zipFileName);
        Map<String, ByteArrayOutputStream> archivedFiles = new HashMap<>();

        // считывание файлов из архива в мэп
        try (ZipInputStream zipReader = new ZipInputStream(Files.newInputStream(pathZip))) {
            ZipEntry entry;
            ByteArrayOutputStream byteArrayOutputStream;
            // цикл продолжается, пока есть следующая зип запись в архиве
            while ((entry = zipReader.getNextEntry()) != null) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                 // такую конструкцию нельзя использовать "while (zipReader.available() > 0)",
                // выдает IndexOutOfBoundsException !!!
                int count;
                // цикл продолжается, пока получайется считать байты в буфферный массив
                while ((count = zipReader.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, count);
                }
                // имя файла и массив байт добавлю в мэп в качестве пары
                archivedFiles.put(entry.getName(), byteArrayOutputStream);
            }
        }

        // запись файлов в архив
        try (ZipOutputStream zipWriter = new ZipOutputStream(Files.newOutputStream(pathZip))) {
            // добавляю новую запись в архив, в конструкторе указываю относительный путь который будет внутри архива
            ZipEntry zipEntry = new ZipEntry("new/" + pathFile.getFileName());
            zipWriter.putNextEntry(zipEntry); // добавляю запись
            Files.copy(pathFile, zipWriter); // добавляю сам файл

            for (Map.Entry<String, ByteArrayOutputStream> pair : archivedFiles.entrySet()) {
                String name = pair.getKey(); // относительный путь к файлу внутри архива
                // проверяю имя файла, без относительного пути
                if (name.substring(name.lastIndexOf("/") + 1).equals(pathFile.getFileName().toString())) continue;
                zipWriter.putNextEntry(new ZipEntry(name));
                zipWriter.write(pair.getValue().toByteArray());
            }
        }
    }
}