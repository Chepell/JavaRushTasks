package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/
//1. Программа не должна выводить текст на экран.
//2. Программа не должна считывать значения с клавиатуры.

public class Solution {
    // Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов
    // String, Integer состоящих из 10 записей по принципу «фамилия» - «зарплата».
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Войтенко", 5000);
        map.put("Куйбышев", 499);
        map.put("Медведев", 505);
        map.put("Белышев", 1700);
        map.put("Леонов", 3000);
        map.put("Иванов", 2000);
        map.put("Тертичников", 4300);
        map.put("Калашников", 450);
        map.put("Логутенко", 1500);
        map.put("Захарченко", 2500);
        return map;
    }

    // Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500.
    public static void removeItemFromMap(HashMap<String, Integer> map) {
        // создаю копию мэпа для итерации по нему
        HashMap<String, Integer> copy = new HashMap<>(map);
        // сам итератор по копии мэпа
        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            // проверка, если значение меньше 500
            if (pair.getValue() < 500) {
                map.remove(pair.getKey()); // удаляю пару из оригинального мэпа
            }
        }
    }

    public static void main(String[] args) {
//        HashMap map0 = createMap();
//        printMap(map0);
//        System.out.println();
//        removeItemFromMap(map0);
//        printMap(map0);
    }

    // метод печатает пары ключ : значение
    public static void printMap(HashMap<String, Integer> map) {
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }
}