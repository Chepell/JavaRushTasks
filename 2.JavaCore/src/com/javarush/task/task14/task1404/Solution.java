package com.javarush.task.task14.task1404;

/* 
Коты
1. Считывать строки(параметры) с консоли, пока пользователь не введет пустую строку(Enter).
2. Каждый параметр соответствует имени кота.

Для каждого параметра:
3. Создать объект cat класса Cat, который равен коту из getCatByKey(String параметр).
4. Вывести на экран cat.toString().


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна прекращать считывать данные после ввода пустой строки.
3. Программа должна выводить на экран описание каждого кота (cat.toString).
4. Программа должна создавать объект класса Cat для каждого введенного имени
    кота(строки считанной с клавиатуры) c помощью метода getCatByKey.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        List<Cat> cats = new ArrayList<>();

        while (true) {
            name = reader.readLine();
            if (name.isEmpty()) break;
            cats.add(CatFactory.getCatByKey(name));
        }

        for (Cat i: cats) {
            System.out.println(i.toString());
        }
    }

    // статичный класс что бы был доступен тут же
    static class CatFactory {
        // метод доступный без создания объекта класса
        static Cat getCatByKey(String key) {
            // создается пустой указатель
            Cat cat;
            // проверка имени поданного в качестве аргумента метода
            if ("vaska".equals(key)) {
                // замена имени на русское и выбор конкретного класса наследника Cat
                cat = new MaleCat("Василий");
            } else if ("murka".equals(key)) {
                cat = new FemaleCat("Мурочка");
            } else if ("kiska".equals(key)) {
                cat = new FemaleCat("Кисюлька");
            } else {
                // если имя не осответствует ни одному варианту
                // то создается объект в классе родителе
                cat = new Cat(key);
            }
            // метод возвращает созданный объект
            return cat;
        }
    }

    // суперкласс
    static class Cat {
        private String name;

        // конструктор, доступный внутри пакета и всем наследникам
        protected Cat(String name) {
            this.name = name;
        }

        // геттер имени
        public String getName() {
            return this.name;
        }

        // переопределение стандартного метода
        public String toString() {
            return "Я уличный кот " + getName();
        }
    }

    // класс наследник
    static class MaleCat extends Cat {
        // конструктор берет правило объявления имени у родительского класса
        MaleCat(String name) {
            super(name);
        }

        // переопределение
        public String toString() {
            return "Я - солидный кошак по имени " + getName();
        }
    }

    static class FemaleCat extends Cat {
        FemaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - милая кошечка по имени " + getName();
        }
    }
}
