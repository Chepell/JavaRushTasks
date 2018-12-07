package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться минимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        // переменная под минимальный байт прочитанный в файле, записываю первый байт файла
        int minByte = inputStream.read();

        // цикл чтения файлового потока, пока есть доступные байты для чтения
        while (inputStream.available() > 0) {
            // сохраняю прочитанный байт в переменную
            int readByte = inputStream.read();
            // проверяю, если прочитанный байт меньше сохраненного,
            // то переписываю значение минимального байта
            if (readByte < minByte) {
                minByte = readByte;
            }
        }
        // закрываю поток чтения файла
        inputStream.close();

        System.out.println(minByte);
    }
}
