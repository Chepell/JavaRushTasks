package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Объяви переменную типа список строк и сразу проинициализируй ee.
        ArrayList<String> list = new ArrayList<>();

        // Считай c клавиатуры числа N и M, считай N строк и добавь их в список.
        final int n = Integer.parseInt(reader.readLine());
        final int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String str = reader.readLine();
            list.add(str);
        }

        // Переставить M первых строк в конец списка.
        for (int i = 0; i < m; i++) {
            String tmp = list.get(0);
            list.remove(0);
            list.add(tmp);
        }

        // Выведи список на экран, каждое значение с новой строки.
        printList(list);
        
    }

    
    // Метод выводит список на экран
    public static void printList(ArrayList<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }
}
