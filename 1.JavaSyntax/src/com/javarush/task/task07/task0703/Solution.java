package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int len = 10;
        String[] strArray = new String[10];
        int[] intArray = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = br.readLine();
        }

        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = strArray[i].length();
        }

        printArray(intArray);


    }

    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void printStrLen(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].length());
        }
    }
}
