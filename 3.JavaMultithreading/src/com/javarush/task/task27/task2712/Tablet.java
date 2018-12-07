package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

//3. Tablet - не должен быть Observable. Убери все зависимости.
//4. В Tablet создай сеттер и установи ссылку на очередь (п.1) при создании планшета.
//5. В Tablet часть логики, которая уведомляет Observer-а, замени на такую, которая добавляет заказ в очередь.
//
//6. В методе main создай и запусти трэды на основании тасок Cook.
//7. Из класса StatisticManager удали сет поваров, его геттер и метод register(Cook cook).
//8. Сделай класс Cook - таском (Runnable). Перенеси логику из трэда внутри конструктора OrderManager в метод run класса Cook.
//9. Удали класс OrderManager и в методе main исправь зависимость Observer-Observable.

public class Tablet {
    final int number;
    private LinkedBlockingQueue<Order> queue;
    static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        try {
            Order order = new Order(this);
            setAdvertisementManager(order);
            queue.offer(order);
            return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        }
    }

    public void createTestOrder() {
        try {
            TestOrder testOrder = new TestOrder(this);
            setAdvertisementManager(testOrder);
            queue.offer(testOrder);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    private void setAdvertisementManager(Order order) {
        try {
            int cookingTimeInSecond = order.getTotalCookingTime() * 60;
            AdvertisementManager advertisementManager = new AdvertisementManager(cookingTimeInSecond);
            advertisementManager.processVideos();
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        ConsoleHelper.writeMessage(order.toString());
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + '}';
    }
}