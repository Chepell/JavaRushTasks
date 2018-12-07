package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Cat tomCat = new Cat("Tom", 7, 8);
        Dog dogBob = new Dog("Bob", 10, 23);
    }

    // classes
    public static class Mouse {
        String name;
        int height;
        int tail;

        // констроуктор класса по умолчанию
        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Dog {
        String name;
        int age;
        int weight;

        // конструктор класса по умолчанию
        public Dog(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
    }

    public static class Cat {
        String name;
        int age;
        int weight;

        // constructor by default
        public Cat(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
    }
}
