package com.javarush.task.task08.task0809;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Время для 10 тысяч вставок
*/

// Программа должна выводить числа на экран.
//4. Метод getTimeMsOfInsert должен вызывать метод insert10000 только один раз.
//5. Метод getTimeMsOfInsert должен вернуть время в миллисекундах, которое занимает 10 тысяч вставок в список.

public class Solution {
    public static void main(String[] args) {
        // Метод main должен вызывать метод getTimeMsOfInsert только два раза.
        System.out.println(getTimeMsOfInsert(new ArrayList()));
        System.out.println(getTimeMsOfInsert(new LinkedList()));
    }

    public static long getTimeMsOfInsert(List list) {
        LocalDateTime new0 = LocalDateTime.now();
        insert10000(list);
        LocalDateTime new1 = LocalDateTime.now();
        Duration duration = Duration.between(new0, new1);
        long millis = duration.toMillis();
        return millis;
    }

    // Метод insert10000(List list) должен вставлять 10 тысяч элементов в список.
    public static void insert10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add(0, new Object());
        }
    }
}
