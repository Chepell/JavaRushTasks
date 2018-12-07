package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int count_pos = 0;
        int count_neg = 0;

        if (num1 > 0) {
            count_pos++;
        } else if (num1 < 0) {
            count_neg++;
        }

        if (num2 > 0) {
            count_pos++;
        } else if (num2 < 0) {
            count_neg++;
        }

        if (num3 > 0) {
            count_pos++;
        } else if (num3 < 0) {
            count_neg++;
        }

        System.out.printf("количество отрицательных чисел: %d\nколичество положительных чисел: %d", count_neg, count_pos);
    }
}
