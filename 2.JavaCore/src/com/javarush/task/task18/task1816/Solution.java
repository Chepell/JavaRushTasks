package com.javarush.task.task18.task1816;

/* 
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int charCount = 0;

        // цикл читает побайтово, пока есть доступные байты
        while (inputStream.available() > 0) {
            // считанный байт downcasting к символу
            char ch = (char) inputStream.read();
//            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
//                charCount++;
//            }
            // или просто по десятичному числовому аналогу символа
            int num = inputStream.read();
            if ((num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
                charCount++;
            }
        }
        inputStream.close();
        System.out.println(charCount);

    }
}
