package com.javarush.task.task07.task0726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Не компилируется задача про котиков
*/

// Программа должна считывать данные с клавиатуры.
// Если пользователь ввел пустую строку вместо имени, то программа должна вывести данные на экран и завершиться.
// Если пользователь ввел: Barsik, 6, 5 и 22 (каждое значение с новой строки),
// то программа должна вывести "Cat name is Barsik, age is 6, weight is 5, tail = 22".
// Если пользователь ввел: Murka, 8, 7 и 20 (каждое значение с новой строки),
// то программа должна вывести "Cat name is Murka, age is 8, weight is 7, tail = 20".
// Если пользователь ввел: Barsik, 6, 5, 22, Murka, 8, 7 и 20 (каждое значение с новой строки),
// то программа должна вывести две строки:
// "Cat name is Barsik, age is 6, weight is 5, tail = 22" и "Cat name is Murka, age is 8, weight is 7, tail = 20".

public class Solution {
    // Создаю публичный список глоабальных констант в виде объектов Cat
    public final static ArrayList<Cat> CATS = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // ввод имени
            String name = reader.readLine();

            // если имя пустое, то прерываю бескоченый цикл
            if (name.isEmpty()) break;
            // ввод остальных аргуентов объекта
            int age = Integer.parseInt(reader.readLine());
            int weight = Integer.parseInt(reader.readLine());
            int tail = Integer.parseInt(reader.readLine());

            // сосдание объекта конструктором
            Cat cat = new Cat(name, age, weight, tail);
            // добавление созанного объекта в список
            CATS.add(cat);
        }

        printList();
    }

    // метод печати объектов из списка
    public static void printList() {
        for (int i = 0; i < CATS.size(); i++) {
            System.out.println(CATS.get(i));
        }
    }

    // класс кота
    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int tailLength;

        // конструктор класса, заменяющий конструктор по умолчанию
        public Cat(String name, int age, int weight, int tailLength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.tailLength = tailLength;
        }

        // метод перегружающий стандартный метод
        // и при запросе данных объекта
        // возвращающий строку с параметрами объекта в отформатированном виде
        @Override
        public String toString() {
            return "Cat name is " + name + ", age is " + age + ", weight is " + weight + ", tail = " + tailLength;
        }
    }
}


