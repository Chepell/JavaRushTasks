package com.javarush.task.task08.task0813;

import java.util.Set;
import java.util.HashSet;

/* 
20 слов на букву «Л»
*/

// Не изменяй заголовок метода createSet().
// Программа не должна выводить текст на экран.
// Программа не должна считывать значения с клавиатуры.
// Метод createSet() должен создавать и возвращать множество (реализация HashSet).
// Множество из метода createSet() должно содержать 20 слов на букву «Л».
public class Solution {
    public static Set<String> createSet() {
        HashSet<String> set = new HashSet<>();
        set.add("Локоть");
        set.add("Лево");
        set.add("Лев");
        set.add("Линия");
        set.add("Локальный");
        set.add("Линейный");
        set.add("Ложе");
        set.add("Лямбда");
        set.add("Ломка");
        set.add("Ластик");
        set.add("Ломоть");
        set.add("Ловкач");
        set.add("Логово");
        set.add("Луна");
        set.add("Лор");
        set.add("Лоб");
        set.add("Лес");
        set.add("Лист");
        set.add("Ловкость");
        set.add("Любовь");
        return set;
    }

    public static void main(String[] args) {

    }
}
