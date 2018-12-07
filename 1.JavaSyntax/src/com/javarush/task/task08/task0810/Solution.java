package com.javarush.task.task08.task0810;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 
Время для 10 тысяч вызовов get
*/

// Программа должна выводить числа на экран.
public class Solution {
    public static void main(String[] args) {
        // Метод main должен вызывать метод getTimeMsOfGet только два раза.
        // Метод main должен вызывать метод fill только два раза.
        System.out.println(getTimeMsOfGet(fill(new ArrayList())));
        System.out.println(getTimeMsOfGet(fill(new LinkedList())));
    }

    // метод наполняет список элементами в цикле
    // и возвращает список
    public static List fill(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add(new Object());
        }
        return list;
    }

    // Метод getTimeMsOfGet должен вызывать метод get10000(List list) только один раз.
    // Метод getTimeMsOfGet должен вернуть время в миллисекундах, которое занимает 10 тысяч вызовов get для списка.
    public static long getTimeMsOfGet(List list) {
        LocalDateTime before = LocalDateTime.now();

        get10000(list);

        LocalDateTime after = LocalDateTime.now();

        Duration duration = Duration.between(before, after);
        long millis = duration.toMillis();
        return millis;
    }

    // метод достает из списка элемент в цикле
    public static void get10000(List list) {
        // проверка что списко не пустой, если пустой выход из метода
        if (list.isEmpty()) return;
        // индекс центрального элемента для доступа
        int x = list.size() / 2;
        // ну и сам цикл
        for (int i = 0; i < 10000; i++) {
            list.get(x);
        }
    }
}
