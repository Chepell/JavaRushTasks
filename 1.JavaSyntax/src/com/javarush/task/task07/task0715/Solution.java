package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        //Объяви переменную типа список строк и сразу проинициализируй ee.
        ArrayList<String> list = new ArrayList<>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");

        String s = "именно";

        //После каждого слова вставь в список строку, содержащую слово "именно".
        for (int i = 1; i <= 5; i += 2) {
            list.add(i, s);
        }

        //Выведи элементы списка на экран, каждый с новой строки.
        for (String i : list) {
            System.out.println(i);
        }


    }
}
