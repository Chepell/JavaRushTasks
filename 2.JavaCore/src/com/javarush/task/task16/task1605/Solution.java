package com.javarush.task.task16.task1605;

import java.util.Date;

/* 
Поговорим о музыке
1. Измени класс Violin так, чтоб он стал таском для нити.
    Используй интерфейс MusicalInstrument
2. Реализуй необходимый метод в нити Violin. Реализация должна быть следующей:
2.1. Считай время начала игры - метод startPlaying().
2.2. Подожди 1 секунду - метод sleepNSeconds(int n), где n - количество секунд.
2.3. Считай время окончания игры - метод stopPlaying().
2.4. Выведи на консоль продолжительность игры в миллисекундах.
    Используй методы из пунктов 2.1 и 2.3.

Пример "Playing 1002 ms".


Требования:
1. Класс Violin не должен быть унаследован от какого-либо дополнительного класса.
2. Класс Violin должен реализовывать интерфейс MusicalInstrument.
3. Метод run класса Violin должен вызывать метод startPlaying.
4. Метод run класса Violin должен вызывать метод sleepNSeconds с параметром 1 секунда.
5. Метод run класса Violin должен вызывать метод stopPlaying.
6. Метод run класса Violin должен выводить на консоль
    продолжительность игры в миллисекундах. Используй формат из примера.
*/

public class Solution {
    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        // запуск потока
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // интерфейс, наследующий интерфейс Runnable
    public interface MusicalInstrument extends Runnable {

        Date startPlaying();

        Date stopPlaying();
    }

    // класс реализует интерфейс MusicalInstrument
    // который в свою очередь наследует интерфейс Runnable
    public static class Violin implements MusicalInstrument{
        private String owner;

        // метод строго без параметров/аргументов
        public void run() {
            Date before = this.startPlaying();
            sleepNSeconds(1);
            Date after = this.stopPlaying();
            long delta = after.getTime() - before.getTime();
            System.out.println("Playing " + delta + " ms");
        }

        // конструктор класса
        public Violin(String owner) {
            this.owner = owner;
        }

        // реализация методов интерфейса
        public Date startPlaying() {
            System.out.println(this.owner + " starts playing");
            return new Date();
        }

        public Date stopPlaying() {
            System.out.println(this.owner + " stops playing");
            return new Date();
        }
    }
}