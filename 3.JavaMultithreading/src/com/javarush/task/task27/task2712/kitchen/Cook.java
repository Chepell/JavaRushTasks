package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    private String name;
    private boolean busy;
    private boolean stopped = false;
    private boolean cathced = false;
    private LinkedBlockingQueue<Order> queue;

    public Cook(String name) {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        setChanged();
        notifyObservers(order);
        StatisticManager statisticManager = StatisticManager.getInstance();
        CookedOrderEventDataRow cookedOrderEventDataRow = new CookedOrderEventDataRow(order.getTablet().toString(),
                name, order.getTotalCookingTime(), order.getDishes());
        statisticManager.register(cookedOrderEventDataRow);
        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        busy = false;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        while (!stopped) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            // смотрю есть ли в голове очереди элемент
            if (queue.peek() != null) {
                // проверка, что повар свободен
                if (!isBusy()) {
                    try {
                        // забираю заказ из очереди и отдаю повару
                        startCookingOrder(queue.take());
                    } catch (InterruptedException e) {
                        cathced = true;
                    }
                }
                if (cathced && queue.isEmpty()) stopped = true;
            }
        }
    }
}