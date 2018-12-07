package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // в цикле добавляю 9 объектов в очередь
            for (int i = 0; i < 9; i++) {
                int num = i + 1;
                System.out.format("Элемент 'ShareItem-%d' добавлен%n", num);
                String name = String.format("ShareItem-%d", num);
                queue.offer(new ShareItem(name, num));
                try {
                    Thread.sleep(100); // каждую итерацию торможу на 0,1 сек
                } catch (InterruptedException e) {
//                    e.printStackTrace(); // в стектрейс ничего не вывожу
                    return; //
                }
                // метод проверяет ждет ли потребитель кого-то в очереди
                if (queue.hasWaitingConsumer()) System.out.format("Consumer в ожидании!%n");
                // если был поднят флаг на прерывание нити, то прерываю тут цикл и выхожу из run
                if (Thread.currentThread().isInterrupted()) break;
            }
    }
}