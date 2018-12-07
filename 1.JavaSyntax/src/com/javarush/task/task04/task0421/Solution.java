package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        Scanner sc = new Scanner(System.in);

        String name0 = sc.nextLine();
        String name1 = sc.nextLine();

        if (name0.equals(name1)) {
            System.out.println("Имена идентичны");
        } else if (name0.length() == name1.length()) {
            System.out.println("Длины имен равны");
        }
    }
}
