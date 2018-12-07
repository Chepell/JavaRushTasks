package com.javarush.task.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Клининговый центр
*/

public class Solution {
    public static void main(String[] args) {
        // список объектов интерфейса Apartments
        List<Apartment> apartments = new ArrayList<>();
        // добавление объектов в список
        apartments.add(new Apt1Room());
        apartments.add(new Apt2Room());
        apartments.add(new Apt3Room());
        // вызов метода отчистик всех квартир
        cleanAllApartments(apartments);
    }

    // реализация метода для вызова конкретных методов
    // конкретного класс
    // аргументом передаются сипсок интерфеса
    public static void cleanAllApartments(List<Apartment> apartments) {
        // прохожу по списку циклом
        for (Apartment i : apartments) {
            // проврка принадлежности объекта конкретному классу
            if (i instanceof Apt1Room) {
                // вызов метода конкретного класса на объекте
                ((Apt1Room) i).clean1Room();
            } else if (i instanceof Apt2Room) {
                ((Apt2Room) i).clean2Rooms();
            } else if (i instanceof Apt3Room) {
                ((Apt3Room) i).clean3Rooms();
            }
        }
    }


    interface Apartment {
    }

    static class Apt1Room implements Apartment {
        void clean1Room() {
            System.out.println("1 room is cleaned");
        }
    }

    static class Apt2Room implements Apartment {
        void clean2Rooms() {
            System.out.println("2 rooms are cleaned");
        }
    }

    static class Apt3Room implements Apartment {
        void clean3Rooms() {
            System.out.println("3 rooms are cleaned");
        }
    }
}
