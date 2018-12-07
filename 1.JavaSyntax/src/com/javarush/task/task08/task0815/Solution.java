package com.javarush.task.task08.task0815;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

// Программа не должна выводить текст на экран.
// Программа не должна считывать значения с клавиатуры.
public class Solution {
    public static HashMap<String, String> createMap() {
        // Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String,
        // String состоящих из 10 записей по принципу «Фамилия» - «Имя».
        HashMap<String, String> map = new HashMap<>();
        map.put("Войтенко", "Артем");
        map.put("Куйбышев", "Ольга");
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

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        // Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
        // счетчик имен в списке, по умолчанию считаю, что имен нет
        int counter = 0;
        // итерирую по мепу
        for (Map.Entry<String, String> pair : map.entrySet()) {
            // если найдено значение
            if (pair.getValue().equals(name)) {
                counter++; // то обновляю счетчик
            }
        }
        return counter; // метод возвращает значение счетчика
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        // Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.
        // keys могут быть только уникальными, поэтому просто проверяю есть ли ключ в мэпе
        if (map.containsKey(lastName)) {
            return 1;
        }
        return 0; // если в иф не зашли, значит ключа нет и метод возвращает 0
    }

    public static void main(String[] args) {
//        HashMap mapp = createMap();
//        int count_name = getCountTheSameFirstName(mapp, "Дима");
//        int count_surname = getCountTheSameLastName(mapp, "Козлов");
//
//        System.out.printf("Указанных фамилий %d, указанных имен %d", count_surname, count_name);
    }
}
