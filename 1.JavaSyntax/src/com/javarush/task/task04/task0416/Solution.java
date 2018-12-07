package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int g = 3;
        int y = 1;
        int r = 1;

        Scanner sc = new Scanner(System.in);
        double t = sc.nextDouble();

        double x = (t % (g + y + r));

        if (x >= 0 && x < 3) {
            System.out.println("зелёный");
        } else if (x >= 3 && x < 4) {
            System.out.println("желтый");
        } else {
            System.out.println("красный");
        }
    }
}