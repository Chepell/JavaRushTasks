package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
Создать массив, элементами которого будут списки строк.
Заполнить массив любыми данными и вывести их на экран.


Требования:
1. Метод createList должен объявлять и инициализировать массив с типом элементов ArrayList.
2. Метод createList должен возвращать созданный массив.
3. Метод createList должен добавлять в массив элементы (списки строк). Списки должны быть не пустые.
4. Программа должна выводить данные на экран.
5. Метод main должен вызывать метод createList.
6. Метод main должен вызывать метод printList.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String> list0 = new ArrayList<>();
        list0.add("Привет");
        list0.add("Пока");

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Здравствуйте");
        list1.add("До свидания");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Как дела");
        list2.add("Что нового");

        ArrayList<String>[] array = new ArrayList[3];
        array[0] = list1;
        array[1] = list1;
        array[2] = list2;

        return array;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}