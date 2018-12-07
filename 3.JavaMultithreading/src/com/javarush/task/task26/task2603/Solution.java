package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напиши public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать массив компараторов.
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т.
В конструктор передается как минимум один компаратор.


Требования:
1. Класс Solution должен содержать public static компаратор CustomizedComparator.
2. Класс CustomizedComparator должен содержать приватное поле comparators типа Comparator[].
3. Класс CustomizedComparator должен содержать конструктор с параметром vararg компараторов.
4. Метод compare() класса CustomizedComparator должен сравнивать объекты в порядке,
    соответствующем последовательности компараторов comparators.
*/
public class Solution {

    public static void main(String[] args) {

    }

    // класс Comparator
    public static class CustomizedComparator<T> implements Comparator<T> {
        // поле класса, массив сортировщиков
        private Comparator<T>[] comparators;

        // при создании принимает массив уже реализованных Comparator
        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        // реализация метода сортировки
        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            // циклом иду по массиву сортировщиков и вызываю
            // почередно метод compare каждого из сортировщиков
            for (Comparator comparator : comparators) {
                // в переменную помещаю результат сортировки
                result = comparator.compare(o1, o2);
                //если аргументы равны, переходим к следующему
                // компаратору (критерию сравнения), если разные возвращаем результат сравнения
                if (result != 0) break;
            }
            return result;
        }
    }
}

