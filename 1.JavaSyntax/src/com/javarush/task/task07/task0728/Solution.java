package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
В убывающем порядке
*/

public class Solution {
    // Программа должна считывать 20 целых чисел с клавиатуры.
    // Программа должна выводить 20 чисел.
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[8];

        for (int i = 0; i < 8; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        // Метод main должен вызывать метод sort.
        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    // В классе Solution должен быть метод public static void sort(int[] array).
    // Метод sort должен сортировать переданный массив по убыванию.
    public static void sort(int[] array) {
        // цикл проходит по всем элементам массива
        for (int i = 0; i < array.length; i++) {
            // Элемент i и все что слева считается отсортированным
            // Запоминаю значение последнего отсортированного элемента
            int elem = array[i];
            // Запоминаю индекс этого элемента для внутреннего цикла
            int j = i;
            // j>0 т.к. вначале считаю первый элемент отсортированным
            // Пока элемент больше предыдущего цикл продолжается, сортировка в обратном порядке
            // Если знак поменять на <, то сортировка будет от меньшего к большему
            while (j > 0 && elem > array[j - 1]) {
                // Сдвигаю элементы на ячейку вправо
                array[j] = array[j - 1];
                // И соответственно сдвигаю значение индекса
                j--;
            }
            // Вышли из цикла, элемент больше предыдущего, значит вставляю его на текущем месте
            array[j] = elem;
        }
    }
}
