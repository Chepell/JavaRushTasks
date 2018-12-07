package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // объект буффера для ввода строк
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит в строку
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        // объявление массива символов и инициалиазация его строкой конвертированной в символы
        char[] abcArray = abc.toCharArray();

        // объявление списка символов алфавита
        ArrayList<Character> alphabet = new ArrayList<>();
        // наполняю его в цикле из массива
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        // прохожу циклом по массиву алфафита
        for (Character c : alphabet) {
            // текущий символ кладу в переменную
            // т.к. replaceAll требует строку а не символ,
            // преобразую переменную к строке
            String ch = c.toString();
            // переменная для счетчика повторений букв
            int control = 0;
            // внуренний цикл по массиво введенных слов
            for (String str : list) {
                // на каждом слове применяю к строке replaceAll замена
                // текущей буквы с верхнего цикла на ничего, во всей строке
                // затем беру длину этой новой строки и вычитаю ее из длины базовой строки
                control += str.length() - str.replaceAll(ch, "").length();
            }
            // по окончании внутреннего цикла сразу вывожу на печать строку
            System.out.println(c + " " + control);
        }


//        // объявляю лист для хранения количества повторов каждой буквы
//        // т.к. понятно что букв 33, обявляю его начальный размер
//        ArrayList<Integer> counter = new ArrayList<>(33);
//
//        // прохожу циклом по массиву алфафита
//        for (Character c : alphabet) {
//            // текущий символ кладу в переменную
//            // т.к. replaceAll требует строку а не символ,
//            // преобразую переменную к строке
//            String ch = c.toString();
//            // переменная для счетчика повторений букв
//            int control = 0;
//            // внуренний цикл по массиво введенных слов
//            for (String str : list) {
//                // на каждом слове применяю к строке replaceAll замена
//                // текущей буквы с верхнего цикла на ничего, во всей строке
//                // затем беру длину этой новой строки и вычитаю ее из длины базовой строки
//                control += str.length() - str.replaceAll(ch, "").length();
//            }
//            // по окончании внутреннего цикла добавляю значение текущего счетчика в список
//            counter.add(control);
//        }
//
//        // конвертирую лист повторений букв в массив
//        Integer[] arrCounter = new Integer[counter.size()];
//        arrCounter = counter.toArray(arrCounter);
//
//        // циклом иду по массиву букв
//        for (int i = 0; i < abcArray.length; i++) {
//            char ch = abcArray[i];
//            int num = arrCounter[i];
//            System.out.println(ch + " " + num);
//        }
    }
}