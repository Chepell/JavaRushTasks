package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;

/*
Алгоритмы-числа
Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания.

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.


Требования:
1. В классе Solution должен присутствовать метод getNumbers c одним параметром типа long.
2. Метод getNumbers должен быть публичным.
3. Метод getNumbers должен быть статическим.
4. Метод getNumbers должен возвращать массив чисел удовлетворяющих условию задачи.
*/
public class Solution {
    public static long[] getNumbers(long N) {
        ArrayList<Long> list = new ArrayList<>();
        //список степенных сумм чисел Армстронга
        ArrayList<Long> listOfPow = new ArrayList<>();
        // циклом прохожу по множеству чисел
        for (long i = 0; i < N; i++) {
            // одинарные числа просто записываю в список
            // чего их возводить в 1ю степень
            if (i < 10) {
                list.add(i);
                // для чисел от 10
            } else {
                // переменная для суммы всех цифр в числе
                long sum = 0;
                // метод в цикле считающий длину числа работает быстрее
                // создаю массив под цифры числа, т.е. дроблю число на разряды
                long[] digits = new long[numLength(i)];
                // счетчик для индекса элемента массива
                int x = 0;
                // и каждое число разряда помещаю в ячейку массива
                for (long j = i; j != 0; j /= 10) {
                    sum += j % 10;
                    digits[x++] = j % 10;
                }

                // если список не содержит число
                if (!listOfPow.contains(sum)) {
                    int summ = 0;
                    // циклом прохожу по элементам массива цифр
                    for (long digit : digits) {
                        // и считаю сумму степеней цифр
                        summ += Math.pow((double) digit, (double) digits.length);
                    }
                    // и если полученное число равно поданном, то значит найдено число армстронга
                    if (i == summ) {
                        // добавляю число в оба списка
                        list.add(i);
                        listOfPow.add(sum);
                    }
                }
            }
        }
        // создаю итоговый массив размером с полученный список
        long[] result = new long[list.size()];
        // в цикле копирую из списка в массив все значения
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        // и возвращаю итоговый массив
        return result;
    }

    // метод возвращает количество разрядов в поданном числе
    public static int numLength(long N) {
        int len = 0;
        while (N > 0) {
            len++;
            N /= 10;
        }
        return len;
    }

    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        long[] armstrongNums = getNumbers(1000000000);
        System.out.println(Arrays.toString(armstrongNums));
        long time = System.currentTimeMillis() - before;
        System.out.println("Time to executions: " + time / 1000.0 + " sec.");
        Runtime runtime = Runtime.getRuntime();
        long usageMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Usage memory: " + usageMemory / 1024 / 1024 + " Mb.");

    }
}
