package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Объяви переменную типа список строк и сразу проинициализируй ee.
        ArrayList<String> list = new ArrayList<>();

        // Считай 10 строк с клавиатуры и добавь их в список.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String str = reader.readLine();
            list.add(str);
        }

        ArrayList<String> result = doubleValues(list);

        // Выведи получившийся список на экран, каждый элемент с новой строки.
        for (String s : result) {
            System.out.println(s);
        }

    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        // Метод doubleValues должен удваивать элементы списка по
        // принципу альфа,бета,гамма -> альфа,альфа,бета,бета,гамма,гамма.
        for (int i = 0; i < list.size(); i++) {
            // Элемент списка на текущей итерации помещаю в переменную
            String str = list.get(i);
            // Добавляю копию строки на текущий индекс
            list.add(i, str);
            // Итерирую счетчик, т.к. добавили новый элемент
            // и что бы на нем не застрять, его нужно перепрыгнуть
            i++; // иначе будет бесконечный цикл
        }
        return list;
    }
}