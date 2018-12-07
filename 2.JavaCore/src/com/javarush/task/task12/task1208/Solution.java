package com.javarush.task.task12.task1208;

/* 
Свобода печати
Написать пять методов print с разными параметрами.


Требования:
1. Программа не должна выводить текст на экран.
2. Класс Solution должен содержать шесть методов.
3. Класс Solution должен содержать статический метод main().
4. Класс Solution должен содержать пять статических
    методов print() с разными параметрами.
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static void print(int x) {
        System.out.println(x);
    }

    public static void print(String string) {
        System.out.println(string);
    }

    public static void print(String string, int num) {
        System.out.printf("Ваша строка %s\nВаше число %d", string, num);
    }

    public static void print(double num) {
        System.out.println(num);
    }

    public static void print(char letter) {
        System.out.println(letter);
    }
}
