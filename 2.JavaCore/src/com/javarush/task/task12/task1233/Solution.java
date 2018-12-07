package com.javarush.task.task12.task1233;

/* 
Изоморфы наступают
Написать метод, который возвращает минимальное число в массиве и его позицию (индекс).


Требования:
1. Класс Solution должен содержать класс Pair.
2. Класс Solution должен содержать два метода.
3. Класс Solution должен содержать метод getMinimumAndIndex().
4. Метод getMinimumAndIndex() должен возвращать минимальное число в массиве и его позицию (индекс).
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        // объект класса Pair
        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Index of minimum element is " + result.y);
    }

    // метод для вычисления пары мин.значение - индекс
    // метод типа Pair принимающий в качестве аргумента массив целых чисел
    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        // если массив не существует или пустой
        if (array == null || array.length == 0) {
            // то возвращаю пустую пару значений в объект
            return new Pair<>(null, null);
        }

//        long before = System.currentTimeMillis();
        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
//        long after = System.currentTimeMillis();
//        System.out.println("Time spend: " + (after - before));

        return new Pair<>(min, index);
    }


    // класс для хранения любых типов пар значений
    public static class Pair<X, Y> {
        // поля
        public X x;
        public Y y;

        // конструктор
        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
