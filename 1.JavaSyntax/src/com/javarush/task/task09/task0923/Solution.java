package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы из введённой строки.
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.
Пример ввода:
Мама мыла раму.

Пример вывода:
а а ы а а у
М м м л р м .


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить две строки.
3. Первая строка должна содержать только гласные буквы из введенной строки, разделенные пробелом.
4. Вторая строка должна содержать только согласные и знаки препинания из введенной строки, разделенные пробелом.
5. Каждая строка должна заканчиваться пробелом.
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        // объявляю объект для ввода с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // строка для сохранения ввода
        String str = reader.readLine();

        // строки для гластный и согластных
        String vowels = "";
        String consonants = "";

        // цикл for-each по строке
        // итерируюсь по char, а строку преобразую в массив символов
        for (char c : str.toCharArray()) {
            // если гластная
            if (isVowel(c) && !Character.isWhitespace(c)) {
                vowels = vowels + c + ' ';
            }
            // если согластная
            if (!isVowel(c) && !Character.isWhitespace(c)) {
                consonants = consonants + c + ' ';
            }
        }

//        // цикл по строке
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            // если гластная
//            if (isVowel(c) && c != ' ') {
//                vowels = vowels + c + ' ';
//            }
//            // если согластная
//            if (!isVowel(c) && c != ' ') {
//                consonants = consonants + c + ' ';
//            }
//        }

        System.out.println(vowels);
        System.out.println(consonants);
    }


    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}