package com.javarush.task.task16.task1613;

/* 
Big Ben clock
1. Разберись, что делает программа.
2. Реализуй логику метода printTime так,
чтобы каждую секунду выдавалось время начиная с установленного в конструкторе.

Пример:
В г. Лондон сейчас 23:59:58!
В г. Лондон сейчас 23:59:59!
В г. Лондон сейчас полночь!
В г. Лондон сейчас 0:0:1!


Требования:
1. Метод printTime должен работать примерно секунду.
2. Метод printTime должен увеличивать (инкрементировать) количество секунд, хранимое в переменной seconds.
3. Секунд, после икрементирования времени, не может быть больше 59. Должно увеличиться количество минут.
4. Минут, после икрементирования времени, не может быть больше 59. Должно увеличиться количество часов.
5. Часов, после икрементирования времени, не может быть больше 23.
*/

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock("Лондон", 23, 59, 57);
        // остановить поток main на 4 секунды
        Thread.sleep(4000);
        // потом обновить значение переменной
        isStopped = true;
        Thread.sleep(1000);
    }

    // класс Часов наследуется от Thread
    public static class Clock extends Thread {
        // поля класса
        private String cityName;
        private int hours;
        private int minutes;
        private int seconds;

        // замена конструктора по умолчанию
        public Clock(String cityName, int hours, int minutes, int seconds) {
            this.cityName = cityName;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            // метода запуска нити внутри конструктора
            start();
        }

        // переопределение основного метода нити
        public void run() {
            try {
                // цикл работает пока переменная не станет false
                while (!isStopped) {
                    // вызывает метод
                    printTime();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTime() throws InterruptedException {
            // Текущий поток обновляется раз в секунду и приостанавливается
            Thread.sleep(1000);
            // считаю секунды
            seconds++;

            // если 60 секунда то обновляю минуты
            // и обнуляю секунды
            if (seconds == 60) {
                seconds = 0;
                minutes++;
            }

            // если 60 минута то обновляю часы
            // и обнуляю минуты
            if (minutes == 60) {
                minutes = 0;
                hours++ ;
            }

            // если 24 час
            // то обновляю часы
            if (hours == 24) {
                hours = 0;
            }

            String sec = seconds < 10 ? "0" + seconds : "" + seconds;
            String min = minutes < 10 ? "0" + minutes : "" + minutes;
            String hour = hours < 10 ? "0" + hours : "" + hours;

            if (hours == 0 && minutes == 0 && seconds == 0) {
                System.out.println(String.format("В г. %s сейчас полночь!", cityName));
            } else {
                System.out.println(String.format("В г. %s сейчас %s:%s:%s!", cityName, hour, min, sec));
            }
        }
    }
}
