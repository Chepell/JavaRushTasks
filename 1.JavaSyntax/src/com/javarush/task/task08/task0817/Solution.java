package com.javarush.task.task08.task0817;

import java.util.*;
import java.util.stream.Collectors;

/* 
Нам повторы не нужны
*/
// Программа не должна выводить текст на экран.
// Программа не должна считывать значения с клавиатуры.

public class Solution {
    public static HashMap<String, String> createMap() {
        // Метод createMap() должен создавать и возвращать словарь HashMap
        HashMap<String, String> map = new HashMap<>();

        // с типом элементов String, String состоящих из 10 записей.
        map.put("Войтенко", "Артём");
        map.put("Куйбышев", "Федор");
        map.put("Медведев", "Дима");
        map.put("Белышев", "Ольга");
        map.put("Леонов", "Василий");
        map.put("Иванов", "Василий");
        map.put("Тертичников", "Андрей");
        map.put("Калашников", "Андрей");
        map.put("Логутенко", "Саша");
        map.put("Захарченко", "Саша");
        return map;
    }

    // Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
    // Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().
    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        // опять создаю копию мэпа для итерирования по ней
        Map<String, String> copy = new HashMap<>(map);
        // итерируюсь по копии
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            // переменная считает сколько раз в множестве значений мэпа повторяется значение с текущей итерации
            int count = Collections.frequency(map.values(), pair.getValue());
            if (count > 1) { // когда вижу больше единицы, значит значение как минимум повторяется
                removeItemFromMapByValue(map, pair.getValue()); // и вот теперь вызываю метод удаления
                // передаю функции мэп и текущее значениее
                // а метод уже из оригинала удаляет пару ключ : значение
            }
        }
    }

    // метод удаляет элемет из мэпа по ключу
    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        // создаю копию мэпа, и при инициализации помещаю туда существующий мэп
        // это прям реальная копия
        // она нужна для того что бы именной по ней пройти, а удалять в это время пары с основного мэпа
        // иначе метод посыпется т.к. мы удаляем пару и идем по мэпу циклом.
        Map<String, String> copy = new HashMap<>(map);
        // вот сам цикл итерируется по скопированному мэпу, это видно по copy.entrySet()
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            // если в копии нахожу элемент с нужным значением
            if (pair.getValue().equals(value)) {
                // то уже по соответствующему ключу нахожу его в основном мэпе и удаляю
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
//        HashMap maap = createMap();
//
//        printMap(maap);
//        System.out.println();
//        removeTheFirstNameDuplicates(maap);
//        printMap(maap);
    }

    // метод печатает пары ключ : значение
    public static void printMap(HashMap<String, String> map) {
        for (Map.Entry<String, String> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }
}
