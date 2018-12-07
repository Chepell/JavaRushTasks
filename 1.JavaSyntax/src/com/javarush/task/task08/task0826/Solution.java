package com.javarush.task.task08.task0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/* 
Пять победителей
*/

// Метод sort() должен сортировать массив чисел от большего к меньшему.
// Метод main() должен вызывать метод sort().
// Программа должна выводить пять наибольших чисел массива. Каждое значение с новой строки.

// Класс Solution должен содержать два метода.
public class Solution {
    public static void main(String[] args) throws Exception {
        // Программа должна считывать значения с клавиатуры.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        sort(array);

        // Программа должна выводить числа на экран.
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array) {
        // сортировка массива
        Arrays.sort(array);

        // разворот элементов от большего к меньшему
        // цикл от начала до середины массива
        for (int i = 0; i < array.length / 2; i++) {
            // сохраняю текущий элемент в переменную
            int temp = array[i];
            // на место текущей переменной сохраняю элемент с другой стороны массива
            array[i] = array[array.length - 1 - i];
            // на место элемента с другой стороны массива помещаю текущий элемент,
            // который был сохранен во временной переменной
            array[array.length - 1 - i] = temp;
        }

//        // цикл проходит по всем элементам массива
//        for (int i = 0; i < array.length; i++) {
//            // Элемент i и все что слева считается отсортированным
//            // Запоминаю значение последнего отсортированного элемента
//            int elem = array[i];
//            // Запоминаю индекс этого элемента для внутреннего цикла
//            int j = i;
//            // j>0 т.к. вначале считаю первый элемент отсортированным
//            // Пока элемент меньше предыдущего цикл продолжается
//            // Если в elem < array[j - 1] знак сменить на >, то сортировка будет от большего к меньшему
//            while (j > 0 && elem > array[j - 1])
//            {
//                // Сдвигаю элементы на ячейку вправо
//                array[j] = array[j - 1];
//                // И соответственно сдвигаю значение индекса
//                j--;
//            }
//            // Вышли из цикла, элемент больше предыдущего, значит вставляю его на текущем месте
//            array[j] = elem;
//        }


    }
}
