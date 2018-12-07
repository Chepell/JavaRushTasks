package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());
        int n3 = Integer.parseInt(reader.readLine());
        int n4 = Integer.parseInt(reader.readLine());
        int n5 = Integer.parseInt(reader.readLine());


        int minimum = min(n1, n2, n3, n4, n5);

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int n1, int n2, int n3, int n4, int n5) {
        int min = n1;
        min = min > n2 ? n2 : min;
        min = min > n3 ? n3 : min;
        min = min > n4 ? n4 : min;
        min = min > n5 ? n5 : min;
        return min;
    }
}
