package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str;

        if (num < 0) {
            if (num % 2 == 0) {
                str = "отрицательное четное число";
            } else {
                str = "отрицательное нечетное число";
            }
        } else if (num > 0) {
            if (num % 2 == 0) {
                str = "положительное четное число";
            } else {
                str = "положительное нечетное число";
            }
        } else {
            str = "ноль";
        }
        System.out.print(str);
    }
}
