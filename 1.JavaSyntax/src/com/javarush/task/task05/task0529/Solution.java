package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        String input;
        while (true) {
            input = br.readLine();
            if (input.equals("сумма")) {
                break;
            }
            sum += Integer.parseInt(input);
        }
        System.out.println(sum);
    }
}
