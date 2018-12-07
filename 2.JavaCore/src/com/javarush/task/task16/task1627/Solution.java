package com.javarush.task.task16.task1627;

/*
Поиграем?
Три человека играют в игру. Каждый игрок(Gamer) характеризуется двумя параметрами:
фамилией(name) и количеством действий в секунду (rating).
Нужно вывести в консоль ход игры и определить победителя и проигравших.
Итак...
1. Разберись, что делает программа.
1.1. List<String> steps хранит последовательность действий,
    которое каждый игрок выполняет от 0 до последнего.
1.2. isWinnerFound показывает, найден победитель или нет.
1.3. Метод sleep выбрасывает InterruptedException и принимает параметр типа long.
1.4. Игроки играют независимо друг от друга.
2. Реализуй логику метода run так, чтобы для каждого игрока:
2.1. Через равные интервалы времени (1000ms / rating)
    выводились в консоль действия, описанные в steps.
2.2. Любой текст должен начинаться с фамилии игрока (метод getName()),
    потом следовать двоеточие, а затем сам текст.

Пример: [Ivanov:Начало игры].

2.3. Когда игрок выполнит все действия из steps, то он считается победителем.
    Выведите [getName() + ":победитель!"].
2.4. Когда найден победитель, то игра останавливается, и остальные
    игроки считаются побежденными. Выведите для них [getName() + ":проиграл"].

Квадратные скобки [ ] выводить на экран не нужно.


Требования:
1. Метод run класса Gamer через равные интервалы времени (1000ms / rating) должен
    выводить в консоль фамилию игрока (метод getName()), потом двоеточие,
    а затем текст из OnlineGame.steps. Пример: [Ivanov:Начало игры].
2. Когда все игровые шаги будут выполнены, а победитель еще не найден,
    метод run должен установить флаг OnlineGame.isWinnerFound в true (сообщить остальным, что он победитель).
3. Если игрок стал победителем, его метод run должен вывести надпись
    [getName() + ":победитель!"]. Например: [Sidorov:победитель!].
4. Методы run всех игроков которые не стали победителями (были прерваны),
    должны вывести надписи [getName() + ":проиграл"]. Например: [Petrov:проиграл]
5. Метод run не должен кидать исключение при прерывании.
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        // запуск нити, в котрое еще 3 нити
        onlineGame.start();
    }

    // класс наследник от Thread
    public static class OnlineGame extends Thread {
        // volitale что бы значение не кэшировалось в потоке
        // а было доступно актуальное значение всем объектом класса
        public static volatile boolean isWinnerFound = false;

        // статик список для хранения шагов в игре
        public static List<String> steps = new ArrayList<>();

        // статик-блок наполняет список значениями
        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        // создаются объекты игроков
        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);

        // метод для нитей
        public void run() {
            // запускаются 3 нити
            gamer1.start();
            gamer2.start();
            gamer3.start();

            // начинает крутиться пустой цикл
            // нужен он что бы выполнение не перешло на следующие строки
            while (!isWinnerFound) {
            }

            // переменная isWinnerFound стала true
            // вышли из цикла и прервали все нити
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    // класс для игроков, наследник класса нитей
    public static class Gamer extends Thread {
        // доавляю поле рейтинга
        private int rating;

        // переопрелделяю конструктор класса
        public Gamer(String name, int rating) {
            // передаю в родительский класс поле имени
            super(name);
            // инициирую поле рейтинга
            this.rating = rating;
        }

        @Override
        public void run() {
            // в цикле шагами иду по шагам игры
            for (String str : OnlineGame.steps) {
                // вывожу объект и его шаг на экран
                System.out.println(getName() + ":" + str);
                // замедляю процесс обернув его в try-catch
                try {
                    // рейтинг - скорость, количество шагов в сек
                    // в итоге получаю сколько мс уходит на один шаг
                    Thread.sleep(1000 / rating);
                } catch (InterruptedException e1) {
                    // сюда попадаю если был вызван метод interrupt
                    System.out.println(getName() + ":проиграл");
                    return;
                }
            }
            // проверяю на всякий случай не опередил ли меня
            // кто-то в последний момент в соседней нити
            if (!OnlineGame.isWinnerFound) {
                // поднимаю победный флаг
                OnlineGame.isWinnerFound = true;
                // и вывожу сообщение о победе
                System.out.println(getName() + ":победитель!");
            }
        }
    }
}
