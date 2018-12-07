package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {
    public static AtomicInteger integer1 = new AtomicInteger(0);

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    //
    public static class AmigoThreadFactory implements ThreadFactory {
        // атомарные поля счетчики, счетчик нитей
        AtomicInteger integer = new AtomicInteger(0);
        // счетчик для объектов класс
        AtomicInteger factoryNum = new AtomicInteger(0);
        // статичное поле одинаковое для всех объектов класса
        static AtomicInteger factoryCount = new AtomicInteger(0);

        // замена конструктора по умолчанию
        public AmigoThreadFactory() {
            // в конструкторе через статичный объект класса устанавливается значение
            factoryNum.set(factoryCount.incrementAndGet());
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r); // создаю поток
            thread.setDaemon(false); // поток не демон
            thread.setPriority(Thread.NORM_PRIORITY); // нормальный приоритет
            thread.setName(Thread.currentThread().getThreadGroup().getName()
                    + "-pool-" + factoryNum + "-thread-" + integer.incrementAndGet());
            return thread;
        }
    }
}