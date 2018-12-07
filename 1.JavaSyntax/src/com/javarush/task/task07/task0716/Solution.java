package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        //Метод fix должен удалять из списка строк все слова, содержащие букву "р".
        //Исключение: слова содержащие и букву "р" и букву "л" - их нужно оставить.
        //Метод fix должен удваивать слова, содержащие букву "л" (добавлять еще один элемент с этим словом).
        //Исключение: слова содержащие и букву "л" и букву "р" - их не нужно удваивать.
        //Метод fix не должен ничего делать со словами, содержащими и букву "л" и букву "р".
        //Mетод fix не должен ничего делать со словами, которые не содержат ни букву "л", ни букву "р".

        //цикл по элементам списка
        for (int i = 0; i < list.size(); i++) {
            //Вытаскиваю в строку элемент списка
            String str = list.get(i);
            //Если стока содержит только букву "р", индекс не равен -1, т.е. буква есть в строке
            //И строка не сождержит 'л', индекс равен -1
            if (str.indexOf('р') != -1 && str.indexOf('л') == -1) {
                list.remove(i); //удаляю строку
                i--; //уменьшаю счетчик на едеиницу, т.к. размер списка только что уменьшился
            }
            //Ищу слова только с буквой 'л'
            if (str.indexOf('л') != -1 && str.indexOf('р') == -1) {
                list.add(i, str); //добавляю копию этой строки в список
                i++; //увеличиваю счетчик на единицу, т.к. только что размер списка увеличился
            }
        }
        return list;
    }
}