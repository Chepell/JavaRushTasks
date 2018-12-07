package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        double x = convertEurToUsd(10, 1.35);
        double y = convertEurToUsd(37, 1.1);
        System.out.println(x);
        System.out.println(y);
    }

    public static double convertEurToUsd(int eur, double course) {
        //напишите тут ваш код
        return eur * course;
    }
}
