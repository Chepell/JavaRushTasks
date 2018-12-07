package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Объяви переменную типа список строк и сразу проинициализируй ee.
        ArrayList<String> list = new ArrayList<>();

        // Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            // Программа должна добавлять строки в начало списка.
            list.add(0, br.readLine());
        }

        // Программа должна выводить список на экран, каждое значение с новой строки.
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
