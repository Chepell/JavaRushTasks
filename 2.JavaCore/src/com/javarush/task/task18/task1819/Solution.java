package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения и считай его содержимое.
3. Затем, для первого файла создай поток для записи. Для второго - для чтения.
4. Содержимое первого и второго файла нужно объединить в первом файле.
5. Сначала должно идти содержимое второго файла, затем содержимое первого.
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName01 = reader.readLine();
        String fileName02 = reader.readLine();
        reader.close();

        // поток для чтения из первого файла
        FileInputStream inputStreamFile01 = new FileInputStream(fileName01);

        // поток для чтения из второго файла
        FileInputStream inputStreamFile02 = new FileInputStream(fileName02);
        // переменные для хранения длин массивов
        int len01 = inputStreamFile01.available();
        int len02 = inputStreamFile02.available();
        // создаю буфферы для первого и второго файла
        byte[] buffer01 = new byte[len01];
        byte[] buffer02 = new byte[len02];
        // читаю файлы в буфферы
        inputStreamFile01.read(buffer01);
        inputStreamFile02.read(buffer02);
        // закрываю потоки
        inputStreamFile01.close();
        inputStreamFile02.close();

        // итоговый общий массив
        byte[] buffer = new byte[len01 + len02];

        // читаю второй буффер и записываю в общий
        for (int i = 0; i < len02; i++) {
            buffer[i] = buffer02[i];
        }
        // читаю первый буффер и записываю в общий начиная с конца
        for (int i = 0; i < len01; i++) {
            buffer[i + len02] = buffer01[i];
        }

        // полок для записи в первый файл
        FileOutputStream outputStreamFile01 = new FileOutputStream(fileName01);

        outputStreamFile01.write(buffer);
        outputStreamFile01.close();
    }
}
//        // буффер для чтения/записи файлов размером 64 Кбайт
//        byte[] buffer = new byte[65536];
//
//
//        ///***///
//        FileInputStream inputStreamFile01 = new FileInputStream(fileName01);
//        FileOutputStream outputStreamTempFile = new FileOutputStream("tempFile.txt");
//
//        // сохраняю содержимое первого файла во временный файл
//        while (inputStreamFile01.available() > 0) {
//            int count = inputStreamFile01.read(buffer);
//            outputStreamTempFile.write(buffer, 0, count);
//        }
//        // закрываю потоки
//        inputStreamFile01.close();
//        outputStreamTempFile.close();
//
//        ///***///
//        FileInputStream inputStreamFile02 = new FileInputStream(fileName02);
//        FileOutputStream outputStreamOverwrite = new FileOutputStream(fileName01);
//
//        // читаю из второго файла и перезаписываю первый файл
//        while (inputStreamFile02.available() > 0) {
//            int count = inputStreamFile02.read(buffer);
//            outputStreamOverwrite.write(buffer, 0, count);
//        }
//
//        // закрываю потоки
//        inputStreamFile02.close();
//        outputStreamOverwrite.close();
//
//        ///***///
//        FileInputStream inputStreamTempFile = new FileInputStream("tempFile.txt");
//        FileOutputStream outputStreamAppend = new FileOutputStream(fileName01, true);
//
//        // читаю из временного файла и дозаписываю в первый файл
//        while (inputStreamTempFile.available() > 0) {
//            int count = inputStreamTempFile.read(buffer);
//            outputStreamAppend.write(buffer, 0, count);
//        }
//
//        // закрываю потоки
//        inputStreamTempFile.close();
//        outputStreamAppend.close();
//    }

