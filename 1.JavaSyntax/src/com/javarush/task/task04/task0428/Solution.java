package com.javarush.task.task04.task0428;

/* 
Положительное число
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

        int counter = 0;

        if (num1 > 0) {
            counter++;
        }
        if (num2 > 0) {
            counter++;
        }
        if (num3 > 0) {
            counter++;
        }

        System.out.println(counter);
    }
}
