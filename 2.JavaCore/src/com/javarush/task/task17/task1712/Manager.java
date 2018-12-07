package com.javarush.task.task17.task1712;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
// Класс Manager должен содержать очередь с заказами (private final поле orderQueue типа Queue).
public class Manager {      //singleton
    // при первичной загрузке класса создается объект
    private static Manager ourInstance = new Manager();

    // неизменяемый список для хранения столок
    private final List<Table> restaurantTables = new ArrayList<>(10);
    private int currentIndex = 0;

    private final Queue<Order> orderQueue = new ConcurrentLinkedQueue<>();        // очередь с заказами
    private final Queue<Dishes> dishesQueue = new ConcurrentLinkedQueue<>();     // очередь с готовыми блюдами

    // метод возвращает менеджера по запросу, но только если он не занят
    public synchronized static Manager getInstance() {
        return ourInstance;
    }

    // приватный конструктор при создании объекта создает еще
    // 10 объектов класса Table и помещаит из в неизменяеммый список
    private Manager() {               // создаем 10 столов
        for (int i = 0; i < 10; i++) {
            restaurantTables.add(new Table());
        }
    }

    // метод с блокировкой мьютекса который возращает стол
    // а затем изменяет индекс что бы при следующем обращении вернуть слеюущий столик
    public synchronized Table getNextTable() {           // официант ходит по кругу от 1 стола к 10
        Table table = restaurantTables.get(currentIndex);
        currentIndex = (currentIndex + 1) % 10;
        return table;
    }

    public Queue<Order> getOrderQueue() {
        return orderQueue;
    }

    public Queue<Dishes> getDishesQueue() {
        return dishesQueue;
    }
}
