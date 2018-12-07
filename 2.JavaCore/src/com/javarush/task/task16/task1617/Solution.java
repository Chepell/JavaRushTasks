package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
1. Разберись, что делает программа.
2. Реализуй логику метода run так, чтобы каждую секунду через пробел
выдавался отсчет начиная с countSeconds до 1, а потом слово [Марш!] (см примеры).
3. Если нить работает 3.5 секунды или более, прерви ее методом interrupt и внутри нити выведи в консоль слово [Прервано!].

Пример для countSeconds=4 :
"4 3 2 1 Прервано!"

4. Если нить работает менее 3.5 секунд, она должна завершиться сама.
Пример для countSeconds=3 :
"3 2 1 Марш!"

PS: метод sleep выбрасывает InterruptedException.


Требования:
1. Метод run класса RacingClock должен содержать цикл.
2. Объект класса RacingClock должен каждую секунду уменьшать значение переменной countSeconds на единицу.
3. Метод main должен вызывать Thread.sleep(3500).
4. Метод main должен вызывать метод interrupt у объекта clock.
5. Если countSeconds равно 3, то программа должна вывести "3 2 1 Марш!".
6. Если countSeconds равно 4, то программа должна вывести "4 3 2 1 Прервано!".
*/

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) {
        // Создается объект класса и запускается нить прямо в конструкторе
        RacingClock clock = new RacingClock();

        // останаливаю главный поток на 3,5 сек
        // в это время второй поток выполняется
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // вызываю метод прерывания потока на объекте
        clock.interrupt();

    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        // переопределение метода нити для класса
        public void run() {
            // в переменную записываю ссылку
            // на объект вызвавшей его нити
            Thread current = Thread.currentThread();
            // цикл работает, пока не будет вызван метод прерывания потока
            while (!current.isInterrupted()) {
                // печатаю значение счетчика
                System.out.print(countSeconds + " ");
                // декрементирую счетчик
                countSeconds--;
                // жду 1 сек
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // сюда помещаю условия для прекращения нити
                    // по сигналу от метода interrupt() из главной нити в main
                    System.out.println(" Прервано!");
                    // ритерн писать тут обязательно
                    return;
                }
                // если прерывание не произошло, то по счетчику когда дошли сюда
                // печатаем строку и покидаем цикл while
                if (countSeconds == 0) {
                    System.out.println("Марш!");
                    return;
                }
            }
        }
    }
}
