package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) throws Exception {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File dest = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, dest);
        ArrayList<File> list = new ArrayList<>();

        try (FileOutputStream writer = new FileOutputStream(dest)) {
            Files.walkFileTree(path.toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toFile().length() > 50) {
                        FileUtils.deleteFile(file.toFile());
                    } else {
                        list.add(file.toFile());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

            Collections.sort(list, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            for (File file : list) {
                if (!file.equals(dest)) {
                    FileReader reader = new FileReader(file);
                    while (reader.ready()) writer.write(reader.read());
                    reader.close();
                    writer.write("\n".getBytes());
                }
            }

            writer.close();
        }

    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    // метод рекурсивного прохода вглубь по переданной папке
    private static Map<String, File> getFileListToMap(File path) {
        Map<String, File> fileMap = new TreeMap<>();
        for (File file : path.listFiles()) {
            if (file.isFile()) { // базовый случай, текущий элемент файл
                if (file.length() < 50) { // если размер файла меньше 50 байт
                    fileMap.put(file.getName(), file); // то добавлю пару (имя файла : абс.путь к файлу) в мэп
                }
            }
            if (file.isDirectory()) { // если это дир а не файл, то рекурсивный вызов
                getFileListToMap(file);
            }
        }
        return fileMap;
    }

    // метод переименовывает файл
    private static File renameFile(File file) {
        if (FileUtils.isExist(file)) {
            String strPath = file.getParent() + "\\allFilesContent.txt";
            File newFileAbsPath = new File(strPath);
            FileUtils.renameFile(file, newFileAbsPath);
            return newFileAbsPath;
        }
        return null;
    }

    private static void writeFromFilesToSingleFile(File writeTo, Map<String, File> source) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeTo)))) {

            for (Map.Entry<String, File> pair : source.entrySet()) {
                File fileToRead = pair.getValue();
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileToRead)));
                    while (reader.ready()) {
                        String line = reader.readLine();
                        writer.write(line);
                        writer.newLine();
                        writer.flush();
                    }
                    reader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
