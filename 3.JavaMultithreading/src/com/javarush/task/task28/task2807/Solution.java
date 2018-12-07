package com.javarush.task.task28.task2807;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
Знакомство с ThreadPoolExecutor
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        // создаю потокобезопасную очередь объектов реализующих интрфейс Runnable
        LinkedBlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>();
        // в цикле создаю 10 элементов и добавляю в очередь
        for (int i = 0; i < 10; i++) {
            int localId = i + 1;
            runnables.add(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
        }

        // создание пула нитей из очедели с параметрами количества потоков и времени жизни
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 5,
                1000, TimeUnit.MILLISECONDS, runnables);
        // запускаю нити ядра
        poolExecutor.prestartAllCoreThreads();
        // прекращаю прием новых задач
        poolExecutor.shutdown();
        // даю пулу 5 секунд на завершение работы нитей
        poolExecutor.awaitTermination(5, TimeUnit.SECONDS);
    }

    private static void doExpensiveOperation(int localId) {
        // метод просто выводит информацию по текущему потоку
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}

// 1. В методе main создай очередь LinkedBlockingQueue<Runnable>.
//2. В цикле добавь в очередь 10 задач Runnable.
//3. У каждой задачи в методе run вызови метод doExpensiveOperation с порядковым номером задачи начиная с 1, см. пример вывода.
//4. Создай объект ThreadPoolExecutor со следующими параметрами:
//- основное количество трэдов (ядро) = 3,
//- максимальное количество трэдов = 5,
//- время удержания трэда живым после завершения работы = 1000,
//- тайм-юнит - миллисекунды,
//- созданная в п.1. очередь с задачами.
//5. Запусти все трэды, которые входят в основное кол-во трэдов - ядро, используй метод prestartAllCoreThreads.
//6. Запрети добавление новых задач на исполнение в пул (метод shutdown).
//7. Дай объекту ThreadPoolExecutor 5 секунд на завершение всех тасок (метод awaitTermination и параметр TimeUnit.SECONDS).
//
//
//Требования:
//1. В методе main нужно создать очередь LinkedBlockingQueue.
//2. В цикле добавь в очередь 10 задач Runnable.
//3. Нужно создать объект ThreadPoolExecutor с параметрами, указанными в задании.
//4. С помощью метода prestartAllCoreThreads нужно запустить основные трэды.
//5. Каждая задача должна вызывать метод doExpensiveOperation с порядковым номером задачи, начиная с 1.
//6. Запрети добавление новых задач на исполнение в пул.
//7. На завершение всех задач в пуле нужно установить 5 секунд.