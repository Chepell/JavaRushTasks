package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        float count = 0;
        int i = 0;

        while (true) {
            i = sc.nextInt();
            if (i == -1) {
                break;
            }
            sum += i;
            count++;
        }

        System.out.println(sum / count);

    }
}

