package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // объект ридер для считывания целых числе с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // инициализация массива на 20 элементов
        int[] array = new int[20];
        // заполнение созданного массива в цикле цислами
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        // метод возвращает итоговый массив
        return array;
    }

    public static int max(int[] array) {
        // метод принимает аргументом массив
        // по умолчанию считает первый элемент максимальным
        int max = array[0];
        // в цикле начиная со второго элемента сравнивает текущий максимум со значением в ячейке
        for (int i = 1; i < array.length; i++) {
            // если нашли большее значение, то обновляем max
            if (array[i] > max) {
                max = array[i];
            }
        }
        // метод возвращает найденный максимум в массиве
        return max;
    }
}
