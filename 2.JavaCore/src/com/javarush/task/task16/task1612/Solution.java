package com.javarush.task.task16.task1612;

/* 
Stopwatch (Секундомер)
1. Разберись, что делает программа.
2. Реализуй логику метода doStep так, чтобы учитывалась скорость бегуна.
2.1. Метод getSpeed() в классе Runner показывает, сколько шагов в секунду делает бегун.
Нужно, чтобы бегун действительно делал заданное количество шагов в секунду.
Если Иванов делает 4 шага в секунду, то за 2 секунды он сделает 8 шагов.
Если Петров делает 2 шага в секунду, то за 2 секунды он сделает 4 шага.
2.2. Метод sleep в классе Thread принимает параметр типа long.

ВАЖНО! Используй метод Thread.sleep(), а не Stopwatch.sleep().


Требования:
1. Метод getSpeed должен возвращать int.
2. Поле speed класса Runner должно иметь тип int.
3. Конструктор класса Runner должен принимать String и int.
4. Метод doStep должен учитывать скорость бегуна. Если скорость бегуна 2 шага в секунду,
    метод должен работать пол секунды; если скорость бегуна 4 шага в секунду, метод должен работать четверть секунды.
5. Вывод программы должен отображать сколько шагов сделали Иванов и Петров за 2 секунды.
*/

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Runner ivanov = new Runner("Ivanov", 4);
        Runner petrov = new Runner("Petrov", 2);
        //на старт!
        //внимание!
        //марш!
        ivanov.start();
        petrov.start();
        // метод тормозит поток main на 2 сек
        // но в это время другие потоки продолжают работать
        Thread.sleep(2000);
        isStopped = true;
        Thread.sleep(1000);
    }

    // класс секундомера
    public static class Stopwatch extends Thread {
        // поле бегуна
        private Runner owner;
        // поле количества шагов
        private int stepNumber;

        // конструктор принимает только объект класса Runner
        public Stopwatch(Runner runner) {
            this.owner = runner;
        }

        // метод для нити
        public void run() {
            try {
                // цикл пока переменная не станет true
                while (!isStopped) {
                    doStep();
                }
            } catch (InterruptedException e) {
            }
        }

        // метод для реализации run
        private void doStep() throws InterruptedException {
            // поток усыпляем на время кратное скорости бегуна
            Thread.sleep(1000 / owner.getSpeed());
            stepNumber++;
            System.out.println(owner.getName() + " делает шаг №" + stepNumber + "!");
        }
    }

    // класс бегуна
    public static class Runner {
        // Внутри поле класса секундомер
        Stopwatch stopwatch;
        private String name;
        private int speed;

        // конструктор принимает имя и скорость
        public Runner(String name, int speed) {
            this.name = name;
            this.speed = speed;
            // поле секундомера заполняется при вызове конструктора
            this.stopwatch = new Stopwatch(this);
        }

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }

        public void start() {
            stopwatch.start();
        }
    }
}
