package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader == null) return "";

        int i;
        StringBuilder stringBuilder = new StringBuilder();
        while ((i = reader.read()) != -1) {
            char c = (char) (i + key); // двигаю и даункастю к символу
            stringBuilder.append(c); // пишу в строку
        }
        return stringBuilder.toString();
    }
}