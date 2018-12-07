package com.javarush.task.task17.task1715;

import java.util.ArrayList;
import java.util.List;

/* 
Аптека
Реализуй интерфейс Runnable в классах Apteka и Person.
Все нити должны работать пока не isStopped.
Логика для Apteka: drugsController должен сделать закупку случайного
лекарства (getRandomDrug) в количестве (getRandomCount) и подождать 300 мс.
Логика для Person: drugsController должен сделать продажу случайного
лекарства (getRandomDrug) в количестве (getRandomCount) и подождать 100 мс.
Расставь synchronized там, где это необходимо.


Требования:
1. Класс Solution должен содержать public static поле drugsController типа DrugsController.
2. Класс Solution должен содержать public static поле isStopped типа boolean.
3. Класс Solution должен содержать private static void метод waitAMoment(), который должен ждать 100 мс.
4. Класс Apteka должен реализовывать интерфейс Runnable.
5. Нить Apteka должна работать пока isStopped = false.
6. Нить Apteka должна использовать drugsController для закупки случайного лекарства (getRandomDrug) в количестве (getRandomCount).
7. Нить Apteka должна ждать 300мс + "между закупками", используя метод waitAMoment().
8. Класс Person должен реализовывать интерфейс Runnable.
9. Нить Person должна работать пока isStopped = false.
10. Нить Person должна использовать drugsController для продажи случайного лекарства (getRandomDrug) в количестве (getRandomCount).
11. Нить Person должна ждать 100мс + "между закупками", используя метод waitAMoment().
12. Методы класса DrugsController должны быть synchronized.
*/

public class Solution {
    // создаю объект класса drugsController, в котором фактически склад лкарств и методы купли/продажи
    public static DrugsController drugsController = new DrugsController();
    public static boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        // создание потоков на основе классов с реализацией интерфейсов
        Thread apteka = new Thread(new Apteka());
        Thread man = new Thread(new Person(), "Мужчина");
        Thread woman = new Thread(new Person(), "Женщина");

        // запуск потоков
        apteka.start();
        man.start();
        woman.start();

        // остановка основного потока
//        Thread.sleep(1000);
        waitAMoment(1000);
        isStopped = true;
    }


    public static class Apteka implements Runnable {

        @Override
        public void run() {
            while (!isStopped) {
                drugsController.buy(getRandomDrug(), getRandomCount());
                for (int i = 0; i < 3; i++) {
                    waitAMoment();
                }
            }

        }
    }

    public static class Person implements Runnable {

        @Override
        public void run() {
            while (!isStopped) {
                drugsController.sell(getRandomDrug(), getRandomCount());
                waitAMoment();
            }
        }
    }

    // метод возращает слуайное целое цисло, для количества прданных / купленных лекарств
    public static int getRandomCount() {
        return (int) (Math.random() * 3) + 1;
    }


    public static Drug getRandomDrug() {
        // берет индекс лекарства из существующего мэпа через остаток от деления на количество полей в мэпе
        int index = (int) ((Math.random() * 1000) % (drugsController.allDrugs.size()));
        List<Drug> drugs = new ArrayList<>(drugsController.allDrugs.keySet());
        return drugs.get(index);
    }

    // метод просто ждет 1/10 секунды
    private static void waitAMoment() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    // перегрузка overload метода добавляется аргумент
    private static void waitAMoment(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }
}
