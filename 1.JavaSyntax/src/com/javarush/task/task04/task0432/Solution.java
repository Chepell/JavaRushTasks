package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // создание буфера под вод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // ввод строки
        String str = reader.readLine();
        // ввод целого числа
        int n = Integer.parseInt(reader.readLine());

        while (n > 0) {
            System.out.println(str);
            n--;
        }

    }
}
