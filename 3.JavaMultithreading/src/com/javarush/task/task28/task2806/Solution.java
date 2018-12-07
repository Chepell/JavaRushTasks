package com.javarush.task.task28.task2806;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
Знакомство с Executors
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        // создаю пул потоков в количестве 5 штук с помощью вызова статичного метода
        ExecutorService service = Executors.newFixedThreadPool(5);
        // в цикле добавляю 10 задач в пул
        for (int i = 0; i < 10; i++) {
            int localId = i + 1;
            // добавление самих задач в виде анонимного класса Runnable
            service.submit(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
        }
        // завершение приема новых задач в пул нитей
        service.shutdown();
        // ожидание 5 секунд окончания работы нитей переданных в пул и прерывание их, смотря что наступит раньше
        service.awaitTermination(5, TimeUnit.SECONDS);


        /* output example
pool-1-thread-2, localId=2
pool-1-thread-1, localId=1
pool-1-thread-3, localId=3
pool-1-thread-1, localId=7
pool-1-thread-1, localId=9
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
pool-1-thread-2, localId=6
pool-1-thread-1, localId=10
pool-1-thread-3, localId=8
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}

//Знакомство с Executors
//1. В методе main создай фиксированный пул из 5 трэдов используя класс Executors.
//2. В цикле отправь на исполнение в пул 10 задач Runnable.
//3. У каждой задачи в методе run вызови метод doExpensiveOperation с порядковым номером задачи начиная с 1, см. пример вывода.
//4. Запрети добавление новых задач на исполнение в пул (метод shutdown).
//5. Дай пулу 5 секунд на завершение всех задач (метод awaitTermination и параметр TimeUnit.SECONDS).
//
//
//Требования:
//1. Используя класс Executors, создай в методе main фиксированный пул из 5 трэдов.
//2. Пул должен принимать на исполнение 10 задач Runnable.
//3. Каждая задача должна вызывать метод doExpensiveOperation с порядковым номером задачи, начиная с 1.
//4. Запрети добавление новых задач на исполнение в пул.
//5. На завершение всех задач в пуле нужно установить 5 секунд.
