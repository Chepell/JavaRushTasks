package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // Объяви переменную типа список строк и сразу проинициализируй ee.
        ArrayList<String> list = new ArrayList<>();
        final int len = 10;

        //Считай 10 строк с клавиатуры и добавь их в список.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < len; i++) {
            String str = reader.readLine();
            list.add(str);
        }

        // Eсли список упорядочен по возрастанию длины строки, то ничего выводить не нужно.
        // Если список не упорядочен по возрастанию длины строки, то нужно вывести на экран
        // индекс первого элемента, нарушающего такую упорядоченность.

        // Инициализирую переменну нулевым индеском, если она не изменится,
        // то значит все строки упорядоченны по возрстанию количества символов
        int ind = 0;
        // Флаг для определения несотрированного списка
        boolean not_sort = false;

        // Цикл итерирую со втрого элемента, т.к. с первым идет сравнение
        for (int i = 1; i < list.size(); i++) {
            // считаю длины предыдущей и текущей строки
            int len0 = list.get(ind).length();
            int len1 = list.get(i).length();
            ind = i; // обновляю индекс на каждой итерации
            // Сравниваю строки
            if (len1 < len0) { // Список не упорядочен, если текущая строка меньше предыдущей
                not_sort = true; // Поднимаю флаг, что список не сортирован
                break; // Прерываю цикл фор, т.к. дальше идти не нужно, условие уже найдено
            }
        }

        // Печатаю индекс
        if (not_sort) {
            System.out.println(ind);
        }
    }
}

