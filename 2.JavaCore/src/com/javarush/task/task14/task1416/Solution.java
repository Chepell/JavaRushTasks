package com.javarush.task.task14.task1416;

/* 
Исправление ошибок
1. Подумай, как связаны интерфейсы Swimmable(способен плавать)
    и Walkable(способен ходить) с классом OceanAnimal(животное океана).
2. Расставь правильно наследование интерфейсов и класса OceanAnimal.
3. Подумай, как могут быть связаны классы Orca(Косатка), Whale(Кит), Otter(Выдра) с классом OceanAnimal.
4. Расставь правильно наследование между классами Orca, Whale, Otter и классом OceanAnimal.
5. Подумай, какой класс должен реализовать интерфейс Walkable и добавить интерфейс этому классу.
6. Подумай, какое животное еще не умеет плавать и добавить ему интерфейс Swimable.


Требования:
1. Косатка(Orca) является животным океана(потомком OceanAnimal) и умеет плавать(поддерживает интерфейс Swimmable).
2. Кит(Whale) является животным океана(потомком OceanAnimal) и умеет плавать(поддерживает интерфейс Swimmable).
3. Выдра(Otter) умеет ходить(поддерживает интерфейс Walkable) и плавать(поддерживает интерфейс Swimmable).
4. Выдра(Otter) НЕ является животным океана(потомком OceanAnimal).
5. Кит(Whale) и Косатка(Orca) НЕ умеют ходить(не поддерживают интерфейс Walkable).
*/

public class Solution {
    public static void main(String[] args) {
        Swimmable animal = new Orca();
        animal.swim();
        animal = new Whale();
        animal.swim();
        animal = new Otter();
        animal.swim();
    }

    public static void test(Swimmable animal) {
        animal.swim();
    }

    // интерфейс отвечающий за умение ходить
    interface Walkable {
        // метод ходьбы для реализации, ничего не возвращает
        void walk();
    }

    // интерфейс отвечающий за умение плавать
    interface Swimmable {
        // метод плавания для реализации, ничего не возвращает
        void swim();
    }

    // абстрактный класс океанических животных с реализацией класс правания
    static abstract class OceanAnimal implements Swimmable {
        // реализация метода интерфейса
        @Override
        public void swim() {
            OceanAnimal currentAnimal = (OceanAnimal) getCurrentAnimal();
            currentAnimal.swimming();
        }

        // метод печатает короткое имя класса и добавляет строку, что он умеет плавать
        private void swimming() {
            System.out.println(getCurrentAnimal().getClass().getSimpleName() + " is swimming");
        }

        // абстрактный метод интерфейса Swimmable
        // обязателен для реализации в классах наследниках
        abstract Swimmable getCurrentAnimal();
    }

    // класс касатки, наследник морских гадов
    static class Orca extends OceanAnimal{
        @Override
        Swimmable getCurrentAnimal() {
            return this;
        }
    }

    // кит
    static class Whale extends OceanAnimal {
        @Override
        Swimmable getCurrentAnimal() {
            return this;
        }
    }

    // выдра не морской гад
    static class Otter implements Walkable, Swimmable {

        @Override
        public void walk() {
            System.out.println(this.getClass().getSimpleName() + " can walk!");
        }

        @Override
        public void swim() {
            System.out.println(this.getClass().getSimpleName() + " can swim!");
        }
    }
}
