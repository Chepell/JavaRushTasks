package com.javarush.task.task07.task0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Вывести числа в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Объяви переменную типа список целых чисел и сразу проинициализируй ee.
        ArrayList<Integer> list = new ArrayList<>();
        final int len = 10;

        // Считай 10 целых чисел с клавиатуры и добавь их в список.
        for (int i = 0; i < len; i++) {
            int num = Integer.parseInt(reader.readLine());
            list.add(num);
        }

        // Выведи числа в обратном порядке. Используй цикл for.
        for (int i = 0; i < list.size(); i++) {
            int indx = list.size() - 1 - i;
            System.out.println(list.get(indx));
        }
    }
}
