package com.javarush.task.task08.task0811;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Квартет «Методы»
*/
// Программа не должна выводить текст на экран.
//2. Класс Solution должен содержать только 5 методов.
//3. Метод getListForGet должен возвращать список, который лучше всего подходит для операции взятия элемента.
//4. Метод getListForSet должен возвращать список, который лучше всего подходит для установки значения элемента.
//5. Метод getListForAddOrInsert должен возвращать список, который лучше всего подходит для операций добавления или вставки элемента.
//6. Метод getListForRemove должен возвращать список, который лучше всего подходит для операции удаления элемента.

public class Solution {
    public static List getListForGet() {
        List list = new ArrayList();
        return list;
    }

    public static List getListForSet() {
        List list = new ArrayList();
        return list;
    }

    public static List getListForAddOrInsert() {
        List list = new LinkedList();
        return list;

    }

    public static List getListForRemove() {
        List list = new LinkedList();
        return list;
    }

    public static void main(String[] args) {

    }
}
