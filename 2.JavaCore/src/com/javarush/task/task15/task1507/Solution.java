package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.


Требования:
1. В классе Solution должны быть реализованы 10 методов printMatrix с различными аргументами.
2. Класс Solution должен быть public.
3. Все методы класса Solution должны быть статическими.
4. Все методы класса Solution должны быть публичными.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "fDf");
        printMatrix(2, 3, Byte.MAX_VALUE);
        printMatrix(2, 3, Short.MAX_VALUE);
        printMatrix(2, 3, Integer.MAX_VALUE);
        printMatrix(2, 3, Long.MAX_VALUE);
        printMatrix(2, 3, Float.MAX_VALUE);
        printMatrix(2, 3, Double.MAX_VALUE);
        printMatrix(2, 3, 'X');
        printMatrix(2, 3, false);
    }

    public static void printMatrix(int m, int n, boolean value) {
        System.out.println("Заполняем объектами Boolean");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, char value) {
        System.out.println("Заполняем объектами Char");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, double value) {
        System.out.println("Заполняем объектами Double");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, float value) {
        System.out.println("Заполняем объектами Float");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, long value) {
        System.out.println("Заполняем объектами Long");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, int value) {
        System.out.println("Заполняем объектами Int");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, short value) {
        System.out.println("Заполняем объектами Short");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, byte value) {
        System.out.println("Заполняем объектами Byte");
        printMatrix(m, n, (Object) value);
    }

    // перегрузка метода с вызовом внутри этого же метода с объектом
    // в качестве аргумента и приведением типа к этому общему типу
    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    // общий метод заполнения матрицы объектами
    public static void printMatrix(int m, int n, Object value) {
        // столбец
        for (int i = 0; i < m; i++) {
            // строка
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            // переход на новую строку
            System.out.println();
        }
    }
}
