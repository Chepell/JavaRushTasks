package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
Есть класс кот - Cat, с полем "имя" (String).
Создать словарь Map<String, Cat> и добавить туда 10 котов в виде "Имя"-"Кот".
Получить из Map множество(Set) всех котов и вывести его на экран.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Метод createMap должен создавать новый объект HashMap.
3. Метод createMap должен добавлять в словарь 10 котов в виде «Имя»-«Кот».
4. Метод createMap должен возвращать созданный словарь.
5. Метод convertMapToSet должен создать и вернуть множество котов, полученных из переданного словаря.
6. Программа должна вывести всех котов из множества на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    // метод создает мэп пар ключ : значение
    // значением будет объект класса Cat
    public static Map<String, Cat> createMap() {
        // объявляю и инициирую мэп
        Map<String, Cat> map = new HashMap<>();

        // добавляю пары в мэп
        map.put("Rich", new Cat("Rich"));
        map.put("Tima", new Cat("Tima"));
        map.put("Bob", new Cat("Bob"));
        map.put("Barcik", new Cat("Barcik"));
        map.put("Joe", new Cat("Joe"));
        map.put("Fedor", new Cat("Fedor"));
        map.put("Anton", new Cat("Anton"));
        map.put("Gena", new Cat("Gena"));
        map.put("Alex", new Cat("Alex"));
        map.put("Igor", new Cat("Igor"));

        // метод возвращает созданный мэп
        return map;
    }

    // метод конвертирует мэп в множество
    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        // объявляю и инициирую множество для объектов типа Cat
        Set<Cat> setCat = new HashSet<>();

        // циклом for-each прохожу по парам мэпа
        for (Map.Entry<String, Cat> pair : map.entrySet()) {

            // добавляю value из мэпа во множестов
            setCat.add(pair.getValue());
        }
        // метод возвращает созданное множество
        return setCat;
    }

    // метод печатает объекты Cat из множества построчно
    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            // тут фактически печатается Cat.toString
            // для каждого объекта класса находящегося в множестве
            System.out.println(cat);
        }
    }

    // класс котов, статический, что бы был доступен в этом же классе
    public static class Cat {
        // приватное поле класса
        private String name;

        // конструктор класса с обяхательным заполнением поля имя
        public Cat(String name) {
            this.name = name;
        }

        // переопределение стандартного метода класса родителя Object
        // теперь печать объекта класса Cat приведет вот к этой строке
        public String toString() {
            return "Cat " + this.name;
        }
    }
}
