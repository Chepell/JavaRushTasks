package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] bigArray = new int[20];
        int[] smallArray01 = new int[10];
        int[] smallArray02 = new int[10];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = Integer.parseInt(br.readLine());
        }

        // цикл пишет большой массив в два маленьких
        for (int i = 0; i < bigArray.length; i++) {
            if (i < 10) { // первая половина пишется
                smallArray01[i] = bigArray[i];
            } else {// втоя половина, i-10 что бы начать индексы второго массива с нуля
                smallArray02[i - 10] = bigArray[i];
            }
        }

        for (int i = 0; i < smallArray02.length; i++) {
            System.out.println(smallArray02[i]);
        }
    }
}
