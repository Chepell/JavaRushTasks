package com.javarush.task.task08.task0805;

import java.util.HashMap;
import java.util.Map;

/* 
На экране — значения!
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Программа должна создавать переменную коллекции HashMap с типом элементов String, String. Переменная должна быть сразу проинициализирована.
        HashMap<String, String> map = new HashMap<>();

        // Программа не должна считывать значения с клавиатуры.
        // Программа должна добавлять в коллекцию 10 различных строк, согласно условию.
        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");

        printValues(map);
    }

    // Метод printValues() должен выводить на экран список значений коллекции, каждый элемент с новой строки.
    public static void printValues(Map<String, String> map) {
        for (Map.Entry<String, String> pair: map.entrySet()) {
            System.out.println(pair.getValue());
        }
    }
}
