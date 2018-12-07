package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        if (n1 == n2 && n1 != n3) {
            System.out.println(3);
        } else if (n2 == n3 && n3 != n1) {
            System.out.println(1);
        } else if (n1 == n3 && n3 != n2)
            System.out.println(2);
        }
}
