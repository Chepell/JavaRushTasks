package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int num4 = sc.nextInt();


        if (max(num1, num2) >= max(num3, num4)) {
            System.out.println(max(num1, num2));
        } else {
            System.out.println(max(num3, num4));
        }

    }

    public static int max(int n1, int n2) {
        if (n1 >= n2) {
            return n1;
        } else {
            return n2;
        }
    }
}
