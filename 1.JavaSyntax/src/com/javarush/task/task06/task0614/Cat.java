package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    // Добавь в класс Cat публичную статическую переменную cats (ArrayList).
    // Переменная cats должна быть проинициализирована.
    public static ArrayList<Cat> cats = new ArrayList<>();

    public Cat() {
    }

    public static void main(String[] args) {
        // Метод main должен создавать 10 объектов Cat (используй конструктор Cat()).
        for (int i = 0; i < 10; i++) {
//            Cat cat = new Cat();
//            // Метод main должен добавить всех созданных котов в переменную cats.
//            cats.add(cat);
            cats.add(new Cat());
        }


        printCats();
    }

    // Метод printCats должен выводить всех котов из переменной cats на экран. Каждого с новой строки.
    public static void printCats() {
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.get(i));
        }
    }
}
