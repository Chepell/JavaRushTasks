package com.javarush.task.task08.task0803;

import java.util.HashMap;
import java.util.Map;

/* 
Коллекция HashMap из котов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // есть массив строк с именами котов
        String[] cats = new String[]{"васька", "мурка", "дымка", "рыжик", "серый", "снежок", "босс", "борис", "визя", "гарфи"};

        // создание хеш-меп и инициалиазция ее с помощью метода
        HashMap<String, Cat> map = addCatsToMap(cats);

        // печать содержимого хеш-мепа
        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            // печатается ключ и вызывается пере записанный
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }


    public static HashMap<String, Cat> addCatsToMap(String[] cats) {
        // Создаю и инициую хеш-мэп
        HashMap<String, Cat> map = new HashMap<>();

        // в цикле длина которого равна поданному массиву строк
        for (int i = 0; i < cats.length; i++) {
            // создаю объект класса Cat с именем = полю массива
            //Cat cat = new Cat(cats[i]); // сразу в вэлуе добавляю
            // помещаю имя в key а сам объект в value хеш-мапа
            map.put(cats[i], new Cat(cats[i]));
        }
        return map;
    }


    public static class Cat {
        // поле класса
        String name;

        // конструктор класса c обязательным именем
        public Cat(String name) {
            this.name = name;
        }

        // переопределенный метод из класса Object
        @Override
        public String toString() {
            // если имя есть, то возвращает его в верхнем регистре, иначе возвращает что было null
            return name != null ? name.toUpperCase() : null;
        }
    }
}