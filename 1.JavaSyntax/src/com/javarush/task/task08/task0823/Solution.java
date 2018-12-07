package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

// Программа должна выводить текст на экран.
// Программа должна считывать строку с клавиатуры.
// Класс Solution должен содержать один метод.
// Программа должна заменять в тексте первые буквы всех слов на заглавные.

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine(); //"hello! i am fine";//

        // переменная под хранение оригинальной строки
        String tmp = s;
        // огинальную строку обнуляю, что бы писать туда измененные символы
        s = "";

        // циклом иду по копии строки
        for (int i = 0; i < tmp.length(); i++) {
            // символ в текущем индексе
            char c = tmp.charAt(i);

            // первый символ строки
            if (i == 0) {
                // меняю регистр символа
                char big = Character.toUpperCase(c);
                // добавляю измененный символ в строку
                s += big;
                // любой символ после проблела,
                // смотрю что предыдущий символ в строке был пробелом
            } else if (i > 0 && Character.isWhitespace(tmp.charAt(i - 1))) {
                // меняю регистр символа
                char big = Character.toUpperCase(c);
                // добавляю измененный символ в строку
                s += big;
                // все остальные символы
            } else {
                // добавляю символ в строку
                s += c;
            }
        }
        System.out.println(s);
    }
}


