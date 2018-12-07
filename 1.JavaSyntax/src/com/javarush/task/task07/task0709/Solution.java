package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создай список строк.
        ArrayList<String> list = new ArrayList<>();

        // Считай с клавиатуры 5 строк и добавь в список.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            list.add(br.readLine());
        }

        // Используя цикл, найди самую короткую строку в списке.
        int firstIndexMin = 0;
        int secondIndexMin = 0;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() < list.get(firstIndexMin).length()) {
                firstIndexMin = i;
                secondIndexMin = 0;
            } else if (list.get(i).length() == list.get(firstIndexMin).length()) {
                secondIndexMin = i;
            }
        }

        if (secondIndexMin == 0) {
            System.out.println(list.get(firstIndexMin));
        } else {
            System.out.println(list.get(firstIndexMin));
            System.out.println(list.get(secondIndexMin));
        }
    }
}
