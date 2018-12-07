package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

// Программа должна считывать данные с клавиатуры.
// Программа должна вывести столько же строк, сколько было введено.
// Если в строке было четное число букв, то необходимо удвоить строку (как в примере).
// Если в строке было нечетное число букв, то необходимо утроить строку (как в примере).
// Программа должна прекращать считывать данные с клавиатуры как только пользователь введет пустую строку и нажмет Enter.

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();

        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> listUpperCase = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            listUpperCase.add(s.toUpperCase());
        }

        ArrayList<String> lastList = new ArrayList<>();
        for (int i = 0; i < listUpperCase.size(); i++) {
            String str = listUpperCase.get(i);
            int len = str.length();
            String newString = "";

            if (len % 2 == 0) { // в строке четное количество символов
                for (int j = 0; j < 2; j++) {
                    newString = newString + str + " ";
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    newString = newString + str + " ";
                }
            }
            lastList.add(newString);
        }

        for (int i = 0; i < lastList.size(); i++) {
            System.out.println(lastList.get(i));
        }
    }
}
