package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Объяви переменную коллекции HashSet с типом элементов String и сразу проинициализируй ee.
        HashSet<String> set = new HashSet<>();

        // Программа не должна считывать строки с клавиатуры.
        // Программа должна добавлять в коллекцию 10 строк, согласно условию.
        set.add("арбуз");
        set.add("банан");
        set.add("вишня");
        set.add("груша");
        set.add("дыня");
        set.add("ежевика");
        set.add("женьшень");
        set.add("земляника");
        set.add("ирис");
        set.add("картофель");

        // Программа должна выводить 10 строк из коллекции на экран, каждую с новой строки.
        for (String str : set) {
            System.out.println(str);
        }
    }
}
