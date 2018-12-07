package com.javarush.task.task16.task1620;

import java.util.ArrayList;
import java.util.List;

/* 
Один для всех, все - для одного
1. Разберись, как работает программа.
1.1. Обрати внимание, что объект Water - один для всех нитей.
2. Реализуй метод ourInterruptMethod, чтобы он прерывал все нити из threads.
3. В методе run исправь значения переменных:
3.1. isCurrentThreadInterrupted - должна равняться значению метода isInterrupted у текущей нити.
3.2. threadName - должна равняться значению метода getName (реализовано в классе Thread) у текущей нити.


Требования:
1. Метод ourInterruptMethod должен прервать все нити из списка threads.
2. Метод run должен получать текущую нить с помощью Thread.currentThread.
3. Метод run должен использовать метод isInterrupted текущей нити.
4. Метод run должен использовать метод getName текущей нити.
5. Метод main должен работать примерно 3 сек.
*/

public class Solution {
    // переменная под количество потоков в списке
    public static byte countThreads = 3;
    // список потоков
    static List<Thread> threads = new ArrayList<>(countThreads);

    public static void main(String[] args) throws InterruptedException {
        initThreadsAndStart();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        for (Thread tt : threads) {
            tt.interrupt();
        }
    }

    // метод наполняет список потоками в цикле
    private static void initThreadsAndStart() {
        // создаю объект
        Water water = new Water("water");
        for (int i = 0; i < countThreads; i++) {
            // в поток помещаю одинаковые объекты
            threads.add(new Thread(water, "#" + i));
        }

        // цикл стартует все нити из списка
        for (int i = 0; i < countThreads; i++) {
            threads.get(i).start();
        }
    }

    // класс реализует интферфейс
    public static class Water implements Runnable {
        private String commonResource;

        // свой конструктор
        public Water(String commonResource) {
            this.commonResource = commonResource;
        }

        public void run() {
            Thread current = Thread.currentThread();
            String threadName = current.getName();
            while (!current.isInterrupted()) {
                try {
                    System.out.println("Объект " + commonResource + ", нить " + threadName);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Нить " + threadName + " закрыта!");
                    return;
                }
            }


//            try {
//                while (!current.isInterrupted()) {
//                    System.out.println("Объект " + commonResource + ", нить " + threadName);
//                    Thread.sleep(1000);
//                }
//            } catch (InterruptedException e) {
//                return;
//            }
        }
    }
}
