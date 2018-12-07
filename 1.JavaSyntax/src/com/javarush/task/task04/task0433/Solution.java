package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
//        int i = 10;
//        while (i > 0) {
//            System.out.println("SSSSSSSSSS");
//            i--;
//        }

        int i = 10;

        while (i > 0) {
            int j = 0;
            while (j < 10) {
                System.out.print("S");
                j++;
            }
            System.out.println("");
            i--;
        }

    }
}
