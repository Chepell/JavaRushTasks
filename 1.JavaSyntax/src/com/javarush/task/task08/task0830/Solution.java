package com.javarush.task.task08.task0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Задача по алгоритмам
Введи с клавиатуры 20 слов и выведи их в алфавитном порядке. Каждое слово - с новой строки.


Требования:
Программа должна выводить текст на экран.
Программа должна считывать значения с клавиатуры.
Класс Solution должен содержать три метода.
Метод main() должен вызывать метод sort().
Метод sort() должен вызывать метод isGreaterThan().
Выведенные слова должны быть отсортированы в алфавитном порядке.
*/


public class Solution {
    public static void main(String[] args) throws Exception {
        // объект для чтения с терминала
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // массив строк для хранения слов
        String[] array = new String[20];

        // в цикле заполняю массив словами
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        // метод сортировки массива
        sort(array);

        // for each цикл для печати всех значений
        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // использую встроенный метод сортировки
        Arrays.sort(array);

        // проход по всей длине массива
        for (int i = 1; i < array.length; i++) {
            // ищу строки начинающиеся с одного символа
            if (array[i - 1].charAt(0) == array[i].charAt(0)
                    // и тогда проверяю что левая строка больше правой
                    // тогда нужно поменять их местами
                    && isGreaterThan(array[i - 1], array[i])) {
                // Переменная буфер для хранения значения текущего элемента
                String tmp = array[i];
                // Следующий элемент перемещаем на текущую позицию
                array[i] = array[i - 1];
                // А в следующий элемент перемещаем значение из буфера
                array[i - 1] = tmp;
            }
        }
    }

//    public static void sort(String[] array) {
//        // Цикл перебора всех элементов массива методом bobble sort
//        // длина массива
//        int len = array.length;
//        // len-1 до предпоследнего элемента, т.к. идет сравнение со следующим элементом
//        for (int i = 0; i < len - 1; i++) {
//            // Второй цикл для сравнения двух ближайших элементов в массиве
//            // len-i т.к. с каждым шагом в основном цикле уменьшается длина массива по которой нужно пройти
//            for (int j = 0; j < len - i - 1; j++) {
//                // Если текущий элемент больше чем следующий
//                if (array[j].charAt(0) > array[j + 1].charAt(0)) {
//                    // Переменная буфер для хранения значения текужего элемента
//                    String tmp = array[j];
//                    // Следующий элемент перемещаем на текущую позицию
//                    array[j] = array[j + 1];
//                    // А в следующий элемент перемещаем значение из буфера
//                    array[j + 1] = tmp;
//                    // если первые буквы слов равны
//                } else if (array[j].charAt(0) == array[j + 1].charAt(0)) {
//                    // смотрю на сумму всех букв в строках
//                    if (isGreaterThan(array[j], array[j + 1])) {
//                        // Переменная буфер для хранения значения текужего элемента
//                        String tmp = array[j];
//                        // Следующий элемент перемещаем на текущую позицию
//                        array[j] = array[j + 1];
//                        // А в следующий элемент перемещаем значение из буфера
//                        array[j + 1] = tmp;
//                        // если первые буквы слов равны
//                    }
//                }
//            }
//        }
//    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
