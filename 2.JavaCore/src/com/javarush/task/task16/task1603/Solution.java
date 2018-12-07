package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
В методе main добавить в статический объект list 5 нитей.
Каждая нить должна быть новым объектом класса Thread,
работающим со своим объектом класса SpecialThread.


Требования:
1. В методе main создай 5 объектов типа SpecialThread.
2. В методе main создай 5 объектов типа Thread.
3. Добавь 5 разных нитей в список list.
4. Каждая нить из списка list должна работать со своим объектом класса SpecialThread.
5. Метод run класса SpecialThread должен выводить "it's a run method inside SpecialThread".
*/

public class Solution {
    // создается список под объекты типа Thread
    // сразу задаю размер сипска в 5 элементов
    public static volatile List<Thread> list = new ArrayList<>(5);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            // создаю новый объект класа Thread
            // и передаю ему в конструкторе в качестве аргумента
            // новый объект класса SpecialThread
            Thread newThread = new Thread(new SpecialThread());
            list.add(newThread);
        }

//        for (Thread th : list) {
//            th.start();
//        }
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
