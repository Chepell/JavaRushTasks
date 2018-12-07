package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int len = 20;
        int maximum;
        int minimum;

        // Создай массив целых чисел (int[]) на 20 элементов.
        int[] array = new int[20];

        // Считай с клавиатуры 20 целых чисел и добавь их в массив.
        for (int i = 0; i < len; i++) {
            int num = Integer.parseInt(reader.readLine());
            array[i] = num;
        }
        selectionSort(array);

        // Найди и выведи через пробел максимальное и минимальное числа.
        // Используй цикл for.
        minimum = array[0];
        maximum = array[array.length - 1];


        System.out.print(maximum + " " + minimum);
        //printArray(array);

    }

    // Selection sort
    public static void selectionSort(int[] array) {

        // сначала массив считается полностью неотсортированным
        for (int i = 0; i < array.length; i++) {
            // индекс первого неотсортированного элемента массива
            int min_indx = i;

            // поиск минимульно элемента в неотсортированной части
            for (int j = i + 1; j < array.length; j++) {
                // запоминаю индекс минимального элемента
                if (array[min_indx] > array[j]) {
                    min_indx = j;
                }
            }
            // если индекс минимального элемента изменился, то нужно сделать перестановку элементов
            if (min_indx != i) {
                // запоминаю значение найденного минимально элемента и неотсортированного списка
                int tmp = array[min_indx];
                // на место найденного мин.элемента помещаю последний элемент несортированной части списка
                array[min_indx] = array[i];
                // на место последнего несортированного элемента помещаю найденный минимальный элемент
                array[i] = tmp;
            }
        }
    }


    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.printf("%d, ", i);
        }
    }
}
