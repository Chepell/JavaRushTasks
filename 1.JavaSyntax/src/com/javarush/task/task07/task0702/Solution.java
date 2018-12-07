package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] array = new String[5];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // заполняю массив 8 из 10
        for (int i = 0; i < array.length - 2; i++) {
            array[i] = reader.readLine();
        }

        // печатаю все символы в обратном порядке
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[array.length - i - 1]);
        }


    }
}