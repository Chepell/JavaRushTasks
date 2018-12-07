package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
С консоли считать имя файла.
Посчитать в файле количество символов ',', количество вывести на консоль.
Закрыть потоки.

Подсказка:
нужно сравнивать с ascii-кодом символа ','.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должно выводится число запятых в считанном файле.
4. Поток чтения из файла должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        // создаю поток побайтового чтения из файла
        FileInputStream inputStream = new FileInputStream(fileName);

        // переменная под счетчик количества запятых в файле
        int commaCount = 0;

        // цикл чтения побайтово, пока они есть
        while (inputStream.available() > 0) {
            // если считанный байт равен 44, то значит что это запятая в ascii таблице кодов
            if (inputStream.read() == 44) {
                // инкрементирую счетчик
                commaCount++;
            }
        }
        // закрываю поток чения из файла
        inputStream.close();
        // вывожу на консоль количество запятых в файле
        System.out.println(commaCount);
    }
}
