package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Объяви переменную коллекции HashMap с типом элементов String, String и сразу проинициализируй ee.
        HashMap<String, String> map = new HashMap<>();

        // Программа не должна считывать значения с клавиатуры.
        // Программа должна добавлять в коллекцию 10 пар строк, согласно условию.
        map.put("арбуз", "ягода");
        map.put("банан", "трава");
        map.put("вишня", "ягода");
        map.put("груша", "фрукт");
        map.put("дыня", "овощ");
        map.put("ежевика", "куст");
        map.put("жень-шень", "корень");
        map.put("земляника", "ягода");
        map.put("ирис", "цветок");
        map.put("картофель", "клубень");

        // Программа должна выводить содержимое коллекции на экран, каждую пару через дефис и с новой строки.
        for (Map.Entry<String, String> pair: map.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }

    }
}
