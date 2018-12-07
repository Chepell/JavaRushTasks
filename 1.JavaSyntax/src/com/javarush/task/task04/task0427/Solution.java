package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import sun.security.util.Length;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int num;
        num = sc.nextInt();
        int length = (Integer.toString(num)).length();

        if (num <= 999 && num >= 1) {
            if (length == 1) {
                if (num % 2 == 0) {
                    System.out.print("четное однозначное число");
                } else {
                    System.out.print("нечетное однозначное число");
                }
            } else if (length == 2) {
                if (num % 2 == 0) {
                    System.out.print("четное двузначное число");
                } else {
                    System.out.print("нечетное двузначное число");
                }
            } else {
                if (num % 2 == 0) {
                    System.out.print("четное трехзначное число");
                } else {
                    System.out.print("нечетное трехзначное число");
                }
            }
        }

    }
}
