package com.javarush.task.task24.task2410;

import java.util.LinkedList;
import java.util.List;

/* 
Рефакторинг, анонимные классы
Сделайте так, чтобы метод getIterator возвращал анонимный класс.
Перенесите логику LocalIterator в анонимный класс.
Меняйте только тело метода getIterator.


Требования:
1. Метод getIterator должен возвращать объект типа Iterator.
2. Объект возвращаемый методом getIterator должен быть экземпляром анонимного класса.
3. Программа должна выводить данные на экран.
4. Логика поведения программы должна остаться прежней.
*/
public class Solution {
    // статичное поле класса в виде списка объектов интерфейса Iterator
    public static List<Iterator> iterators = new LinkedList<>();
    // поле счетчик объектов
    private int countItems;

    // метод возвращающий объект интерфейса Iterator
    public Iterator getIterator(final String name) {
        // созаем анонимный класс и сразу его возвращаем
        return new Iterator(){
            // у анонимного класса нет конструктора, но есть блок инициализации
            {
                countItems++;
                System.out.println(name + " item " + countItems);
            }
            // переоределяем метод интрефейса
            @Override
            public Iterator next() {
                // что бы вернуть объект анонимного класса, просто вызываем сам метод
                return getIterator(name);
            }
        };
    }

//    // метод возвращающий объект интерфейса Iterator
//    public Iterator getIterator(final String name) {
//        // внутри создается класс LocalIterator
//        class LocalIterator implements Iterator {
//            // конструктор класса
//            public LocalIterator() {
//                countItems++;
//                System.out.println(name + " item " + countItems);
//            }
//            // реализация метода интерфейса, которая создает новый объект
//            public Iterator next() {
//                return new LocalIterator();
//            }
//        }
//        // и метод возвращает объект класса
//        return new LocalIterator();
//    }

    public static void main(String[] args) {
        // создается объект главного класса
        Solution solution = new Solution();

        // на этом объекте вызывается метод, который создает объект итератора
        Iterator iterator = solution.getIterator("iterator");
        // циклом добавляются объекты в список, которые создаются с помощью реализованного метода next()
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}
