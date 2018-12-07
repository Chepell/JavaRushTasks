package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            int length = text.length();
            byte[] buffer = new byte[length];

            // курсор на место чтения файла
            randomAccessFile.seek(number);

            // чтение из файла в буффер
            randomAccessFile.read(buffer, 0, length);
            // курсор в конец
            randomAccessFile.seek(randomAccessFile.length());
            // создание сроки из буфера
            String readStringFromFile = new String(buffer);
            // сравнение прочитанного с параметром
            if (text.equals(readStringFromFile)) {
                randomAccessFile.write("true".getBytes());
            } else {
                randomAccessFile.write("false".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}