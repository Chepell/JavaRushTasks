package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if (a > b) {
            if (c > a) {
                System.out.println(a);
            } else if (b > c) {
                System.out.println(b);
            } else {
                System.out.println(c);
            }
        } else {
            if (c < a) {
                System.out.println(a);
            } else if (b < c) {
                System.out.println(b);
            } else {
                System.out.println(c);
            }
        }
    }
}
