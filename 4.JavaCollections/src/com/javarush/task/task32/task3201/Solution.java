package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            // если длина файла, меньше чем место куда нужно поставить указатель
            if (randomAccessFile.length() < number) {
                // то ставлю указатель в конец файла
                randomAccessFile.seek(randomAccessFile.length());
            } else {
                randomAccessFile.seek(number);
            }
            // пишу текст, предварительно преобразовав его в массив байт
            randomAccessFile.write(text.getBytes());
        } catch (IOException e) {
            System.out.println("Error with file access!");
        }

    }
}
