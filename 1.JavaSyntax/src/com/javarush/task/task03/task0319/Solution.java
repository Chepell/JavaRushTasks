package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String sNum1 = reader.readLine();
        int num1 = Integer.parseInt(sNum1);
        String sNum2 = reader.readLine();
        int num2 = Integer.parseInt(sNum2);

        System.out.println(name + " получает " + num1 + " через " + num2 + " лет.");
    }
}
