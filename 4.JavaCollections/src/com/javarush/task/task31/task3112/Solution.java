package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // из строки создаю url
        URL url = new URL(urlString);
        // из url достаю только путь ниже домена, содаю на его основе Path, а затем вытаскиваю только имя файла
        Path fileName = Paths.get(url.getFile()).getFileName();
        // сцепляю папку для закачки и имя конечного файла в один объект Path
        Path path = downloadDirectory.resolve(fileName);
        // на основе пути создаю конечный файл
        Path file = Files.createFile(path);
        // создаю входящий поток чтения из сети конкретного файла
        InputStream is = url.openStream();
        // создаю временный файл
        Path tempFile = Files.createTempFile("", ".tmp");
        // читаю из сети во временный файл
        Files.copy(is, tempFile, StandardCopyOption.REPLACE_EXISTING);
        // перемещаю из временного в конечный файл
        Files.move(tempFile, file, StandardCopyOption.REPLACE_EXISTING);
        // возвращаю путь к конечному файлу
        return file;
    }
}
