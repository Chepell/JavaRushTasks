package com.javarush.task.task13.task1315;

/* 
Том, Джерри и Спайк
1. Создай классы Dog, Cat и Mouse.
2. Реализуй интерфейсы в добавленных классах, учитывая что:
- Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.
- Мышь(Mouse) может передвигаться и может быть съедена.
- Собака(Dog) может передвигаться и съесть кого-то.


Требования:
1. Класс Cat должен быть объявлен внутри класса Solution.
2. Класс Dog должен быть объявлен внутри класса Solution.
3. Класс Mouse должен быть объявлен внутри класса Solution.
4. Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.
5. Мышь(Mouse) может передвигаться и может быть съедена.
6. Собака(Dog) может передвигаться и съесть кого-то.
*/

public class Solution {
    public static void main(String[] args) {

    }

    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Eatable {
        void eaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }

    public class Cat implements Movable, Eatable, Eat {
        @Override
        public void move() {
            System.out.println("I cam chase to the mouse!");
        }

        @Override
        public void eaten() {
            System.out.println("If dog will catch me, I'll be eaten by him");
        }

        @Override
        public void eat() {
            System.out.println("I'll catch mouse and eat him");
        }
    }

    public class Dog implements Movable, Eat {
        @Override
        public void move() {
            System.out.println("I cam chase to the cat!");
        }

        @Override
        public void eat() {
            System.out.println("I'll catch cat and eat him");
        }
    }

    public class Mouse implements Movable, Eatable {
        @Override
        public void move() {
            System.out.println("I can only flee");
        }

        @Override
        public void eaten() {
            System.out.println("If cat will catch me, I'll be eaten by him");
        }
    }

}