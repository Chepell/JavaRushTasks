package com.javarush.task.task35.task3512;

/* 
Генератор объектов
*/
public class Solution {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Generator<Event> eventGenerator = new Generator<>(Event.class);

        System.out.println(eventGenerator.newInstance().getId()); // 1
        System.out.println(eventGenerator.newInstance().getId()); // 2
        System.out.println(eventGenerator.newInstance().getId()); // 3
    }

}
