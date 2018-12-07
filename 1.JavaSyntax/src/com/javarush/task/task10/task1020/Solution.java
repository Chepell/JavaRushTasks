package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/* 
Задача по алгоритмам
Задача: ввести с клавиатуры 30 чисел.
Вывести 10-е и 11-е минимальные числа.

Пояснение:
Самое минимальное число - 1-е минимальное.
Следующее минимальное после него - 2-е минимальное

Пример:
1 6 5 7 1 15 63 88
Первое минимальное - 1
Второе минимальное - 1
Третье минимальное - 5
Четвертое минимальное - 6


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Класс Solution должен содержать два метода.
4. Метод sort() должен сортировать массив элементов.
5. Метод main() должен вызывать метод sort().
6. Программа должна выводить 10-е и 11-е минимальные числа. Каждое значение с новой строки.
*/

public class Solution {
    public static final int len = 10;

    public static void main(String[] args) throws Exception {
        // объявление и инициализация объекта для ввода числе с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // создаю массив 30 целых чисел
        int[] array = new int[len];

        // цикл запроса и сохранения 30 чисел
        for (int i = 0; i < len; i++) {

            int num;
            try {
                num = Integer.parseInt(reader.readLine());
                array[i] = num;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число.");
            }

        }

        sort(array);

        System.out.println(array[3]);
        System.out.println(array[2]);
    }

    public static void sort(int[] array) {
        Arrays.sort(array);
    }
}
