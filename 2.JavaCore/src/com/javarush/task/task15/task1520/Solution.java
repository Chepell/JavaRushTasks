package com.javarush.task.task15.task1520;

/* 
Тренировка мозга
Найти логическую ошибку: утка(Duck) должна корректно реализовывать интерфейс Movable.
Исправьте ошибку.

Результат вывода в консоль должен быть:
flying
moving


Требования:
1. Результат вывода на экран должен соответствовать условию.
2. В классе Duck должен быть реализован метод doAnotherAction.
3. Метод doAnotherAction() в классе Duck должен выводить на экран строку "moving".
4. Метод move в классе Util должен вызывать метод doAnotherAction у переданного ему объекта.
5. Класс Duck должен реализовывать интерфейс Movable.
6. Класс Duck должен реализовывать интерфейс Flyable.
*/

public class Solution {
    public static void main(String[] args) {
        // обявление и инициализация объекта класса
        Duck duck = new Duck();
        // доступ к статичным методам класса
        Util.fly(duck);
        Util.move(duck);
    }

    public static class Duck implements Flyable, Movable {
        // реализация методов интерфейсов
        @Override
        public void doAction() {
            System.out.println("flying");
        }

        @Override
        public void doAnotherAction() {
            System.out.println("moving");
        }
    }

    // статичный класс с доступными методами принимающими объекты
    // реализующие интерфейс Flyable и Movable
    public static class Util {
        // в качестве аргумента подяется объект реализующий интерфейс Flyable
        // и получает метод интерфейса Flyable
        static void fly(Flyable animal) {
            animal.doAction();
        }

        // в качестве аргумента подяется объект реализующий интерфейс Movable
        // и получает метод интерфейса Movable
        static void move(Movable animal) {
            animal.doAnotherAction();
        }
    }

    // интерфейсы с методами под реализацию в классах
    public interface Flyable {
        void doAction();
    }

    public interface Movable {
        void doAnotherAction();
    }
}
