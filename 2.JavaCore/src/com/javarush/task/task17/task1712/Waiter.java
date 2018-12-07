package com.javarush.task.task17.task1712;

// класс оффицианта
public class Waiter implements Runnable {
    // публичное поле отвечает за работу объекта
    public boolean continueWorking = true;

    @Override
    public void run() {
        // создается объект класса менеджер
        Manager manager = Manager.getInstance();

        // могу работать или очередь готовых заказов не пустая
        while (continueWorking || !manager.getDishesQueue().isEmpty()) {
            // если очередь готовых заказов не пустая
            if (!manager.getDishesQueue().isEmpty()) {       //относим готовый заказ
                // объект готового блюда забирается из очереди менеджера
                Dishes dishes = manager.getDishesQueue().poll();
                System.out.println("Официант отнес заказ для стола №" + dishes.getTableNumber());
                // если готовых заказов нет, то принимаю новый заказ
            } else {
                // получаю в переменную следующий столик для обслуживания
                Table table = manager.getNextTable();
                Order order = table.getOrder();
                System.out.println("Получен заказ от стола №" + order.getTableNumber());
                manager.getOrderQueue().add(order);
            }
            try {
                Thread.sleep(100);  //walking to the next table
            } catch (InterruptedException e) {
            }
        }
    }
}
