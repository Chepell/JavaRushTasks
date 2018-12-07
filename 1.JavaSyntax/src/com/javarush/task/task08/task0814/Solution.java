package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

// Программа не должна выводить текст на экран.
// Программа не должна считывать значения с клавиатуры.
// Класс Solution должен содержать только три метода.
public class Solution {
    public static HashSet<Integer> createSet() {
        // Метод createSet() должен создавать и возвращать множество HashSet состоящих из 20 различных чисел.
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(15);
        set.add(42);
        set.add(-52);
        set.add(65);
        set.add(41);
        set.add(11);
        set.add(10);
        set.add(3);
        set.add(8);
        set.add(86);
        set.add(2);
        set.add(5);
        set.add(98);
        set.add(35);
        set.add(45);
        set.add(75);
        set.add(9);
        set.add(7);
        set.add(6);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        // Метод removeAllNumbersMoreThan10() должен удалять из множества все числа больше 10.
        set.removeIf(x -> x > 10);
        return set;
    }

//    public static void printSet(HashSet<Integer> set) {
//        for (Integer i: set) {
//            System.out.println(i);
//        }
//    }

    public static void main(String[] args) {
//        HashSet<Integer> hashSet = createSet();
//        removeAllNumbersMoreThan10(hashSet);
//        printSet(hashSet);
    }
}
