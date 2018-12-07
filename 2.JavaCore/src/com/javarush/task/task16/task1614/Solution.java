package com.javarush.task.task16.task1614;

import java.util.ArrayList;
import java.util.List;

/* 
Обратный отсчет
1. Разберись, что делает программа.
2. Реализуй логику метода printCountdown так, чтобы программа каждые полсекунды
выводила объект из переменной list. Выводить нужно в обратном порядке - от переданного в Countdown индекса до нуля.

Пример:
Передан индекс 3

Пример вывода в консоль:
Строка 2
Строка 1
Строка 0


Требования:
1. Метод printCountdown должен работать примерно полсекунды.
2. Метод printCountdown должен уменьшать (декрементировать) значение переменной countFrom.
3. Метод printCountdown должен выводить элемент списка list с индексом равным новому значению countFrom.
4. Метод main должен создавать один объект типа Countdown.
5. Вывод программы должен соответствовать примеру из условия.
*/

public class Solution {
    // сразу обявляется список
    // модификатор volatile что переменная может быть изменена
    // и ее не нужно кэшировать, а хранить в общей Main Memory
    public static volatile List<String> list = new ArrayList<>(3);

    // Теперь выполняется статический блок, в котором список инициируется строками
    static {
        for (int i = 0; i < 5; i++) {
            list.add("Строка " + i);
        }
    }

    // Теперь метож main отрабатывается
    public static void main(String[] args) throws InterruptedException {
        // создание обекта класса нить и передача ему в конструкторе объекта
        Thread t = new Thread(new Countdown(3), "Countdown");
        // запуск потока
        // когда реализуется интерфейс, в конструкторе поток нельзя запускать
        t.start();
    }

    // Класс реализующий интерфейс Runnable для нитей
    public static class Countdown implements Runnable {
        // поле класса, говорит о том, откуда начинать отсчет
        private int countFrom;

        // конструктор, принимающий только значение отсчета
        // конструктор свой, а не как в наследовании, который нужно переопределять
        // в интерфейсе ведь нет ничего, кроме сигнатуры методов, которые нужно реализовывать
        public Countdown(int countFrom) {
            this.countFrom = countFrom;
        }

        // реализация метода нитей
        public void run() {
            try {
                // цикл работает по переменной
                while (countFrom > 0) {
                    printCountdown();
                }
            } catch (InterruptedException e) {
            }
        }

        //
        public void printCountdown() throws InterruptedException {
//            for (int i = countFrom - 1; i >= 0; i--) {
//                System.out.println(list.get(i));
//                countFrom--;
//                // остановка исполнения на пол секунды
//                Thread.sleep(500);
//            }
            // так намного проще, чем в цикле
            // цикл тут излишен, т.к. дальше в run итак идет цикл
            countFrom--;
            System.out.println(list.get(countFrom));
            Thread.sleep(500);
        }
    }
}
