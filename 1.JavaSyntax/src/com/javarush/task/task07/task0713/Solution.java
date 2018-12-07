package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //Объяви и сразу проинициализируй 4 переменных типа ArrayList (список целых чисел).
        //Первый список будет главным, а остальные - дополнительными.
        ArrayList<Integer> base_list = new ArrayList<>();
        ArrayList<Integer> tree_list = new ArrayList<>();
        ArrayList<Integer> two_list = new ArrayList<>();
        ArrayList<Integer> last_list = new ArrayList<>();

        //Считать 20 чисел с клавиатуры и добавить их в главный список.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0, num; i < 20; i++) {
            num = Integer.parseInt(reader.readLine());
            base_list.add(num);
        }

        //Добавить в первый дополнительный список все числа из главного, которые нацело делятся на 3.
        //Добавить во второй дополнительный список все числа из главного, которые нацело делятся на 2.
        //Добавить в третий дополнительный список все остальные числа из главного.
        for (int i = 0; i < base_list.size(); i++) {
            Integer x = base_list.get(i);
            if (x % 3 == 0) {
                tree_list.add(x);
            }
            if (x % 2 == 0) {
                two_list.add(x);
            }
            if (x % 3 != 0 && x % 2 != 0) {
                last_list.add(x);
            }
        }
        //Метод printList должен выводить на экран все элементы переданного списка, каждый с новой строки.
        //Программа должна вывести три дополнительных списка, используя метод printList.
        printList(tree_list);
        printList(two_list);
        printList(last_list);
    }

    public static void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
