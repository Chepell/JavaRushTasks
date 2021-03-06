package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/*
ThreadLocalRandom
*/
public class Solution {

    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        return current.nextInt(from, to);
    }

    public static double getRandomDouble() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        return current.nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        return current.nextLong(0, n);
    }

    public static void main(String[] args) {
//        double randomDouble = getRandomDouble();
//        System.out.println(randomDouble);
    }
}

// ThreadLocalRandom
//Класс Solution будет использоваться трэдами.
//Реализуй логику всех методов, используйте класс ThreadLocalRandom.
//getRandomIntegerBetweenNumbers должен возвращать случайный int между from и to.
//getRandomDouble должен возвращать случайный double.
//getRandomLongBetween0AndN должен возвращать случайный long между 0 и n.
//
//
//Требования:
//1. В классе Solution должны быть только статические методы.
//2. Метод getRandomIntegerBetweenNumbers с помощью ThreadLocalRandom должен возвращать случайный int [from..to].
//3. Метод getRandomDouble с помощью ThreadLocalRandom должен возвращать случайный double [      