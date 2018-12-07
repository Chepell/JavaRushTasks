package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.


Требования:
1. Программа НЕ должна считывать данные с клавиатуры.
2. Программа НЕ должна выводить данные на экран.
3. Программа должна записывать данные в файл.
4. Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // проверка, что введено два параметра в командной строке
        if (args.length != 2) {
            System.out.println("You must input two parameters");
            System.exit(1);
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        // реализация в блоке try-with-resources
        try (InputStream inputStream = new FileInputStream(inputFileName);
             OutputStream outputStream = new FileOutputStream(outputFileName)) {

            // кодировки
            Charset charsetIn = Charset.forName("Windows-1251");
            Charset charsetOut = Charset.forName("UTF-8");

            // буффер под весь файл
            byte[] buffer = new byte[inputStream.available()];
            // читаю файл в буффер
            inputStream.read(buffer);
            // конвертирую буффер в строку используя кодировку
            String bufferString = new String(buffer, charsetIn);
            // теперь назад в буфер помещаю строку в нужной кодировке
            buffer = bufferString.getBytes(charsetOut);
            // пишу буфер в файл
            outputStream.write(buffer);
        }
    }
}

