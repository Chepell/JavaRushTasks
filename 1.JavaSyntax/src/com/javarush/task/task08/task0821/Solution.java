package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

// Программа должна выводить текст на экран.
// Класс Solution должен содержать только три метода.
public class Solution {
    public static void main(String[] args) {
        // Метод main() должен вызывать метод createPeopleList().
        Map<String, String> map = createPeopleList();

        // Метод main() должен вызывать метод printPeopleList().
        printPeopleList(map);
    }

    // Метод createPeopleList() должен создавать и возвращать словарь Map
    // с типом элементов String, String. Кроме того, добавлять в словарь 10 человек.
    // В методе createPeopleList() должны добавляться люди с одинаковыми фамилиями.
    // В методе createPeopleList() должны добавляться люди с одинаковыми именами.
    public static Map<String, String> createPeopleList() {
        Map<String, String> map = new HashMap<>();
        map.put("Войтенко", "Артём");
        map.put("Куйбышев", "Федор");
        map.put("Медведев", "Дима");
        map.put("Белышев", "Ольга");
        map.put("Леонов", "Василий");
        map.put("Войтенко", "Василий");
        map.put("Тертичников", "Андрей");
        map.put("Калашников", "Андрей");
        map.put("Логутенко", "Саша");
        map.put("Захарченко", "Саша");
        return map;
    }

    // Метод printPeopleList() должен выводить на экран всех людей из словаря Map.
    // Каждое значение вывести с новой строки. Фамилия и имя разделены пробелом.
    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}