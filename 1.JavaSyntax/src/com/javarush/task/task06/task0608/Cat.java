package com.javarush.task.task06.task0608;

/* 
Статические методы для кошек
*/

public class Cat {
    private static int catCount = 0;

    // базовый конструктор, при создании объекта обновляет счетчик статической переменной
    public Cat() {
        catCount++;
    }

    // геттер позволяющий узнать значение счетчика
    public static int getCatCount() {
        return catCount;
    }

    // сеттер присваивающий значение счетчику
    public static void setCatCount(int catCount) {
        Cat.catCount = catCount;
    }

    public static void main(String[] args) {

    }
}
