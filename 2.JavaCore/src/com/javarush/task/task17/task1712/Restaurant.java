package com.javarush.task.task17.task1712;

import java.util.ArrayList;
import java.util.List;

/* 
Ресторан
1.Разберись, что делает программа. Официант почему-то не относит приготовленные блюда назад к столам :(

2.Исправь ошибку.

Подсказка: это одна строчка


Требования:
1. Класс Restaurant должен содержать список поваров и официантов (public static поле threads типа List).
2. Класс Manager должен содержать очередь с заказами (private final поле orderQueue типа Queue).
3. Класс Manager должен содержать очередь с готовыми блюдами (private final поле dishesQueue типа Queue).
4. Класс Manager должен реализовывать паттерн Singleton.
5. Класс Waiter должен реализовывать интерфейс Runnable.
6. Класс Cook должен реализовывать интерфейс Runnable.
7. Если нет готовых блюд в очереди, нить класса Waiter должна
    получать заказ от столика и добавлять его в очередь заказов.
8. Если есть готовые блюда в очереди, нить класса Waiter должна
    брать блюдо из очереди и относить заказ для столика.
9. Если нет заказов в очереди с заказами, нить класса Cook должна отдыхать (повар отдыхает).
10. Если есть заказы в очереди с заказами, нить класса Cook должна готовить блюдо и добавлять
    его в очередь с готовыми блюдами.
*/

public class Restaurant {
    // список для потоков
    public static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        // Создаю новый объект класса Waiter который реализует интерфейс Runnable
        Waiter waiterTarget = new Waiter();
        // Cоздаю нить для объекта
        Thread waiter = new Thread(waiterTarget);
        // добавляю поток в список
        threads.add(waiter);

        // создаю повара
        Cook cookTarget = new Cook();
        // Создаю нить для объекта
        Thread cook = new Thread(cookTarget);
        // помещаю повора в список потоков
        threads.add(cook);

        waiter.start();
        cook.start();

        Thread.sleep(2000);
        cookTarget.continueWorking = false;
        Thread.sleep(500);
        waiterTarget.continueWorking = false;
    }
}
