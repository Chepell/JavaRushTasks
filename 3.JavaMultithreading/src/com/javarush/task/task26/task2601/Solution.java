package com.javarush.task.task26.task2601;

/* 
Почитать в инете про медиану выборки
Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
Верни отсортированный массив от минимального расстояния до максимального.
Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.

Пример входящего массива:
13, 8, 15, 5, 17
медиана - 13

Отсортированный масив:
13, 15, 17, 8, 5
*/

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Integer[] testArray = {17, 15, 8, 5, 13};
        Integer[] sort = sort(testArray);
        System.out.println(Arrays.toString(sort));
    }

    public static Integer[] sort(Integer[] array) {
        // определяю длину массива и середину
        int len = array.length;
        int mid = array.length / 2;
        // создаю копию базового массива для последующей обработки
        Integer[] copyArray = Arrays.copyOf(array, len);
        // сортрую полученный массив по возрастанию
        Arrays.sort(copyArray);
        // переменная для медианы
        int med;
        if (len % 2 == 1) {
            med = copyArray[mid];
        } else {
            med = (copyArray[mid] + copyArray[mid - 1]) / 2;
        }
        // простой компаратор который сортирует элементы i по их удалению от медианы
        Arrays.sort(copyArray, Comparator.comparingDouble(i -> Math.abs(med - i)));
        return copyArray;
    }
}
