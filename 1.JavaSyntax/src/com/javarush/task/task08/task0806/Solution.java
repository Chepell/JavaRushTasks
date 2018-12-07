package com.javarush.task.task08.task0806;

import java.util.HashMap;
import java.util.Map;

/* 
Коллекция HashMap из Object
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Программа должна создавать переменную коллекции HashMap с типом элементов String, Object. 
        // Переменная должна быть сразу проинициализирована.
        HashMap<String, Object> map = new HashMap<>();

        // Программа не должна считывать значения с клавиатуры.
        // Программа должна добавлять в коллекцию 10 различных объектов, согласно условию.
        map.put("Sim", 5);
        map.put("Tom", 5.5);
        map.put("Arbus", false);
        map.put("Baby", null);
        map.put("Cat", "Cat");
        map.put("Eat", new Long(56));
        map.put("Food", new Character('3'));
        map.put("Gevey", '6');
        map.put("Hugs", 111111111111L);
        map.put("Comp", (double) 123);

        // Программа должна выводить на экран содержимое коллекции, каждый элемент с новой строки.
        for (Map.Entry<String, Object> pair: map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }

    }
    
    
}
