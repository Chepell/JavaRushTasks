package com.javarush.task.task11.task1123;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        // объявляю и сразу инициирую массив целых чисел
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};


        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Maximum is " + result.y);
    }


    // метод возвращающий объект типа Pair в качестве параметра принимает массив целых чисел
    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] array) {
        // если указатель пустой или массив нулевой, то возвращаю пустой объект
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        // сортировка массива в прямом направлении
        Arrays.sort(array);
        int x = array[0]; // на перой позиции минимум
        int y = array[array.length - 1]; // на последней максимум

        return new Pair<Integer, Integer>(x, y);
    }


    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
