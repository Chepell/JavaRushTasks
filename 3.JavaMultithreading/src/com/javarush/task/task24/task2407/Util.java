package com.javarush.task.task24.task2407;

import java.util.LinkedList;
import java.util.List;

public class Util {
    //Util отлично работает со всеми классами Cat, Mouse. А ведь Mouse отличается от Cat.
    public static void printDialog(List<Sayable> pets) {
        for (int i = 0; i < pets.size(); i++) {
            // циклом по всем объектам списка достаю метод say()
            System.out.println(pets.get(i).say());
        }
    }

    // метод возвращающий список объектов класса Pet
    public static List<Pet> getPets() {
        List<Pet> pets = new LinkedList<>();
        pets.add(new Cat("Мурзик"));
        pets.add(new Cat("Васька"));
        pets.add(new Cat("Кошка"));
        pets.add(new Mouse());
        pets.add(new Cat("Томас"));
        return pets;
    }

    // метод принимает список объектов Pet а возвраащет объекты интерфейса
    public static List<Sayable> convertPetToSayable(List<Pet> pets) {
        List<Sayable> result = new LinkedList<>();
        // циклом список вычитывается
        for (Pet pet : pets) {
            // генерируется случайное число
            int i = (int) (Math.random() * 7) - 2;
            // в новый список добавляется объект Sayable с помощью использования метода на объекте Pet
            result.add(pet.toSayable(i));
        }
        return result;
    }
}
