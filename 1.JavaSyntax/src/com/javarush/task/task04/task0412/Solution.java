package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        double d = sc.nextDouble();


 /*       // проверка ввода
        if (sc.hasNextDouble()) {
            d = sc.nextDouble();
        } else {
            System.out.println("Вы ввели не число!");
        }*/

        // манипуляции с числом
        if (d > 0) {
            d *= 2;
        } else if (d < 0) {
            d += 1;
        }


        System.out.println(d);


    }

}