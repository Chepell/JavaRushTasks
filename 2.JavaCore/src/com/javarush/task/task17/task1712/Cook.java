package com.javarush.task.task17.task1712;

// класс повара
public class Cook implements Runnable {
    // поле отвечае за способность работать
    public boolean continueWorking = true;

    @Override
    public void run() {
        boolean needToWait;
        // цикл нити продолжается пока флаг способности работать поднят
        // или пока метод из класса Manager не возвращает пустую очерель заказов
        while (continueWorking || needToCookOrders()) {
            try {
                // синхронизация по текущему объекту
                // повар может делать только что-то одно,
                // поэтому блокиоровка по текущему объекту
                synchronized (this) {
                    // в свой флаг сохраняю обратное значение метода needToCookOrders()
                    // т.е. что в очереди заказов что-то есть и
                    needToWait = !needToCookOrders();
                    // начинаю готовить если не нужно ждать
                    if (!needToWait) {
                        cooking();
                    }
                }
                // если повар может готовить и очередь заказов пустая
                if (continueWorking && needToWait) {
                    System.out.println("Повар отдыхает");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    // метод создает singletone объект менеджера вызывает геттером очередь и методом проверяет что она пустая,
    // если не пустая то true надо что-то готовить
    private boolean needToCookOrders() {
        return !Manager.getInstance().getOrderQueue().isEmpty();
    }

    // метод берет блюдо в готовку
    private void cooking() throws InterruptedException {
        // создание переменной ссылки на singletone объект менеджер
        Manager manager = Manager.getInstance();
        // из очереди удаляется и помещается в переменную объект класса Order
        Order order = manager.getOrderQueue().poll();      // повар берет заказ из очереди
        System.out.println(String.format("Заказ будет готовиться %d мс для стола №%d", order.getTime(), order.getTableNumber()));
        // поток тормозится на вермя готовки
        Thread.sleep(order.getTime());     // готовим блюдо
        // теперь можно создать объект класса блюдо, и определить на какой стол его нужно отнести
        Dishes dishes = new Dishes(order.getTableNumber());       //  это готовое блюдо
        // готовое блюдо помещаю в очередь готовых заказов
        manager.getDishesQueue().offer(dishes);
        System.out.println(String.format("Заказ для стола №%d готов", dishes.getTableNumber()));
    }
}
