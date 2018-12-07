package com.javarush.task.task08.task0807;

import java.util.*;

/* 
LinkedList и ArrayList
*/

//1. Программа не должна выводить текст на экран.
//2. Программа не должна считывать значения с клавиатуры.
//3. Программа должна содержать только три метода.
//4. Метод createArrayList() должен создавать и возвращать список ArrayList.
//5. Метод createLinkedList() должен создавать и возвращать список LinkedList.


public class Solution {
    public static Object createArrayList() {
        List list = new ArrayList();
        return list;
    }

    public static Object createLinkedList() {
        LinkedList listL = new LinkedList<>();
        return listL;
    }

    public static void main(String[] args) {

    }
}
