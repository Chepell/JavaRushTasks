package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/* 
Факториал
Написать метод, который вычисляет факториал - произведение
всех чисел от 1 до введенного числа включая его.

Пример вычислений: 4! = factorial(4) = 1*2*3*4
Пример вывода: 24

1. Ввести с консоли число меньше либо равно 150.
2. Реализовать функцию factorial.
3. Если введенное число меньше 0, то вывести 0.
0! = 1

Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить на экран факториал введенного числа.
3. Метод factorial должен возвращать строковое
    представление факториала числа переданного ему в качестве параметра.
4. Метод factorial должен принимать один параметр типа int.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

//        long before = System.currentTimeMillis();
//        System.out.println(factorial(input));
        System.out.println(factorial(input));
//        long after = System.currentTimeMillis();
//        System.out.println(after - before);

//        for (int i = 0; i <= 150; i++) {
//            System.out.println(factorial(i));
//        }
    }

    ////// ВАРИАНТ СОВМЕМ ЧУТЬ БЫСТРЕЕ //////
    /// но думаю память жрет страшно
    public static String factorial2(int n) {
        if (n >= 0) {
            // массив для хранения всех факториалов
            BigInteger[] bigArray = new BigInteger[n + 1];
            // цикл раcчета значений факториалов и помещения их в массив
            for (int i = 0; i <= n; i++) {
                if (i < 2) {
                    bigArray[i] = BigInteger.ONE;
                } else {
                    bigArray[i] = BigInteger.valueOf(i).multiply(bigArray[i - 1]);
                }
            }
            return bigArray[n].toString();
        }
        // если в качестве парметра передано отрицательное число
        return "0";
    }

    public static String factorial(int n) {
        if (n >= 0) {
            // переменная для хранения больших целых чисел
            BigInteger bigFact = BigInteger.ONE;
            for (int i = 0; i <= n; i++) {
                // для 0 и 1 ничего не делаю, факториал равен 1.
                if (i > 1) {
                    bigFact = bigFact.multiply(BigInteger.valueOf(i));
                }
            }
            return bigFact.toString();
        }
        // если в качестве парметра передано отрицательное число
        return "0";
    }


}
