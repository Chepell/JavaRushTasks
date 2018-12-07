package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

// Программа должна выводить текст на экран.
public class Solution {
    public static void main(String[] args) {
        // Метод main() должен один раз вызывать метод createCats().
        Set<Cat> cats = createCats();

        // Метод main() должен вызывать метод printCats().
        printCats(cats);

        // Метод main() должен удалять одного кота из множества котов.
        cats.remove(cats.toArray()[0]);

    }

    // Метод createCats() класса Solution должен возвращать множество (Set) содержащее 3 кота.
    public static Set<Cat> createCats() {
        Set<Cat> catSet = new HashSet<>();
        catSet.add(new Cat());
        catSet.add(new Cat());
        catSet.add(new Cat());
       
        return catSet;
    }

    // Метод printCats() класса Solution должен вывести на экран всех котов из множества. Каждый кот с новой строки.
    public static void printCats(Set<Cat> cats) {
        for (Cat i : cats) {
            System.out.println(i.toString());
        }
    }

    // Внутри класса Solution должен быть public static класс Cat с конструктором по умолчанию.
    public static class Cat {


    }

}
