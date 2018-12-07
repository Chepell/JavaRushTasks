package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Объяви переменную типа список строк и сразу проинициализируй ee.
        ArrayList<String> list = new ArrayList<>();

        // Считывай строки с клавиатуры и добавляй их в список, пока пользователь не введет строку "end".
        // Саму строку "end" не нужно добавлять в список.
        while (true) {
            String str = reader.readLine();

            // если введено end, то прервать бесконечный цикл
            if ("end".equals(str.toLowerCase())) {
                break;
            }

            // иначе добавляю строку в список
            list.add(str);
        }

        // Выведи список на экран, каждое значение с новой строки.
        // Используй цикл for.
        printList(list);
    }


    public static void printList(ArrayList<String> list) {
        for (String s : list) {
            System.out.println(s);
        }

    }
}