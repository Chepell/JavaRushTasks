package com.javarush.task.task16.task1606;

import java.util.ArrayList;
import java.util.List;

/* 
join: в нужное время в нужном месте
Подумай, в каком месте и для какого объекта нужно
вызвать метод join, чтобы результат выводился по-порядку
сначала для firstThread, а потом для secondThread.
Вызови метод join в нужном месте.

Пример вывода:
firstThread : String 1
firstThread : String 2
...
firstThread : String 19
firstThread : String 20
secondThread : String 1
...
secondThread : String 20


Требования:
1. Метод main должен вызывать метод join для объекта firstThread.
2. Метод main не должен вызывать метод join для объекта secondThread.
3. Метод main не должен вызывать System.out.println() или System.out.print().
4. Вывод программы должен соответствовать примеру из задания.
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        // создание объектов класса, в конструкторе указываю имя потока
        PrintListThread firstThread = new PrintListThread("firstThread");
        PrintListThread secondThread = new PrintListThread("secondThread");
        // запуск нити потока
        firstThread.start();
        // запуск метода окончания выполнения нити firstThread
        firstThread.join();
        // запуск нити следующего объекта
        secondThread.start();
    }


    // метод для печати объектов списка,
    // в качестве параметра передается строка имени
    // просто печать 20 элементов в формате
    public static void printList(List<String> list, String threadName) {
        // foreach цикл по элементам списка
        for (String item : list) {
            // отформатированный вывод на печать
            System.out.println(String.format("%s : %s", threadName, item));
        }
    }

    // метод для получения списка строк
    public static List<String> getList(int n) {
        // создается список
        List<String> result = new ArrayList<>();
        // если аргументом передали число меньше 1, то ничего не наполняю
        // а сразу возвращаю инициализированный пустой список
        if (n < 1) return result;

        // иначе в цикле наполняю список строками
        // форматирую так что бы нумерация шла с еденицы
        for (int i = 0; i < n; i++) {
            result.add(String.format("String %d", (i + 1)));
        }

        // в конце возвращаю список
        return result;
    }

    // класс наследник от Thread
    public static class PrintListThread extends Thread {
        // Реализация конструктора родителя с заданием именя потока в поле
        public PrintListThread(String name) {
            // передаю аргумент в конструктор родителя
            super(name);
        }

        // реализация метода потока
        public void run() {
            // берется реализованный метод в него передается
            // список из 20 значений и добавляется имя потока
            printList(getList(20), getName());
        }
    }
}
