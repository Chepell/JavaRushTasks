package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //Объяви переменную типа список строк и сразу проинициализируй ee.
        ArrayList<String> list = new ArrayList<>();

        //Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        //Программа должна выводить на экран самую короткую строку, если она была раньше самой длинной.
        //Программа должна выводить на экран самую длинную строку, если она была раньше самой короткой.
        //Должна быть выведена только одна строка.

        //Буду сохранять индексы минимального и максимального числа в списке
        //По умолчанию оба индекса ставлю на ноль
        int index_min = 0;
        int index_max = 0;

        //В цикле прохожу по всем элементам списка за исключением нулевого
        //Т.к. с него начинаю сравнение
        for (int i = 1; i < list.size(); i++) {
            //Обновляю значение индекса максимального числа
            //Если чило больше, чем с сохраненным индексом
            if (list.get(index_max).length() < list.get(i).length()) {
                index_max = i;
            }
            //Обновляю значение индекса минимального числа
            if (list.get(index_min).length() > list.get(i).length()) {
                index_min = i;
            }
        }

        //Проверяю какое число было раньше
        //То и вывожу на экран
        if (index_max < index_min) {
            System.out.println(list.get(index_max));
        } else {
            System.out.println(list.get(index_min));
        }
    }
}
