package com.javarush.task.task15.task1506;

/* 
Что-то лишнее
1. Программа должна выводить следующее:
Это double
Это Object
Это double
Это Integer
Это double

2. Удали реализации всех лишних методов


Требования:
1. В классе Solution должен остаться метод print с одним параметром типа Integer.
2. В классе Solution должен остаться метод print с одним параметром типа Object.
3. В классе Solution должен остаться метод print с одним параметром типа double.
4. Вывод на экран должен соответствовать условию.
*/

public class Solution {
    public static void main(String[] args) {
        print((short) 1); // идет upcasting short -> int -> long -> float -> double
        print((Number) 1); // идет upcasting  Number -> Object
        print(1); // идет upcasting int -> long -> float -> double
        print((Integer) 1); // есть именно метод Integer
        print((int) 1); // идет upcasting int -> long -> float -> double
    }

    public static void print(Integer i) {
        System.out.println("Это Integer");
    }

//    public static void print(long i) {
//        System.out.println("Это long");
//    }

//    public static void print(Short i) {
//        System.out.println("Это Object");
//    }

    public static void print(Object i) {
        System.out.println("Это Object");
    }

    public static void print(double i) {
        System.out.println("Это double");
    }

//    public static void print(Double i) {
//        System.out.println("Это double");
//    }

//    public static void print(float i) {
//        System.out.println("Это Double");
//    }
}
