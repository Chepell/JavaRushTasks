package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

/* 
Множество всех животных
*/

// Программа должна выводить текст на экран.
// Метод printPets() должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки.
public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    // Метод createCats() класса Solution должен возвращать множество (Set) содержащее 4 кота.
    public static Set<Cat> createCats() {
        // обявляюю переменную и инициирую ее для хранения множества объектов типа Cat
        Set<Cat> result = new HashSet<>();
        // в цикле создаю и добавляю объекты в множество
        for (int i = 0; i < 4; i++) {
            result.add(new Cat());
        }
        // возвращаю множество
        return result;
    }

    // Метод createDogs() класса Solution должен возвращать множество (Set) содержащее 3 собаки.
    public static Set<Dog> createDogs() {
        // обявляюю переменную и инициирую ее для хранения множества объектов типа Dog
        Set<Dog> result = new HashSet<>();
        // в цикле создаю и добавляю объекты в множество
        for (int i = 0; i < 3; i++) {
            result.add(new Dog());
        }
        return result;
    }

    // Метод join() класса Solution должен возвращать объединенное множество всех животных - всех котов и собак.
    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        // обявляюю переменную типа Object что бы она могла принять объекты обоих типов (полиморфизм)
        Set<Object> commonSet = new HashSet<>();
        // иду циклом по элементам множества dogs и сохраняю их в новое общее множество
        for (Dog dog : dogs) {
            commonSet.add(dog);
        }
        // иду циклом по элементам множества cats и сохраняю их в новое общее множество
        for (Cat cat : cats) {
            commonSet.add(cat);
        }
        // возвращаю новое множество
        return commonSet;
    }

    // Метод removeCats() должен удалять из множества pets всех котов, которые есть в множестве cats.
    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        // объявляю переменну типа Object и инициирую ее множеством всех животных для итерирования
        Set<Object> copy = new HashSet<>(pets);
        // циклом иду по копии множества
        for (Object obj : copy) {
            // проверяю сожержится ли текущий экзмепляр множества pets в множестве cats
            if (cats.contains(obj)) {
                // если содержится, значит удаляю его из основного множества всех животных
                pets.remove(obj);
            }
        }
    }

    public static void printPets(Set<Object> pets) {
        // прохожу циклом по поданному в метод множеству и печатаю их на экран
        for (Object obj : pets) {
            System.out.println(obj);
        }
    }

    // Внутри класса Solution должен быть public static классы Cat, Dog.
    public static class Cat {

        public Cat() {
        }
    }

    public static class Dog {

        public Dog() {
        }
    }
}
