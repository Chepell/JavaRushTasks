package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        //официант у нас один
        Waiter waiter = new Waiter();

        //2 повара привязываем к официанту и регистрируем в хралище статистики
        List<Cook> cookLists = new ArrayList<>();
        // в цикле создаю 2х повторов
        for (int i = 0; i < 2; i++) {
            Cook cook = new Cook("Amigo" + i); // создание повара
            cook.setQueue(orderQueue); // установка у повора очереди
            cook.addObserver(waiter); // назначение оффицианта в качестве наблюдателя
            cookLists.add(cook);
        }

        //у нас 5 платшетов, привязываем к очереди
        List<Tablet> tabletList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tabletList.add(tablet);

        }

        // рандомные заказы
        Thread thread = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        thread.start();
        // жду 1 секунду на отработку нити
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
        thread.interrupt(); // нить прерывается

        //планшет директора
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}