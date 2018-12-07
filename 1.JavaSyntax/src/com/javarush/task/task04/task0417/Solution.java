package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
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

        if (n1 == n2) {
            if (n1 == n3) {
                System.out.println(n1 + " " + n2 + " " + n3);
            } else {
                System.out.println(n1 + " " + n2);
            }
        } else if (n2 == n3) {
            if (n2 == n1) {
                System.out.println(n1 + " " + n2 + " " + n3);
            } else {
                System.out.println(n2 + " " + n3);
            }
        } else if (n3 == n1) {
            if (n3 == n2) {
                System.out.println(n1 + " " + n2 + " " + n3);
            } else {
                System.out.println(n3 + " " + n1);
            }
        }
    }
}


