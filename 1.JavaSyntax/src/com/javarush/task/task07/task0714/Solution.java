package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        //Объяви переменную типа ArrayList (список строк) и сразу проинициализируй ee.
        ArrayList<String> list = new ArrayList<>();

        //Считай 5 строк с клавиатуры и добавь их в список.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();
            list.add(s);
        }

        //Удали третий элемент списка.
        list.remove(2);

        //Выведи элементы на экран, каждый с новой строки.
        //Порядок вывода должен быть обратный.
        for (int i = 0, ls = list.size(); i < ls; i++) {
            String str = list.get(ls - 1 - i);
            System.out.println(str);
        }
    }
}