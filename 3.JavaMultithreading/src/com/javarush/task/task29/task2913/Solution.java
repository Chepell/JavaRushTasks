package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

//    public static String recursion(int a, int b) {
//        if (a > b) {
//            return a + " " + recursion(a - 1, b);
//        } else {
//            if (a == b) {
//                return Integer.toString(a);
//            }
//            return a + " " + recursion(a + 1, b);
//        }
//    }

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder finalStb = new StringBuilder();
        if (a < b) {
            for (int i = a; i <= b; i++) {
                finalStb.append(i).append(" ");
            }
        } else if (a > b) {
            for (int i = a; i >= b; i--) {
                finalStb.append(i).append(" ");
            }
        } else {
            finalStb.append(a);
        }
        return finalStb.toString().trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;

//        numberA = -10_000_000;
//        numberB = 10_000_000;
//        System.out.println(recursion(numberA, numberB));
//        System.out.println("*******************************************");
//        System.out.println(recursion(numberB, numberA));

//        long before = System.currentTimeMillis();
        System.out.println(getAllNumbersBetween(numberA, numberB));
//        System.out.println("*******************************************");
        System.out.println(getAllNumbersBetween(numberB, numberA));
//        long after = System.currentTimeMillis();
//        System.out.printf("Операция заняла %.2f секунд.", (after - before) / 1000.0);
    }
}

//Замена рекурсии
//В программе случайным образом генерируются два целых числа A и В.
// Нужно вывести все целые числа от A до B включительно, в порядке возрастания,
// если A меньше B, или в порядке убывания в противном случае.
//
//Задача реализована с использованием рекурсии.
//Иногда в результате работы программы получаем Exception in thread "main" java.lang.StackOverflowError.
//
//Твоя задача: перепиши код без использования рекурсии.
//Метод recursion переименуй на getAllNumbersBetween.
//
//
//Требования:
//1. Метод recursion необходимо переименовать на getAllNumbersBetween.
//2. Ни в одном методе класса Solution не должно быть рекурсивных вызовов.
//3. В конце строчки вывода последовательности чисел не должно быть пробела.
//4. Логика работы программы должна остаться прежней.