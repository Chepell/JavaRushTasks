package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить "InterruptedException" при
    возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить "Ура";
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода
    showWarning нить должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово "N",
    а потом вывести в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread>
    threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.

Подсказка:
Нить 4 можно проверить методом isAlive()


Требования:
1. Статический блок класса Solution должен создавать и добавлять 5 нитей в список threads.
2. Нити из списка threads не должны стартовать автоматически.
3. Нить 1 из списка threads должна бесконечно выполняться.
4. Нить 2 из списка threads должна выводить "InterruptedException"
    при возникновении исключения InterruptedException.
5. Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
6. Нить 4 из списка threads должна реализовать интерфейс Message,
    при вызове метода showWarning нить должна останавливаться.
7. Нить 5 из списка threads должна читать с консоли числа пока не
    введено слово "N", а потом вывести в консоль сумму введенных чисел.
 */
public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread01());
        threads.add(new Thread02());
        threads.add(new Thread03());
        threads.add(new Thread04());
        threads.add(new Thread05());
    }

    public static void main(String[] args) {
        Thread th = threads.get(1);
        th.start();
        th.interrupt();

    }
}

class Thread01 extends Thread {

    @Override
    public void run() {
        while (true) {
        }
    }
}

class Thread02 extends Thread {

    @Override
    public void run() {
        // нить вечная
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
}

class Thread03 extends Thread {

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
            try {
                System.out.println("Ура");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread04 extends Thread implements Message {

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
        }
    }

    @Override
    public void showWarning() {
        this.interrupt();
    }
}

class Thread05 extends Thread {
    // Нить 5 должна читать с консоли числа пока не введено слово "N",
    // а потом вывести в консоль сумму введенных чисел.
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int num;
        int sum = 0;
        while (!current.isInterrupted()) {
            try {
                // читаю строку
                str = reader.readLine();
                // если введено N
                if ("N".equalsIgnoreCase(str)) {
                    // закрываю ридер
                    reader.close();
                    // вывожу на экран сумму
                    System.out.println(sum);
                    // и завершаю цикл while после чего
                    // завершается и весь метод run
                    break;
                }
                // если не выход то парсю строку в число
                num = Integer.parseInt(str);
                // суммирую числа
                sum += num;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}