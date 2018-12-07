package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    // поля класса, приватный список всех лошадей
    private List<Horse> horses = new ArrayList<>();
    // статическое поле игры
    public static Hippodrome game;

    // конструктор с параметром принимающим список лошадей
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }


    // геттер для получения списка лошадей
    public List<Horse> getHorses() {
        return horses;
    }

    // метод  в цикле проходит по всем лошадям списка и вызывает их методы move
    public void move() {
//        for (Horse horse : horses) {
//            horse.move();
//        }
        horses.forEach(Horse::move);
    }

    // метод  в цикле проходит по всем лошадям списка и вызывает их методы print
    public void print() {
        // метод в цикле вызывает методы print() для каждой лошади Horse из списка horses
        horses.forEach(Horse::print);
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // метод для поиска в списке с лошедями той, которая прошла максимальное расстояние
    public Horse getWinner() {
//        Horse winner = null;
//        double distanseOfWinner = 0;
//        for (Horse horse : horses) {
//            if (horse.getDistance() > distanseOfWinner) {
//                distanseOfWinner = horse.getDistance();
//                winner = horse;
//            }
//        }
//        return winner;

        // метод полностью заменяет все что выше
        return horses
                .stream() // превращаю список в поток
                .max(Comparator // вызываю метод поиска максимума
                        .comparing(Horse::getDistance)) // вызываю внутри метод сравнения по getDistance
                .orElse(null); // и в конце вызываю условие что вернуть если не найден максимум
    }


    public void printWinner() {
        String name = getWinner().getName();
        System.out.printf("Winner is %s!", name);
    }


    public static void main(String[] args) {
        List<Horse> horseList = new ArrayList<>();
        horseList.add(new Horse("Phil", 3, 0));
        horseList.add(new Horse("Mary", 3, 0));
        horseList.add(new Horse("John", 3, 0));
        game = new Hippodrome(horseList);

        game.run();
        game.printWinner();
    }
}
